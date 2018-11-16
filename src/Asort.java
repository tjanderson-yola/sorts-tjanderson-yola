/** 
 *This is my code! An abstract class which represents a sort class
 * CS 312 - Assignment 7
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Asort
{
    protected List<Integer> list;
    
    public Asort()
    {
        list = new LinkedList<Integer>();
        //list = new ArrayList<Integer>();
        readList();
    }
    
    /* 
     * purpose: read integers of a list that are piped in and put into a list
     * input:   std in
     * result:  the list of integers
     */
    private void readList()
    {
        Scanner scan = new Scanner(System.in);
        System.err.println("if given nothing to read, will cause loop, simply type \"exit\" to escape\n");
        while(scan.hasNext())
        {
            try 
            {
                String next = scan.next();
                if(next.equals("exit"))
                {
                    break;
                }
                list.add(new Integer(Integer.parseInt(next)));
            }
            catch(NumberFormatException nfe)
            {
                System.err.println("skipped item because it was not a number");
            }
        }
        scan.close();
    }
       
    public String toString()
    {
        String str = "";
        for(Comparable<Integer> item:list)
        {
            str += item + " \n";
        }
        
        return str;
    }
    
    public abstract void sort(); 
}