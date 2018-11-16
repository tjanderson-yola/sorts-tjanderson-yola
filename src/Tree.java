/** 
 *This is my code! It represents a tree used for tree sort
 * CS 312 - Assignment 6 
 *@author Thomas Anderson
 *@version 1.0 11/2/2018
 */

import java.util.*;

public class Tree <T extends Comparable<T>>
{
    Node root;
    Tree<T> leftSubTree;
    Tree<T> rightSubTree;
    boolean debug;
    
    public Tree()
    {
        
    }
    
    public Tree(List<T> list, boolean debug)
    {
        this.debug = debug;
        
        createTree(createLeaves(list));
    }
    
    /* 
     * purpose: sort the elements in the tree and put them in a List
     * input:   whether or not to output the individual steps of the sort
     * result:  the sorted List
     */
    public List<T> sort(boolean trace)
    {
        List<T> sortedList = new ArrayList<T>();
        
        if(debug || trace)
            System.out.println("Starting sorted tree (preorder): " + toString());
        
        while(root != null)
        {
            T temp = root.data;
            root = null;
            sortedList.add(temp);
            pushUp();
            if(debug || trace)
                System.out.println("Sorted tree after removing " + temp + ": " + toString());
        }
        
        return sortedList;
    }
    
    /* 
     * purpose: Turn a List of values into a List of leaves (trees with no children)
     * input:   List of values
     * result:  List of leaves
     */
    private List<Tree<T>> createLeaves(List<T> list)
    {
        List<Tree<T>> treeList = new LinkedList<Tree<T>>();
        
        for(T item: list)
        {
            Tree<T> temp = new Tree<T>();
            temp.root = new Node(item);
            treeList.add(temp);
        }
        
        return treeList;
    }
    
    /* 
     * purpose: recursively creates the initial tree for sorting by combining the leaves into one tree
     * input:   List of trees to combine
     * result:  the tree with all leaves inserted
     */
    private void createTree(List<Tree<T>> list)
    {  
        if(list.size() == 0)
        {
            root = null;
            leftSubTree = null;
            rightSubTree = null;
        }
        else if(list.size() == 1)
        {
            Tree<T> fullTree = list.get(0);
            this.root = fullTree.root;
            this.leftSubTree = fullTree.leftSubTree;
            this.rightSubTree = fullTree.rightSubTree;
        }
        else
        {
            List<Tree<T>> newList = new LinkedList<Tree<T>>();
            
            while(list.size() > 0)
            {
                if(list.size() == 1)
                {
                    Tree<T> nullTree = new Tree<T>();
                    newList.add(list.remove(0).combine(nullTree));
                }
                else
                    newList.add(list.remove(0).combine(list.remove(0)));
                if(debug)
                    System.out.println(newList.get(newList.size() - 1));
            }
            
            createTree(newList);
        }
    }
    
    /* 
     * purpose: combines a single other tree with this one by creating a new tree with 
     * root null and subtrees as the trees being combined and then sorting the resulting tree 
     * input:   other tree
     * result:  new tree which combines this tree with the other tree
     */
    private Tree<T> combine(Tree<T> other)
    {
        Tree<T> newTree = new Tree<T>();
        newTree.root = null;
        newTree.leftSubTree = this;
        newTree.rightSubTree = other;
        newTree.pushUp();
        return newTree;
    }
    
    /* 
     * purpose: sorts the current tree so that smallest value is moved to the top of tree
     * input:   none
     * result:  the current tree is now sorted
     */
    private void pushUp()
    {
        if(root != null)
        {
            if(debug) {System.out.println("not null in pushUp");}
            return;
        }
        else if(leftSubTree == null && rightSubTree  == null)
        {
            return;
        }
        else
        {
            if(leftSubTree.root == null)
            {
                root = rightSubTree.root;
                rightSubTree.root = null;
                rightSubTree.pushUp();
            }
            else if(leftSubTree.root.compareTo(rightSubTree.root) > 0)
            {
                root = rightSubTree.root;
                rightSubTree.root = null;
                rightSubTree.pushUp();
            }
            else
            {
                root = leftSubTree.root;
                leftSubTree.root = null;
                leftSubTree.pushUp();
            }
        }
        
    }
    
    /* 
     * purpose: outputs tree in pre-order
     * input:   none
     * result:  String of elements in tree with pre-order traversal
     */
    public String toString()
    {
        if(root == null)
        {
            return "null ";
        }
        else if(leftSubTree == null && rightSubTree == null)
        {
            return root.toString();
        }
        else if(leftSubTree == null)
        {
            return root.toString() + "( " + rightSubTree.toString() + " )"; 
        }
        else if(rightSubTree == null)
        {
            return root.toString() + "( " + leftSubTree.toString() + " )";
        }
        return root.toString() + "( " + leftSubTree.toString() + " )" + "( " + rightSubTree.toString() + " )";
    }
    
    private class Node implements Comparable<Node>
    {
        protected T data;
        
        public Node(T value)
        {
            data = value;
        }

        @Override
        public int compareTo(Tree<T>.Node o)
        {
           if(o == null)
           {
               return -1;
           }
           return data.compareTo(o.data);
        }
        
        public String toString()
        {
            return data.toString() + " ";
        }  
    }
}
