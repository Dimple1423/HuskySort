package edu.neu.coe.huskySort.travellingSalesmanProblem;

import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.SalesmanGenome;
import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.SelectionType;
import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.ÜberSalesmensch;

import java.util.List;
import java.util.Random;

/**
 * @author Dimpleben Kanjibhai Patel
 */
public class Main {
    public static void main(String args[]){
        // Input Matrix
        int n = 4000;

        Random r = new Random();
        int[][] tsp = new int[n][n];
        int initalNode = r.nextInt(tsp.length);
        int x = 0;
        for(int i=0; i< n; i++){
            System.out.print(++x+" ");
            for(int j = i+1; j < n; j++){
                tsp[i][j] = r.nextInt(100);
                tsp[j][i] = tsp[i][j];
            }
            tsp[i][i] = -1;
        }

//        for(int i=0; i<n; i++){
//            for(int j = 0; j < n; j++)
//                System.out.print(tsp[i][j] + " ");
//            System.out.println();
//        }

        // Function Call
        System.out.println("Greedy start");
        long startTime = System.nanoTime();

        Greedy greedy = new Greedy();
        List<Integer> greedyResult =  greedy.findMinRoute(tsp, initalNode);

        long endTime = System.nanoTime();
        double time = endTime-startTime;
        time = (double) (endTime-startTime)/1000000000;
        System.out.println("Time taken = "+time);

        System.out.println("Greedy end");

        ÜberSalesmensch geneticAlgorithm = new ÜberSalesmensch(n, SelectionType.TOURNAMENT, tsp, initalNode, 0);
        SalesmanGenome result = geneticAlgorithm.optimize(greedyResult);

        System.out.println(result);
    }
}
