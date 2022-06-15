public class ConvertBinary{
   private class Node{
       int val;
       Node next;
       public Node() {}
       public Node(int val) { this.val = val; }
       public Node(int val, Node next) { this.val = val; this.next = next; }
   
   }
   public Node head;
   
   public void add(int data){
      Node newNode = new Node(data, null);
      
      
      if(head == null){
         head = newNode;
      }
      else{
         Node cur = head;
         
         while(cur.next != null){
            cur = cur.next;
         }
         cur.next = newNode;
      }
      
   }
   
   public int getDecimalValue(Node head) {
        Node curr = head;
        int count = 0;
      
      while(curr != null){
         count++;
         curr = curr.next;
      }
        
        
        int finalSum = 0, listSize = count; 
        listSize--;
        int size = listSize;
        Node cur = head;
        
        if(cur.val == 1){
            int c = (int)Math.pow(2, listSize);
            finalSum +=c;
        }
        cur = cur.next;
        
        while(cur != null){
             listSize--;
            if(cur.val == 1){
               int c = (int)Math.pow(2, listSize);
               finalSum += c;
            }
           
            
            cur = cur.next;
        }
        return finalSum;   
    }
    public Node getHead(){
       return head;
    }
 }