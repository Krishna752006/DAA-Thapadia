// Java program to solve fractional Knapsack Problem
import java.util.*;

// item value class
class ItemValue implements Comparable<ItemValue>{
	int value, weight;
	ItemValue(int value, int weight){
		this.value = value;
		this.weight = weight;
	}
	public int getValue(){
		return value;
	}
	public int getWeight(){
		return weight;
	}
	@Override
	public int compareTo(ItemValue v1){
		double ratio = (double)this.value/this.weight;
		double ratio2 = (double)v1.value/v1.weight;
		return Double.compare(ratio2, ratio);
	}
	@Override
	public String toString(){
		String s = getValue() + "," + getWeight();
		return s;
	}
}

public class Knapsack {
	// function to get maximum value
	private static double getMaxValue(ItemValue[] arr, int capacity)
	{		
		printItems(arr);

		// sorting items by value/weight ratio;
		Arrays.sort(arr);

		System.out.println("After sorting");
		printItems(arr);

		double totalValue = 0d;
		for (ItemValue item : arr) 
		{
			if (capacity - item.getWeight() >= 0) 
			{
				// this item can be picked whole
				capacity -= item.getWeight();
				totalValue += item.getValue();
			}
			else {
				// item item cant be picked whole
				totalValue += item.getValue() * ((double) capacity / item.getWeight());
				break;
			}
		}
		return totalValue;
	}

	static void printItems(ItemValue[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("[" + arr[i] + "]");
		}
	}

	public static void main(String[] args)
	{
		ItemValue[] arr = { new ItemValue(100, 20),
				new ItemValue(60, 10),
				new ItemValue(120, 30)};
		int capacity = 50;
		double maxValue = getMaxValue(arr, capacity);
		// Function call
		System.out.println("Maximum value we can obtain = "+ maxValue);
	}
}
