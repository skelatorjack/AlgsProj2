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
    private final int MAX = 10000;
    private final int MIN = 1;

    MergeSort()
    {
        this.smallInput = new int[100];
        this.mediumInput = new int[1000];
        this.largeInput = new int[10000];
    }
    public void setSmallInput(int [] arr)
    {
        if (arr.length == this.smallInput.length)
            System.arraycopy(arr, 0, this.smallInput, 0, this.smallInput.length);
    }
    public void setMediumInput(int [] arr)
    {
        if (arr.length == this.mediumInput.length)
            System.arraycopy(arr, 0, this.mediumInput, 0, this.mediumInput.length);
    }
    public void setLargeInput(int [] arr)
    {
        if (arr.length == this.largeInput.length)
        {
            System.arraycopy(arr, 0, this.largeInput, 0, this.largeInput.length);
            for (int i = 0; i < this.largeInput.length; i++)
            {
                if (this.largeInput[i] == 0)
                    this.largeInput[i] = 1;
            }
        }
    }
    public int [] getSmallInput()
    {
        return this.smallInput;
    }
    public int [] getMediumInput()
    {
        return this.mediumInput;
    }
    public int [] getLargeInput()
    {
        return this.largeInput;
    }
    public void mergeSort(int lowerIndex, int higherIndex, int [] array)
    {
        if (lowerIndex < higherIndex)
        {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

            mergeSort(lowerIndex, middle, array);

            mergeSort(middle + 1, higherIndex, array);

            merge(lowerIndex, middle, higherIndex, array);
        }
    }
    public void merge(int lowerIndex, int middle, int higherIndex, int [] array)
    {
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        int [] tempMerge = new int[array.length];

        for (int t = 0; t < array.length; t++)
        {
            tempMerge[t] = array[t];
        }

        while(i <= middle && j <= higherIndex)
        {
            if (tempMerge[i] <= tempMerge[j])
            {
                array[k] = tempMerge[i];
                i++;
            }
            else
            {
                array[k] = tempMerge[j];
                j++;
            }
            k++;
        }
        while (i <= middle)
        {
            array[k] = tempMerge[i];
            k++;
            i++;
        }
    }
    /*
    public void printArray(int [] arr)
    {
        //System.out.println("Hello: ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    */

}
