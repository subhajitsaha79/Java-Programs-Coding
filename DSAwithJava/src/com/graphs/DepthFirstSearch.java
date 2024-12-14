package com.graphs;

import java.util.LinkedList;

class Graph{
	private int v;
	
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	void addEdge(int v, int s)
	{
		adj[v].add(s);
	}
	void DepthFirstSearchRecursive(int source, boolean visited[])
	{
		visited[source]=true;
		System.out.println();
	}
}

public class DepthFirstSearch {

}
