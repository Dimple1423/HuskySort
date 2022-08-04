package edu.neu.coe.huskySort.finalProject.quickSort;

import edu.neu.coe.huskySort.sort.ComparisonSortHelper;
import edu.neu.coe.huskySort.sort.HelperFactory;
import edu.neu.coe.huskySort.sort.Sort;
import edu.neu.coe.huskySort.util.Config;
import edu.neu.coe.huskySort.util.Instrumenter;
import edu.neu.coe.huskySort.util.PrivateMethodInvoker;
import edu.neu.coe.huskySort.util.StatPack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static edu.neu.coe.huskySort.util.Utilities.round;
import static org.junit.Assert.assertTrue;

public class Main {

    public static void main(String args[]) throws IOException {
        int k = 4;
        int N = (int) Math.pow(2, k);
        // NOTE this depends on the cutoff value for quick sort.
        int levels = k - 2;
        final Config config = Config.setupConfig("true", "", "1", "1", "");
        final ComparisonSortHelper<Integer> helper = (ComparisonSortHelper<Integer>) HelperFactory.create("quick sort basic", N, config);
        System.out.println(helper);
        Sort<Integer> s = new QuickSort_Basic<>(helper);
        s.init(N);
        final Integer[] xs = helper.random(Integer.class, r -> r.nextInt(10000));
        helper.preProcess(xs);
        for(int x: xs)
            System.out.print(x+" ");
        System.out.println();
        Integer[] ys = s.sort(xs);
        for(int x: ys)
            System.out.print(x+" ");
        System.out.println();
        //assertTrue(helper.sorted(ys));
        helper.postProcess(ys);
        final PrivateMethodInvoker privateMethodTester = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodTester.invokePrivate("getStatPack");
        System.out.println(statPack);
        final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
        final int copies = (int) statPack.getStatistics(Instrumenter.COPIES).mean();
        final int worstCompares = round(2.0 * N * Math.log(N));
        final int bestCompares = round(N * k);
        System.out.println("bestCompares: " + bestCompares + ", compares: " + compares + ", worstCompares: " + worstCompares);
        //assertTrue(compares <= worstCompares);
        System.out.println("ratio of compares to swaps: " + compares*1.0/swaps);
    }
}
