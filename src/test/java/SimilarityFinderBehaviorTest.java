import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.search.SimpleSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

    }

    @Test
    void checkIfSecondSequenceIsNull(){

    }

    @Test
    void checkIfSequenceSearcherIsNull(){

    }

    @Test
    void checkIfSimilarityFinderOperatesSequenceSearcher(){

    }
}
