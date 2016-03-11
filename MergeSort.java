/**
 * Jack Pettit
 * CS 3130
 * 3/9/16
 *
 */

import java.util.*;

public class MergeSort
{
    private int [] smallInput;
    private int [] mediumInput;
    private int [] largeInput;
    private final int max = 1000;
    private final int min = 1;

    MergeSort()
    {
        this.smallInput = new int[10];
        this.mediumInput = new int[1000];
        this.largeInput = new int[10000];
    }
    public void sortedArray(int [] array)
    {
        for (int i = 0; i < array.length; i++)
        {
             array[i] = i + 1;
        }
    }
    public void randomArray(int [] array, int max, int min)
    {
        Random rand = new Random();
        int randomNum = 0;

        for (int i = 0; i < array.length; i++)
        {
            randomNum = rand.nextInt((max - min) + 1);
            array[i] = randomNum;
        }
    }
    public static void main(String [] args)
    {
        MergeSort mySort = new MergeSort();
        mySort.randomArray(mySort.smallInput, mySort.max, mySort.min);

        for (int i = 0; i < mySort.smallInput.length; i++)
        {
            System.out.println("SmallInput [" + i + "] is " + mySort.smallInput[i]);
        }
    }
}
