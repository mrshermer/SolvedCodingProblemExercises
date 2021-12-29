import java.util.ArrayList;

public class BinarySearchTreeValidation {
   private class Node{
     public Node left = null;
     public Node right = null;
     public int data = 0;
     
     public Node(Node left, int data, Node right){
       this.left = left;
       this.data = data;
       this.right = right;
     } 
  }
  private Node head;
  
  private ArrayList<Integer> isBST(Node head, ArrayList<Integer> tempArray){
     if(head == null){
        return tempArray;
     }
     tempArray = isBST(head.left, tempArray);
     tempArray.add(head.data);
     tempArray = isBST(head.right, tempArray);
     return tempArray;
  }
    
  public void isBinarySearchTree(){
     System.out.println("Test 1:");
     
     head = new Node(null, 8, null);
     head.left = new Node(null, 4, null);
     head.right = new Node(null, 10, null);
     head.left.left = new Node(null, 2, null);
     head.left.right = new Node(null, 12, null);
     head.right.right = new Node(null, 20, null);
     
     Node temp = head;
     boolean result = true;
     ArrayList<Integer> tempArray = new ArrayList<Integer>();
     
     tempArray = isBST(head, tempArray);
     System.out.println("Array representation of tree [InOrder Traversal] {2, 4, 12, 8, 10, 20}");
     
     for(int a = 0; a < tempArray.size() - 1; a++){
        if(tempArray.get(a) > tempArray.get(a+1)){
           result = false;
           a = tempArray.size();
        }
     }
     if(!result){
        System.out.println("This is not a Binary Search Tree");
     }
     else{
        System.out.println("This is a Binary Search Tree");
     }
     
     System.out.println("Test 2:");
     head = new Node(null, 8, null);
     head.left = new Node(null, 4, null);
     head.right = new Node(null, 10, null);
     head.left.left = new Node(null, 2, null);
     head.left.right = new Node(null, 5, null);
     head.right.right = new Node(null, 20, null);
     
     tempArray = new ArrayList<Integer>();
     result = true;
     
     tempArray = isBST(head, tempArray);
     System.out.println("Array representation of tree [InOrder Traversal] {2, 4, 5, 8, 10, 20}");
     
     for(int a = 0; a < tempArray.size() - 1; a++){
        if(tempArray.get(a) > tempArray.get(a+1)){
           result = false;
           a = tempArray.size();
        }
     }
     if(!result){
        System.out.println("This is not a Binary Search Tree");
     }
     else{
        System.out.println("This is a Binary Search Tree");
     }
  }//end of method




}//end of class