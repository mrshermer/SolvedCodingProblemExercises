public class FinalValueofVariableAfterPerformingOperations{
   public static void main(String[] args){
     String[] array = {"--X","X++","X++"};
    
    finalValueAfterOperations(array);
   }
   public static int finalValueAfterOperations(String[] operations) {
        int count = 0;
        
        for(int a = 0; a < operations.length; a++){
             if(operations[a].equals("X++") || operations[a].equals("++X")){
                 count++;
             }
             else if(operations[a].equals("X--") || operations[a].equals("--X")){
                 count--;
             }
        }
        return count;
    }
}