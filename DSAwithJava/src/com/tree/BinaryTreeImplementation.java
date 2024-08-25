package com.tree;
import java.util.*;

public class BinaryTreeImplementation {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTree{
		static int index = -1;
		public Node buildTreePreorder(int nodes[])
		{
			index++;
			if(nodes[index]==-1)
			{
				return null;
			}
			Node newNode = new Node(nodes[index]);
			newNode.left = buildTreePreorder(nodes);
			newNode.right = buildTreePreorder(nodes);
			return newNode;
		}
		public void preorder(Node root)
		{
			if(root==null)
			{
//				System.out.print("-1"+" ");
				return;
			}
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
		public void inorder(Node root)
		{
			if(root==null)
			{
//				System.out.print("-1"+" ");
				return;
			}
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
		public void postorder(Node root)
		{
			if(root==null)
			{
//				System.out.print("-1"+" ");
				return;
			}
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
		public void levelOrder(Node root)
		{
			Queue<Node> q = new LinkedList<>();
			if(root==null)
			{
				return;
			}
			q.add(root);
			q.add(null);
			while(!q.isEmpty()) {
				Node currNode = q.remove();
				if(currNode==null)
				{
					System.out.println();
					if(q.isEmpty())
					{
						break;
					}
					else
					{
						q.add(null);
					}
				}
				else {
					System.out.print(currNode.data+" ");
					if(currNode.left!=null)
					{
						q.add(currNode.left);
					}
					if(currNode.right!=null)
					{
						q.add(currNode.right);
					}
				}
			}
			
		}
		public int countOfNodes(Node root)
		{
			if(root==null)
			{
				return 0;
			}
			int leftNodes = countOfNodes(root.left);
			int rightNodes = countOfNodes(root.right);
			return leftNodes + rightNodes + 1;
		}
		public int sumOfNodes(Node root)
		{
			if(root==null)
			{
				return 0;
			}
			int leftSum = sumOfNodes(root.left);
			int rightSum = sumOfNodes(root.right);
			return leftSum + rightSum + root.data;
		}
		public int height(Node root)
		{
			if(root==null)
			{
				return 0;
			}
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			int myHeight = Math.max(leftHeight, rightHeight) + 1;
			return myHeight;
		}
		public int diameter(Node root)
		{
			if(root==null)
			{
				return 0;
			}
			int diam1 = diameter(root.left);
			int diam2 = diameter(root.right);
			int diam3 = height(root.left) + height(root.right) + 1;
			return Math.max(diam3, Math.max(diam1, diam2));
		}
	}
	
	public static void main(String[] args) {
		
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTreePreorder(nodes);
		System.out.println("Root of the tree containing the data : "+root.data);
		System.out.print("Preorder Traversal of the tree : ");
		tree.preorder(root);
		System.out.println();
		System.out.print("Inorder Traversal of the tree : ");
		tree.inorder(root);
		System.out.println();
		System.out.print("Postorder Traversal of the tree : ");
		tree.postorder(root);
		System.out.println();
		System.out.println("Levelorder Traversal of the tree : ");
		tree.levelOrder(root);
		System.out.println("Count of Nodes in Tree : "+tree.countOfNodes(root));
		System.out.println("Sum of Nodes in Tree : "+tree.sumOfNodes(root));
		System.out.println("Height of the Tree : "+tree.height(root));
		System.out.println("Diameter of the Tree : "+tree.diameter(root));
	}

}
