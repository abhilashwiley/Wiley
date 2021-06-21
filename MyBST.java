package com.wiley;

public class MyBST<T extends Comparable<T>> {

	Node root;
	static int d=0;

	class Node {
		T key;
		Node left, right;

		public Node(T key) {
			this.key = key;
		}
	}

	void insert(T key) {
		root = insertKey(root, key);
	}

	Node insertKey(Node root, T key) {
		// if tree is empty
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key.compareTo(root.key) < 0)
			root.left = insertKey(root.left, key);
		else if (key.compareTo(root.key) > 0)
			root.right = insertKey(root.right, key);

		return root;

	}

	void inorder() {
		inorderKey(root);
		System.out.println();
	}

	void inorderKey(Node root) {
		if (root != null) {
			inorderKey(root.left);
			System.out.print(root.key + "  ");
			inorderKey(root.right);
		}

	}

	void preorder() {
		preorderKey(root);
		System.out.println();
	}

	void preorderKey(Node root) {
		if (root != null) {
			System.out.print(root.key + "  ");
			inorderKey(root.left);
			inorderKey(root.right);
		}

	}

	void postorder() {
		postorderKey(root);
		System.out.println();
	}

	void postorderKey(Node root) {
		if (root != null) {
			inorderKey(root.left);
			inorderKey(root.right);
			System.out.print(root.key + "  ");
		}

	}
	
	int height()
	{
		return heightTree(root);
	}
	
	int heightTree(Node root)
	{
		if(root==null)
			return -1;
		return 1+Math.max(heightTree(root.right), heightTree(root.right));
	}
	
	int depth(T k)
	{
//		d=0;
		return depthNode(root,k);
	}
	int depthNode(Node root,T k)
	{
		if(k.compareTo(root.key)<0)
		{
			d=d+1;
			return depthNode(root.left, k);
		}
		else if(k.compareTo(root.key)>0)
		{
			d=d+1;
			return depthNode(root.right, k);
			
		}
		else
			return d;
			
	}

	Node delete(Node root, T k) {
		if (root == null)
			return null;
		if (k.compareTo(root.key) > 0)
			root.right = delete(root.right, k);
		else if (k.compareTo(root.key) < 0)
			root.left = delete(root.left, k);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				root.key = max(root.left);
				root.left = delete(root.left, root.key);
			}
		}
		return root;
	}

	T max(Node root) {
		T temp = null;
		while (root.right != null) {
			temp = root.key;
			root = root.right;
		}
		return temp;
	}

	boolean search(Node root, T k) {
		if (root == null)
			return false;
		if (k.compareTo(root.key) > 0)
			return search(root.right, k);
		else if (k.compareTo(root.key) < 0)
			return search(root.left, k);
		return true;
	}

}
