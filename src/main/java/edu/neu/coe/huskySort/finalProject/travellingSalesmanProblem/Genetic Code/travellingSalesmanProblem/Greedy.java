package edu.neu.coe.huskySort.travellingSalesmanProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Dimpleben Kanjibhai Patel
 */
public class Greedy {
    // Function to find the minimum
    // cost path for all the paths
    static void findMinRoute(int[][] tsp, int initialNode)
    {
        int sum = 0;
        int counter = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> visitedRouteList
                = new ArrayList<>();

        // Starting from the 0th indexed
        // city i.e., the first city
        Random r = new Random();

        int i = initialNode;
        visitedRouteList.add(initialNode);
        int[] route = new int[tsp.length];

        // Traverse the adjacency
        // matrix tsp[][]
        while (i < tsp.length
                && j < tsp[i].length) {

            // Corner of the Matrix
            if (counter >= tsp[i].length - 1) {
                break;
            }

            // If this path is unvisited then
            // and if the cost is less then
            // update the cost
            if (j != i
                    && !(visitedRouteList.contains(j))) {
                if (tsp[i][j] < min) {
                    min = tsp[i][j];
                    route[counter] = j + 1;
                }
            }
            j++;

            // Check all paths from the
            // ith indexed city
            if (j == tsp[i].length) {
                sum += min;
                min = Integer.MAX_VALUE;
                visitedRouteList.add(route[counter] - 1);
                j = 0;
                i = route[counter] - 1;
                counter++;
            }
        }


        // Update the ending city in array
        // from city which was last visited
        i = route[counter - 1] - 1;
        System.out.println(initialNode);
        for(int x: visitedRouteList)
            System.out.print(x + " ");
        System.out.println();
        sum += tsp[i][initialNode];
//
//        for (j = 0; j < tsp.length; j++) {
//
//            if ((i != j) && tsp[i][j] < min) {
//                min = tsp[i][j];
//                route[counter] = j + 1;
//            }
//        }
//        sum += min;

        // Started from the node where
        // we finished as well.
        System.out.print("Greedy : Minimum Cost is : ");
        System.out.println(sum);
    }
}
