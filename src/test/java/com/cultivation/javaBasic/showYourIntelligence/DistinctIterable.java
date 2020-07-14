package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;
    private int currentIndex = 0;
    private List<E> content;

    DistinctIterator(Iterator<E> iterator) {
        content = new ArrayList<>();

        iterator.forEachRemaining(item -> {
            if (!content.contains(item)) {
                content.add(item);
            }
        });
        this.iterator = content.iterator();
    }

    @Override
    public boolean hasNext() {
//        throw new NotImplementedException();
        return currentIndex < content.size();
    }

    @Override
    public E next() {
//        throw new NotImplementedException();
        return content.get(currentIndex++);
    }
    // --end->
}