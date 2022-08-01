package edu.neu.coe.huskySort.travellingSalesmanProblem;

import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.SalesmanGenome;
import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.SelectionType;
import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.ÜberSalesmensch;

import java.util.Random;

/**
 * @author Dimpleben Kanjibhai Patel
 */
public class Main {
    public static void main(String args[]){
        // Input Matrix
        int n = 10000;
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
        System.out.println();
//        for(int i=0; i<n; i++){
//            for(int j = 0; j < n; j++)
//                System.out.print(tsp[i][j] + " ");
//            System.out.println();
//        }


        // Function Call
        System.out.println("Greedy start");

        Greedy greedy = new Greedy();
        greedy.findMinRoute(tsp, initalNode);

        System.out.println("Greedy end");

        long startTime = System.nanoTime();
        System.out.println("Genetic start");

        ÜberSalesmensch geneticAlgorithm = new ÜberSalesmensch(n, SelectionType.TOURNAMENT, tsp, initalNode, 0);
        SalesmanGenome result = geneticAlgorithm.optimize();

        System.out.println("Genetic end");

        long endTime = System.nanoTime();
        double time = endTime-startTime;
        System.out.println("Time taken = "+time);

        System.out.println(result);
    }
}
