public class DecodingIPAddress{
   public static void main(String[] args){
      StringBuilder build = new StringBuilder("1.1.1.1");
      System.out.println(defangIPaddr(build.toString()));
   }
   public static String defangIPaddr(String address) {
        StringBuilder build = new StringBuilder(address);
        int inrement = 0;
        
        for(int a = 0; a < address.length(); a++){
            if(address.charAt(a) == '.'){
                build.insert(a + inrement, '[');
                build.insert(a + (2 +inrement) , ']');
                inrement+=2;
            }
        }
        return build.toString();
    }

}