package tree;
public class Tree {

	private Node root;
	
	public Tree() {
		root = null;
	}
	
	public Tree(Node node) {
		root = node;
	}
	
	public void setRoot(Node node) {
		if(root != null) {
			System.out.println("Can't change the root of an existing tree");
			return;
		}
		root = node;
	}
	
	public Node search(String name) {
		return search(root, name);
	}
	public Node search(Node node, String name) {
		if(node != null) {
			if(node.getString().equals(name)) {
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
	public void insert(Node insertNode) {
		insert(root, insertNode);
	}
	public void insert(Node node, Node insertNode) {
		if(root == null) {
			root = insertNode;
			insertNode.increment();
		}
		if(node == null) {
			return;
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
	public void delete(Node delete) {
		delete(root,delete);
	}
	public void delete(Node node, Node delete) {
		if(node == null) {
			System.out.println("Can't delete a null Node");
		}
		else if(delete == null) {
			return;
		}
		else if(node.getString() != null && node.getString().compareTo(delete.getString()) == 0 ) {
			root = null;
			deletedInsert(node.getLeft());
			deletedInsert(node.getRight());
		}
		else {
			//if its the left node then
			//check if its null first to avoid dealing with NullPointerExceptions
				if(node.getLeft() != null && node.getLeft().getString().compareTo(delete.getString()) == 0) {
					Node temp = node.getLeft();
					node.setLeft(null);
					deletedInsert(temp.getLeft());
					deletedInsert(temp.getRight());
				}
			else if(node.getRight() != null && node.getRight().getString().compareTo(delete.getString()) == 0) {
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
	public void print() {
		print(root);
	}
	public void print(Node node) {
		if(node != null) {
			print(node.getLeft());
			System.out.println(node.getString() + " " + node.getCount());
			print(node.getRight());
		}
	}
}
