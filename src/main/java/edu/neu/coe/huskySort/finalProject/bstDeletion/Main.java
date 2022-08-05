package edu.neu.coe.huskySort.finalProject.bstDeletion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        BSTSimple bSimple = new BSTSimple();
        BSTRandom bRandom = new BSTRandom();
        BSTOptimisedDelete bOd = new BSTOptimisedDelete();
        Random r = new Random();
        List<Integer> list=new ArrayList<>();
        int n=512;

        int t=0;
       // int[] rand = new int[n];

        for(int i=0; i<n; i++){
            t = r.nextInt(1000);
            //rand[i] = t;
//            System.out.print(t+" ");
            bSimple.put(t,t);
            bOd.put(t,t);
            list.add(t);
            //bRandom.put(t,t);
            bOd.put(t,t);
        }
        System.out.println("Simple Size = " + bSimple.size());
//        System.out.println("Random Size = " + bRandom.size());
        System.out.println("Optimized Size = " + bOd.size());
        System.out.println("Simple Height = " + bSimple.depth());
//        System.out.println("Random Height = " + bRandom.height());
        System.out.println("Optimized Height = " + bOd.depth());

//        bRandom.inOrder();
        for(int i=0; i<n/2; i++){
            int a = r.nextInt(list.size());
            bSimple.delete(list.get(a));
            bOd.delete(list.get(a));
            list.remove(a);
            //bRandom.delete(rand[a]);

        }


        System.out.println(" ");
//        bRandom.inOrder();
        System.out.println("Simple Size = " + bSimple.size());
//        System.out.println("Random Size = " + bRandom.size());
        System.out.println("Optimized Size = " + bOd.size());
        System.out.println(" ");
        System.out.println("Simple Height = " + bSimple.depth());
//        System.out.println("Random Height = " + bRandom.height());
        System.out.println("Optimized Height = " + bOd.depth());





    }

}
