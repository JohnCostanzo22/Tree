package tree;
public class Main {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Node node1 = new Node("hi");
		Node node2 = new Node("bob");
		Node node3 = new Node("tim");
		Node node4 = new Node("z");
		Node node5 = new Node("tay");
		Node node6 = new Node("red");
		Node node7 = new Node("blue");
		Node node8 = new Node("bobby");
		Node node9 = new Node("kud");
		Node node10 = new Node("xeno");
		tree.insert(new Node(null), node1);
		tree.insert(node1);
		tree.insert(node2);
		tree.insert(node3);
		tree.insert(node1);
		tree.insert(node2);
		tree.insert(node5);
		tree.insert(node6);
		tree.insert(node7);
		tree.insert(node10);
		tree.print();
		System.out.println(tree.search(node1, "bob").getString());
		tree.delete(node1, node1);
		tree.print();
	}
}
