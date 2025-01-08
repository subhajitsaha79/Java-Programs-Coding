package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BreadthFirstSearchDisconnected{
	
	public static void breadthFirstSearch(List<List<Integer>> adj, int source, boolean[] visited)
	{
		Queue<Integer> q = new LinkedList<>();
		visited[source] = true;
		q.add(source);
		while(!q.isEmpty())
		{
			int curr = q.poll();
			System.out.println(curr+" ");
			for(int x:adj.get(curr))
			{
				if(!visited[x])
				{
					visited[x] = true;
					q.add(x);
				}
			}
		}
	}
	
	public static void breathFirstSearchDisconnected(List<List<Integer>> adj)
	{
		boolean[] visited = new boolean[adj.size()];
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[i])
			{
				breadthFirstSearch(adj, i, visited);
			}
		}
	}
	
	public static void addEdge(List<List<Integer>> adj, int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
}

public class BreadthFirstSearchImplementationDiscGraph {

	public static void main(String[] args) {
		
		int v = 6;
		List<List<Integer>> adj = new ArrayList<>(v);
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<>());
		}
		BreadthFirstSearchDisconnected.addEdge(adj, 0, 1);
		BreadthFirstSearchDisconnected.addEdge(adj, 0, 2);
		BreadthFirstSearchDisconnected.addEdge(adj, 3, 4);
		BreadthFirstSearchDisconnected.addEdge(adj, 4, 5);
		
		BreadthFirstSearchDisconnected.breathFirstSearchDisconnected(adj);
		

	}

}
