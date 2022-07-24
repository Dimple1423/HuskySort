package edu.neu.coe.huskySort.travellingSalesmanProblem;

import java.util.Random;

/**
 * @author Dimpleben Kanjibhai Patel
 */
public class Main {
    public static void main(String args[]){
        // Input Matrix
        int n = 4;
        int[][] tsp = new int[n][n];
        Random r = new Random();
        for(int i=0; i< n; i++){
            for(int j = i+1; j < n; j++){
                tsp[i][j] = r.nextInt(100);
                tsp[j][i] = tsp[i][j];
            }
            tsp[i][i] = -1;
        }
        for(int i=0; i<n; i++){
            for(int j = 0; j < n; j++)
                System.out.print(tsp[i][j] + " ");
            System.out.println();
        }


        // Function Call
        Greedy greedy = new Greedy();
        greedy.findMinRoute(tsp);
    }
}
