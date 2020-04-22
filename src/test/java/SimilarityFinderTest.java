import edu.iis.mto.search.SequenceSearcherDubler;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimilarityFinderTest {
    private SimilarityFinder similarityFinder;
    private SequenceSearcherDubler searcher;
    static private int[] sequence1 = new int[]{};
    static private int[] sequence2 = new int[]{};

    static private final double TOTAL_SIMILARITY = 1.0;
    static private final double NO_SIMILARITY = 0.0;

    @BeforeEach
    void init(){
        searcher = new SequenceSearcherDubler();
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
        sequence1 = new int[]{1, 2, 3};
        sequence2 = new int[]{};
        searcher.setExpectedValues(new int[]{-1, -1, -1}, new boolean[]{false, false, false});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertTrue(searcher.getCallNumber() > 0);
    }

    @Test
    void checkIfBothSequencesEmpty(){
        sequence1 = new int[]{};
        sequence2 = new int[]{};
        searcher.setExpectedValues(new int[]{0}, new boolean[]{true});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(TOTAL_SIMILARITY, result);
    }

    @Test
    void checkIfFirstSequenceEmpty(){
        sequence1 = new int[]{};
        sequence2 = new int[]{1, 2, 3};
        searcher.setExpectedValues(new int[]{-1, -1, -1}, new boolean[]{false, false, false});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(NO_SIMILARITY, result);
    }

    @Test
    void checkIfSecondSequenceEmpty(){
        sequence1 = new int[]{1, 2, 3};
        sequence2 = new int[]{};
        searcher.setExpectedValues(new int[]{-1, -1, -1}, new boolean[]{false, false, false});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(NO_SIMILARITY, result);
    }

    @Test
    void checkIfOneCommonValueInSequences(){
        sequence1 = new int[]{1, 2, 3, 4, 5, 6};
        sequence2 = new int[]{6, 7, 8, 9, 10};
        searcher.setExpectedValues(new int[]{-1, -1, -1, -1, -1, 0}, new boolean[]{false, false, false, false, false, true});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(0.1, result);
    }

    @Test
    void checkIfAllCommonValuesInSequences(){
        sequence1 = new int[]{1, 2, 3, 4, 5};
        sequence2 = new int[]{5, 4, 3, 2, 1};
        searcher.setExpectedValues(new int[]{4, 3, 2, 1, 0}, new boolean[]{true, true, true, true, true});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(TOTAL_SIMILARITY, result);
    }

    @Test
    void checkIfNoneCommonValuesInSequences(){
        sequence1 = new int[]{1, 2, 3, 4, 5};
        sequence2 = new int[]{6, 7, 8, 9, 10};
        searcher.setExpectedValues(new int[]{-1, -1, -1, -1, -1}, new boolean[]{false, false, false, false, false});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(NO_SIMILARITY, result);
    }

    @Test
    void checkIfAllCommonValuesExceptOneInSequences(){
        sequence1 = new int[]{1, 2, 3, 4, 5};
        sequence2 = new int[]{5, 4, 3, 2};
        searcher.setExpectedValues(new int[]{-1, 3, 2, 1, 0}, new boolean[]{false, true, true, true, true});
        double result = similarityFinder.calculateJackardSimilarity(sequence1, sequence2);
        Assertions.assertEquals(0.8, result);
    }


}
