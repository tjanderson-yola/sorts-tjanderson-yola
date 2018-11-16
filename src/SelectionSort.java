/** 
 *This is my code! Selection sort algorithm
 * CS 312 - Assignment 7 
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */

public class SelectionSort extends Asort
{

    public SelectionSort()
    {
        super();
    }

    public void sort()
    {
        iterativeSelection();
    }
    
    /* 
     * purpose: sort list using iterative selection sort
     * input:   list
     * result:  the sorted list
     */
    private void iterativeSelection()
    {
        for(int index = 0; index < list.size() - 1; index++)
        {
            Comparable<Integer> min = list.get(index);
            int minIndex = index;
            
            for(int i = index; i < list.size(); i++)
            {
                if(min.compareTo(list.get(i)) > 0)
                {
                    min = list.get(i);
                    minIndex = i;
                }
            }
            
            list.add(index, list.get(minIndex));
            list.add(minIndex + 1, list.get(index + 1));
            list.remove(minIndex + 2);
            list.remove(index + 1);
        }
            
    }
    
    public static void main(String[] args)
    {
        Asort sort = new SelectionSort();
        sort.sort();
        System.out.print(sort.toString());
    }
}
