public class CreateBinaryTree{
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
  public Node head;
  
  public void createTree(int data){
     Node temp = head;
     Node placeHolder = head;
   
     Node newNode = new Node(null,data,null);
     int maxLevel = getMaxLevel(temp, 0);
     
     int leafNodes = countLeafNodes(temp, 0, 0, maxLevel);
     
     if(leafNodes == Math.pow(2, maxLevel) && temp != null){
        placeHolder = goFarLeft(temp, placeHolder);
     }
     else{
        placeHolder = placeNodeMarker(temp, placeHolder, 0, maxLevel);
     }       
     
     head = addAttachNode(placeHolder, newNode);
  }
  
  public Node addAttachNode(Node placeHolder, Node newNode){
     if(placeHolder == null){
         return newNode;
     }
     if(placeHolder.left == null){
        placeHolder.left = addAttachNode(placeHolder.left, newNode);
     }
     else if(placeHolder.right == null){
        placeHolder.right = addAttachNode(placeHolder.right, newNode);
     }
     placeHolder = head;
     return head;
  }
  public int getMaxLevel(Node head, int count){
     if(head == null){
        return count;
     }
     if(head.left != null){
        count++;
     }     
     count = getMaxLevel(head.left, count);
     return count;
  }
  public int countLeafNodes(Node head, int localLevelCount, int leafNodeCount, int maxLevel){
     if(head == null){
        return leafNodeCount;
     }
     if(head.left == null && head.right == null && localLevelCount == maxLevel){
        leafNodeCount++;
     }
     leafNodeCount = countLeafNodes(head.left, localLevelCount+1, leafNodeCount, maxLevel);
     leafNodeCount = countLeafNodes(head.right, localLevelCount+1, leafNodeCount, maxLevel);
     
     return leafNodeCount;
  }
  public Node goFarLeft(Node head, Node placeHolder){
     if(head == null){
        return placeHolder;
     }
     if(head.left == null && head.right == null){
        placeHolder = head;
     }
     
     placeHolder = goFarLeft(head.left, placeHolder);
     return placeHolder;
  }
  public Node placeNodeMarker(Node head, Node placeHolder, int localLevelCount, int maxLevel){
     if(head == null){
       return placeHolder;
     }
     if(head.left != null && head.right == null && localLevelCount < maxLevel){
        placeHolder = head;
     }
     else if(head.left == null && head.right == null && localLevelCount < maxLevel){
        if(placeHolder.right != null){
           placeHolder = head;
        }
     }
     placeHolder = placeNodeMarker(head.left, placeHolder, localLevelCount+1, maxLevel);
     placeHolder = placeNodeMarker(head.right, placeHolder, localLevelCount+1, maxLevel);
     return placeHolder;
  }

}