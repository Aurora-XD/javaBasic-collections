package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sequence implements Iterable<Integer> {
    private final Integer start;
    private final Integer end;

    public Sequence(Integer start, Integer end) {
        if (start >= end) {
            throw new IllegalArgumentException("Start must be smaller than End.");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SequenceIterator(start, end);
    }
}

class SequenceIterator implements Iterator<Integer> {
    // TODO: You can add additional fields or methods if you want.
    // <--start
    private List<Integer> storage;
    private int index;

    private void initStorage(Integer start, Integer end) {
        while (start < end) {
            storage.add(start);
            start++;
        }
    }
    // --end-->

    SequenceIterator(Integer start, Integer end) {
        // TODO: please implements the following code to pass the test
        // <--start
//        throw new NotImplementedException();
        storage = new ArrayList<>();
        initStorage(start, end);
        index = -1;
        // --end-->
    }

    @Override
    public boolean hasNext() {
        // TODO: please implements the following code to pass the test
        // <--start
//        throw new NotImplementedException();
        return (index + 1) >= 0 && (index + 1) < storage.size();
        // --end-->
    }

    @Override
    public Integer next() {
        // TODO: please implements the following code to pass the test
        // <--start
//        throw new NotImplementedException();
        index++;
        return storage.get(index);
        // --end-->
    }
}
