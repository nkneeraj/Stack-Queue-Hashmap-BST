package com.cg.datastructure;

public class LinkedList<K> {

	public INode<K> head;
	public INode<K> tail;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	// uc1 add node at first
	public void add(INode<K> node) {
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			INode<K> temp = this.head;
			this.head = node;
			this.head.setNext(temp);
		}
	}

	// uc3 Append
	public void append(INode<K> Node) {
		if (head == null) {
			head = Node;
			return;
		}
		INode<K> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(Node);
		return;
	}

	// uc4 insert node between two nodes
	public void insert(INode<K> pre, INode<K> newNode, INode<K> next) {
		pre.setNext(newNode);
		newNode.setNext(next);
	}

	// uc5
	public INode<K> Pop() {
		if (head == null)
			return head;
		INode<K> temp = head.getNext();
		head.setNext(temp);
		head = temp;
		return head;
	}

	// uc6
	public INode<K> popLast() {
		if (head == null)
			return null;
		if (head.getNext() == null)
			return null;
		INode<K> temp = head;
		while (temp.getNext().getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		return head;
	}

	// uc7
	public INode<K> search(K key) {
		INode<K> temp = head;
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}

	// uc8
	public void insertAfterKey(K key, INode<K> node) {
		INode<K> temp = search(key);
		if (temp == null)
			System.out.println("no node present with key: " + key);
		else {
			INode<K> keyNext = temp.getNext();
			temp.setNext(node);
			node.setNext(keyNext);
		}
	}

	// uc9
	public INode<K> deleteNodeWithKey(K key) {
		INode<K> temp = head;
		while (temp != null && temp.getNext().getKey() != key)
			temp = temp.getNext();
		INode<K> deleteNode = temp.getNext();
		temp.setNext(deleteNode.getNext());
		deleteNode.setNext(null);
		return deleteNode;
	}

	public int size() {
		INode<K> temp = head;
		int size = 0;
		while (temp != null) {
			temp = temp.getNext();
			size++;
		}
		return size;
	}
	
	public void addPrint() {
		if (head == null) {
			System.out.println("No node present");
			return;
		}
		INode<K> temp = head;
		while (temp != null) {
			System.out.println(temp.getKey() + " X ");
			temp = temp.getNext();
		}
		return;
	}
	
}
