package edu.neu.coe.huskySort.travellingSalesmanProblem;

import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.SalesmanGenome;
import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.SelectionType;
import edu.neu.coe.huskySort.travellingSalesmanProblem.geneticAlgorithm.ÜberSalesmensch;

import java.util.Random;

/**
 * @author Dimpleben Kanjibhai Patel
 */
public class Main {
    public static void main(String args[]) {
        // Input Matrix
        for (int n = 3; n < 20; n++) {
            System.out.println("Number of cities =" + n);
            Random r = new Random();
            int[][] tsp = new int[n][n];
            int initalNode = r.nextInt(tsp.length);

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    tsp[i][j] = r.nextInt(100);
                    tsp[j][i] = tsp[i][j];
                }
                tsp[i][i] = -1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(tsp[i][j] + " ");
                System.out.println();
            }


            // Function Call
            Greedy greedy = new Greedy();
            greedy.findMinRoute(tsp, initalNode);

            ÜberSalesmensch geneticAlgorithm = new ÜberSalesmensch(n, SelectionType.TOURNAMENT, tsp, initalNode, 0);
            SalesmanGenome result = geneticAlgorithm.optimize();
            System.out.println(result);
        }
    }
}
