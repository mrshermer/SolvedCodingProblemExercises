public class MiddleOfLinkedList{
   private class Node{
      private int data;
      Node next;
      
      public Node(int d, Node n){
         this.data = d;
         this.next = n;
      }
   }
   public Node head;
      
      
   public void addNode(int data){
    
      
     if(head == null){
         head = new Node(data, null);;
     }
     else{
         Node cur = head;
         
         while(cur.next != null){
            cur = cur.next;
         }
         cur.next = new Node(data, null);
     }
   } 
   public Node middleNode(Node head) {
      Node cur = head;
      int length = 0;
      
      while(cur != null){
         length++;
         cur = cur.next;
      }
      int middle = length/2;
      cur = head;
      
      for(int a = 0; a < middle; a++){
         cur = cur.next;
      }
      return cur;  
   }
   public void printResult(){
      head = middleNode(head);
      
      while(head != null){
         System.out.print(head.data + " ");
         head = head.next;
      }
   }
 

}