import edu.iis.mto.search.SequenceSearcher;
import edu.iis.mto.search.SimpleSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimilarityFinderStateTest {
    static private SimilarityFinder similarityFinder;
    static private SequenceSearcher searcher;
    static private int[] sequence1;
    static private int[] sequence2;

    static private final double TOTAL_SIMILARITY = 1.0;
    static private final double NO_SIMILARITY = 0.0;

    @BeforeAll
    static void init(){
        searcher = new SimpleSequenceSearcher();
        similarityFinder = new SimilarityFinder(searcher);
    }

    @Test
    void checkIfBothSequencesEmpty(){
        sequence1 = new int[]{};
        sequence2 = new int[]{};
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(TOTAL_SIMILARITY, result);
    }

    @Test
    void checkIfFirstSequenceEmpty(){
        sequence1 = new int[]{};
        sequence2 = new int[]{1, 2, 3};
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(NO_SIMILARITY, result);
    }

    @Test
    void checkIfSecondSequenceEmpty(){
        sequence1 = new int[]{1, 2, 3};
        sequence2 = new int[]{};
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(NO_SIMILARITY, result);
    }

    @Test
    void checkIfOneCommonValueInSequences(){
        sequence1 = new int[]{1, 2, 3, 4, 5, 6};
        sequence2 = new int[]{6, 7, 8, 9, 10};
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(0.1, result);
    }

    @Test
    void checkIfAllCommonValuesInSequences(){

    }

    @Test
    void checkIfNoneCommonValuesInSequences(){

    }

    @Test
    void checkIfAllCommonValuesExceptOneInSequences(){

    }


}
