/** 
 *This is my code!A tree sort algorithm
 * CS 312 - Assignment 7 
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */
public class TreeSort extends Asort
{

    public TreeSort()
    {
        super();
    }

    /* 
     * purpose: sorts list using tree sort (from asn6)
     * input:   list
     * result:  the sorted list
     */
    public void sort()
    {
        Tree<Integer> sortTree = new Tree<Integer>(list, false);
        list = sortTree.sort(false);
    }
    
    public static void main(String[] args)
    {
        Asort sort = new TreeSort();
        sort.sort();
        System.out.print(sort.toString());
    }
}
