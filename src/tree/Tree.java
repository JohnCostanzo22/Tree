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
			//throw
		}
		else if(search(root , insertNode.getString()) != null) {
			insertNode.increment();
		}
		else {
			if(insertNode.getString().compareTo(node.getString()) < 0) {
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
			//do something
		}
		else if(delete == null) {
			return;
		}
		else if(node == delete) {
			root = null;
			deletedInsert(node.getLeft());
			deletedInsert(node.getRight());
		}
		else {
			//if its the left node then
			if(node.getLeft() == delete) {
				Node temp = node.getLeft();
				node.setLeft(null);
				deletedInsert(temp.getLeft());
				deletedInsert(temp.getRight());
			}
			else if(node.getRight() == delete) {
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
