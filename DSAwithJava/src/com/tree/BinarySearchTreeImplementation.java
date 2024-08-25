package com.tree;

public class BinarySearchTreeImplementation {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int val){
			this.data = val;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BST{
		public Node insertNode(Node root, int val) 
		{
			if(root==null)
			{
				root = new Node(val);
				return root;
			}
			else
			{
				if(root.data>val)
				{
					root.left = insertNode(root.left, val);
				}
				else
				{
					root.right = insertNode(root.right, val);
				}
			}
			return root;
		}
		public void inorder(Node root)
		{
			if(root==null)
			{
				return;
			}
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
		public boolean searchKey(Node root,int key)
		{
			if(root==null)
			{
				return false;
			}
			else
			{
				if(root.data>key)
				{
					return searchKey(root.left, key);
				}
				else if(root.data<key)
				{
					return searchKey(root.right, key);
				}
				else if(root.data==key)
				{
					return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		
		int values[] = {5, 1, 3, 4, 2, 7};
		Node root = null;
		BST tree = new BST();
		for(int i=0;i<values.length;i++)
		{
			root = tree.insertNode(root, values[i]);
		}
		System.out.print("Inorder traversal of the created BST : ");
		tree.inorder(root);
		System.out.print("\nIs 4 present in BST ? "+tree.searchKey(root, 4));
	}

}
