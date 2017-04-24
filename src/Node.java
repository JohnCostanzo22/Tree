/*
 * Class that creates objects called Nodes That contain ints
 * and keeps track of the previous and next Nodes
 */
public class Node {
	
	//properties
	private int num;
	private Node next;
	private Node previous;
	
	/**
	 * Constructor that sets num field
	 * @param num - integer of the Node
	 */
	public Node(int num) {
		this.num = num;
		this.next = null;
		this.previous = null;
	}
	
	/**
	 * Accessor method for the next Node
	 * @return the next Node
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * Mutator method for the Previous Node
	 * @param node - the new previous Node
	 */
	public void setPrevious(Node node) {
		this.previous = node;
	}

	/**
	 * Accessor method for the previous Node
	 * @return the previous Node
	 */
	public Node getPrevious() {
		return previous;
	}

	/**
	 * Mutator method for the next Node
	 * @param node - the new next Node
	 */
	public void setNext(Node node) {
		this.next = node;
	}

	/**
	 * Accessor method
	 * @return the int value of the Node
	 */
	public int getValue() {
		return num;
	}
}