import java.util.ArrayList;

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
			System.out.println("No parent");
			return null;
		}

		else {
			return findParent(n, root);
		}
	}

	private Node findParent(Node n, Node subRoot) {
		if (subRoot.left == n || subRoot.right == n) {
			System.out.println("Parent: " + subRoot);
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
		if (root == n || root == null) {
			return null;
		}

		else {
			return findGrandparent(n, root);
		}
	}

	private Node findGrandparent(Node n, Node subRoot) {
		if (subRoot.left == n || subRoot.right == n) {
			Node parent = findParent(n);
			Node grandParent = findParent(parent);
			System.out.println("Grandparent :" + grandParent);
			return grandParent;
		}

		else if (n.value < subRoot.value) {
			subRoot = n.left;
			Node parent = findParent(subRoot);
			Node grandParent = findParent(parent);
			System.out.println("Grandparent :" + grandParent);
			return grandParent;
		}

		else if (n.value > subRoot.value) {
			subRoot = n.right;
			Node parent = findParent(subRoot);
			Node grandParent = findParent(parent);
			System.out.println("Grandparent :" + grandParent);
			return grandParent;
		}
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

	public void testMetode(int value) {
		Node node = find(value);
		findParent(node);
		//findGrandparent(node);

	}

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

	private void add(int value, Node subRoot) {
		if (value < subRoot.value) {
			if (subRoot.left == null) {
				Node nyNode = new Node(value);
				subRoot.left = nyNode;
				System.out.println("Inserted a new Node " + nyNode.value);
				return;
			}
			add(value, subRoot.left);

		} else if (value >= subRoot.value) {
			if (subRoot.right == null) {
				Node nyNode = new Node(value);
				subRoot.right = nyNode;
				System.out.println("Inserted a new Node " + nyNode.value);
				return;
			}
			add(value, subRoot.right);
		}
	}

	// Returns number of nodes in the tree	
	public int size() {
		if (root == null) {
			return 0;
		}
		else {
			return size(root);
		}
	}

	// Returns number of nodes in the tree
	private int size(Node subRoot) {
		if (subRoot == null) {
			return 0;
		}
		else {
			return(size(subRoot.left) + 1 + size(subRoot.right));
		}
	}
	

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


	public ArrayList<Integer> sortedArray() {
		
		if (root != null) {
			ArrayList<Integer> sortert = new ArrayList<Integer>();
			inorder(root, sortert);
			int counter = 0;
			return sortert;
		}
		return null;
	}
	
	// Inorder, tilhører sortedArray
	private void inorder(Node subRoot, ArrayList<Integer> sortertRef) {
		ArrayList<Integer> sortert = sortertRef;

		if (subRoot.left != null) {
			inorder(subRoot.left, sortert);
		}

		sortert.add(subRoot.value);

		if (subRoot.right != null) {
			inorder(subRoot.right, sortert);
		}
	}



/*
	public void addAll(ArrayList integers) {	// 
		if ()
	}

	private void addAll(ArrayList integers) {
		if (l > h) {
			return;
		}

		venstrekall = (arrayRef, l, (root-1));
		hoyrekall = (arrayRef, (m+1), h);

	}
*/

	/*
	public boolean remove(int value);
	public int findNearestSmallerThan(int value); 
	public int[] findInRange (int low, int high);	// side 101 i boken.
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