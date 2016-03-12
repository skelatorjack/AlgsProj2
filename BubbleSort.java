/**
 * Created by skelatorjack on 3/10/16.
 */

import java.util.*;

public class BubbleSort
{
    private int [] smallInput;
    private int [] mediumInput;
    private int [] largeInput;
    private final int max = 1000;
    private final int min = 1;

    BubbleSort()
    {
        smallInput = new int[12];
        mediumInput = new int[1000];
        largeInput = new int[10000];
    }

    // add elements to these arrays in sorted order. These numbers range from 1 to 1000 inclusive.

    private void sortedInput()
    {

        for (int i = 0; i < this.smallInput.length; i++)
            this.smallInput[i] = i + 1;


        for (int j = 0; j < this.mediumInput.length; j++)
            this.mediumInput[j] = j + 1;


        for (int l = 0; l < this.largeInput.length; l++)
            this.largeInput[l] = l + 1;

    }

    // add elements to these arrays in random order. These numbers range from 1 to 1000 inclusive.
    private void randomInput()
    {

        Random rand = new Random();
        int randomNum = 0;

        for (int i = 0; i < this.smallInput.length; i++)
        {
            randomNum = rand.nextInt((this.max - this.min) + 1);
            this.smallInput[i] = randomNum;
        }

        for (int j = 0; j < this.mediumInput.length; j++)
        {
            randomNum = rand.nextInt((this.max - this.min) + 1);
            this.mediumInput[j] = randomNum;
        }

        for (int l = 0; l < this.largeInput.length; l++)
        {
            randomNum = rand.nextInt((this.max - this.min) + 1);
            this.largeInput[l] = randomNum;
        }

    }
    private void almostSorted()
    {
        for (int i = 0; i < this.smallInput.length; i++)
        {
            if (((i + 1) % 10) == 0 && i != this.smallInput.length - 1)
            {
                this.smallInput[i] = i + 2;
                this.smallInput[i + 1] = this.smallInput[i] - 1;
                i++;
            }
            else
            {
                this.smallInput[i] = i + 1;
            }
        }

        for (int i = 0; i < this.mediumInput.length; i++)
        {
            if (((i + 1) % 10) == 0 && i != this.mediumInput.length - 1)
            {
                this.mediumInput[i] = i + 2;
                this.mediumInput[i + 1] = this.mediumInput[i] - 1;
                i++;
            }
            else
            {
                this.mediumInput[i] = i + 1;
            }
        }

        for (int i = 0; i < this.largeInput.length; i++)
        {
            if (((i + 1) % 10) == 0 && i != this.largeInput.length - 1)
            {
                this.largeInput[i] = i + 2;
                this.largeInput[i + 1] = this.largeInput[i] - 1;
                i++;
            }
            else
            {
                this.largeInput[i] = i + 1;
            }
        }
        //arr = this.smallInput;
        //printArray(this.smallInput);
    }
    private void printArray(int [] arr)
    {
        //System.out.println("Hello: ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    private void bubbleSortWithoutCount(int [] arr)
    {
        int temp = 0;

        for (int j = 0; j < arr.length; j++)
        {
            for (int i = 1; i < arr.length - j; i++)
            {
                if (arr[i - 1] > arr[i])
                {
                    temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    private void bubbleSortWithCount(int [] arr) {
        int temp = 0;
        int count = 1;
        while (count != 0) {
            count = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    count++;
                }
            }

        }
    }
    private void copyArray(int [] arr)
    {
        if (this.smallInput.length == arr.length)
        {
            for (int i = 0; i < smallInput.length; i++)
            {
                arr[i] = this.smallInput[i];
            }
        }
        else if (this.mediumInput.length == arr.length)
        {
            for (int i = 0; i < mediumInput.length; i++)
            {
                arr[i] = this.mediumInput[i];
            }
        }
        else
        {
            for (int i = 0; i < this.largeInput.length; i++)
            {
                arr[i] = this.largeInput[i];
            }
        }
    }
    public static void main (String[] args)
    {
        int [] arr1 = new int[12];
        int [] arr2 = new int[1000];
        int [] arr3 = new int[10000];
        long startTime = 0;
        long endTime = 0;
        long duration = 0;


        BubbleSort mySort = new BubbleSort();
        //mySort.sortedInput(arr1, arr2, arr3);
        mySort.almostSorted();
        mySort.copyArray(arr1);
        System.out.println("Before sort: ");
        mySort.printArray(arr1);
        //mySort.randomInput();
        startTime = System.nanoTime();
        mySort.bubbleSortWithoutCount(arr1);
        endTime = System.nanoTime();
        mySort.printArray(arr1);
        duration = endTime - startTime;


        System.out.println("The time for BubbleSort with no swaps counting for 10 elements with almost sorted input is: " + duration + " nanoseconds.");

        startTime = 0;
        endTime = 0;
        mySort.copyArray(arr1);

        System.out.println("Before sort: ");
        mySort.printArray(arr1);
        startTime = System.nanoTime();
        mySort.bubbleSortWithCount(arr1);
        endTime = System.nanoTime();
        duration = endTime - startTime;

        mySort.printArray(arr1);

        System.out.println("The time for BubbleSort with  swaps counting for 10 elements with almost sorted input is: " + duration + " nanoseconds.");


    }
}
