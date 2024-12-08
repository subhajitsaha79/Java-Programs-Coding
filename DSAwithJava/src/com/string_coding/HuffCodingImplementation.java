package com.string_coding;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffCodingImplementation {
	
	/*
	 * Initializing a HuffmanNode Class that contains the data and character as the attribute
	 * It also has a compare function overriden from the comparator interface
	 * which helps it to be used with the PriorityQueue.
	 * Also the HuffmanNode class is used to represent a Binary tree with left and right
	 * subtrees. Each node is used to represent a data for the character frequency, a character
	 * and a connection to it's corresponding left and right subtrees.
	 * */
	static class HuffmanNode implements Comparator<HuffmanNode>{
		int data;
		char c;
		HuffmanNode left, right;
		@Override
		public int compare(HuffmanNode o1, HuffmanNode o2) {
			return o1.data - o2.data;
		}
	}
	
	/*
	 * Recursive function for the printCode function so that the Huffman code for
	 * the tree can be generated. If the node is a empty node then return empty which
	 * is the base case.
	 * 
	 * If the node is a leaf node with no left and right subtrees and the character
	 * of the node is a letter and not a non letter, then we include that node while
	 * working out the Huffman code from the root to the leaf node and then we print it.
	 * 
	 * 
	 * Finally there are two calls for the printCode method for the left and the right subtree.
	 * For traversing the root to the left subtree, we add a 0 to the HuffmanCode and for traversing
	 * the right subtree we add a 1 to the final HuffmanCode
	 * */
	public static void printCode(HuffmanNode root, String s)
	{
		if(root==null)
		{
			return;
		}
		if(root.left==null && root.right==null && Character.isLetter(root.c))
		{
			System.out.println(root.c+" : "+s);
		}
		printCode(root.left, s+"0");
		printCode(root.right, s+"1");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * We will be working with six characters.
		 * 
		 * Initialize the character array with the designated characters with their character
		 * frequencies seperately for all the seperate characters.
		 * */
		int n = 6;
		char[] charArray = {'a','b','c','d','e','f'};
		int[] charFreq = {5, 9, 12, 13, 16, 45};
		
		/*
		 * PriorityQueue of HuffmanNodes to mimick a min heap and extract the node with the
		 * minimum frequency.
		 * */
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new HuffmanNode());
		
		//Create distinct HuffmanNodes for each character and add them to the PriorityQueue
		for(int i=0;i<n;i++)
		{
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
			hn.data = charFreq[i];
			
			hn.left = null;
			hn.right = null;
			q.add(hn);
		}
		//Initialize the root Huffman node and use it for traversing the Huffman Binary Tree
		HuffmanNode root = null;
		while(q.size()>1)
		{
			//Extract 2 most minimum nodes from the PriorityQueue and merge them to form a new HuffmanNode
			//with merged frequency and a non letter character
			HuffmanNode x = q.peek();
			q.poll();
			HuffmanNode y = q.peek();
			q.poll();
			HuffmanNode f = new HuffmanNode();
			//merged frequency
			f.data = x.data + y.data;
			//non letter character
			f.c = '-';
			//the new node is having the left and right subtrees with the original minimum nodesk
			f.left = x;
			f.right = y;
			root = f;
			q.add(f);
		}
		printCode(root, "");
		sc.close();
	}

}
