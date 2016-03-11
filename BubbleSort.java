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

    private void sortedInput(int[] array)
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
            this.mediumInput[j] = j + 1;
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
        printArray(this.smallInput);
    }
    private void printArray(int [] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main (String[] args)
    {
        BubbleSort mySort = new BubbleSort();
        mySort.almostSorted();
    }
}
