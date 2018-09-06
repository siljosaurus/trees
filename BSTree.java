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
	Node root;

	public BSTree() {	// Konstruktør for et tomt tre
		root = null;
	}

	public BSTree(int rootValue) {	// Konstruktør for et tre med en referanse til root Node.
		root = new Node();
		root.value = rootValue;
	}


	// private metoder til BSTree
	
	private Node findParent(Node n){
		if (root == n || root == null) {
			return null;
		}
		else {
			return findParent(n, root);
		}
	}

	private Node findParent(Node n, Node subRoot) {
		if (subRoot.left == n || subRoot.right == n) {
			return subRoot;
		}

		else if (n.value < subRoot.value) {
			subRoot = n.left;
			return(findParent(n, subRoot));

		}

		else if (n.value > subRoot.value) {
			subRoot = n.right;
			return(findParent(n, subRoot));
		}
		return null;
	}


	private Node findGrandparent(Node n){ 
		// Finner nodens besteforelder
		return null;
	}



	private Node find(int value){ 
		if (root == null) {
			return null;
		}
		else {
			return find(value, root);
		}
	}

	private Node find(int value, Node subRoot) {
		if (value == subRoot.value) {
			return subRoot;
		}
		else if (value < subRoot.value) {
			if (subRoot.left == null) { return null; }		// Sjekker om neste node er null, ergo finnes ikke input value i treet
			return find(value, subRoot.left);
		} 
		else {
			if (subRoot.right == null) { return null; }
			return find(value, subRoot.right);
		}

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

	/*
	public int size() {
		int teller = 0;

		if (root == null) {
			return teller;
		}
		else {
			size(teller, root);
	}

	private int size(int teller, Node subtreeRoot) {
		while (subtreeRoot.left != null) {

		}
	}
	*/

	public boolean existsInTree(int value) {
		if (find(value) == null) {
			System.out.println("Noden finnes ikke i treet");
			return false;
		}
		else {
			System.out.println("Noden FINNES i treet");
			return true;
		}
	}



	/*
	public boolean remove(int value);
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