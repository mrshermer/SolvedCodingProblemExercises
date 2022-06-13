public class RemoveVowelsFromString {
  public  static void main(String[] args){
       removeVowels("welcome to geeksforgeeks");
    }
    
  public  static String removeVowels(String S) {
        StringBuilder build = new StringBuilder("");
        
        for(int a = 0; a < S.length(); a++){
            char c = S.charAt(a);
            if(c!= 'a' && c != 'e' && c != 'i' 
            && c!= 'o' && c != 'u'){
                build.append(S.charAt(a));
            }
        }
        
        return build.toString();
    }
}