package fouryy11;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FindSecondLargest 
{
	public static void main(String[] args) 
	{
		int input = getInput();
		ArrayList<Integer> findSecondLargest = createArrayList(input);

		int firstSize = findSecondLargest.size();		// Takes size of our first list.
		createTree(findSecondLargest, firstSize);
	}

	/*	Creating tree structure and send it to findSecondLargest function.	*/
	private static void createTree(ArrayList<Integer> arrayList, int firstSize)
	{
		Stopwatch timer7 = new Stopwatch();		    	
		for(int i=0 ; i < arrayList.size() - 1 ; i = i+2)		// Matching them two by two and add winner to end of the list.
		{	
			if(arrayList.get(i) > arrayList.get(i+1))
				arrayList.add(arrayList.get(i));
			else
				arrayList.add(arrayList.get(i+1));
		}
		findSecondLargest(arrayList, firstSize);
		System.out.println("Time (Second Largest Element): "+ timer7.elapsedTime() + "\n");			
	}

	/*	Select winner and find the losers who lose against winner and add them to list then select to maximum of this list.	*/
	private static void findSecondLargest(ArrayList<Integer> arrayList, int size)
	{
		ArrayList<Integer> comparisons = new ArrayList<>();
		int max = arrayList.get(arrayList.size()-1);
		System.out.println("First largest element is: " + max);
		int firstIndex = arrayList.indexOf(max);
		int k = (int) (Math.log(arrayList.size()/Math.log(2)))+1;
		try
		{
			for(int i = 0 ; i < k ; i++)		// Creating losers against winner list.
			{
				if(firstIndex % 2 == 1)
					comparisons.add(arrayList.get(firstIndex-1));
				else
					comparisons.add(arrayList.get(firstIndex+1));
				firstIndex = (firstIndex/2) + size;
			}	
		}
		catch(IndexOutOfBoundsException e)
		{
		}
		int secondMax = comparisons.get(0);		// Doing selection to find max of losers list and it is our Second Largest.
		for (int i = 1 ; i < comparisons.size() ; i ++)
			if(comparisons.get(i) > secondMax)
				secondMax = comparisons.get(i);
		System.out.println("Second largest element is: " + secondMax);
	}

	private static int getInput()
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Please type your number of elements: ");
		return scn.nextInt();

	}

	private static ArrayList<Integer> createArrayList(int elements)
	{
		ArrayList newArrayList = new ArrayList();
		Random rnd = new Random();
		for (int i = 0; i < elements; i++) 
		{
			int a = 5000 - rnd.nextInt(10000);
			newArrayList.add(a);
		}
		return newArrayList;			
	}	   
}
