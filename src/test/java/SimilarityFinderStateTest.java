import edu.iis.mto.search.SimpleSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimilarityFinderStateTest {
    static private SimilarityFinder similarityFinder;
    static private int[] emptySequence;

    @BeforeAll
    static void init(){
        emptySequence = new int[]{};
        similarityFinder = new SimilarityFinder(new SimpleSequenceSearcher());
    }

    @Test
    void shouldBeBothSequencesEmpty(){

    }

    @Test
    void shouldBeOneSequenceEmpty(){

    }

    @Test
    void shouldBeOneSequenceEmpty2(){

    }

    @Test
    void shouldBeOneCommonValueInSequences(){

    }

    @Test
    void shouldBeAllCommonValuesInSequences(){

    }

    @Test
    void shouldBeNoneCommonValuesInSequences(){

    }

    @Test
    void shouldBeAllCommonValuesExceptOneInSequences(){

    }


}
