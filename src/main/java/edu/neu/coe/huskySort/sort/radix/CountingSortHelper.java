package edu.neu.coe.huskySort.sort.radix;

import edu.neu.coe.huskySort.util.Helper;

/**
 * CountingSortHelper interface.
 * <p>
 * A ComparisonSortHelper provides all of the utilities that are needed by sort methods, for example, compare and swap.
 * <p>
 * CONSIDER having the concept of a current sub-array, then we could dispense with the lo, hi parameters.
 *
 * @param <X>
 */
public interface CountingSortHelper<X extends StringComparable<X, Y>, Y extends Comparable<Y>> extends Helper<X> {

    /**
     * Compare values v and w and return true if v is less than w.
     *
     * @param v the first value.
     * @param w the second value.
     * @param d the position of interest.
     * @return true if v is less than w.
     */
    default boolean less(final X v, final X w, final int d) {
        return this.compare(v, w, d) < 0;
    }

    /**
     * Compare value v with value w.
     *
     * @param v the first value.
     * @param w the second value.
     * @param d the position of interest.
     * @return -1 if v is less than w; 1 if v is greater than w; otherwise 0.
     */
    default int compare(final X v, final X w, final int d) {
        return v.charAt(d).compareTo(w.charAt(d));
    }


    default int cutoff() {
        return 7;
    }

    /**
     * If instrumenting, increment the number of copies by n.
     *
     * @param n the number of copies made.
     */
    default void incrementCopies(final int n) {
        // do nothing.
    }

    /**
     * Method to do any required preProcessing.
     *
     * @param xs the array to be sorted.
     * @return the array after any pre-processing.
     */
    default X[] preProcess(final X[] xs) {
        // CONSIDER invoking init from here.
        return xs;
    }

    default void registerDepth(final int depth) {
    }

    default int maxDepth() {
        return 0;
    }
}
