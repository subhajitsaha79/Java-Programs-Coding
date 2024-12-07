package com.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/* Greedy algorithm that solves the single source shortest path problem for a directed
 * graph G = (V, E) with non negative edge weights. w(u, v)>=0 for each edge (u,v) belongs to E.
 */
public class DijkstraAlgorithmImplementation {
	
	/*
	 * Creation of a static class called Node which implements the comparator interface since this particular class
	 * will work inside a priority Queue.
	 * 
	 * Since the class is implementing the comparator interface, it needs to override the compare method.
	 * The comparison is based on comparison of two node objects w.r.t their costs.
	 * */
	static class Node implements Comparator<Node>
	{
		public int node;
		public int cost;
		public Node()
		{
		}
		public Node(int node, int cost)
		{
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compare(Node node1, Node node2)
		{
			if(node1.cost<node2.cost)
			{
				return -1;
			}
			if(node1.cost>node2.cost)
			{
				return 1;
			}
			return 0;
		}
		
	}
	
	//distance from source vertex to the respective vertices
	private int dist[];
	/* 
	 * Dijkstra's algorithm maintains a set of S vertices whose final shortest-path weights from
	 * the source have been determined.
	 * 
	 * All vertices v belonging to S,d[v] = delta(s, v), the algorithm selects the vertex
	 * u belonging to V-S with the minimum shortest path estimate, insert u into S and relaxes all
	 * edges leaving u.
	 * 
	 * A minimum priority queue Q that contains all vertices in V-S keyed by their d values.
	 * 
	 * Graph G is represented by adjacency list
	 * 
	 * Always chooses the "lightest"/"closest" vertex in V-S to insert into set S
	 * that's why it's called a greedy strategy
	 * 
	 * Bears similarity to both breadth-first search and Prim's algorithm for computing minimum spanning
	 * trees.
	 */
	//set is used to keep the final list of vertices whose least path weights have been computed
	private Set<Integer> settled;
	//priority queue is used to represent V-S set with dist values keyed
	//when required fetch the least distant vertex outside a given set S
	private PriorityQueue<Node> pq;
	//v represents the number of vertices in the graph
	private int v;
	//graph is represented as an adjacency list
	List<List<Node>> adj;
	
	public DijkstraAlgorithmImplementation(int v)
	{
		//initialize the number of vertices in the graph
		this.v = v;
		//initialize the array containing the distances from source to destination vertices
		dist = new int[v];
		//initialize the set containing set of vertices for who minimum path weights have been computed
		settled = new HashSet<Integer>();
		//initialize priority queue with the number of vertices for Node objects
		//Node needs to have the comparator interface implemented so that sorting can be done easily
		pq = new PriorityQueue<Node>(v, new Node());
	}
	
	public void dijkstra_algo(List<List<Node>> adj, int src)
	{
		//initialize the adjacency list of the graph
		this.adj = adj;
		
		//initially assign positive infinity to all the vertices in the distance array
		for(int i=0;i<v;i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		
		//add the source vertex with id and cost, since it's already covered with cost 0
		pq.add(new Node(src, 0));
		//distance to source vertex is set as 0
		dist[src] = 0;
		
		//while the length of set S containing covered vertices is not equal to the length of the array
		while(settled.size()!=v)
		{
			//if the priority queue is empty to return the minimum path weight vertex in set V-S
			//then break out of the loop
			if(pq.isEmpty())
				return;
			//return the minimum cost node in V-S from the priority queue
			int u = pq.remove().node;
			//if the extracted node is present in the already covered set S
			//then move to the next minimum node from V-S
			if(settled.contains(u))
			{
				continue;
			}
			else {
				//if it's not present in the already covered set S then add it
				settled.add(u);
			}
			//relax all the neighboring edges along connected vertices around vertex u
			edge_neighbours(adj, u);
		}
	}
	
	//method to check out the neighboring vertices along connected vertices around vertex u
	public void edge_neighbours(List<List<Node>> adj, int u)
	{
		//initializing two variables for original edge distance and new distance
		//which can be computed through intermediate vertices
		int edgeDistance = -1;
		int newDistance = -1;
		//fetch the neighboring vertices of a vertex currently processed
		for(int i=0;i<adj.get(u).size();i++)
		{
			//From the list of the vertices, fetch the list of vertices adjacent to the said vertex
			Node v = adj.get(u).get(i);
			//If the adjacent vertex is not present in the set of already path weight computed vertices
			if(!settled.contains(v.node))
			{
				//get the initial cost from u to v in edgeDistance
				edgeDistance = v.cost;
				//the source to v distance will be the sum of distance of source to u plus the edgeDistance of u to v
				newDistance = dist[u] + edgeDistance;
				//if the computed distance is less than the current current distance to reach the vertex from the source vertex
				if(newDistance < dist[v.node])
				{
					//reinitialize the distance to the new distance
					dist[v.node] = newDistance;
				}
				//add the current neighboring node of the current node to the priority queue in V-S set so that it can be settled
				pq.add(new Node(v.node, dist[v.node]));
			}
		}
	}
	public static void main(String[] args) 
	{
		//initialize number of nodes and source vertex
		int v = 5; int source = 0;
		//initialize the object of LinkedList with an arraylist instance i.e. it's a arraylist of arraylist
		List<List<Node>> adj = new ArrayList<List<Node>>();
		for(int i=0;i<v;i++)
		{
			List<Node> item = new ArrayList<Node>();
			adj.add(item);
		}
		//add the nodes(1,2,3,4) in the arraylist of 0th node with weights 9,6,5,3
		adj.get(0).add(new Node(1,9));
		adj.get(0).add(new Node(2,6));
		adj.get(0).add(new Node(3,5));
		adj.get(0).add(new Node(4,3));
		
		//add the nodes(1,3) in the arraylist of 2nd node with weights 2,4
		adj.get(2).add(new Node(1,2));
		adj.get(2).add(new Node(3,4));
		
		//create an object for the Algorithm implementation class
		DijkstraAlgorithmImplementation obj = new DijkstraAlgorithmImplementation(v);
		//using the object for the implementation class, invoke the dijkstra method
		obj.dijkstra_algo(adj, source);
		
		//finally print the values from the dist[] array
		System.out.println("The shortest path from node : ");
		for(int i=0;i<obj.dist.length;i++)
		{
			System.out.println(source + " to " + i + " is " + obj.dist[i]);
		}

	}

}
