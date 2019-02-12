/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class Open {
   public Open(){
      JFileChooser c=new JFileChooser();
        c.showOpenDialog(null);  
    }
    public static void main(String args[]){
        new Open();
    }
}
