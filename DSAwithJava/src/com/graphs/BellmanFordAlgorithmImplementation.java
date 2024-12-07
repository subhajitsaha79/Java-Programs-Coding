package com.graphs;

import java.util.Arrays;

public class BellmanFordAlgorithmImplementation {
	
	static int[] bellmanFord_algorithm(int n, int[][] edges, int src)
	{
		/*
		 * distance array to store the final distances from the source vertex.
		 * Initially the distance array is storing positive infinity
		 * 
		 * the source vertex entry into the distance vertex is 0
		 * 
		 * Now for the loop running from 0 till n-1 for each vertex, to compute the minimum path weight
		 * 
		 * another loop is run inside the original loop to run over all the edges in the graph
		 * and compute the minimum path weight reaching the other vertices from the current vertex 
		 * check if the path weight is less than the path weights currently holded and update accordingly
		 * 
		 * otherwise by iterating if we reach the last vertex in the outer loop, then it's understandable
		 * that the weight is deacreasing due to the presence of negative weight cycle 
		 * and we return -1
		 * 
		 */
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		for(int i=0;i<n;i++)
		{
			for(int[] edge:edges)
			{
				int u = edge[0];
				int v = edge[1];
				int wt = edge[2];
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt < dist[v])
				{
					if(i==n-1)
						return new int[] {-1};
					dist[v] = dist[u] + wt;
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = new int[][] {
			{1,3,2},
			{4,3,-1},
			{2,4,1},
			{1,2,1},
			{0,1,5}
		};
		int src = 0;
		int[] ans = bellmanFord_algorithm(n, edges, src);
		for(int dist:ans)
		{
			System.out.print(dist+" ");
		}
		

	}

}
