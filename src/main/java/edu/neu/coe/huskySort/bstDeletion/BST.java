package edu.neu.coe.huskySort.bstDeletion;

import java.util.Random;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node
    {
        private final Key key;
        private Value val;
        private Node left, right;

        private int count;
        public Node(Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }
    }

    public int size()
    {  return size(root);  }
    private int size(Node x)
    {
        if (x == null) return 0;
        return x.count;
    }
//returns height of the tree
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public void put(Key key, Value val)
    { root = put(root, key, val); }
    private Node put(Node x, Key key, Value val)
    {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else if (cmp == 0)
            x.val = val;
        return x;
    }
    public Value get(Key key)
    {
        Node x = root;
        while (x != null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.val;
        }
        return null;
    }



    public void deleteMin()
    {  root = deleteMin(root);  }
    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key)
    { root = delete(root, key); }
    private Node delete(Node x, Key key) {
        Random r = new Random();
        int select = r.nextInt(2);
//        System.out.println(select);
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            if( select ==0){
                deleteSuccessor(x);
            }
            else if(select ==1){
                deletePredecessor(x);
            }

        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteHeight(Key key)
    { root = deleteHeight(root, key); }
    private Node deleteHeight(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = deleteHeight(x.left, key);
        else if (cmp > 0) x.right = deleteHeight(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            if(height(x.right) > height(x.left)){
                deleteSuccessor(x);
            }
            else if(height(x.left) > height(x.right)){
                deletePredecessor(x);
            }

        }
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    public Key min() {
        if (isEmpty()) throw new IllegalArgumentException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new IllegalArgumentException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else       return max(x.right);
    }

    public void deleteSuccessor(Node x){
        Node t = x;
        x = min(t.right);
        x.right = deleteMin(t.right);
        x.left = t.left;
    }

    public void deletePredecessor(Node x){
        Node t = x;
        x = max(t.left);
        x.left = deleteMax(t.left);
        x.right = t.right;
    }

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node x) {
        if (x == null) {
            return;
        }

        inOrder(x.left);
        System.out.printf("%s ", x.key);
        inOrder(x.right);
    }




    public static void main(String[] args){
        BST tree = new BST();
        Random r = new Random();
        int t=0;

        for(int i=0; i<100; i++){
            t = r.nextInt(100000);
//            System.out.print(t+" ");
            tree.put(t,t);

        }
        tree.inOrder();
        tree.deleteHeight(t);
        System.out.println(" ");
        tree.inOrder();




//        System.out.println(tree.height());
    }
}
