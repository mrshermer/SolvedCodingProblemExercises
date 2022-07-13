import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle{
   public static void main(String[] args){
       generate(5);
   }
   public static List<List<Integer>> generate(int numRows) {
       List<List<Integer>> finalList = new ArrayList<List<Integer>>();
       List<Integer> tempList = new ArrayList<Integer>();
       
       for(int a = 1; a <= numRows; a++){
           if(a == 1){
              tempList.add(1);
              finalList.add(tempList);
           }
           else if(a == 2){
              tempList = new ArrayList<Integer>();
              tempList.add(1);
              tempList.add(1);
              finalList.add(tempList);
           }
           else{
              tempList = new ArrayList<Integer>();
              List<Integer> holder = finalList.get(a-2);
              tempList.add(1);
              
              for(int b = 0; b < holder.size() - 1; b++){
                 tempList.add(holder.get(b) + holder.get(b+1));
              }
              tempList.add(1);
              finalList.add(tempList);
           }      
       }
       
       return finalList; 
   }
}

//1. Establish a loop to place N indiviual lists in your final Lists of Lists;
     //2.Then, since you know the first two rows you can place them in your final lists of lists already
     //3. Grab the previous list, add 1 to the current list; add the sum of the previous list; then add 1 at the end
     //   add that to your final list