package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BreadthFirstSearch{
	
	static void breadthFirstSearch(List<List<Integer>> adj, int s)
	{
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[adj.size()];
		visited[s] = true;
		q.add(s);
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
	
	static void addEdge(List<List<Integer>> adj, int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(v);
	}
}

public class BreadthFirstSearchImplementation {
	
	public static void main(String args[])
	{
		int v = 5;
		List<List<Integer>> adj = new ArrayList<>(v);
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<>());
		}
		BreadthFirstSearch.addEdge(adj, 0, 1);
		BreadthFirstSearch.addEdge(adj, 0, 2);
		BreadthFirstSearch.addEdge(adj, 1, 3);
		BreadthFirstSearch.addEdge(adj, 1, 4);
		BreadthFirstSearch.addEdge(adj, 2, 4);
		
		System.out.println("BFS starting from 0:");
		BreadthFirstSearch.breadthFirstSearch(adj, 0);
		
	}
}
