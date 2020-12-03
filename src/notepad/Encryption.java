/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

/**
 *
 * @author DELL
 */
public class Encryption {
    
    int key;
    public Encryption(int key){
    this.key = key;
    }   

    String encrypt(String plaintext) {
        //Applied algorithms in chaining mode 
        //to induce confusion and diffusion and 
        //decreasing security attacks.

        //substitution
        StringBuffer a = modified_caeser_cipher(plaintext,key);
        System.out.println(a);
        //transposition
        String b = railfence_cipher(a);
        System.out.println(b);
        //confusion + diffusion
        String c = vernam(b);
        return c;
    }

    private StringBuffer modified_caeser_cipher(String text,int s) {
        System.out.println("keyshift="+s);
//        s=0;
        StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) + 
                                  s - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) + 
                                  s - 97) % 26 + 97); 
                result.append(ch); 
            } 
        } 
        return result;
    }

    private String railfence_cipher(StringBuffer data) {
        
        char[] encrypted = new char[data.length()];
        int numRails = 5,n=0;
        for(int k = 0 ; k < numRails; k ++) {
        int index = k;
        boolean down = true;
        while(index < data.length() ) {
                //System.out.println(k + " " + index+ " "+ n );
                encrypted[n++] = data.charAt(index);

                if(k == 0 || k == numRails - 1) {
                        index = index + 2 * (numRails - 1);
                }
                else if(down) {
                        index = index +  2 * (numRails - k - 1);
                        down = !down;
                }
                else {
                        index = index + 2 * k;
                        down = !down;
                }
        }
    }
    return new String(encrypted);
//        return a;
        
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String vernam(String b) {
        
        String randoml = "sejalgupta";
        String randomu = "SEJALGUPTA";
        String encrypted="";
        
        for(int i=0;i<b.length();i++){
            char c = b.charAt(i);
            
            if(Character.isUpperCase(c)){
                encrypted = encrypted + (char) (c + randomu.charAt(i%10)-65);   
            }
            else{
                encrypted = encrypted + (char) ((c + randoml.charAt(i))%26 + 'a') ;
//                System.out.println("haha    " + encrypted);
            }
        }
        
        return encrypted;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
