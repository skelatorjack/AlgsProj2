/**
 * Created by skelatorjack on 3/10/16.
 */

import java.util.*;

public class SelectionSort
{
    private int[] smallInput;
    private int[] mediumInput;
    private int[] largeInput;
    private final int MAX = 10000;
    private final int MIN = 1;

    SelectionSort()
    {
        smallInput = new int[100];
        mediumInput = new int[1000];
        largeInput = new int[10000];
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
    public void selectionSort(int [] array)
    {
        int first = 0;
        int temp = 0;

        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;

            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[index])
                    index = j;
            }
            int smallNum = array[index];
            array[index] = array[i];
            array[i] = smallNum;
        }
    }
    /*
    public void printArray(int [] array)
    {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    */

}

