public class CheckBalanced{
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
  
  private int countLeftTree(Node head, Node stayLeft, int count){
     if(head == null){
        return count;
     }
     if(head.left != null && head.right != null){
        count++;
     }
     else if(head.left != null && head.right == null){
        count++;
     }
     else if(head.left == null && head.right != null){
        count++;
     }
     count = countLeftTree(head.left, stayLeft, count);
     
     if(head != stayLeft){
       count = countLeftTree(head.right, stayLeft, count);
     }
     return count;
  }
  private int countRightTree(Node head, Node stayRight, int count){
     if(head == null){
        return count;
     }
     if(head.left != null && head.right != null){
        count++;
     }
     else if(head.left != null && head.right == null){
        count++;
     }
     else if(head.left == null && head.right != null){
        count++;
     }
     count = countRightTree(head.right, stayRight, count);
     if(head != stayRight){
        count = countRightTree(head.left, stayRight, count);
     }
     
     
     return count;
  }
  
  public void isTreeBalanced(){
     System.out.println("Tree Example 1 - [Array Format]:  [1, 2, 4]");
     head = new Node(null, 1, null);
     head.left = new Node(null, 2, null);
     head.right = new Node(null, 4, null);
     
     Node stayHead = head;
     
     int leftHeight = countLeftTree(head, stayHead, 0);
     int rightHeight = countRightTree(head, stayHead, 0);
     
     if(leftHeight - rightHeight <= 1){
        System.out.println("This is a balanced tree");
     }
     else{
        System.out.println("This is not a balanced tree");
     }
     System.out.println();
     
     System.out.println("Tree Example 2 - [Array Format]:  [1, 2, 4, 6]");
     head = new Node(null, 1, null);
     head.left = new Node(null, 2, null);
     head.right = new Node(null, 4, null);
     head.left.left = new Node(null, 6, null);
     stayHead = head;
     
     leftHeight = countLeftTree(head, stayHead, 0);
     rightHeight = countRightTree(head, stayHead, 0);
     
     if(leftHeight - rightHeight <= 1){
        System.out.println("This is a balanced tree");
     }
     else{
        System.out.println("This is not a balanced tree");
     }
     
     System.out.println();
     
     System.out.println("Tree Example 3 - [Array Format]:  [1, 2, 4, 6, 7]");
     head = new Node(null, 1, null);
     head.left = new Node(null, 2, null);
     head.right = new Node(null, 4, null);
     head.left.left = new Node(null, 6, null);
     head.right.right = new Node(null, 7, null);
     stayHead = head;
     
     leftHeight = countLeftTree(head, stayHead, 0);
     rightHeight = countRightTree(head, stayHead, 0);
     
     if(leftHeight - rightHeight <= 1){
        System.out.println("This is a balanced tree");
     }
     else{
        System.out.println("This is not a balanced tree");
     }
     
     System.out.println();
     
     System.out.println("Tree Example 4 - [Array Format]:  [1, 2, 4, 6, 7, 9]");
     head = new Node(null, 1, null);
     head.left = new Node(null, 2, null);
     head.right = new Node(null, 4, null);
     head.left.left = new Node(null, 6, null);
     head.right.right = new Node(null, 7, null);
     head.left.left.right = new Node(null, 9, null);
     stayHead = head;
     
     leftHeight = countLeftTree(head, stayHead, 0);
     rightHeight = countRightTree(head, stayHead, 0);
     
     if(leftHeight - rightHeight <= 1){
        System.out.println("This is a balanced tree");
     }
     else{
        System.out.println("This is not a balanced tree");
     }

     System.out.println();
     
     System.out.println("Tree Example 5 - [Array Format]:  [1, 2, 4, 6, 7, 9, 10, 11]");
     head = new Node(null, 1, null);
     head.left = new Node(null, 2, null);
     head.right = new Node(null, 4, null);
     head.left.left = new Node(null, 6, null);
     head.right.right = new Node(null, 7, null);
     head.left.left.right = new Node(null, 9, null);
     head.left.left.left = new Node(null, 10, null);
     head.left.left.left.left = new Node(null, 11, null);
     
     
     stayHead = head;
     
     leftHeight = countLeftTree(head, stayHead, 0);
     rightHeight = countRightTree(head, stayHead, 0);
     
     if(leftHeight - rightHeight <= 1){
        System.out.println("This is a balanced tree");
     }
     else{
        System.out.println("This is not a balanced tree");
     }
  }

}