package com.monthlychallengemay.day16;

public class OddEvenLinkedList {
	// Ref:
	// https://thefellowprogrammer.blogspot.com/2020/05/odd-even-linked-list.html
	/*
	 * 1) The head and odd variable are head and tail pointer of odd linked list. 2)
	 * The evenHead and even variable are head and tail pointer of even linked list.
	 * 3) Then iterate all nodes, a) Put odd nodes to odd linked list b) Put even
	 * nodes to even linked list 4) Variables odd & even are used for iterating
	 * through linked list.
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public ListNode oddEvenList1(ListNode head) {

		ListNode tempOddHead = new ListNode(0);
		ListNode tempEvenHead = new ListNode(0);
		ListNode oddHead = tempOddHead;
		ListNode evenHead = tempEvenHead;

		while (head != null) {
			oddHead.next = head;
			oddHead = oddHead.next;
			head = head.next;

			evenHead.next = head;
			evenHead = evenHead.next;

			// Since while loop will only check the next condition
			if (head != null)
				head = head.next;
		}

		oddHead.next = tempEvenHead.next;
		return tempOddHead.next;

	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		OddEvenLinkedList oel = new OddEvenLinkedList();
		oel.oddEvenList(n1);
	}
}
