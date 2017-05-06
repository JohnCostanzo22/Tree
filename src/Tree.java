
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
	
	public void insert(Node node, String name) {
		if(node == null) {
			//throw
		}
		if(root == null) {
			root = new Node(name);
			root.increment();
		}
		else if(search(node, node.getString()) != null) {
			node.increment();
		}
		else {
			if(name.compareTo(node.getString()) < 0) {
				if(node.getLeft() != null) {
					insert(node.getLeft(), name);
				}
				else {
					node.setLeft(new Node(name));
					node.getLeft().increment();
				}
			}
			else {
				if(node.getRight() != null) {
					insert(node.getRight(), name);
				}
				else {
					node.setRight(new Node(name));
					node.getRight().increment();
				}
			}
		}
	}
}
