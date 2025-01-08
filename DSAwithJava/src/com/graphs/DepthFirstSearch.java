package com.graphs;

import java.util.Iterator;
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
	void DepthFirstSearchRecursiveUtility(int source, boolean visited[])
	{
		visited[source]=true;
		System.out.println(source+" ");
		Iterator<Integer> i = adj[source].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				DepthFirstSearchRecursiveUtility(n, visited);
			}
		}
	}
	void DepthFirstSearch()
	{
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
				DepthFirstSearchRecursiveUtility(i, visited);
			}
		}
	}
}

public class DepthFirstSearch {
	public static void main(String args[])
	{
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Depth First Traversal");
		g.DepthFirstSearch();
	}
}
