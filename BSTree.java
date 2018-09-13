import java.util.Arrays;	// Denne er importert fordi den kan brukes i metoden findInRange, der jeg bruker en toString for å se elementer i array.

public class BSTree implements BSTOper {

	private class Node {
		Node left, right;
		int value;

		// Konstruktører til Node
		Node() {
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
	static int COUNTER = 0;			// Tilhører sortedArray 
	static int RANGECOUNTER = 0;	// Tilhører findInRange


	public BSTree() {
		root = null;
	}

	public BSTree(int rootValue) {
		root = new Node();
		root.value = rootValue;
	}


// ----------- PRIVATE METODER TIL BSTree

	// Finner foreldre-noden
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
			subRoot = subRoot.left;
			return(findParent(n, subRoot));
		}

		else if (n.value > subRoot.value) {
			subRoot = subRoot.right;
			return(findParent(n, subRoot));
		}
		return null;
	}

	// Finner besteforelder-noden
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
			return grandParent;
		}

		else if (n.value < subRoot.value) {
			Node parent = findParent(subRoot);
			Node grandParent = findParent(parent);
			return grandParent;
		}

		else if (n.value > subRoot.value) {
			Node parent = findParent(subRoot);
			Node grandParent = findParent(parent);
			return grandParent;
		}
		return null;
	}


	// Finner en value i treet, returnerer Node referanse
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
			if (subRoot.left == null) { 
				return null; 
			}
			return find(value, subRoot.left);
		}

		else {
			if (subRoot.right == null) { 
				return null; 
			}
			return find(value, subRoot.right);
		}
	}

