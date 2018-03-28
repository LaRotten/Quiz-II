package OperationswithStackandTree;

import java.util.ArrayList;

class Node{
	String data;
	Node next;
	Node(String s){
		data=s;
		next=null;
	}
}

class Stack{
	private Node head;
	Stack(){
		head=null;
	}
	void pushStack(String s) {
		Node tempNode;
		if(head==null) head=new Node(s);
		else {
			tempNode=new Node(s);
			tempNode.next=head;
			head=tempNode;
		}
	}
	void printStack() {
		Node tempNode=head;
		if(head==null)	System.out.println("There is no Stack");
		else {
			System.out.print("Stack   : ");
			while(tempNode!=null) {
				System.out.print(tempNode.data +" ");
				tempNode=tempNode.next;
			}
		}
	}
	Node getHead() {
		return head;
	}
	
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Node2{
	String data;
	Node2 right,left;
	Node2(String s){
		data=s;
		right=left=null;
	}
}
class Tree{
	private Node2 root,tempNode2,tempNode3,tempNode4;
	Tree(){
		root=null;
	}
	void pushRoot(String s) {
		root=new Node2(s);
		tempNode2=root;
		tempNode3=root;
		
		System.out.println("Root    : " + root.data);
		
	}
	void pushTree(String s1,String s2) {
		tempNode2.right=new Node2(s1);
		tempNode2.left=new Node2(s2);
		
		tempNode2=tempNode2.left;
	}
	void printTree() {
		System.out.print("Tree    : ");
		System.out.print(tempNode3.data+" ");
		while(tempNode3.right!=null) {
			System.out.print(tempNode3.right.data+ " " + tempNode3.left.data+ " ");
			tempNode3=tempNode3.left;
		}
	}
	int isOperand(String operator,int num1,int num2){
		switch(operator){
		case"+":
			return num1+num2;
		case"-":
			return num1-num2;
		case"*":
			return num1*num2;
		case"/":
			return num1/num2;
			
		}
	return -1;

	}
	void cutTree() {
		tempNode4=root;
	
		while(tempNode4.left.left!=null) {
			tempNode4=tempNode4.left;
		}
		int x=isOperand(tempNode4.data,Integer.parseInt(tempNode4.left.data),Integer.parseInt(tempNode4.right.data));
		tempNode4.data=Integer.toString(x);
		tempNode4.left=null;
		tempNode4.right=null;
		
		if(root.data.matches("[/*-+]")) {
			cutTree();
		}
		else {
			System.out.println();
			System.out.println("The Result : "+ x);
		}
	}
	
	
	
	
	
	
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////



public class Project {
	public static void main(String []args) {
		Stack o=new Stack();
		Tree t=new Tree();
		
		String s="3 2 + 2 * ";
		String[] tokens =s.split(" +");
		System.out.print("Tokens  : ");
		for(int i=0;i<tokens.length;i++) {
			System.out.print(tokens[i] + " ");
			o.pushStack(tokens[i]);
		}
		System.out.println();
		o.printStack();
		System.out.println();
		Node n=o.getHead(); 	//gets head referance of the Stack
		t.pushRoot(n.data);
		n=n.next;	//The first element of the tree already pushed as the root
		while(n!=null && n.next!=null) {
			t.pushTree(n.data, n.next.data);
			n=n.next.next;
		}
		t.printTree();
		t.cutTree();
		
		
		
	}
}
