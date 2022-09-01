public class ClimbingStairs {
   public static void main(String[] args){
       System.out.println(climbStairs(6));
   }
   public static int climbStairs(int n){
      int[] distinctSteps = new int[n+1];
      distinctSteps[0] = 1;
      distinctSteps[1] = 2; 
      
      for(int a = 2; a < n; a++){
          distinctSteps[a] = distinctSteps[a-2] + distinctSteps[a-1];
      }
      
      return distinctSteps[n-1];
   }
}