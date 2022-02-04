import java.util.List;
import java.util.ArrayList;

public class BSTSequence{
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
  
  public void BSTSeq(){
     System.out.println("Sample Tree: [10, 5, 20] \n");
  
     List<Integer> subtree5 = new ArrayList<Integer>();
     subtree5.add(5);
     List<Integer> subtree20 = new ArrayList<Integer>();
     subtree20.add(20);
     List<Integer> results = new ArrayList<Integer>();
     int rootNode = 10;
     
     validateBSTSeq(results, subtree5, subtree20, rootNode);
  }
  public void validateBSTSeq(List<Integer> res, List<Integer> subtree5, List<Integer> subtree20, int rootNode){
     if(subtree5.size() == 0 || subtree20.size() == 0){
        System.out.print("[ " + rootNode + " ");
        if(subtree5.size() == 0){
           for(int a = 0; a < res.size(); a++){
               System.out.print(res.get(a) + " ");
           }
           for(int a = 0; a < subtree20.size(); a++){
               System.out.print(subtree20.get(a) + " ");
           }
           
        }
        else{
           for(int a = 0; a < res.size(); a++){
               System.out.print(res.get(a) + " ");
           }
           for(int a = 0; a < subtree5.size(); a++){
               System.out.print(subtree5.get(a) + " ");
           }

        }
        System.out.println("]");        
        return;
     }
     int firstNum = subtree5.remove(0);
     res.add(firstNum);
     validateBSTSeq(res, subtree5, subtree20, rootNode);
     subtree5.add(0, res.remove(0));
     
     int secondNumber = subtree20.remove(0);
     res.add(secondNumber);
     validateBSTSeq(res, subtree5, subtree20, rootNode);
     subtree20.add(0, res.remove(0));
  }

}