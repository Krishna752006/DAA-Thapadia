import java.util.*;

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TreeOperations {
    public ArrayList<Integer> getPersonIDs(BinaryTreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        findLonelyNodes(root, nodes);
        return nodes;
    }

    private void findLonelyNodes(BinaryTreeNode root, ArrayList<Integer> nodes) {
        //WRITE YOUR CODE HERE
        if(root == null)
        return;
        if(root.left != null && root.right == null)
        nodes.add(root.left.data);
        if(root.left == null && root.right != null)
        nodes.add(root.right.data);
        findLonelyNodes(root.left,nodes);
        findLonelyNodes(root.right,nodes);
    }
}

public class Solution {
    static BinaryTreeNode root;

    // Modified to return the updated root
    BinaryTreeNode insertLevelOrder(String[] arr, int i) {
        // Base case for recursion
        if (i >= arr.length || arr[i].equals("-1")) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(arr[i]));

        // insert left child
        root.left = insertLevelOrder(arr, 2 * i + 1);

        // insert right child
        root.right = insertLevelOrder(arr, 2 * i + 2);

        return root;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution ln = new Solution();
        TreeOperations sol = new TreeOperations();

        // Reading input
        String str[] = sc.nextLine().split(" ");
        root = ln.insertLevelOrder(str, 0);

        // Get lonely nodes
        ArrayList<Integer> result = sol.getPersonIDs(root);
        Collections.sort(result);  // Sort the result to print in ascending order
        System.out.println(result);
    }
}

