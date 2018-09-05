public class BSTree implements BSTOper {

	private class Node {
		Node left, right;

		// Verdier i venstre subtre er < (mindre enn) verdien i noden selv
		// Verdier i høyre subtre er > (større enn) verdien i noden selv
		int value;

		// Konstruktører til Node
		Node() { // Tom Node.... not sure why?
			this.left = null;
			this.right = null;
		}

		Node(int v) {	
			this.value = v;
			this.left = null;
			this.right = null;
		}
	}

	// Peker & Konstruktører til BSTree
	private Node root;

	public BSTree() {
		root = null;
	}

	public BSTree(int rootValue, BSTree left, BSTree right) {
		root = new Node();
		root.value = rootValue;
		root.left = left.root;
		root.right = right.root;
	}

	// private metoder til BSTree
	private Node findParent(Node n){ 
		// Finner nodens forelder
		return null;
	} 

	private Node findGrandparent(Node n){ 
		// Finner nodens besteforelder
		return null;
	}

	private Node find(int value){ 
		// Finner noden på gitt indeks.
		return null;
	}

	// Metoder fra BSTOper

	public void add(int value) {
		if (root == null) {
			Node nyNode = new Node(value);
			root = nyNode;
			System.out.println("Inserted a new Node " + nyNode.value);
		}
		else {
			add(value, root);
		}
	}

	private void add(int value, Node node) {
		if (value < node.value) {
			if (node.left == null) {
				Node nyNode = new Node(value);
				node.left = nyNode;
				System.out.println("Inserted a new Node " + nyNode.value);
				return;
			}
			add(value, node.left);

		} else if (value >= node.value) {
			if (node.right == null) {
				Node nyNode = new Node(value);
				node.right = nyNode;
				System.out.println("Inserted a new Node " + nyNode.value);
				return;
			}
			add(value, node.right);
		}
	}

	public int size() {
		int teller = 0;

		if (root == null) {
			return teller;
		}
		else {
			return teller;	// IKEK FERDIG
		}
	}



	/*
	public boolean remove(int value);
	public boolean existsInTree(int value); 
	public int findNearestSmallerThan(int value); 
	public void addAll(int[] integers);
	public int[] sortedArray() ; // inorder
	public int[] findInRange (int low, int high);
	*/



	/* TILLEGGSOPPGAVE

	// brukes til rød-svarte trær (tilleggsoppgave) 
	private static byte BLACK = 1;
	private static byte RED = 2;


	private class RBNode extends Node { 
		private byte colour = 0;

		boolean isRed() { 
			return colour == RED; 
		} 

		boolean isBlack() { 
			return colour == BLACK; 
		} 

		void setToRed() { 
			colour = RED; 
		}

		void setToBlack() { 
			colour = BLACK; 
		}

	}

	*/
}