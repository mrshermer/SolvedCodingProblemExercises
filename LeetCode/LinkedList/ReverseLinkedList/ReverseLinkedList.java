public class ReverseLinkedList{
   private class Node{
      private int data;
      Node next;
      
      public Node(int d, Node n){
         this.data = d;
         this.next = n;
      }
    }
    private Node head;
    
    
    
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
   public Node reverseList(Node head) {
     Node endOfList = null, addToEndList = null;
     
     if(head != null){
        endOfList = pointToEndList(head);
        addToEndList = endOfList;
     }
     Node prev = null;
     Node cur = head;
     
     
     while(head != endOfList){
        while(cur.next != endOfList){
           prev = cur;
           cur = cur.next;
        }
        if(prev == null){
                  Node newNode = new Node(cur.data, null);
                  addToEndList.next = newNode;
                  head = head.next;
                  addToEndList = addToEndList.next;
        }
        else{
                  Node newNode = new Node(cur.data, null);
                  addToEndList.next = newNode;
                  prev.next = cur.next;
                  addToEndList = addToEndList.next;
        }
 
        
        prev = null;
        cur = head;

        
     }
     
     return head;    
   }
    private Node pointToEndList(Node head){
       while(head.next != null){
          head = head.next;
       }
       return head;
    }
    
    
    public void printResult(){
      
      
      head = reverseList(head);
      
      while(head != null){
         System.out.print(head.data + " ");
         head = head.next;
      }
   }



}