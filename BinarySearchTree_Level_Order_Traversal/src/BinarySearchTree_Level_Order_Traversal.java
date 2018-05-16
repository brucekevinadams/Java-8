// Program written in Java 8 (JavaSE-1.8)
// Bruce K. Adams
// ezaroth@gmail.com
// 5-16-2018

/*
 * This program uses a Linked List Node to represent a Binary Tree
 * The user inputs an integer that defines the total number of integers
 * to be entered into a Binary Tree. The program then outputs
 * the binary tree in Level-Order Transversal also known as a breadth-first search,
 * which prints to console each level of the Tree, from left to right, starting
 * at level 0, and proceeding to level 1, and so on.
 * 
 * Sample input shown below: 
 * 6  // Enter 6 integers into binary tree
 * 3  // Start with 3
 * 5
 * 4
 * 7
 * 2
 * 1  // 6th integer is 1
 * 
 *     The Binary Search Tree represented graphically from previous inputs
 * 
 *        3    ---- Level 0
 *      /  \   
 *     2    5  ----- Level 1
 *    /    /  \ 
 *   1    4   7  ---- Level 2
 * 
 * 
 * Sample Output shown on next line:
 * 3 2 5 1 4 7 
 * 
 */

import java.util.Scanner;

class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinarySearchTree_Level_Order_Traversal {
	static void levelOrder(Node root) {

		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	static int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
		}

		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* Inserts nodes */
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
		sc.close();
	}

}