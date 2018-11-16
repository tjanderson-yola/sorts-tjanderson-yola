/** 
 *This is my code! A heap sort algorithm
 * CS 312 - Assignment 7
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */
public class HeapSort extends Asort
{

    public HeapSort()
    {
        super();
    }

    public void sort()
    {
        heapSort();
    }
    
    /* 
     * purpose: sort list by creating a max heap and moving the top node to the sorted part of list
     * input:   list
     * result:  the sorted list
     */
    //code taken from https://www.geeksforgeeks.org/java-program-for-heap-sort/
    private void heapSort()
    { 
        int n = list.size(); 
      
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(n, i); 
      
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            list.add(i , list.get(0));
            list.add(0, list.get(i + 1));
            list.remove(i + 2);
            list.remove(1);
      
            // call max heapify on the reduced heap 
            heapify(i, 0); 
        } 
    }

    /* 
     * purpose: heapify subtree with root i
     * input:   size of subtree n and root i
     * result:  subtree is a heap
     */
    // code taken from https://www.geeksforgeeks.org/java-program-for-heap-sort/
    void heapify(int n, int i) 
    { 
        int largest = i;  // Initialize largest as root 
        int l = 2*i + 1;  // left = 2*i + 1 
        int r = 2*i + 2;  // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && list.get(l) > list.get(largest)) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n &&  list.get(r) > list.get(largest)) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            list.add(i , list.get(largest));
            list.add(largest + 1, list.get(i + 1));
            list.remove(largest + 2);
            list.remove(i + 1);
  
            // Recursively heapify the affected sub-tree 
            heapify(n, largest); 
        } 
    } 
    
    public static void main(String[] args)
    {
        Asort sort = new HeapSort();
        sort.sort();
        System.out.print(sort.toString());
    }
}
