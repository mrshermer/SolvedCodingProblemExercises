import java.util.*;

public class CountingBits{
   public static void main(String[] args){
       countBits(3);
   }
    public static int[] countBits(int n) {
        int[] array = new int[n+1];
        ArrayList<Integer> numberToChooseFrom = new ArrayList<Integer>();
        numberToChooseFrom.add(1);
        //numberToChooseFrom.add(2);
        
        int powerCounter = 2;
        
            for(int a = 0; a < n+1; a++){
                if(a == 0){
                    array[a] = 0;
                }
                else if(a == 1){
                    array[a] = 1;
                }
                else if(a == powerCounter){
                    numberToChooseFrom.add(powerCounter);
                    array[a] = 1;
                    powerCounter *= 2;
                }
                else{
                    int sum = a - numberToChooseFrom.get(numberToChooseFrom.size() - 1);
                
                    array[a] = array[numberToChooseFrom.get(numberToChooseFrom.size() - 1)] + array[sum];
                }
            }
        
        return array;
    }

}