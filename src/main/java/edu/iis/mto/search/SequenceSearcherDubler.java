package edu.iis.mto.search;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceSearcherDubler implements SequenceSearcher{
    AtomicInteger callNumber = new AtomicInteger(0);
    boolean[] found;
    int[] pos;

    public void setExpectedValues(int[] pos, boolean[] found){
        this.pos = pos;
        this.found = found;
    }

    public int getCallNumber(){
        return callNumber.get();
    }

    @Override
    public SearchResult search(int elem, int[] seq) {
        int index = callNumber.getAndIncrement();
        SearchResult.Builder result = SearchResult.builder();
        result.withPosition(pos[index]);
        result.withFound(found[index]);
        return result.build();
    }
}