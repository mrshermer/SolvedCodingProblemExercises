public class NthTribonicaNumber {
   public static void main(String[] args){
      System.out.println(tribonacci(2));
   }
   public static int tribonacci(int n) {
      int[] fib = new int[n+1];
      int sum = 0, pointer = 0;
   
      for(int a = 0; a <= n; a++){
         if(a == 0){
            fib[0] = 0;
         }
         else if(a == 1){
            fib[1] = 1;
         }
         else if(a == 2){
            fib[2] = 1;
         }
         else{
              sum += fib[pointer] + fib[pointer+1] + fib[pointer+2];
              fib[a] = sum;
              sum = 0;
              pointer++;
         }
      }//end of for
      return fib[n];
   }
}