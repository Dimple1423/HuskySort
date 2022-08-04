//package edu.neu.coe.huskySort.bstDeletion;
//
//public class BSTH<Key extends Comparable<Key>, Value> {
//    private BSTH.Node root;
//    private class Node
//    {
//        private final Key key;
//        private Value val;
//        private BSTH.Node left, right;
//
//        private int count;
//        public Node(Key key, Value val)
//        {
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    public int size()
//    {  return size(root);  }
//    private int size(BSTH.Node x)
//    {
//        if (x == null) return 0;
//        return x.count;
//    }
//    //returns height of the tree
//    public int height() {
//        return height(root);
//    }
//    private int height(BSTH.Node x) {
//        if (x == null) return -1;
//        return 1 + Math.max(height(x.left), height(x.right));
//    }
//
//
//    public void deleteMin()
//    {  root = deleteMin(root);  }
//    private BSTH.Node deleteMin(BSTH.Node x)
//    {
//        if (x.left == null) return x.right;
//        x.left = deleteMin(x.left);
//        x.count = 1 + size(x.left) + size(x.right);
//        return x;
//    }
//    public void deleteMax() {
//        root = deleteMax(root);
//    }
//
//    private BSTH.Node deleteMax(BSTH.Node x) {
//        if (x.right == null) return x.left;
//        x.right = deleteMax(x.right);
//        x.count = size(x.left) + size(x.right) + 1;
//        return x;
//    }
//    public void deleteHeight(Key key)
//    { root = deleteHeight(root, key); }
//    private BSTH.Node deleteHeight(BSTH.Node x, Key key) {
//        if (x == null) return null;
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0) x.left = deleteHeight(x.left, key);
//        else if (cmp > 0) x.right = deleteHeight(x.right, key);
//        else {
//            if (x.right == null) return x.left;
//            if (x.left == null) return x.right;
//            if(height(x.right) > height(x.left)){
//                DeleteSuccessor(x);
//            }
//            else if(height(x.left) > height(x.right)){
//                DeletePredecessor(x);
//            }
//
//        }
//        x.count = size(x.left) + size(x.right) + 1;
//        return x;
//    }
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//    public Key min() {
//        if (isEmpty()) throw new IllegalArgumentException("calls min() with empty symbol table");
//        return min(root).key;
//    }
//
//    private BSTH.Node min(BSTH.Node x) {
//        if (x.left == null) return x;
//        else                return min(x.left);
//    }
//
//    public Key max() {
//        if (isEmpty()) throw new IllegalArgumentException("calls max() with empty symbol table");
//        return max(root).key;
//    }
//
//    private BSTH.Node max(BSTH.Node x) {
//        if (x.right == null) return x;
//        else       return max(x.right);
//    }
//
//    public void DeleteSuccessor(BSTH.Node x){
//        BSTH.Node t = x;
//        x = min(t.right);
//        x.right = deleteMin(t.right);
//        x.left = t.left;
//    }
//
//    public void DeletePredecessor(BSTH.Node x){
//        BSTH.Node t = x;
//        x = max(t.left);
//        x.left = deleteMax(t.left);
//        x.right = t.right;
//    }
//}
