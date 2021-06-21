package com.wiley;

public class MyBSTMain {
	public static void main(String[] args) {

		MyBST<Integer> tree = new MyBST<>();

		tree.insert(50);
		tree.insert(90);
		tree.insert(70);
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(40);
		tree.insert(120);

//		tree.delete(tree.root, 50);

		System.out.println(tree.search(tree.root, 50));
		
		System.out.println(tree.height());
		System.out.println(tree.depth(1));

		tree.inorder();
		tree.preorder();
		tree.postorder();
		
	}

}
