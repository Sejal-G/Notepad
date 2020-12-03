/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JTextArea;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class Open {
   public Open(JTextArea area){
      JFileChooser c=new JFileChooser();
     // c.setFileFilter(new FileTypeFilter(".txt","Text File"));
      int result=c.showOpenDialog(null); 
      if(result == JFileChooser.APPROVE_OPTION){
          try{
              File fi=c.getSelectedFile();
          
          BufferedReader br=new BufferedReader(new FileReader(fi.getPath()));
          String s="";
          String line="";
          while(( br.readLine()!=null)){
              //System.out.println(s);
              line=br.readLine();
              s=s+line;
          }
          area.setText(s);
          if(br==null){
              br.close();
          }
          }
      catch(Exception e){
          JOptionPane.showMessageDialog(null,e.getMessage());
      }
      }
   }
    public static void main(String args[]){
        
        JTextArea area=new JTextArea();
        new Open(area);
    }
}
