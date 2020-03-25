import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.search.SimpleSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimilarityFinderBehaviorTest {
    private SimilarityFinder similarityFinder;
    private SequenceSearcher searcher;
    private int[] sequence1 = new int[]{1, 2, 3};
    private int[] sequence2 = new int[]{4, 5, 6};

    @BeforeEach
    void init(){
        searcher = new SimpleSequenceSearcher();
        similarityFinder = new SimilarityFinder(searcher);
    }

    @Test
    void checkIfBothSequencesAreNull(){
        Assertions.assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(null, null));
    }

    @Test
    void checkIfFirstSequenceIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(null, sequence2));
    }

    @Test
    void checkIfSecondSequenceIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> similarityFinder.calculateJackardSimilarity(sequence1, null));
    }

    @Test
    void checkIfSequenceSearcherIsNull(){
        SimilarityFinder finder = new SimilarityFinder(null);
        Assertions.assertThrows(NullPointerException.class, () -> finder.calculateJackardSimilarity(sequence1, sequence2));
    }

    @Test
    void checkIfSimilarityFinderOperatesSequenceSearcher(){
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertTrue(searcher.callNumber.get() > 0);
    }
}
