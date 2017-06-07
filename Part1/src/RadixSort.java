package harun1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class RadixSort {

	public static void main(String[] args) 
	{
		int input = getInput();
		ArrayList radixSort = createArrayList(input);
		radixSort(radixSort, radixSort.size());

	}
    private static void countSort(ArrayList<Integer> newArrayList, int n, int exp)	//For radixSort
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);                                                                                                                                                                                                                                         
	        for (i = 0; i < n; i++)
	        {
	            count[ (newArrayList.get(i)/exp)%10 ]++;
	        }
	 
	        for (i = 1; i < 10; i++)
	        {
	            count[i] += count[i - 1];
	        }
	 
	        for (i = n - 1; i >= 0; i--)
	        {
	            output[count[ (newArrayList.get(i)/exp)%10 ] - 1] = newArrayList.get(i);
	            count[ (newArrayList.get(i)/exp)%10 ]--;
	        }
	 
	        for (i = 0; i < n; i++)
	        {
	        	newArrayList.set(i, output[i]);
	        }

    }	 
    private static void radixSort(ArrayList<Integer> newArrayList, int length)
    {
		Stopwatch timer1 = new Stopwatch();		    	
        int max = Collections.max(newArrayList);
        try
        {
        for (int exp = 1; max/exp > 0; exp *= 10)
        {
        	
            countSort(newArrayList, length, exp);
        }

			System.out.println("Sorted Array List (Radix Sort): " + newArrayList );
			System.out.println("Time (Radix Sort): "+ timer1.elapsedTime() + "\n");
        }
        catch (ArrayIndexOutOfBoundsException ex) 
        {
			System.out.println("Radix sort cant haddle with negative numbers. ");
			System.out.println("Time (Radix Sort): "+ timer1.elapsedTime() + "\n");
		}
 	        
    }
	private static int getInput()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Please type your number of elements: ");
		return scn.nextInt();
	
	}
	private static ArrayList createArrayList(int elements)
	{
		ArrayList newArrayList = new ArrayList();
		Random rnd = new Random();
		for (int i = 0; i < elements; i++) 
		{
			int a = rnd.nextInt(100);
			newArrayList.add(a);
		}
		return newArrayList;
		
	}
}
