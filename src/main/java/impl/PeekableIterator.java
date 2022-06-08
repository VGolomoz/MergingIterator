package impl;

import java.util.Iterator;

/**
 * An peekable iterator. Wrapper over the usual Iterator of E elements that provides method
 * to work with current value.
 *
 * @author Vadym Golomoz
 */
public class PeekableIterator<E> implements Iterator<E> {
    private final Iterator<E> iterator;
    private E current;

    /**
     * Create an new instance of PeekableIterator.
     *
     * @param iterator of E elements
     *
     */
    public PeekableIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        this.current = iterator.next();
    }

    /**
     * Returns the current iterable element
     *
     * @return the current iterable element
     *
     */
    public E peek() {
        if (current == null) current = iterator.next();

        return current;
    }

    /**
     * Returns true if the iteration has more elements.
     * @return true if the iteration has more elements
     *
     */
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     * Throws: NoSuchElementException – if the iteration has no more elements
     * @return the next element in the iteration
     *
     */
    @Override
    public E next() {
        if (current == null) return iterator.next();

        E temp = current;
        current = null;
        return temp;
    }

    /**
     * Removes from the underlying collection the last element returned by this iterator.
     * Throws: UnsupportedOperationException – if the remove operation is not supported by this iterator
     *         IllegalStateException – if the next method has not yet been called,
     *         or the remove method has already been called after the last call to the next method
     *
     */
    @Override
    public void remove() {
        iterator.remove();
    }
}
