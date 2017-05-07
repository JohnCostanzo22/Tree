/*
 * Creates a tree of nodes and keeps track of the root and the counter of each Node
 */
package tree;
public class Tree {

	//properties
	private Node root;
	
	/**
	 * default constructor sets root to null
	 */
	public Tree() {
		root = null;
	}
	
	/**
	 * constructor that sets root to a node
	 * @param node - the root
	 */
	public Tree(Node node) {
		root = node;
	}
	
	/**
	 * sets the root if it is null
	 * does not allow root to be changed
	 * @param node - new root
	 */
	public void setRoot(Node node) {
		if(root != null) {
			System.out.println("Can't change the root of an existing tree");
			return;
		}
		if(node != null)
			root = node;
	}
	
	/**
	 * Calls the search method with the root and the node to search for
	 * @param name - String of node to search for
	 * @return - the node if it exists in the tree or null if not
	 */
	public Node search(String name) {
		return search(root, name);
	}
	/**
	 * searches tree for the string passed in starting at the node 
	 * @param node - node to start the search
	 * @param name - String being searched for
	 * @return - the node with String name if found
	 * else returns null
	 */
	public Node search(Node node, String name) {
		if(node != null) {
			if(node.getString().equalsIgnoreCase(name)) {
				return node;
			}
			else {
				Node foundNode = search(node.getLeft(), name);
				if(foundNode == null) {
					foundNode = search(node.getRight(), name);
				}
				return foundNode;
			}
		}
		else {
			return null;
		}
	}
	/**
	 * Calls insert method using root and insertNode
	 * @param insertNode - node to be inserted
	 */
	public void insert(Node insertNode) {
		insert(root, insertNode);
	}
	/**
	 * inserts insertNode into the tree keeping alphabetical order
	 * and maintaining root and counter variable of node
	 * Does not allow repeat nodes
	 * @param node - node to start search for alphabetical position
	 * @param insertNode - node to be inserted
	 */
	public void insert(Node node, Node insertNode) {
		if(root == null) {
			root = insertNode;
			insertNode.increment();
		}
		if(node == null) {
			return;	//do nothing with a null node
		}
		if(insertNode == null) {
			System.out.println("Can't insert a null Node");
		}
		else if(search(root , insertNode.getString()) != null) {
			search(root , insertNode.getString()).increment();
		}
		else {
			if(insertNode.getString().compareToIgnoreCase(node.getString()) < 0) {
				if(node.getLeft() != null) {
					insert(node.getLeft(), insertNode);
				}
				else {
					node.setLeft(insertNode);
					node.getLeft().increment();
				}
			}
			else {
				if(node.getRight() != null) {
					insert(node.getRight(), insertNode);
				}
				else {
					node.setRight(insertNode);
					node.getRight().increment();
				}
			}
		}
	}
	/**
	 * Calls deleted method using root and delete
	 * @param delete - node to get deleted
	 */
	public void delete(Node delete) {
		delete(root,delete);
	}
	/**
	 * Deletes a node from the tree and inserts back in all children
	 * @param node - node to start search for delete node
	 * @param delete - node to get deleted
	 */
	public void delete(Node node, Node delete) {
		if(node == null) {
			System.out.println("Can't delete with a null Node");
		}
		else if(delete == null) {
			return;	//do nothing with a null delete 
		}
		//compare the strings of the nodes not the actual nodes
		//check the current nodes children to keep track of the parent node
		else if(node.getString() != null && node.getString().compareToIgnoreCase(delete.getString()) == 0 ) {
			root = null;
			deletedInsert(node.getLeft());
			deletedInsert(node.getRight());
		}
		else {
			//if its the left node then
			//check if its null first to avoid dealing with NullPointerExceptions
				if(node.getLeft() != null && node.getLeft().getString().compareToIgnoreCase(delete.getString()) == 0) {
					Node temp = node.getLeft();
					node.setLeft(null);
					deletedInsert(temp.getLeft());
					deletedInsert(temp.getRight());
				}
			//right node
			else if(node.getRight() != null && node.getRight().getString().compareToIgnoreCase(delete.getString()) == 0) {
				Node temp = node.getRight();
				node.setRight(null);
				deletedInsert(temp.getLeft());
				deletedInsert(temp.getRight());
			}
			else {
				if(node.getLeft() != null) {
					delete(node.getLeft(), delete);
				}
				if(node.getRight() != null) {
					delete(node.getRight(), delete);
				}
			}
		}
	}
	/**
	 * deletes the node and calls insert method to add back to 
	 * tree. Also deletes and adds back all children
	 * @param node - node to be deleted and then added back
	 */
	private void deletedInsert(Node node) {
		if(node != null) {
			Node tempLeft = node.getLeft();
			Node tempRight = node.getRight();
			node.setLeft(null);
			node.setRight(null);
			insert(node);
			node.decrement();
			if(tempLeft != null) {
				deletedInsert(tempLeft);
			}
			if(tempRight != null) {
				deletedInsert(tempRight);
			}
		}
	}
	/**
	 * Calls print method starting from root
	 */
	public void print() {
		print(root);
	}
	/**
	 * prints the tree using the inorder method
	 * @param node - starting node
	 */
	public void print(Node node) {
		if(node != null) {
			print(node.getLeft());
			System.out.println(node.getString() + " " + node.getCount());
			print(node.getRight());
		}
	}
}
