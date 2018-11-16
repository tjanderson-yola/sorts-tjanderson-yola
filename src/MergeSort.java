/** 
 *This is my code! A merge sort algorithm
 * CS 312 - Assignment 7
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */

import java.util.List;
import java.util.LinkedList;

public class MergeSort extends Asort
{

    public MergeSort()
    {
        super();
    }

    public void sort()
    {
        mergeSort(list, list.size());
    }
    
    /* 
     * purpose: sort list using merge sort
     * input:   list, and the size of the list
     * result:  sorted list
     */
    //code taken from https://www.baeldung.com/java-merge-sort
    public void mergeSort(List<Integer> a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        List<Integer> l = new LinkedList<Integer>();
        List<Integer> r = new LinkedList<Integer>();
     
        for (int i = 0; i < mid; i++) {
            l.add(a.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.add(a.get(i));
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
     
        merge(a, l, r, mid, n - mid);
    }
    
    /* 
     * purpose: merge sublists together in sorted order
     * input:   left and right sublists, and the list to merge them into
     * result:  sorted list
     */
    //code taken from https://www.baeldung.com/java-merge-sort
    public void merge(List<Integer> a, List<Integer> l, List<Integer> r, int left, int right) 
    {
            
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) 
        {
            if (l.get(i) < r.get(j)) 
            {
                a.add(k++, l.get(i++));
                a.remove(k);
            }
            else 
            {
                a.add(k++, r.get(j++));
                a.remove(k);
            }
        }
          
        while (i < left) 
        {
            a.add(k++, l.get(i++));
            a.remove(k);
        }
        while (j < right) 
        {
            a.add(k++, r.get(j++));
            a.remove(k);
        }
    }
    
    public static void main(String[] args)
    {
        Asort sort = new MergeSort();
        sort.sort();
        System.out.print(sort.toString());
    }
}
