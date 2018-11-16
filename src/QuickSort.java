/** 
 *This is my code! Quick sort algorithm
 * CS 312 - Assignment 7
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */
public class QuickSort extends Asort
{

    public QuickSort()
    {
        super();
    }

    public void sort()
    {
        quickSort(0, list.size() - 1);
    }
    
    /* 
     * purpose: sort list using quick sort algorithm
     * input:   beginning and ending indices of unsorted list
     * result:  the sorted list
     */
    //code taken from https://www.baeldung.com/java-quicksort
    public void quickSort(int begin, int end) {
        
        if (begin < end) {
            int partitionIndex = partition(begin, end);
     
            quickSort(begin, partitionIndex-1);
            quickSort(partitionIndex+1, end);
        }
        
    }
    
    /* 
     * purpose: determine pivot and move everything less than pivot before and everything greater after
     * input:   beginning and ending indices of the list
     * result:  the partition index
     */
    //code taken from https://www.baeldung.com/java-quicksort
    private int partition(int begin, int end) {
        int pivot = list.get(end);
        int i = (begin-1);
     
        for (int j = begin; j < end; j++) {
            if (list.get(j) <= pivot) {
                i++;
     
                list.add(i, list.get(j));
                list.add(j + 1, list.get(i + 1));
                list.remove(j + 2);
                list.remove(i + 1);
            }
        }
     
        
        list.add(i + 1, list.get(end));
        list.add(end + 1, list.get(i + 2));
        list.remove(end + 2);
        list.remove(i + 2);
     
        return i+1;
    }
    
    public static void main(String[] args)
    {
        Asort sort = new QuickSort();
        sort.sort();
        System.out.print(sort.toString());
    }
}
