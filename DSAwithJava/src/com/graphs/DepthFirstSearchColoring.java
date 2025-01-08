package com.graphs;

import java.util.Iterator;
import java.util.LinkedList;

class GraphNew{
	private int v;
	private String[] color;
	private int[] parent;
	private int[] discovery;
	private int[] finishing;
	private int time;
	
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	GraphNew(int v)
	{
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
		color = new String[v];
		parent = new int[v];
		discovery = new int[v];
		finishing = new int[v];
	}
	void addEdge(int v, int s)
	{
		adj[v].add(s);
	}
	void DepthFirstSearchRecursiveUtility(int source, boolean visited[])
	{
		visited[source]=true;
		color[source]="grey";
		discovery[source]=time;
		time = time+1;
		System.out.println(source+" ");
		Iterator<Integer> i = adj[source].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				parent[n]=source;
				DepthFirstSearchRecursiveUtility(n, visited);
			}
		}
		color[source]="black";
		finishing[source]=time;
		time = time+1;
	}
	void DepthFirstSearch()
	{
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++)
		{
			color[i]="white";
			parent[i]=-1;
		}
		time = 0;
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
				DepthFirstSearchRecursiveUtility(i, visited);
			}
		}
	}
	void getColors()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print(this.color[i]+" ");
		}
	}
	void getParents()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print(this.parent[i]+" ");
		}
	}
	void getDiscoveryTimes()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print(this.discovery[i]+" ");
		}
	}
	void getFinishingTimes()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print(this.finishing[i]+" ");
		}
	}
}

public class DepthFirstSearchColoring {
	public static void main(String args[])
	{
		GraphNew g = new GraphNew(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is Depth First Traversal");
		g.DepthFirstSearch();
		g.getColors();
		System.out.println();
		g.getParents();
		System.out.println();
		g.getDiscoveryTimes();
		System.out.println();
		g.getFinishingTimes();
	}
}
