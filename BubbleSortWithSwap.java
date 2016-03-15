/**
 * Jack Pettit
 * CS 3130
 * Project 2
 * 3/10/16
 */


// this is my BubbleSort class. 
public class BubbleSortWithSwap
{
    private int [] smallInput;
    private int [] mediumInput;
    private int [] largeInput;
    private final int max = 10000;
    private final int min = 1;

    BubbleSortWithSwap()
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
    public void printArray(int [] arr)
    {
        //System.out.println("Hello: ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void bubbleSortWithCount(int [] arr)
    {
        int temp = 0;
        //int count = 1;
        int swaps = 0;

        for (int j = 0; j < arr.length; j++)
        {
            for (int i = 0; i < arr.length - j - 1; i++)
            {
                if (arr[i] > arr[i + 1])
                {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swaps++;
                }
            }
            if (swaps == 0)
            {
                //System.out.println("Already sorted. J is " + j);
                break;
            }
        }

    }

}