// ----------- PUBLIC METODER TIL BSTree

	// Legger til en Node med value i treet
	public void add(int value) {
		if (root == null) {
			Node nyNode = new Node(value);
			root = nyNode;
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
				return;
			}
			add(value, subRoot.left);

		} else if (value >= subRoot.value) {
			if (subRoot.right == null) {
				Node nyNode = new Node(value);
				subRoot.right = nyNode;
				return;
			}
			add(value, subRoot.right);
		}
	}


	// Returnerer antall noder i treet	
	public int size() {
		if (root == null) {
			return 0;
		}
		else {
			return size(root);
		}
	}

	private int size(Node subRoot) {
		if (subRoot == null) {
			return 0;
		}
		else {
			return(size(subRoot.left) + 1 + size(subRoot.right));	
		}
	}


	// Returnerer en boolean tilstand på om value eksisterer i treet
	public boolean existsInTree(int value) {
		if (root == null) {
			return false;
		}
		else {
			return existsInTree(value, root);
		}
	}

	private boolean existsInTree(int value, Node subRoot) {
		if (subRoot == null) { 
			return false; 
		}

		if (subRoot.value == value) { 
			return true; 
		}

		if (subRoot.value > value) {
			return existsInTree(value, subRoot.left);
		}

		return existsInTree(value, subRoot.right);
	}


	
	// Returnerer en liste med sorterte noder, bruker inorder traversal
	public int[] sortedArray() {
		if (root != null) {
			int[] sortert = new int[size()];
			sortedArray(root, sortert);
			COUNTER = 0;
			return sortert;
		}
		return null;
	}
	
	// Inorder traversal er gunstig her fordi man går gjennom treet fra venstresiden til høyresiden,
	// og dermed får vi en god måte å sortere fra minst til størst på :)
	
	private void sortedArray(Node subRoot, int[]sortertRef) {
		int[] sortert = sortertRef;

		if (subRoot.left != null) {
			sortedArray(subRoot.left, sortert);
		}

		sortert[COUNTER] = subRoot.value;
		COUNTER++;

		if (subRoot.right != null) {
			sortedArray(subRoot.right, sortert);
		}
	}
	

	// Finner alle elementer lagret i treet mellom to verdier
	public int[] findInRange(int low, int high) {
		if (root == null) {
			return null;
		}

		else if (this.find(low) == null) {
			return null;
		}

		else if (this.find(high) == null) {
			return null;
		}

		else {
			int[] inRange = new int[size()];	// Bruker .size for da er jeg sikker på at det alltid er plass
			findInRange(low, high, inRange, root);
			RANGECOUNTER = 0;
			System.out.println(Arrays.toString(inRange)); //<<--- Kan bruke denne for å se innholdet i listen i terminalen
			return inRange;
		}
	}

	// Bruker inorder traversal her også, bygget opp på akkurat samme måte som sortedArray
	private void findInRange(int low, int high, int[] inRangeRef, Node subRoot) {
		int[] inRange = inRangeRef;

		if (subRoot.left != null) {
			findInRange(low, high, inRange, subRoot.left);
		}
		
		if (low <= subRoot.value && high >= subRoot.value) {
			inRange[RANGECOUNTER] = subRoot.value;
			RANGECOUNTER++;	
		}

		if (subRoot.right != null) {
			findInRange(low, high, inRange, subRoot.right);	
		}
	}


	// Tar imot en array med tilfeldige verdier, og legger disse til i treet
	public void addAll(int[] integers) {
		for (int i : integers) {
			add(integers[i]);
		}

		// addAllSorted(integers, 0, integers.length -1);	// <<-- Dersom du vet at int[] integers er sortert
	}

	// Denne har jeg og en venn jobbet LENGE med før vi forsto hva addAll faktisk skulle gjøre, så den legger 
	// jeg med bare for å vise, og kan brukes dersom int[] integers er en sortert liste :)
	private void addAllSorted(int[] integers, int l, int h) {
		if (l > h) {
			return;
		}

		int m = (l + h) / 2;	// Har brukt boken som referanse til denne formelen, side 91-92. 
		
		add(integers[m]);						// Basiskall
		addAllSorted(integers, l, (m-1));		// Venstrekall
		addAllSorted(integers, (m+1), h);		// Hoyrekall
	}

	// Fjerner et node objekt
	public boolean remove(int value) {
		Node n = find(value);

		if (n == null || root == null) {
			System.out.println("Value do not exist in tree");
			return false;
		}
		
		else {
			return remove(value, n);
		}
	}

	// Tar gjerne imot tips på hvordan jeg kunne løst denne metoden rekursivt :)
	private boolean remove(int value, Node subRoot) {
		
		// Tilfelle 0: subRoot er root
		if (subRoot == root ) {

			// root er bladnode
			if (subRoot.left == null && subRoot.right == null) {
				root = null;
				return true;
			}

			// root har 2 barn
			if (subRoot.left != null && subRoot.right != null) {
				Node nearestSmaller = find(findSmallestValue(subRoot.right));

				// Spesialtilfelle: dersom nearestSmaller == subroot.right
				if (nearestSmaller == subRoot.right) {
					nearestSmaller.left = subRoot.left;
					root = nearestSmaller;
					return true;
				}

				else {
					Node parent = findParent(nearestSmaller);
					subRoot.value = nearestSmaller.value;
					parent.left = nearestSmaller.right;
					return true;
				}
			}

			// root har 1 venstrebarn
			if (subRoot.left != null) {
				root = subRoot.left;
				return true;
			}

			// root har 1 høyrebarn
			if (subRoot.right != null) {
				root = subRoot.right;
				return true;
			}
		}

		// Tilfelle 1: subRoot har ingen barn (er en bladnode)
		if (subRoot.left == null && subRoot.right == null) {
			Node parent = findParent(subRoot);
			
			// Dersom Noden er på venstresiden av root
			if (parent.left.value == subRoot.value) {
				parent.left = null;
				return true;
			}
			
			// Dersom Noden er på høyresiden av root
			else if (parent.right.value == subRoot.value) {
				parent.right = null;
				return true;
			}
		}

		// Tilfelle 2: subRoot har 1 eller 2 barn, (er en intern node)
		else {

			// subRoot har to barn
			if (subRoot.left != null && subRoot.right != null ) {
				Node nearestSmaller = find(findSmallestValue(subRoot.right));
				Node parent = findParent(nearestSmaller);
				
				// Spesialtilfelle: dersom parent er subRoot
				if (parent == subRoot) { 
					subRoot.value = nearestSmaller.value;
					parent.right = nearestSmaller.right;
					return true;
				}

				else {
					subRoot.value = nearestSmaller.value;
					parent.left = nearestSmaller.right;
					return true;
				}
			}

			// subRoot har 1 venstrebarn
			else if (subRoot.left != null) {
				Node parent = findParent(subRoot.left);
 				
 				// Spesialtilfelle: dersom parent == subRoot
				if (parent.left == subRoot) { 
					parent.left = subRoot.left;
					return true;
				}

				else { 
					parent.right = subRoot.left;
					return true;
				}
			}

			// subRoot har 1 høyrebarn
			else if (subRoot.right != null) {
				Node parent = findParent(subRoot.right);
				
				// Spesialtilfelle: dersom parent == subRoot
				if (parent.left == subRoot) { 
					parent.left = subRoot.right;
					return true;
				}

				else { 
					parent.right = subRoot.right;
					return true;
				}
			}
		}
		return false;
	}

	// Hjelpemetode til remove. Brukes til å traverserse seg helt ned i en "venstregren"
	private int findSmallestValue(Node n) {
    	if (n.left == null) {
      		return n.value;
    	}
    	else {
      		return findSmallestValue(n.left);
    	}
  	}
	

	// Denne metoden er inorder-traversering inspirert, til å gå gjennom treet for å finne det nest minste tallet før value
	public int findNearestSmallerThan(int value){
    	if (root == null) {
    		return 0;
    	}
    	return findNearestSmallerThan(value, root, 0);
  	}

	private int findNearestSmallerThan(int value, Node subRoot, int low) {
    	if (subRoot.left != null) {
    		low = findNearestSmallerThan(value, subRoot.left, low);
    	}
    
    	if (subRoot.value >= low && subRoot.value < value) {
      		low = subRoot.value;
    	}
    
    	if (subRoot.right != null){
      		low = findNearestSmallerThan(value, subRoot.right, low);
    	}
    	return low;
  	}
}