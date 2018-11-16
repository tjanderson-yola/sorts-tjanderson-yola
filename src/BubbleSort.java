/** 
 *This is my code! A bubble sort algorithm
 * CS 312 - Assignment 7
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */

public class BubbleSort extends Asort
{

    public BubbleSort()
    {
        super();
    }

    public void sort()
    {
        iterativeBubble();
    }
    
    /* 
     * purpose: sorts the elements in a list using iterative Bubble sort
     * input:   list
     * result:  the sorted List
     */
    private void iterativeBubble()
    {
        for(int size =  list.size(); size > 1; size --)
        {
            for(int i = 0; i < size - 1; i++)
            {
                if(list.get(i).compareTo(list.get(i+1)) > 0)
                {
                    list.add(i,list.remove(i+1)); 
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        Asort sort = new BubbleSort();
        sort.sort();
        System.out.print(sort.toString());
    }
}
