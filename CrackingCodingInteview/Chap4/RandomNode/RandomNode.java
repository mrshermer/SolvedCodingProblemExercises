import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNode{
   private class Node{
      Node left, right;
      int data;
      
      public Node (Node l, int d, Node r){
        this.left = l;
        this.data = d;
        this.right = r;      
      }
   }   
   private Node insertNode(Node newNode, Node head, Node headPointer){
      if(head == null){
         head = newNode;
      }
      
      else if(head.left == null){
         head.left = newNode;
      }
      else if(head.right == null){
         head.right = newNode;
      }
      if(headPointer != null){
        head = headPointer;
      }
      
      return head;
   }
   private int getMaxLevel(Node head, int level){
       if(head == null){
          return level;
       }
       level++;
       level = getMaxLevel(head.left, level);
       
       return level;
   }
   private int countNodes(Node head, int tempCount, int count, int maxLevel){
      if(head == null){
         return count;
      }
      if(head.left == null && tempCount == maxLevel){
         count++;
      }
      else if(head.right == null && tempCount == maxLevel){
         count++;
      }
      count = countNodes(head.left, tempCount+1, count, maxLevel);
      count = countNodes(head.right, tempCount+1, count, maxLevel);
      
      return count;
   }
   private Node goFarLeft(Node head){
      if(head.left == null){
         return head;
      }
      head = goFarLeft(head.left);
      return head;
   }
   private Node placePointerNode(Node head, Node pN, Node permHeadMarker, int count, int maxLevel){
       if(head == null){
          return pN;
       }
       if(head.left == null && count != maxLevel){
          if(pN == permHeadMarker){
               pN = head;
          }     
       }
       else if(head.right == null && count != maxLevel){
          //if(pN == null){
             pN = head;
          //}
       }
       pN = placePointerNode(head.left, pN, permHeadMarker, count+1, maxLevel);
       pN = placePointerNode(head.right, pN, permHeadMarker, count+1, maxLevel);
       return pN;
       
   }
   
   private Node constructTree(Node head, int data){
            
      int maxLevel = getMaxLevel(head, -1);
      int nodeCount = 0;
      nodeCount = countNodes(head, 0, nodeCount, maxLevel);
      Node newNode = new Node(null, data, null);
      Node temp = head;
      Node permHeadMarker = head;
      
      if(nodeCount == Math.pow(2,maxLevel)){
         head = goFarLeft(head);
      }
      else{
         head = placePointerNode(head, temp, permHeadMarker, 0, maxLevel);  
      }
      head = insertNode(newNode, head, temp);
      
      return head;
   }
   private boolean find(Node head, boolean result, int data){
      if(head == null){
        return result;
      }
      if(head.data == data){
         result = true;
      }
      result = find(head.left, result, data);
      result = find(head.right, result, data);
      return result;
   }
   private Node findNodeToDelete(Node temp, Node nodeToDelete, Node pmH, int data){
      if(temp == null){
         return nodeToDelete;
      }
      if(nodeToDelete == pmH && temp.data == data){
         nodeToDelete = temp;
      }
      nodeToDelete = findNodeToDelete(temp.right, nodeToDelete, pmH, data);   
      nodeToDelete = findNodeToDelete(temp.left, nodeToDelete, pmH,  data);
      return nodeToDelete;
   }
   private Node pointCurrentNode(Node pHM,  Node cur, int hData, int nC, int maxLevel){
      if(pHM == null){
         return cur;
      }
      if(nC == maxLevel && cur.data == hData){
         cur = pHM;
      }
      cur = pointCurrentNode(pHM.right, cur, hData, nC + 1, maxLevel);
      cur = pointCurrentNode(pHM.left,  cur, hData, nC + 1, maxLevel);
      return cur;
   }
   private boolean deleteNode(Node prev, Node nodeToDelete, Node cur, boolean nodeDeleted){
      if(prev == null){
         return nodeDeleted;
      }
      
      if(prev.left != null && !nodeDeleted && prev.left.data == cur.data){
         nodeToDelete.data = cur.data;
         prev.left = null;
         nodeDeleted = true;
      }
      else if(prev.right != null && !nodeDeleted && prev.right.data == cur.data){
         nodeToDelete.data = cur.data;
         prev.right = null;
         nodeDeleted = true;
      }
      nodeDeleted = deleteNode(prev.right, nodeToDelete, cur, nodeDeleted);
      nodeDeleted = deleteNode(prev.left,  nodeToDelete, cur, nodeDeleted);
      return nodeDeleted;
   }
   private List<Integer> preOrderTraversalTree(Node head, List<Integer> nodesInTree){
      if(head == null){
         return nodesInTree;
      }
      nodesInTree = preOrderTraversalTree(head.left, nodesInTree);
      nodesInTree.add(head.data);
      nodesInTree = preOrderTraversalTree(head.right, nodesInTree);
      
      return nodesInTree;
   }
   public void mainDriverMethod(){
      Node temp = null;
      boolean result = false;
      
      //////////////////////////////
      // inserting into binary tree
      
      temp = constructTree(temp, 78);
      temp = constructTree(temp, 89);
      temp = constructTree(temp, 8);
      temp = constructTree(temp, 1);
      temp = constructTree(temp, 3);
      temp = constructTree(temp, 9);
      temp = constructTree(temp, 100);
      temp = constructTree(temp, 2);
      temp = constructTree(temp, 45);
      temp = constructTree(temp, 24);
      temp = constructTree(temp, 124);
      temp = constructTree(temp, 12);
      temp = constructTree(temp, 345);
      temp = constructTree(temp, 1233);
      
      /////////////////////////////////////
      //finding value in binary tree
      result = find(temp, result, 78);      
      System.out.println("Value [78] exists in tree: " + result);
      
      result = false;
      result = find(temp, result, 101);
      System.out.println("Value [101] exists in tree: " + result);
      
      ////////////////////////////////////
      // deletionOfNode
      
      Node nodeToDelete = temp;
      Node permantHeadMarker = temp;
      Node prev = temp, cur = temp;
      int maxLevel = getMaxLevel(temp, -1);
      int nodeCount = 0;
      boolean nodeDelete = false;
      
      nodeToDelete = findNodeToDelete(temp, nodeToDelete, permantHeadMarker, 89);
      
      cur = pointCurrentNode(permantHeadMarker, cur, cur.data, nodeCount, maxLevel);
      
      nodeDelete = deleteNode(prev, nodeToDelete, cur, nodeDelete);
      
      //deleting 1
      
      permantHeadMarker = temp;
      prev = temp; cur = temp; nodeToDelete = temp;
      nodeDelete = false;
      
      nodeToDelete = findNodeToDelete(temp, nodeToDelete, permantHeadMarker, 1);
      
      cur = pointCurrentNode(permantHeadMarker, cur, cur.data, nodeCount, maxLevel);
      
      nodeDelete = deleteNode(prev, nodeToDelete, cur, nodeDelete);
      
      //deleting 2
      
      permantHeadMarker = temp;
      prev = temp; cur = temp; nodeToDelete = temp;
      nodeDelete = false;
      
      nodeToDelete = findNodeToDelete(temp, nodeToDelete, permantHeadMarker, 2);
      
      cur = pointCurrentNode(permantHeadMarker, cur, cur.data, nodeCount, maxLevel);
      
      nodeDelete = deleteNode(prev, nodeToDelete, cur, nodeDelete);


      //Pick random Node
      
      permantHeadMarker = temp;
      List<Integer> nodesInTree = new ArrayList<Integer>();
      
      nodesInTree = preOrderTraversalTree(permantHeadMarker, nodesInTree);
      
      Random rand = new Random();
      
      int randomNode = rand.nextInt(nodesInTree.size()) + 1;
      
      System.out.println("Random Node picked: " + nodesInTree.get(randomNode));
   }
   
}