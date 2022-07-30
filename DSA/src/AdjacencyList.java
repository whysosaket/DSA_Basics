import java.util.ArrayList;
import java.util.LinkedList;
public class AdjacencyList {
public static void main(String[] args) {
		
		// Adjacency List = An array/arraylist of linkedlists.
		//			          Each LinkedList has a unique node at the head.
		//			          All adjacent neighbors to that node are added to that node's linkedlist
		
		//				  runtime complexity to check an Edge: O(v)
		//				  space complexity: O(v + e)
		
		Graph1 graph = new Graph1();
		
		graph.addNode(new Node1('A'));
		graph.addNode(new Node1('B'));
		graph.addNode(new Node1('C'));
		graph.addNode(new Node1('D'));
		graph.addNode(new Node1('E'));
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		
		//System.out.println(graph.checkEdge(0, 1));
	}
}

class Graph1 {

	ArrayList<LinkedList<Node1>> alist;
	
	Graph1(){
		alist = new ArrayList<>();
	}
	
	public void addNode(Node1 node) {
		LinkedList<Node1> currentList = new LinkedList<>();
		currentList.add(node);
		alist.add(currentList);
	}
	public void addEdge(int src, int dst) {
		LinkedList<Node1> currentList = alist.get(src);
		Node1 dstNode = alist.get(dst).get(0);
		currentList.add(dstNode);
	}
	public boolean checkEdge(int src, int dst) {
		LinkedList<Node1> currentList = alist.get(src);
		Node1 dstNode = alist.get(dst).get(0);
		
		for(Node1 node : currentList) {
			if(node == dstNode) {
				return true;
			}
		}
		return false;
	}
	public void print() {
		for(LinkedList<Node1> currentList : alist) {
			for(Node1 node : currentList) {
				System.out.print(node.data + " -> ");
			}
			System.out.println();
		}
	}	
}
class Node1 {

	char data;
	
	Node1(char data){
		this.data = data;
	}
}
