import java.lang.StringBuilder;

public class FirstCommonAncestor
{
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
  
  private StringBuilder pathOfP(Node head, StringBuilder p, String targetP){
    if(head == null){
       return p;
    }
    if(head.data == Integer.parseInt(targetP)){
       p.insert(0, head.data + " ");
    }
    if(!p.toString().contains(String.valueOf(targetP))){
      p = pathOfP(head.left, p, targetP);
    }
    if(!p.toString().contains(String.valueOf(targetP))){
      p = pathOfP(head.right, p, targetP);
    }
    if(p.toString().contains(targetP) && !p.toString().contains(String.valueOf(head.data)))
    {
       p.insert(0, head.data + " ");
    }

    return p;
  }
   private StringBuilder pathOfQ(Node head, StringBuilder q, String targetQ){
     if(head == null){
       return q;
    }
    if(head.data == Integer.parseInt(targetQ)){
       q.insert(0, head.data + " ");
    }
    if(!q.toString().contains(String.valueOf(targetQ))){
       q = pathOfQ(head.left, q, targetQ);
    }  
    if(!q.toString().contains(String.valueOf(targetQ))){
      q = pathOfQ(head.right, q, targetQ);
    }
    if(q.toString().contains(targetQ) && !q.toString().contains(String.valueOf(head.data)))
    {
       q.insert(0, head.data + " ");
    }

    return q;

   }
  
  public void firstCommonAncestor(int p, int q){
     StringBuilder pathStringP = new StringBuilder("");
     StringBuilder pathStringQ = new StringBuilder("");
     
     Node tracker = head;
     String targetP = String.valueOf(p);
     String targetQ = String.valueOf(q);
     String ancestor = "";
     
     head = new Node(null, 3, null);
     head.left = new Node(null, 5, null);
     head.right = new Node(null, 1, null);
     head.left.left = new Node(null, 6, null);
     head.left.right = new Node(null, 2, null);
     head.left.right.left = new Node(null, 7, null);
     head.left.right.right = new Node(null, 4, null);
     head.right.left = new Node(null, 0, null);
     head.right.right = new Node(null, 8, null);
     
     pathStringP = pathOfP(head, pathStringP, targetP);
     pathStringQ = pathOfQ(head, pathStringQ, targetQ);
     
     for(String node: pathStringP.toString().split(" ")){
        if(pathStringQ.toString().contains(node)){
           ancestor = node;
        }
     }
     System.out.println("First common ancestor is: " + ancestor);
  }
  





}