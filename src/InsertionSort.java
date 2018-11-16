/** 
 *This is my code! An insertion sort algorithm
 * CS 312 - Assignment 7
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */
public class InsertionSort extends Asort
{

    public InsertionSort()
    {
        super();
    }

    public void sort()
    {
        iterativeInsertion();
    }
    
    /* 
     * purpose: sorts list using insertion iteratively
     * input:   list
     * result:  the sorted List
     */
    private void iterativeInsertion()
    {
        for(int index = 1; index < list.size(); index ++)
        {
            int insertIndex = index;
            for(int  i = index - 1; i >= 0; i--)
            {
                if(list.get(i).compareTo(list.get(index)) >= 0)
                {
                    insertIndex = i;
                }
            }
            list.add(insertIndex, list.remove(index));
        }
    }
    
    public static void main(String[] args)
    {
        Asort sort = new InsertionSort();
        sort.sort();
        System.out.print(sort.toString());
    }
}
