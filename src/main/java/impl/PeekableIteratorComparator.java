package impl;

import java.util.Comparator;

/**
 * A comparison function, which imposes a total ordering on PeekableIterator elements.
 *
 * @author Vadym Golomoz
 */
public class PeekableIteratorComparator implements Comparator<PeekableIterator<Integer>> {


    /**
     * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer
     * as the first argument is less than, equal to, or greater than the second.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to,
     * or greater than the second
     */
    @Override
    public int compare(PeekableIterator<Integer> o1, PeekableIterator<Integer> o2) {
        return Integer.compare(o1.peek(), o2.peek());
    }
}
