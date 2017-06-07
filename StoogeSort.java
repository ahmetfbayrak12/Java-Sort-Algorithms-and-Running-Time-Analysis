package fouryy11;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StoogeSort 
{
	public static void main(String[] args) 
	{
		int input = getInput();
		ArrayList<Integer> stoogeArrayList = createArrayList(input);
		stoogeSort(stoogeArrayList);
	}

	private static void stoogeSort(ArrayList<Integer> L) 
	{
		Stopwatch timer = new Stopwatch();		    	
		stoogeSort(L, 0, L.size() - 1);        
		System.out.println("Sorted Array List (Stooge Sort): "+ L);			
		System.out.println("Time (Stooge Sort): "+ timer.elapsedTime() + "\n");

	}	

	private static ArrayList<Integer> stoogeSort(ArrayList<Integer> L, int i, int j)
	{
		if((int)L.get(j) < (int)L.get(i))		//exchange
		{
			int temp = L.get(i);
			L.set(i, L.get(j));
			L.set(j, temp);
		}
		if (j-i > 1) 
		{
			int t = (j-i+1)/3;
			stoogeSort(L, i, j - t);
			stoogeSort(L, i + t, j);
			stoogeSort(L, i, j - t);
		}
		return L;
	}

	private static int getInput()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Please type your number of elements: ");
		return scn.nextInt();

	}

	private static ArrayList<Integer> createArrayList(int elements)
	{
		ArrayList<Integer> newArrayList = new ArrayList<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < elements; i++) 
		{
			int a = 50 - rnd.nextInt(100);
			newArrayList.add(a);
		}
		return newArrayList;
	}
}
