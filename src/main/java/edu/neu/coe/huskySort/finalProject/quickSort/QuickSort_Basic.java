package edu.neu.coe.huskySort.finalProject.quickSort;

import edu.neu.coe.huskySort.sort.HelperFactory;
import edu.neu.coe.huskySort.sort.Sort;
import edu.neu.coe.huskySort.sort.simple.Partition;
import edu.neu.coe.huskySort.sort.simple.Partitioner;
import edu.neu.coe.huskySort.sort.simple.QuickSort;
import edu.neu.coe.huskySort.util.*;
import edu.neu.coe.huskySort.sort.ComparisonSortHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort_Basic<X extends Comparable<X>> extends QuickSort<X> {

    public static final String DESCRIPTION = "QuickSort basic";

    public QuickSort_Basic(String description, int N, Config config) {
        super(description, N, config);
        setPartitioner(createPartitioner());
    }

    /**
     * Constructor for QuickSort_Basic
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public QuickSort_Basic(ComparisonSortHelper<X> helper) {
        super(helper);
        setPartitioner(createPartitioner());
    }

    /**
     * Constructor for QuickSort_Basic
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public QuickSort_Basic(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    /**
     * Constructor for QuickSort_Basic
     *
     * @param config the configuration.
     */
    public QuickSort_Basic(Config config) {
        this(0, config);
    }

    @Override
    public Partitioner<X> createPartitioner() {
        return new Partitioner_Basic(getHelper());
    }

    public class Partitioner_Basic implements Partitioner<X> {

        public Partitioner_Basic(Helper<X> helper) {
            this.helper = helper;
        }

        /**
         * Method to partition the given partition into smaller partitions.
         *
         * @param partition the partition to divide up.
         * @return an array of partitions, whose length depends on the sorting method being used.
         */
        public List<Partition<X>> partition(Partition<X> partition) {

            System.out.println("In quick sort basic");

            final X[] xs = partition.xs;
            final int from = partition.from;
            final int to = partition.to;
            final int hi = to - 1;
            X v = xs[from];
            int i = from;
            int j = to;
            // NOTE: we are trying to avoid checking on instrumented for every time in the inner loop for performance reasons (probably a silly idea).
            // NOTE: if we were using Scala, it would be easy to set up a comparer function and a swapper function. With java, it's possible but much messier.
            if (helper.instrumented()) {
                helper.incrementCopies(1);
                while (true) {
                    while (i < hi && helper.invertedPure(xs[++i], v)) {
                    }
                    while (j > from && helper.invertedPure(v, xs[--j])) {
                    }
                    if (i >= j) break;
                    helper.swap(xs, i, j);
                }
                helper.swap(xs, from, j);
            }
//            else {
//            while (true) {
//                while (i < hi && xs[++i].compareTo(v) < 0) {}
//                while (j > from && xs[--j].compareTo(v) > 0) {}
//                if (i >= j) break;
//                swap(xs, i, j);
//            }
//            swap(xs, from, j);
//            }
            System.out.println("j="+j);
            for(X x: xs)
                System.out.print(x+" ");
            System.out.println();

            List<Partition<X>> partitions = new ArrayList<>();
            partitions.add(new Partition<>(xs, from, j));
            partitions.add(new Partition<>(xs, j + 1, to));
            return partitions;
        }

        private void swap(X[] xs, int i, int j) {
//            X temp = ys[i];
//            ys[i] = ys[j];
//            ys[j] = temp;
            if (i == j) return;
            swaps++;
            final X v = xs[i];
            final X w = xs[j];
//            instrumenter.incrementHits(4);
//            if (instrumenter.isCountFixes()) updateFixes(xs, i, j, v, w);
            xs[i] = w;
            xs[j] = v;
        }

        private final Helper<X> helper;

    }

    private int swaps;
    private int noOfComparisons;



}
