public class MaxiumNumberWords 
{
   public static void main(String[] args){
      String[] array = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
      System.out.println(mostWordsFound(array));
   }
  public static int mostWordsFound(String[] sentences) {
      int tempCount = 0, finalCount = 0;
      
      for(int a = 0; a < sentences.length; a++){
         String[] split = sentences[a].split(" ");
         
         for(String word: split){
            tempCount++;
         }
         if(finalCount <= tempCount){
            finalCount = tempCount;
         }
         tempCount = 0;
      }  
        
        
      return finalCount;
  }

}