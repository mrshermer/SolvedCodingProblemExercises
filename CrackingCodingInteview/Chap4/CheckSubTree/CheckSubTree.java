import java.util.List;
import java.util.ArrayList;

public class CheckSubTree{
   private class Node{
      int data;
      Node left;
      Node right;
      
      public Node(Node left, int data, Node right){
        this.left = left;
        this.data = data;
        this.right = right;   
         
      }
   }
   Node headSubtree1;
   Node headSubtree2;
   
   public void startProcess(){
     System.out.println("Example 1:");
     System.out.println("Tree 1: [4, 0, 78]");
     headSubtree1 = new Node(null, 4, null);
     headSubtree1.left = new Node(null, 0, null);
     headSubtree1.right = new Node(null, 78, null);
     
     System.out.println("Tree 2: [4, -9, 78]");
     headSubtree2 = new Node(null, 4, null);
     headSubtree2.left = new Node(null, -9, null);
     headSubtree2.right = new Node(null, 78, null);
     
   
     List<Integer> subtree2 = new ArrayList<Integer>();
     List<Integer> subtree1 = new ArrayList<Integer>();
     boolean result = true;
     
     subtree2 = buildSubTree(subtree2, headSubtree2);
     subtree1 = buildSubTree(subtree1, headSubtree1);
     
     result = isTreeTwoSubTreeOne(subtree1, subtree2, 1, 2);
     
     if(result){
        System.out.println("Example 1: Tree2 is a subtree is of Tree 1");
     }
     else{
        System.out.println("Example 1: Tree2 is not a subtree is of Tree 1");
     }
     
     System.out.println();
     System.out.println("Example 2:");
     System.out.println("Tree 1 [68, 69, 74, 77, 79, 80, 81, 91, 92]");
     headSubtree1 = new Node(null, 77, null);
     headSubtree1.left = new Node(null, 69, null);
     headSubtree1.left.left = new Node(null, 68, null);
     headSubtree1.left.right = new Node(null, 74, null);
     headSubtree1.right = new Node(null, 91, null);
     headSubtree1.right.right = new Node(null, 92, null);
     headSubtree1.right.left = new Node(null, 80, null);
     headSubtree1.right.left.left = new Node(null, 79, null);
     headSubtree1.right.left.right = new Node(null, 81, null);
     
     
     
     System.out.println("Tree 2 [40, 50, 51, 77, 79, 80, 81, 91, 92]");
     headSubtree2 = new Node(null, 77, null);
     headSubtree2.left = new Node(null, 50, null);
     headSubtree2.left.left = new Node(null, 40, null);
     headSubtree2.left.right = new Node(null, 51, null); 
     headSubtree2.right = new Node(null, 91, null);
     headSubtree2.right.right = new Node(null, 92, null);
     headSubtree2.right.left = new Node(null, 80, null);
     headSubtree2.right.left.left = new Node(null, 79, null);
     headSubtree2.right.left.right = new Node(null, 81, null);

     subtree2 = new ArrayList<Integer>();
     subtree1 = new ArrayList<Integer>();
     result = true;
     
     subtree2 = buildSubTree(subtree2, headSubtree2);
     subtree1 = buildSubTree(subtree1, headSubtree1);
     
     result = isTreeTwoSubTreeOne(subtree1, subtree2, 3, 8);
     
     if(result){
        System.out.println("Example 2: Tree2 is a subtree is of Tree 1");
     }
     else{
        System.out.println("Example 2: Tree2 is not a subtree is of Tree 1");
     }
     /////////////////////////////////////////////////
     
     System.out.println();
     System.out.println("Example 3: ");
     
     System.out.println("Tree 1 [68, 69, 74, 77, 79, 80, 81, 91, 92]");
     headSubtree1 = new Node(null, 77, null);
     headSubtree1.left = new Node(null, 69, null);
     headSubtree1.left.left = new Node(null, 68, null);
     headSubtree1.left.right = new Node(null, 74, null);
     headSubtree1.right = new Node(null, 91, null);
     headSubtree1.right.right = new Node(null, 92, null);
     headSubtree1.right.left = new Node(null, 80, null);
     headSubtree1.right.left.left = new Node(null, 79, null);
     headSubtree1.right.left.right = new Node(null, 81, null);
     
    
     
     System.out.println("Tree 2 [40, 50, 51, 77, 79, 80, 81, 93, 94]");
     headSubtree2 = new Node(null, 77, null);
     headSubtree2.left = new Node(null, 50, null);
     headSubtree2.left.left = new Node(null, 40, null);
     headSubtree2.left.right = new Node(null, 51, null); 
     headSubtree2.right = new Node(null, 93, null);
     headSubtree2.right.right = new Node(null, 94, null);
     headSubtree2.right.left = new Node(null, 80, null);
     headSubtree2.right.left.left = new Node(null, 79, null);
     headSubtree2.right.left.right = new Node(null, 81, null);

     subtree2 = new ArrayList<Integer>();
     subtree1 = new ArrayList<Integer>();
     result = true;
     
     subtree2 = buildSubTree(subtree2, headSubtree2);
     subtree1 = buildSubTree(subtree1, headSubtree1);
     
     result = isTreeTwoSubTreeOne(subtree1, subtree2, 3, 8);
     
     if(result){
        System.out.println("Example 3: Tree2 is a subtree is of Tree 1");
     }
     else{
        System.out.println("Example 3: Tree2 is not a subtree is of Tree 1");
     }
     
   }
   private List<Integer> buildSubTree(List<Integer> subtree2, Node head){
     if(head == null){
        return subtree2;
     }  
     buildSubTree(subtree2, head.left);
     subtree2.add(head.data);
     buildSubTree(subtree2, head.right);
     return subtree2;
   }
   private boolean isTreeTwoSubTreeOne(List<Integer> subtree1, List<Integer> subtree2, int min2, int max2){
      System.out.print("SubTree 2: SubTree [ ");
      for(int a = min2; a <= max2; a++){
         System.out.print(subtree2.get(a) + " ");   
      }
      System.out.println("] ");
      
      if(subtree2.size() > subtree1.size()){
         System.out.println("Tree 2 is not a subtree of Tree 1");
      }
      for(int a = min2; a < max2; a++){
          if(subtree2.get(a) != subtree1.get(a)){
            return false;
          }
      }
      return true;
   }

}