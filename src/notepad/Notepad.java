/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.Desktop;
import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import textfiles.WriteFile;
//import java.awt.print.*;
/**
 *
 * @author SejalGupta
 */
public class Notepad implements ActionListener//,Printable
{
    JMenuBar mb;JMenu file,edit,view,help,format;JFrame f;JTextArea area;  
    JMenuItem x1,x2,x3,x4,x5,x6,x7;
    JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;
    JMenuItem v1;
    JMenuItem h1,h2;
    JMenuItem f1,f2;
    Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
    void setAction(){
        x1.addActionListener(this);
        x2.addActionListener(this);
        x3.addActionListener(this);
        x4.addActionListener(this);
        x5.addActionListener(this);
        x6.addActionListener(this);
        x7.addActionListener(this);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        m5.addActionListener(this);
        m6.addActionListener(this);
        m7.addActionListener(this);
        m8.addActionListener(this);
        h1.addActionListener(this);
        h2.addActionListener(this);
        f1.addActionListener(this);
        m9.addActionListener(this);
        m10.addActionListener(this);
        v1.addActionListener(this);
    }
    /*private void update(){
        if(area.getSelectedText()!= null)
            System.out.println("Selected ")
    }*/
public Notepad(){
    f=new JFrame("Untitled-Notepad");
    JPanel p=new JPanel();
    mb=new JMenuBar();
    file=new JMenu("File");
    edit=new JMenu("Edit");
    format=new JMenu("Format");
    view =new JMenu("View");
    help=new JMenu("Help");
    f.add(new JScrollPane(area));
    area=new JTextArea("");
    h1=new JMenuItem("Help");
    h2=new JMenuItem("About Notepad");
    help.add(h1);
    help.add(h2);
    f1=new JMenuItem("Word Wrap");
    f2=new JMenuItem("Font");
    format.add(f1);
    
    format.add(f2);
    m1=new JMenuItem("Undo ");
    m1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z,
            java.awt.Event.CTRL_MASK)); 
    m2=new JMenuItem("Copy ");
    m2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,
            java.awt.Event.CTRL_MASK));
    m3=new JMenuItem("Paste ");
    m3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V,
            java.awt.Event.CTRL_MASK));
    m4=new JMenuItem("Cut ");
    m4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X,
            java.awt.Event.CTRL_MASK));
    m5=new JMenuItem("Delete ");
    m5.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE,
            java.awt.Event.CTRL_MASK));
    m6=new JMenuItem("Find ");
    m6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F,
            java.awt.Event.CTRL_MASK));
    m7=new JMenuItem("Find Next ");
    m7.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3,
            java.awt.Event.SHIFT_MASK));
    m8=new JMenuItem("Replace ");
    m8.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H,
            java.awt.Event.CTRL_MASK));
    m9=new JMenuItem("Go To ");
    m4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G,
            java.awt.Event.CTRL_MASK));
    m10=new JMenuItem("Time ");
    edit.add(m1);edit.add(m2);
    edit.add(m3);
    edit.add(m4);edit.add(m5);edit.addSeparator();
    edit.add(m6);edit.add(m7);edit.add(m8);edit.add(m9);edit.add(m10);
    
    
    
    v1=new JMenuItem("Status Bar");
    x1=new JMenuItem("New ");
    x1.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,
                                           java.awt.Event.CTRL_MASK));
    x2=new JMenuItem("Open ");
    x2.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,
                                           java.awt.Event.CTRL_MASK));
    x3=new JMenuItem("Save ");
    x3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
                                           java.awt.Event.CTRL_MASK));
    x4=new JMenuItem("Save As");
    x5=new JMenuItem("Page Setup");
    x6=new JMenuItem("Print ");
    x6.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P,
                                           java.awt.Event.CTRL_MASK));
    x7=new JMenuItem("Exit");
    file.add(x1);
    view.add(v1);
    file.add(x2);
    file.add(x3);
    file.add(x4);file.addSeparator();
    file.add(x5);file.add(x6);file.add(x7); 
    mb.add(file);
    mb.add(edit);
    mb.add(view);
    mb.add(format);
    mb.add(help);
    setAction();
    f.setJMenuBar(mb);
    area.setBounds(0,0,750,750);
    f.getContentPane().setLayout(new FlowLayout());
    JScrollPane scroll=new JScrollPane(area);
    f.add(area);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    f.setSize(750,750);
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(scroll);
    
}
String foldername,filename;
    @Override
    public void actionPerformed(ActionEvent eve){
    if(eve.getSource()==x7)
        System.exit(0);
    else if(eve.getSource()==x1)
        new Notepad();
    else if(eve.getSource()==x2)
            new Open();
    else if(eve.getSource()==x4)
    {
        JFileChooser chooser=new JFileChooser("C:\\Users\\Default\\Documents\\Notepad");
        chooser.setDialogTitle("Save As");
        int rval= chooser.showSaveDialog(null);
            //if(rval==javax.swing.JFileChooser.APPROVE_OPTION){
        filename=chooser.getSelectedFile().getName();
        f.setTitle(filename);
    }
    else if(eve.getSource()==x3){
    JFileChooser jf=new JFileChooser("C:\\Users\\Default\\Documents");
        int rval= jf.showSaveDialog(null);
       // if(rval==JFileChooser.APPROVE_OPTION)
        //{
            File file=jf.getSelectedFile();
            filename=file.getName();
            System.out.println(filename);
            f.setTitle(filename);  
            try{
            FileWriter wr=new FileWriter(filename, true);
            FileReader r=new FileReader(filename);
            
            BufferedReader br=new BufferedReader(r);
            String line;
            while((line=br.readLine())!=null){
                wr.write(line);
            }
           }
        catch(IOException e){
            e.printStackTrace();
        }
        //}
    }
        
    else if(eve.getSource()==x5);
    else if(eve.getSource()==h1){
        
                }
    else if(eve.getSource()==h2){
        new About();
    }
    else if(eve.getSource()==x6);
    else if(eve.getSource()==m1);
    else if(eve.getSource()==m2)
    {  //COPY
       StringSelection jtf= new StringSelection(area.getSelectedText());
        
        cb.setContents(jtf,jtf);
    }
    else if(eve.getSource()==m3){
        //PASTE
        
        Transferable clipData=cb.getContents(this);
        try{
            String clipString=(String)clipData.getTransferData(DataFlavor.stringFlavor);
            area.replaceRange(clipString,area.getSelectionStart(),area.getSelectionEnd());
        }
        catch(Exception e){
            System.err.println("Not Working");
        }
        }
    else if(eve.getSource()==m4){
        //CUT
       try{ 
       StringSelection jtf=new StringSelection(area.getSelectedText());
       cb.setContents(jtf,jtf); 
       area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());
        }
       catch(Exception e){
           System.err.println("Not Working");
       }
    }
    
    else if(eve.getSource()==m5){
        //StringSelection jtf=new StringSelection(area.getSelectedText());
        area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
    }
    else if(eve.getSource()==m6);
    
}
   

    
    public static void main(String[] args) {
              new Notepad();
    }

    private String getCurrentDirectory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

    
    

