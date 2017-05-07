package tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) {
		Tree tree = new Tree();
		Tree fileTree = new Tree();
		Tree fileTree2 = new Tree();
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
		System.out.println("Histogram of random nodes: ");
		tree.print();
		tree.delete(node1);
		System.out.println("Histogram with the root (hi) deleted: ");
		tree.print();
		
		tree.delete(node5);
		System.out.println("Histogram with node 'tay' deleted: ");
		tree.print();
		
		//with a txt file
		String fileName = "Sentence.txt";
		readFile(fileName, fileTree);
		System.out.println("Histogram of Sentence example: ");
		fileTree.print();
		
		System.out.print("Search for 'sentence' (should return the node if found): ");
		System.out.println(fileTree.search("sentence").getString());
		Node se = new Node("sentence");
		fileTree.delete(se);
		System.out.println("Histogram of Sentence example with 'sentence' deleted: ");
		fileTree.print();
		try {
			System.out.println(fileTree.search("sentence").getString());
		} catch(NullPointerException e) {
			System.out.println("Node not found");
		}
		readFile("Random.txt", fileTree2);
		System.out.println("Histogram of a large random text file: ");
		//fileTree2.print();
		
	}
	
	public static void readFile(String fileName, Tree fileTree) {
		String line = null;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[+\\-*/\\^ ]+");
                for(int i = 0; i < words.length; i++) {
                	fileTree.insert(new Node(words[i]));
                }
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
}
