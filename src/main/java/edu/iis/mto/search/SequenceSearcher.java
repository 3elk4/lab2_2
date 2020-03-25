package edu.iis.mto.search;

import java.util.concurrent.atomic.AtomicInteger;

public interface SequenceSearcher {
    AtomicInteger callNumber = new AtomicInteger(0);
    SearchResult search(int elem, int[] seq);
}
