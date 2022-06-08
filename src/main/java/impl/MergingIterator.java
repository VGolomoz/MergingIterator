package impl;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * An merging iterator that produces globally sorted sequence from the given N iterators
 * depending on the comparison rule.
 *
 * @author Vadym Golomoz
 */
public class MergingIterator<E> implements Iterator<E> {
    private final PriorityQueue<PeekableIterator<E>> priorityQueue;

    /**
     * Create an new instance of MergingIterator.
     *
     * @param comparator with sorting conditions
     * @param iterators array of iterators of E elements
     *
     */
    public MergingIterator(Comparator<E> comparator, Iterator<E>... iterators) {
        this.priorityQueue = new PriorityQueue(iterators.length, comparator);

        for (Iterator<E> i : iterators) {
            if (i.hasNext()) priorityQueue.add(new PeekableIterator(i));
        }
    }

    /**
     * Returns true if the iteration has more elements.
     * @return true if the iteration has more elements
     *
     */
    @Override
    public boolean hasNext() {
        return priorityQueue.size() > 0;
    }

    /**
     * Returns the next element in the iteration.
     * Throws: NoSuchElementException – if the iteration has no more elements
     * @return the next element in the iteration
     *
     */
    @Override
    public E next() {
        PeekableIterator<E> iterator = priorityQueue.poll();
        E result = iterator.next();
        if (iterator.hasNext()) {
            priorityQueue.add(iterator);
        }
        return result;
    }

    /**
     * UnsupportedOperation
     * @throws UnsupportedOperationException
     *
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    /**
     * UnsupportedOperation
     * @throws UnsupportedOperationException
     *
     */
    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        throw new UnsupportedOperationException("forEachRemaining");
    }
}
