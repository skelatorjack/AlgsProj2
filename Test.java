/**
 * Created by skelatorjack on 3/14/16.
 */

import java.util.*;

public class Test
{
    private int [] smallInput;
    private int [] mediumInput;
    private int [] largeInput;
    private final int MAX;
    private final int MIN;
    private long startTime;
    private long endTime;
    private long duration;

    Test()
    {
        this.smallInput = new int[100];
        this.mediumInput = new int[1000];
        this.largeInput = new int[10000];
        this.startTime = 0;
        this.endTime = 0;
        this.duration = 0;
        this.MAX = 10000;
        this.MIN = 1;
    }
    public void sortedInput()
    {
        for (int i = 0; i < this.smallInput.length; i++)
            this.smallInput[i] = i + 1;


        for (int j = 0; j < this.mediumInput.length; j++)
            this.mediumInput[j] = j + 1;


        for (int l = 0; l < this.largeInput.length; l++)
            this.largeInput[l] = l + 1;

    }

    // add elements to these arrays in random order. These numbers range from 1 to 10000 inclusive.

    public void randomInput()
    {

        Random rand = new Random();
        int randomNum = 0;

        for (int i = 0; i < this.smallInput.length; i++)
        {
            randomNum = rand.nextInt((this.MAX - this.MIN) + 1);
            this.smallInput[i] = randomNum;
        }

        for (int j = 0; j < this.mediumInput.length; j++)
        {
            randomNum = rand.nextInt((this.MAX - this.MIN) + 1);
            this.mediumInput[j] = randomNum;
        }


        for (int l = 0; l < this.largeInput.length; l++)
        {
            randomNum = rand.nextInt((this.MAX - this.MIN) + 1);
            this.largeInput[l] = randomNum;
        }


    }

