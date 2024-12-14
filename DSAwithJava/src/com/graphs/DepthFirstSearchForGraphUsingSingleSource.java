package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchForGraphUsingSingleSource {
	
	static void DepthFirstSearchRecursive(List<List<Integer>> adj, boolean[] visited, int s)
	{
		visited[s] = true;
		System.out.print(s + " ");
		for(int i:adj.get(s))
		{
			if(!visited[i])
			{
				DepthFirstSearchRecursive(adj, visited, i);
			}
		}
	}
	
	static void DepthFirstSearchForSourceVertex(List<List<Integer>> adj, int s)
	{
		boolean[] visited = new boolean[adj.size()];
		
		DepthFirstSearchRecursive(adj, visited, s);
	}
	
	static void addEdgeInAdjacencyList(List<List<Integer>> adj, int s, int t)
	{
		adj.get(s).add(t);
		
		adj.get(t).add(s);
	}
	
	public static void main(String args[])
	{
		int v = 5;
		List<List<Integer>> adj = new ArrayList<>(v);
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<>());
		}
		int[][] edges = {{1,2},{1,0},{2,0},{2,3},{2,4}};
		for(int[] e:edges)
		{
			addEdgeInAdjacencyList(adj, e[0], e[1]);
		}
		int source = 1;
		System.out.println("Depth First Search from source : "+source);
		DepthFirstSearchForSourceVertex(adj, source);
	}
}
