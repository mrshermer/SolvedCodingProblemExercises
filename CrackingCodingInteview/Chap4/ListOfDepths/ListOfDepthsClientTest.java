import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepthsClientTest{
  public static void main(String[] args){
     ListOfDepths chap4 = new ListOfDepths();
     chap4.createTree(4);
     chap4.createTree(56);
     chap4.createTree(90);
     chap4.createTree(100);
     chap4.createTree(101);
     chap4.createTree(8);
     ArrayList<LinkedList> depths = chap4.mainFunctionListOfDepths();
     for(int i = 0; i < depths.size(); i++){
        System.out.println("LinkedList: " + i);
        LinkedList list = depths.get(i);
        System.out.print("[");
        
        for(int j = 0; j < list.size(); j++){
           if(j == list.size() - 1){
              System.out.print(list.get(j));
           }
           else{
              System.out.print(list.get(j) + ", ");
           }
           
        }
        System.out.print("]\n");
     }
     
  }
 

  
}