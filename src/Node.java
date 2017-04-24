/*
 * Class that creates objects called Nodes That contain ints
 * and keeps track of the previous and next Nodes
 */
public class Node {
	
	//properties
	private String string;
	private Node left, right;
	private int counter;
	
	/**
	 * Constructor that sets num field
	 * @param num - integer of the Node
	 */
	public Node(String string) {
		this.string = string;
		left = null;
		right = null;
		counter = 0;
	}
	
	/**
	 * Accessor method for the next Node
	 * @return the next Node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Mutator method for the Previous Node
	 * @param node - the new previous Node
	 */
	public void setLeft(Node node) {
		left = node;
	}

	/**
	 * Accessor method for the previous Node
	 * @return the previous Node
	 */
	public Node getRigt() {
		return right;
	}

	/**
	 * Mutator method for the next Node
	 * @param node - the new next Node
	 */
	public void setRight(Node node) {
		right = node;
	}

	/**
	 * Accessor method
	 * @return the int value of the Node
	 */
	public String getString() {
		return string;
	}
	
	public void increment() {
		counter++;
	}
	
	public int getCount() {
		return counter;
	}
}