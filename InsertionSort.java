import java.util.Random;

/**
 * Created by skelatorjack on 3/10/16.
 */
public class InsertionSort
{
    private int[] smallInput;
    private int[] mediumInput;
    private int[] largeInput;
    private final int MAX = 10000;
    private final int MIN = 1;

    InsertionSort()
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
            for (int i = 0; i < largeInput.length; i++)
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
    public void insertionSort(int [] array)
    {
        int temp = 0;

        for (int i = 1; i < array.length; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (array[j] < array[j - 1])
                {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }

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
    public void copyArray(int [] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = smallInput[i];
        }
    }
}
