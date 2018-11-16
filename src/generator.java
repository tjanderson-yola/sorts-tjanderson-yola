/** 
 *This is my code! Generates a random list of integers
 * CS 312 - Assignment 7
 *@author Thomas Anderson
 *@version 1.0 11/16/2018
 */
import java.util.Random;

public class generator
{
    private final static int MAX = 10000;
    private final static int MIN = 0;
    long seed;
    int count;
    
    private void usage()
    {
        System.err.println("\nUsage: java generator seed count\n"
                + "outputs a list of count random integers to std out\n");
    }
    
    public generator(String[] args)
    {
        processLine(args);
    }
    
    /* 
     * purpose: reads the seed and count from command line
     * input:   command line args
     * result:  seed and count or usage if commands are invalid
     */
    private void processLine(String[] args)
    {
        if(args.length != 2)
        {
            usage();
        }
        else
        {
            try 
            {
                seed = Long.parseLong(args[0]);
                count = Integer.parseInt(args[1]);
            }
            catch(NumberFormatException nfe)
            {
                usage();
            }
        }
    }
    
    /* 
     * purpose: generates list of ints and outputs to std out
     * input:   seed and count
     * result:  list of random ints
     */
    private void outputList()
    {
        Random rand = new Random(seed);
        for(int i = 0; i < count; i++)
        {
            System.out.println((rand.nextInt((MAX - MIN) + 1) + MIN) + " ");
        }
    }
    
    public static void main(String[] args)
    {
        generator intGen = new generator(args);
        intGen.outputList();
    }
    
    
}
