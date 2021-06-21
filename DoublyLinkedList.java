package com.wiley;

public class DoublyLinkedList {

	Node head, tail;

	static class Node {
		int data;
		Node next, prev;

		public Node(int data, Node next, Node prev) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;

		}

	}

	public static DoublyLinkedList insert(DoublyLinkedList list, int value) {
		Node curr = new Node(value, null, null);
		if (list.head == null) {
			list.head = curr;
			list.tail = list.head;
		} else {
			curr.next = null;
			curr.prev = list.tail;
			list.tail.next = curr;
			list.tail = curr;

		}
		return list;
	}

	public static DoublyLinkedList frontInsert(DoublyLinkedList list, int value) {
		Node curr = new Node(value, null, null);
		if (list.head == null) {
			list.head = curr;
			list.tail = list.head;
		} else {
			curr.next = list.head;
			curr.prev = null;
			list.head.prev = curr;
			list.head = curr;

		}
		return list;
	}

	public static DoublyLinkedList delete(DoublyLinkedList list, int value) {
		if (list.head != null && list.tail != null) {
			if (list.head == list.tail && list.head.data == value) {
				list.head=null;
				list.tail=null;
			} else if (list.head.data == value) {
				list.head = list.head.next;
				list.head.prev=null;
			} else if (list.tail.data == value) {
				list.tail = list.tail.prev;
				list.tail.next=null;
			} else {
				Node prev = list.head;
				while (prev.next != null) {
					if (prev.next.data == value) {
						prev.next = prev.next.next;
						prev.next.prev = prev;
						break;
					}
					prev = prev.next;
				}
			}
		}
		return list;
	}

	public static void forwardTraversal(DoublyLinkedList list) {
		if (list.head == null && list.tail == null)
			return;
		else {
			Node temp = list.head;
			while (temp.next != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}

			System.out.println(temp.data);
		}
	}

	public static void backwardTraversal(DoublyLinkedList list) {
		if (list.head == null && list.tail == null)
			return;
		else {
			Node temp = list.tail;
			while (temp.prev != null) {
				System.out.print(temp.data + " ");
				temp = temp.prev;
			}
			System.out.println(temp.data);

		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		list = list.insert(list, 10);
		list = list.insert(list, 49);
		list = list.insert(list, 23);
		list = list.insert(list, 40);
		list = list.insert(list, 90);
		list = list.insert(list, 60);
		list=list.frontInsert(list, 100);

		list.forwardTraversal(list);
		list=list.delete(list, 60);
		list.forwardTraversal(list);
		list.backwardTraversal(list);
		
	}

}
