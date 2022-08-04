public class MinStairCase{
  public static void main(String[] args){
      int[] cost = {1,2,3,3};
      
      System.out.println(minCostClimbingStairs(cost));
  }
  public static int minCostClimbingStairs(int[] cost) {
       int[] minStepsArray = new int[cost.length+1];
       minStepsArray[0] = cost[0];
       minStepsArray[1] = cost[1];
       
       for(int a = 2; a <= cost.length; a++){
          if(a == cost.length){
            minStepsArray[a] += Math.min(minStepsArray[a-2], minStepsArray[a-1]);
          }
          else{
            minStepsArray[a] = cost[a] +  Math.min(minStepsArray[a-2], minStepsArray[a-1]);
          }
          
          
       }
       
       return minStepsArray[minStepsArray.length-1]; 
  }
  //1. Create an array that would calcualte the cost of the min step at each step
  //2. Fill the first two steps with index =0, index = 1
  //3. Go through each steps and calculate the min
  //4.   min = step current on + min(cost[i-1], cost[i-2])
  
  //5. When you reach the top, the last spot in the min steps array would be the min

}