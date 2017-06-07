package fouryy11;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ShakerSort 
{
	public static void main(String[] args) 
	{
		int input = getInput();
		ArrayList shakerSort = createArrayList(input);
		shakerSort(shakerSort);
	}

	private static void shakerSort(ArrayList<Integer> A)
	{
		Stopwatch timer2 = new Stopwatch();			
		boolean swapped;
		do 
		{
			swapped = false;
			for(int i = 0 ; i < A.size()-2;i++)
			{
				if(A.get(i) > A.get(i+1))
				{
					int temp = A.get(i);
					A.set(i, A.get(i+1));
					A.set(i+1, temp);
					swapped = true;
				}
			}
			if (!swapped) 
			{
				break;
			}
			swapped = false;
			for(int j = A.size()-2;j>0; j--)
			{
				if (A.get(j)>A.get(j+1)) 
				{
					int temp = A.get(j);
					A.set(j, A.get(j+1));
					A.set(j+1, temp);
					swapped  = true;
				}
			}

		} while (swapped);

		System.out.println("Sorted Array List (Shaker Sort): "+ A);			
		System.out.println("Time (Shaker Sort): "+ timer2.elapsedTime() + "\n");			
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
			int a = 50 - rnd.nextInt(100);
			newArrayList.add(a);
		}
		return newArrayList;
	}
}
