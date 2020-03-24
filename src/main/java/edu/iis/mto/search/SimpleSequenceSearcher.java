package edu.iis.mto.search;

public class SimpleSequenceSearcher implements SequenceSearcher{
    @Override
    public SearchResult search(int elem, int[] seq) {
        SearchResult.Builder builder = SearchResult.builder();
        builder.withPosition(-1);
        builder.withFound(false);
        for(int i = 0; i < seq.length; ++i){
            if(seq[i] == elem){
                builder.withPosition(i);
                builder.withFound(true);
                break;
            }
        }
        return builder.build();
    }
}
