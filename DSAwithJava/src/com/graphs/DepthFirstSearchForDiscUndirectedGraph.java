package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchForDiscUndirectedGraph {
	
	static void addEdgeAdjacencyList(List<List<Integer>> adj, int s, int t)
	{
		adj.get(s).add(t);
		adj.get(t).add(s);
	}
	
	static void DepthFirstSearchRecursive(List<List<Integer>> adj, boolean[] visited, int s)
	{
		visited[s] = true;
		System.out.print(s+" ");
		for(int i:adj.get(s))
		{
			if(!visited[i])
			{
				DepthFirstSearchRecursive(adj, visited, i);
			}
		}
	}
	
	static void DepthFirstSearchForDisconnectedUndirectedGraph(List<List<Integer>> adj, int v)
	{
		boolean visited[] = new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				DepthFirstSearchRecursive(adj, visited, i);
			}
		}
	}
	
	public static void main(String args[])
	{
		int v = 6;
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<>());
		}
		int[][] edges = {{1,2}, {2,0}, {0,3}, {4,5}};
		for(int[] edge:edges)
		{
			addEdgeAdjacencyList(adj, edge[0], edge[1]);
		}
		System.out.println("Complete DFS of the graph : ");
		DepthFirstSearchForDisconnectedUndirectedGraph(adj, v);
	}
}