    public void almostSorted()
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

    }

    public void setUpTimer()
    {
        this.endTime = 0;
        this.startTime = 0;
        this.duration = 0;
    }
    public static long calculateTime(long startTime, long endTime)
    {
        return endTime - startTime;
    }
    public void testSorted(BubbleSort bs, InsertionSort is, QuickSort qs, MergeSort ms, SelectionSort ss)
    {
        this.sortedInput();
        bs.setSmallInput(this.smallInput);
        is.setSmallInput(this.smallInput);
        ms.setSmallInput(this.smallInput);
        qs.setSmallInput(this.smallInput);
        ss.setSmallInput(this.smallInput);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("SMALL INPUT SORTED ORDER.");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        // for smallInput
        this.setUpTimer();
            // bubble sort with swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getSmallInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        System.out.println("The array after sort is: ");
        //bs.printArray(bs.getSmallInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.smallInput.length + " elements in " +
                " sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();
            // bubble sort with no swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getSmallInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getSmallInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.smallInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getSmallInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //is.printArray(is.getSmallInput());
        System.out.println("The running time for a insertion sort for " + this.smallInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
        //System.out.println("The array before sort is ");
        //qs.printArray(qs.getSmallInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getSmallInput().length - 1, qs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //qs.printArray(qs.getSmallInput());
        System.out.println("The running time for a quick sort for " + this.smallInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
        //System.out.println("The array before sort is ");
        //ms.printArray(ms.getSmallInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getSmallInput().length - 1, ms.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ms.printArray(ms.getSmallInput());
        System.out.println("The running time for a merge sort for " + this.smallInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
        //System.out.println("The array before sort is ");
        //ss.printArray(ss.getSmallInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ss.printArray(ss.getSmallInput());
        System.out.println("The running time for a selection sort for " + this.smallInput.length + " elements in  sorted order in nanoseconds is: " + this.duration);

        // set mediumInput
        bs.setMediumInput(this.mediumInput);
        is.setMediumInput(this.mediumInput);
        ms.setMediumInput(this.mediumInput);
        qs.setMediumInput(this.mediumInput);
        ss.setMediumInput(this.mediumInput);

        // for mediumInput
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("MEDIUM INPUT SORTED ORDER");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        this.setUpTimer();
        // bubble sort with swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getMediumInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getMediumInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.mediumInput.length + " elements in  sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getMediumInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getMediumInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.mediumInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getMediumInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //is.printArray(is.getMediumInput());
        System.out.println("The running time for a insertion sort for " + this.mediumInput.length + " elements in sorted order nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
        //System.out.println("The array before sort is ");
        //qs.printArray(qs.getMediumInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getMediumInput().length - 1, qs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //qs.printArray(qs.getMediumInput());
        System.out.println("The running time for a quick sort for " + this.mediumInput.length + " elements in sorted order nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
        //System.out.println("The array before sort is ");
        //ms.printArray(ms.getMediumInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getMediumInput().length - 1, ms.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ms.printArray(ms.getMediumInput());
        System.out.println("The running time for a merge sort for " + this.mediumInput.length + " elements in sorted order nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
        //System.out.println("The array before sort is ");
        //ss.printArray(ss.getMediumInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ss.printArray(ss.getMediumInput());
        System.out.println("The running time for a selection sort for " + this.mediumInput.length + " elements in sorted order nanoseconds is: " + this.duration);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("LARGE INPUT SORTED ORDER");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        bs.setLargeInput(this.largeInput);
        is.setLargeInput(this.largeInput);
        ms.setLargeInput(this.largeInput);
        qs.setLargeInput(this.largeInput);
        ss.setLargeInput(this.largeInput);

        // large input
        this.setUpTimer();
        // bubble sort with swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getLargeInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getLargeInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.largeInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getLargeInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getLargeInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.largeInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getLargeInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //is.printArray(is.getLargeInput());
        System.out.println("The running time for a insertion sort for " + this.largeInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
        System.out.println("The array before sort is ");
        //qs.printArray(qs.getLargeInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getLargeInput().length - 1, qs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //qs.printArray(qs.getLargeInput());
        System.out.println("The running time for a quick sort for " + this.largeInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
        //System.out.println("The array before sort is ");
       // ms.printArray(ms.getLargeInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getLargeInput().length - 1, ms.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ms.printArray(ms.getLargeInput());
        System.out.println("The running time for a merge sort for " + this.largeInput.length + " elements in sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
        //System.out.println("The array before sort is ");
        //ss.printArray(ss.getLargeInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ss.printArray(ss.getLargeInput());
        System.out.println("The running time for a selection sort for " + this.largeInput.length + " elements in nanoseconds is: " + this.duration);
    }
    public void testRandom(BubbleSort bs, InsertionSort is, QuickSort qs, MergeSort ms, SelectionSort ss)
    {
        this.randomInput();
        bs.setSmallInput(this.smallInput);
        is.setSmallInput(this.smallInput);
        ms.setSmallInput(this.smallInput);
        qs.setSmallInput(this.smallInput);
        ss.setSmallInput(this.smallInput);

        // for smallInput
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("SMALL INPUT RANDOM ORDER");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        this.setUpTimer();
        // bubble sort with swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getSmallInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // bs.printArray(bs.getSmallInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.smallInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
       // System.out.println("The array before sort is ");
       // bs.printArray(bs.getSmallInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // bs.printArray(bs.getSmallInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.smallInput.length + " elements in  random order  in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
      //  System.out.println("The array before sort is ");
       // is.printArray(is.getSmallInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // is.printArray(is.getSmallInput());
        System.out.println("The running time for a insertion sort for " + this.smallInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
       /// System.out.println("The array before sort is ");
       // qs.printArray(qs.getSmallInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getSmallInput().length - 1, qs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // qs.printArray(qs.getSmallInput());
        System.out.println("The running time for a quick sort for " + this.smallInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
       // System.out.println("The array before sort is ");
        //ms.printArray(ms.getSmallInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getSmallInput().length - 1, ms.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ms.printArray(ms.getSmallInput());
        System.out.println("The running time for a merge sort for " + this.smallInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
       // System.out.println("The array before sort is ");
       // ss.printArray(ss.getSmallInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ss.printArray(ss.getSmallInput());
        System.out.println("The running time for a selection sort for " + this.smallInput.length + " elements in random order in nanoseconds is: " + this.duration);

        // set mediumInput
        bs.setMediumInput(this.mediumInput);
        is.setMediumInput(this.mediumInput);
        ms.setMediumInput(this.mediumInput);
        qs.setMediumInput(this.mediumInput);
        ss.setMediumInput(this.mediumInput);

        // for mediumInput
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("MEDIUM INPUT RANDOM ORDER.");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        this.setUpTimer();
        // bubble sort with swaps counting
       // System.out.println("The array before sort is ");
        //bs.printArray(bs.getMediumInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // bs.printArray(bs.getMediumInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.mediumInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
        System.out.println("The array before sort is ");
       // bs.printArray(bs.getMediumInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
       // bs.printArray(bs.getMediumInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.mediumInput.length + " elements in  random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getMediumInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // is.printArray(is.getMediumInput());
        System.out.println("The running time for a insertion sort for " + this.mediumInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
       // System.out.println("The array before sort is ");
       // qs.printArray(qs.getMediumInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getMediumInput().length - 1, qs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // qs.printArray(qs.getMediumInput());
        System.out.println("The running time for a quick sort for " + this.mediumInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
       // System.out.println("The array before sort is ");
       // ms.printArray(ms.getMediumInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getMediumInput().length - 1, ms.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ms.printArray(ms.getMediumInput());
        System.out.println("The running time for a merge sort for " + this.mediumInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
        //System.out.println("The array before sort is ");
       // ss.printArray(ss.getMediumInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ss.printArray(ss.getMediumInput());
        System.out.println("The running time for a selection sort for " + this.mediumInput.length + " elements in random order in nanoseconds is: " + this.duration);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("LARGE INPUT RANDOM ORDER");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        bs.setLargeInput(this.largeInput);
        is.setLargeInput(this.largeInput);
        ms.setLargeInput(this.largeInput);
        qs.setLargeInput(this.largeInput);
        ss.setLargeInput(this.largeInput);

        // large input
        this.setUpTimer();
        // bubble sort with swaps counting
       // System.out.println("The array before sort is ");
        //bs.printArray(bs.getLargeInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getLargeInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.largeInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getLargeInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getLargeInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.largeInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getLargeInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //is.printArray(is.getLargeInput());
        System.out.println("The running time for a insertion sort for " + this.largeInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
        //System.out.println("The array before sort is ");
        //qs.printArray(qs.getLargeInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getLargeInput().length - 1, qs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //qs.printArray(qs.getLargeInput());
        System.out.println("The running time for a quick sort for " + this.largeInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
        //System.out.println("The array before sort is ");
        //ms.printArray(ms.getLargeInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getLargeInput().length - 1, ms.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ms.printArray(ms.getLargeInput());
        System.out.println("The running time for a merge sort for " + this.largeInput.length + " elements in random order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
        //System.out.println("The array before sort is ");
        //ss.printArray(ss.getLargeInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ss.printArray(ss.getLargeInput());
        System.out.println("The running time for a selection sort for " + this.largeInput.length + " elements in random order in nanoseconds is: " + this.duration);
    }
    public void testAlmostSorted(BubbleSort bs, InsertionSort is, QuickSort qs, MergeSort ms, SelectionSort ss)
    {
        this.almostSorted();
        bs.setSmallInput(this.smallInput);
        is.setSmallInput(this.smallInput);
        ms.setSmallInput(this.smallInput);
        qs.setSmallInput(this.smallInput);
        ss.setSmallInput(this.smallInput);


        // for smallInput

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("SMALL INPUT ALMOST SORTED");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        this.setUpTimer();
        // bubble sort with swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getSmallInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
       // bs.printArray(bs.getSmallInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.smallInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getSmallInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getSmallInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.smallInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getSmallInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //is.printArray(is.getSmallInput());
        System.out.println("The running time for a insertion sort for " + this.smallInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
        //System.out.println("The array before sort is ");
       // qs.printArray(qs.getSmallInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getSmallInput().length - 1, qs.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // qs.printArray(qs.getSmallInput());
        System.out.println("The running time for a quick sort for " + this.smallInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
        //System.out.println("The array before sort is ");
       // ms.printArray(ms.getSmallInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getSmallInput().length - 1, ms.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ms.printArray(ms.getSmallInput());
        System.out.println("The running time for a merge sort  for " + this.smallInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
       // System.out.println("The array before sort is ");
       // ss.printArray(ss.getSmallInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getSmallInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ss.printArray(ss.getSmallInput());
        System.out.println("The running time for a selection sort for " + this.smallInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        // set mediumInput
        bs.setMediumInput(this.mediumInput);
        is.setMediumInput(this.mediumInput);
        ms.setMediumInput(this.mediumInput);
        qs.setMediumInput(this.mediumInput);
        ss.setMediumInput(this.mediumInput);

        // for mediumInput
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("MEDIUM INPUT ALMOST SORTED.");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        this.setUpTimer();
        // bubble sort with swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getMediumInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // bs.printArray(bs.getMediumInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.mediumInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
        //System.out.println("The array before sort is ");
       // bs.printArray(bs.getMediumInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getMediumInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.mediumInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getMediumInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //is.printArray(is.getMediumInput());
        System.out.println("The running time for a insertion sort for " + this.mediumInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
        //System.out.println("The array before sort is ");
        //qs.printArray(qs.getMediumInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getMediumInput().length - 1, qs.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //qs.printArray(qs.getMediumInput());
        System.out.println("The running time for a quick sort for " + this.mediumInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
        //System.out.println("The array before sort is ");
        //ms.printArray(ms.getMediumInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getMediumInput().length - 1, ms.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ms.printArray(ms.getMediumInput());
        System.out.println("The running time for a merge sort for " + this.mediumInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
        //System.out.println("The array before sort is ");
        //ss.printArray(ss.getMediumInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getMediumInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ss.printArray(ss.getMediumInput());
        System.out.println("The running time for a selection sort for " + this.mediumInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("LARGE INPUT ALMOST SORTED");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        bs.setLargeInput(this.largeInput);
        is.setLargeInput(this.largeInput);
        ms.setLargeInput(this.largeInput);
        qs.setLargeInput(this.largeInput);
        ss.setLargeInput(this.largeInput);

        // large input
        this.setUpTimer();
        // bubble sort with swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getLargeInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithCount(bs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getLargeInput());
        System.out.println("The running time for a bubble sort with swaps counting for " + this.largeInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();
        // bubble sort with no swaps counting
        //System.out.println("The array before sort is ");
        //bs.printArray(bs.getLargeInput());
        this.startTime = System.nanoTime();
        bs.bubbleSortWithoutCount(bs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //bs.printArray(bs.getLargeInput());
        System.out.println("The running time for a bubble sort with no swaps counting for " + this.largeInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // insertion sort
        //System.out.println("The array before sort is ");
        //is.printArray(is.getLargeInput());
        this.startTime = System.nanoTime();
        is.insertionSort(is.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //is.printArray(is.getLargeInput());
        System.out.println("The running time for a insertion sort for " + this.largeInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // quicksort
        //System.out.println("The array before sort is ");
        //qs.printArray(qs.getLargeInput());
        this.startTime = System.nanoTime();
        qs.quickSort(0, qs.getLargeInput().length - 1, qs.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //qs.printArray(qs.getLargeInput());
        System.out.println("The running time for a quick sort for " + this.largeInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // mergesort
        //System.out.println("The array before sort is ");
        //ms.printArray(ms.getLargeInput());
        this.startTime = System.nanoTime();
        ms.mergeSort(0, ms.getLargeInput().length - 1, ms.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
       // System.out.println("The array after sort is: ");
       // ms.printArray(ms.getLargeInput());
        System.out.println("The running time for a merge sort for " + this.largeInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

        this.setUpTimer();

        // selection sort
        //System.out.println("The array before sort is ");
        //ss.printArray(ss.getLargeInput());
        this.startTime = System.nanoTime();
        ss.selectionSort(ss.getLargeInput());
        this.endTime = System.nanoTime();
        this.duration = this.calculateTime(this.startTime, this.endTime);
        //System.out.println("The array after sort is: ");
        //ss.printArray(ss.getLargeInput());
        System.out.println("The running time for a selection sort for " + this.largeInput.length + " elements in almost sorted order in nanoseconds is: " + this.duration);

    }
    public static void main(String [] args)
    {
        Test myTest = new Test();


        BubbleSort myBubble = new BubbleSort();
        InsertionSort myInsert = new InsertionSort();
        QuickSort myQuick = new QuickSort();
        MergeSort myMerge = new MergeSort();
        SelectionSort mySelect = new SelectionSort();

        myTest.testSorted(myBubble, myInsert, myQuick, myMerge, mySelect);
        myTest.testRandom(myBubble, myInsert, myQuick, myMerge, mySelect);
        myTest.testAlmostSorted(myBubble, myInsert, myQuick, myMerge, mySelect);
    }

}

