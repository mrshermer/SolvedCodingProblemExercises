public class DivisorGame{
  public static void main(String[] args){
     divisorGame(4);
     
     
  }
  public static boolean divisorGame(int n) {
     boolean aliceWon = false;
     
       while(n != 1){
         int div = 1;
         n = n - div;
         
         if(!aliceWon){
            aliceWon = true;
         }
         else{
            aliceWon = false; 
         }
     }
     return aliceWon;
  }
  
}//end of class  

    