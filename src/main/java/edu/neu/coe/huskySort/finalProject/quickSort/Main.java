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

            int k=3;
            int N = (int) Math.pow(2, k);
            System.out.println("N="+N);
            int levels = k - 2;
            final Config config = Config.setupConfig("true", "", "1", "", "");
            final ComparisonSortHelper<Integer> helper = (ComparisonSortHelper<Integer>) HelperFactory.create("quick sort basic", N, config);
            System.out.println(helper);
            Sort<Integer> s = new QuickSort_Basic<>(helper);
            s.init(N);
            final Integer[] xs = helper.random(Integer.class, r -> r.nextInt(10000));
//          final Integer[] xs = {3,1,6,2,7,9,4,5};

            helper.preProcess(xs);
            System.out.println(Arrays.toString(xs));
            Integer[] ys = s.sort(xs);
            System.out.println(Arrays.toString(ys));
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
            System.out.println("ratio of compares to swaps: " + compares*1.0/swaps);



    }
}
