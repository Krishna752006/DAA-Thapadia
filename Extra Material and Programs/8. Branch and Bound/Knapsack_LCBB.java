/*
Mr. Dharma went to D-mart, and picked a basket with a capacity C.
There are N products in Dharma's wishlist.
You will be given desired cost and quantity of each Product.
Out of the wishlist Mr Dharma has, he wants to purchase the products in the following way:
	- The sum of quantities taken into the basket is less than or equal to C.
	- The sum of cost of the products in the basket is maximum among all 
	the possible combinations of products.

Your task is to help, Mr. Dharma to purachase the products with maximum cost, 
with the given basket capacity. 

Input Format:
-------------
Line-1: Two space separated integers, N and C.
Next N lines: Two space separated integers, Ci and Qi.
			cost and quantity of i-th product.

Output Format:
--------------
Print an integer, Maximum cost to pay to D-Mart.


Sample Input-1:
---------------
4 15
12 6
10 2
10 4
18 9

Sample Output-1:
----------------
38

Explanation:
------------
Quantity = 2 + 4 + 9 = 15
Cost = 10 + 10 + 18 = 38


Sample Input-2:
---------------
4//items 21//weight
18 6
20 3
14 5
18 9








Sample Output-2:
----------------
56

Explanation:
------------
Quantity = 6 + 3 + 9 = 18
Cost = 18 + 20 + 18 = 56

******* Testcases *******
case =1
input =4 15
12 6
18 9
10 2
10 4
output =38

case =2
input =4 21
18 6
20 3
14 5
18 9
output =56

case =3
input =4 12
30 5
28 7
20 4
24 2
output =74

case =4
input =8 28
18 6
20 3
18 6
18 9
10 2
30 12
12 6
28 14
output =86

case =5
input =10 24
27 9
32 8
40 5
38 7
28 7
54 12
64 8
39 13
48 8
26 13
output =152

case =6
input =10 27
27 9
32 8
40 5
38 7
28 7
54 12
64 8
39 13
48 8
26 13
18 9
10 2
30 12
12 6
28 14
output =170

*/

/*
Follow the steps:

1) Sort all items in decreasing order of ratio of value per unit weight so that 
an upper bound can be computed using Greedy Approach.
2) Initialize maximum profit, maxProfit = 0, create an empty queue, Q, and 
create a dummy node of decision tree and enqueue it to Q. 
Profit and weight of dummy node are 0.
3) Do following while Q is not empty.
	a)	Extract an item from Q. Let the extracted item be u.
	b)	Compute profit of next level node. If the profit is more than maxProfit, then update maxProfit.
	c)	Compute bound of next level node. If bound is more than maxProfit, then add next level node to Q.
	d)	Consider the case when next level node is not considered as part of solution 
	and add a node to queue with level as next, but weight and profit without considering next level nodes. 


Item Class: Represents each item with a weight and value. These are inputs for the knapsack problem.

Node Class: Represents nodes in the decision tree. Each node has:
	level: The index of the current item being considered.
	profit: Total profit accumulated at this node.
	weight: Total weight accumulated.
	bound: Upper bound of the maximum profit achievable from this node onward.

Priority Queue: Used to implement a max-heap based on the bound value to 
prioritize nodes with the highest potential profit.

*/

import java.util.*;

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
	public String toString()
	{
		return "[" + value + "," + weight + "]";
	}
}

class Node {
    int level, profit, bound;
    int weight;

    Node(int level, int profit, int weight) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
    }
	public String toString()
	{
		return "[" + level + "," + weight + "," + profit + "," + bound + "]";
	}
}

public class Knapsack_LCBB {
    static Comparator<Item> itemComparator = (a, b) -> {
        double ratio1 = (double) a.value / a.weight;
        double ratio2 = (double) b.value / b.weight;
        // Sorting in decreasing order of value per unit weight
        return Double.compare(ratio2, ratio1);
    };

    static int bound(Node u, int n, int W, Item[] arr) {
		//System.out.println("level " + u.level + " n " + n + " profit " + u.profit + " weight " + u.weight);
        if (u.weight >= W)
            return 0;

        int profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;

        while (j < n && totalWeight + arr[j].weight <= W) {
            totalWeight += arr[j].weight;
            profitBound += arr[j].value;
            j++;
        }

        if (j < n)
            profitBound += (int) ((W - totalWeight) * arr[j].value / arr[j].weight);

        return profitBound;
    }

    static int knapsack(int W, Item[] arr, int n) {
		System.out.println("Before sort " + Arrays.toString(arr));
        Arrays.sort(arr, itemComparator);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.bound, a.bound));
        Node u, v;
		System.out.println("After sort " + Arrays.toString(arr));

		u = new Node(-1, 0, 0);
		priorityQueue.offer(u);

        int maxProfit = 0;

		// One by one extract an item from decision tree compute profit of all children 
		// of extracted item and keep saving maxProfit

        while (!priorityQueue.isEmpty()) {
			System.out.println("Queue " + priorityQueue);
            u = priorityQueue.poll();

			// If it is starting node, assign level 0
            if (u.level == -1)
                v = new Node(0, 0, 0);
			// If there is nothing on next level
            else if (u.level == n - 1)
                continue;
			// Else if not last node, then increment level, and compute profit of children nodes.
            else
                v = new Node(u.level + 1, u.profit, u.weight);

            v.profit = u.profit + arr[v.level].value;
	        v.weight = u.weight + arr[v.level].weight;

			//System.out.println("level " + v.level + " profit " + v.profit + " weight " + v.weight);

			// Compute profit of next level node. 
			// If the profit is more than maxProfit, then update maxProfit.
            if (v.weight <= W && v.profit > maxProfit)
                maxProfit = v.profit;

			// Compute bound of next level node. 
			// If bound is more than maxProfit, then add next level node to Q.
            v.bound = bound(v, n, W, arr);
			System.out.println("Item included level " + v.level + " bound " + v.bound + " maxProfit " + maxProfit);

            if (v.bound > maxProfit)
                priorityQueue.offer(v);

			// Do the same thing, but Without taking the item in knapsack
			// Add a node to queue with level as next, but weight and profit without considering next level nodes. 
            v = new Node(u.level + 1, u.profit, u.weight);
            v.bound = bound(v, n, W, arr);

			System.out.println("Item not included level " + v.level + " bound " + v.bound + " maxProfit " + maxProfit);

            if (v.bound > maxProfit)
                priorityQueue.offer(v);
        }

        return maxProfit;
    }
    
    public static void main(String[] args) 
	{
		/*
		4//items 10//capacity
		40 4
		42 7
		25 5
		12 3
		*/
		Scanner sc=new Scanner(System.in);
		int size = sc.nextInt();
		int wt = sc.nextInt();

		Item arr[] = new Item[size];
		for(int i=0;i<size;i++)
			arr[i] = new Item(sc.nextInt(), sc.nextInt());

        int maxProfit = knapsack(wt, arr, size);
        System.out.println("Maximum possible profit = " + maxProfit);
    }
}