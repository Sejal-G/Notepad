/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;
import java.awt.Color;
import java.io.File;
import java.applet.Applet;
import java.awt.Graphics;
//import edu.rit.swing.FileTypeFilter;
import java.io.IOException;
import java.io.FileWriter;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import javax.swing.filechooser.FileFilter;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

//import textfiles.WriteFile;
//import java.awt.print.*;
/**
 *
 * @author SejalGupta
 */
public class Notepad implements ActionListener//,Printable
{
    JMenuBar mb;JMenu file,edit,view,help,format,code;JFrame f;JTextArea area;  
    JMenuItem x1,x2,x3,x4,x5,x6,x7;
    JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;
    JMenuItem v1;
    JMenuItem h1,h2;
    JMenuItem f1,f2,f3,f4,f5;
   
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
        m9.addActionListener(this);
        m10.addActionListener(this);
        h1.addActionListener(this);
        h2.addActionListener(this);
        f1.addActionListener(this);
        f2.addActionListener(this);
        f3.addActionListener(this);
        f4.addActionListener(this);
        f5.addActionListener(this);
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
    f3=new JMenuItem("Bold");
    f4=new JMenuItem("Italics");
    f5=new JMenuItem("Word Count");
    format.add(f1);
   
    format.add(f2);
    format.add(f3);
    format.add(f4);format.add(f5);
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
    m9.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G,
            java.awt.Event.CTRL_MASK));
    f3.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B,
            java.awt.Event.CTRL_MASK));
    f4.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I,
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
            new Open(area);
    else if(eve.getSource()==x4)
    { //SAVE AS
        JFileChooser chooser=new JFileChooser("E:\\");
        chooser.setDialogTitle("Save As");
        int rval= chooser.showSaveDialog(null);
            //if(rval==javax.swing.JFileChooser.APPROVE_OPTION){
        filename=chooser.getSelectedFile().getName();
        f.setTitle(filename);
    }
    else if(eve.getSource()==x3){
        //SAVE
    JFileChooser jf=new JFileChooser("E:\\");
        //jf.setFileFilter(new FileTypeFilter(".txt","Text File"));
        int rval= jf.showSaveDialog(null);
        if(rval==JFileChooser.APPROVE_OPTION)
        {
            String content=area.getText();
            File fi=jf.getSelectedFile();
            String us=fi.getPath();//+".txt";
            //System.out.println(fi.getPath());
            filename=fi.getName();
            String[] str=filename.split("\\.",2);
           
            //System.out.println(filename);
            f.setTitle(str[0]);  
            try{
            FileWriter fw=new FileWriter(us);
            fw.write(content);
            fw.flush();
            fw.close();
            /*FileReader r=new FileReader(filename);
           
            BufferedReader br=new BufferedReader(r);
            String line;
            while((line=br.readLine())!=null){
                wr.write(line);*/
            }
           
           
        catch(IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }
        }
    }
       
    else if(eve.getSource()==x5);
    else if(eve.getSource()==h1){
       
                }
    else if(eve.getSource()==h2){
        new About();
    }
    else if(eve.getSource()==x6){
        try{
            new Pagination();
        }
        catch(Exception e){
        }
    }
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
            System.out.println(clipString);//whether data is worth pasting or not
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
    else if(eve.getSource()==f2){
       
        //font
    }
    else if(eve.getSource()==f3){
//        String jtf=area.getSelectedText();
        String jtf= area.getSelectedText();
        area.setFont(area.getFont().deriveFont(Font.BOLD, 14f));
//        area.setFont(new Font("Tahoma", Font.BOLD, 14));
//        String(jtf, 10, 50),area.getSelectionStart(),area.getSelectionEnd());
    }//bold
   
    else if(eve.getSource()==f4){
        String jtf=area.getSelectedText();
        area.setFont(area.getFont().deriveFont(Font.ITALIC,14f));
    }//italics
   
    else if(eve.getSource()==m6){
        //find
    }
    else if(eve.getSource()==m8){
        //REPLACE
        JFrame fraw=new JFrame("Replace");
        JLabel repl,find;JTextField r,f;
        r=new JTextField("FIND");
        f=new JTextField("REPLACE");
        find=new JLabel("Find");
        repl= new JLabel("Replace");
        JButton click=new JButton("Find");
        JButton doubleclick=new JButton("Replace");
        fraw.add(doubleclick);
        fraw.add(click);
        doubleclick.setBounds(100,150,85,15);
        click.setBounds(100,120,85,15);
        find.setBounds(50,50,85,15);
        click.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jtf=area.getSelectedText();
                JDialog d=new JDialog(fraw,"WARNING",true);
                if(jtf==null){
                    fraw.add(d);
                    d.setSize(300,300);
                    d.setVisible(true);
                    d.add( new JLabel("Select before proceeding!!"));
                    System.out.println("Select before proceeding");
                }
                else
                {
                String s1=r.getText();
                System.out.println(s1);
                Highlighter.HighlightPainter painter=new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
                int offset=jtf.indexOf(s1);
                System.out.println(offset);
                int length=s1.length();
                while(offset!=-1){
                    try{
                        //area.select(offset,offset+length);
                        area.getHighlighter().addHighlight(offset,offset+length,painter);
                        offset=jtf.indexOf(s1,offset+1);
                    }
                    catch(Exception ble){System.out.println("Ya");}
                }
                }
            }
        });
        doubleclick.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jtf=area.getSelectedText();
                String s1=find.getText();
                Highlighter.HighlightPainter painter=new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
                int offset=jtf.indexOf(s1);
                int length=s1.length();
                while(offset!=-1){
                    try{
                        area.getHighlighter().addHighlight(offset,offset+length,painter);
                        offset=jtf.indexOf(s1,offset+1);
                    }
                    catch(BadLocationException ble){System.out.println("Ya");}
                }
            }
        });
        f.setBounds(140,80,85,15);
        r.setBounds(140,50,85,15);
        repl.setBounds(50,80,85,15);
        fraw.add(find);
        fraw.add(f);fraw.add(r);
        fraw.add(repl);fraw.add(repl);
        fraw.setSize(300,300);
        fraw.setLayout(null);
        fraw.setVisible(true);
    }
}
   

   
    public static void main(String[] args) {
              new Notepad();
    }

    private String getCurrentDirectory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

    
    

