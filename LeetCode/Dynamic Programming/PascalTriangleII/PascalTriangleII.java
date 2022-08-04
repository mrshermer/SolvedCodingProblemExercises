import java.util.List;
import java.util.ArrayList;

public class PascalTriangleII{
   public static void main(String[] args){
      List<Integer> result = getRow(1000);
   }
   public static List<Integer> getRow(int rowIndex) {
       List<List<Integer>> finalList = new ArrayList<List<Integer>>();
       List<Integer> tempList = new ArrayList<Integer>();
       
       tempList.add(1);
       finalList.add(tempList);
       tempList = new ArrayList<Integer>();
       tempList.add(1);
       tempList.add(1);
       finalList.add(tempList);
       tempList = new ArrayList<Integer>();
       
              
       for(int a = 2; a < (rowIndex + 1); a++){
          
          ArrayList<Integer> prevList = (ArrayList<Integer>)finalList.get(a-1);
          tempList.add(1);
          
          for(int b = 0; b < prevList.size() - 1; b++){
             int sum = prevList.get(b) + prevList.get(b+1);
             tempList.add(sum);
          }
          tempList.add(1);
          finalList.add(tempList);
          tempList = new ArrayList<Integer>();
       }
       
       return finalList.get(rowIndex); 
   }
}