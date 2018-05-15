import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class LinkedList {
	public static Node insert(Node head, int data) {
		if (head == null)
			return new Node(data);
		else if (head.next == null) {
			head.next = new Node(data);
		} else {
			insert(head.next, data);
		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		System.out.println("Enter number of integers for Linked List: ");
		int N = sc.nextInt();

		System.out.println("Enter " + N + " integers: ");
		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		System.out.println("The linked list is composed of: ");
		display(head);
		sc.close();
	}
}