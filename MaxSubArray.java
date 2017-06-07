package fouryy11;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MaxSubArray {

	public static void main(String[] args) 
	{
		int input = getInput();
		ArrayList maxSubArray = createArrayList(input);
		maxSubArray(maxSubArray);
	}

	private static void maxSubArray(ArrayList<Integer> A) 
	{
		Stopwatch timer3 = new Stopwatch();
		if(A.size()==0)
		{
			System.out.println("There is no element in the Arraylist.");
			System.out.println("Time (Max Sub Array): "+ timer3.elapsedTime() + "\n");	        
		}
		else
		{
			System.out.println("Maximum Sub Array: " + maxSubArray(A,0,A.size()-1));
			System.out.println("Time (Max Sub Array): "+ timer3.elapsedTime() + "\n");	         
		}
	}

	private static int maxSubArray(ArrayList<Integer> A, int left, int right) 
	{
		if(right == left)
		{
			return A.get(left);
		}
		int middle = (left+right)/2;
		int leftAns = maxSubArray(A, left, middle);
		int rightAns = maxSubArray(A, middle+1, right);
		int leftMax = A.get(middle);
		int rightMax = A.get(middle+1);
		int temp = 0;
		for(int i=middle;i>=left;i--) 
		{
			temp += A.get(i);
			if(temp > leftMax) 
			{
				leftMax = temp;
			}
		}
		temp = 0;
		for(int i=middle+1;i<=right;i++) 
		{
			temp += A.get(i);
			if(temp > rightMax) 
			{
				rightMax = temp;
			}
		}
		return max(max(leftAns, rightAns),leftMax+rightMax);
	}	

	private static int max(int i, int j) 
	{
		if(i>j)
			return i;
		else 
			return j;

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
