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
	
	static class TreeInfo{
		int height;
		int diameter;
		TreeInfo(int height, int diameter)
		{
			this.height = height;
			this.diameter = diameter;
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
		public void reset_index()
		{
			index=-1;
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
		public TreeInfo diameter2(Node root)
		{
			if(root==null)
			{
				return new TreeInfo(0,0);
			}
			TreeInfo left = diameter2(root.left);
			TreeInfo right = diameter2(root.right);
			int myHeight = Math.max(left.height, right.height)+1;
			int diam1 = left.diameter;
			int diam2 = right.diameter;
			int diam3 = left.height + right.height + 1;
			int myDiam = Math.max(Math.max(diam1, diam2), diam3);
			TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
			return myInfo;
		}
		public boolean isSubTree(Node root,Node subroot)
		{
			if(subroot==null)
			{
				return true;
			}
			if(root==null)
			{
				return false;
			}
			if(root.data==subroot.data)
			{
				if(isIdentical(root,subroot))
				{
					return true;
				}
			}
			return isSubTree(root.left,subroot)||isSubTree(root.right,subroot);
		}
		public boolean isIdentical(Node root, Node subroot)
		{
			if(root==null && subroot==null)
			{
				return true;
			}
			if(root==null || subroot==null)
			{
				return false;
			}
			if(root.data==subroot.data)
			{
				return isIdentical(root.left,subroot.left)&&isIdentical(root.left,subroot.left);
			}
			return false;
		}
		public int sumOfNodesValueAtKthLevel(Node root,int k)
		{
			int level=1,sum=0;
			Queue<Node> q = new LinkedList<>();
			if(root==null)
			{
				return -1;
			}
			q.add(root);
			q.add(null);
			while(!q.isEmpty())
			{
				Node currNode = q.remove();
				if(currNode==null)
				{
					if(q.isEmpty())
					{
						break;
					}
					else
					{
						q.add(null);
						level++;
					}
				}
				else
				{
					if(level==k)
					{
						sum+=currNode.data;
					}
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
			return sum;			
		}
	}
	
	public static void main(String[] args) {
		
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTreePreorder(nodes);
		tree.reset_index();
		System.out.println("Root of the tree containing the data : "+root.data);
		System.out.print("Preorder Traversal of the tree : ");
		tree.preorder(root);
		System.out.print("\nInorder Traversal of the tree : ");
		tree.inorder(root);
		System.out.print("\nPostorder Traversal of the tree : ");
		tree.postorder(root);
		System.out.println("\nLevelorder Traversal of the tree : ");
		tree.levelOrder(root);
		System.out.println("Count of Nodes in Tree : "+tree.countOfNodes(root));
		System.out.println("Sum of Nodes in Tree : "+tree.sumOfNodes(root));
		System.out.println("Height of the Tree : "+tree.height(root));
		System.out.println("Diameter of the Tree : "+tree.diameter(root));
		System.out.println("Diameter of the tree using lesser time complexity method: "+tree.diameter2(root).diameter);
		int nodes_sub[] = {2,4,-1,-1,5,-1,-1};
		Node subroot = tree.buildTreePreorder(nodes_sub);
		System.out.print("Preorder Traversal of the Subtree : ");
		tree.preorder(subroot);
		System.out.println("\nIs SubTree? "+tree.isSubTree(root, subroot));
		System.out.print("Sum of Nodes at level 1 : "+tree.sumOfNodesValueAtKthLevel(root, 1));
		System.out.print("\nSum of Nodes at level 2 : "+tree.sumOfNodesValueAtKthLevel(root, 2));
		System.out.print("\nSum of Nodes at level 3 : "+tree.sumOfNodesValueAtKthLevel(root, 3));
	}

}
