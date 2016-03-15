import java.util.Random;

/**
 * Created by skelatorjack on 3/10/16.
 */
public class QuickSort
{
    private int[] smallInput;
    private int[] mediumInput;
    private int[] largeInput;
    private final int MAX = 10000;
    private final int MIN = 1;

    QuickSort()
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
    public void quickSort(int lowerIndex, int higherIndex, int [] array)
    {
        int i = lowerIndex;
        int j = higherIndex;

        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j)
        {
            while (array[i] < pivot)
                i++;

            while (array[j] > pivot)
                j--;

            if (i <= j)
            {
                swapNumbers(i, j, array);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);

        if (i < higherIndex)
            quickSort(i, higherIndex, array);
    }
    public void swapNumbers(int i , int j, int [] array)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
