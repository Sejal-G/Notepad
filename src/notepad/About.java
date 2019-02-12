/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;
import javax.swing.*;
/**
 *
 * @author Sejal Gupta
 */
public class About{
    JFrame f4;
    public About(){
       f4=new JFrame("Oo");
        JTextArea label=new JTextArea("It is the sole product of the owner, developed by Jim. This product can be used using a license key that the product owner will dispatch to the companies and should e ethically bought by the users/customers.");
        label.setSize(300,300);
        f4.add(label);
        f4.setLayout(null);
        f4.setSize(500,500);
        f4.setVisible(true);
    }
    public static void main(String args[])
    {
        new About();
    }
}
