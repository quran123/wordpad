import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class menu1 extends JFrame implements ActionListener
{
    JMenuBar jmb;
    JMenu file ,edit,format,help,color;
    JMenuItem mnew,open,save,saveas,exit,cut,copy,paste,find,replace,font,date,wordwrap,doc;
    JMenuItem bgcolor,fgcolor,red,blue,yellow;
    JTextArea t;
    JScrollPane jsp;
    String message;
    JMenuBar jmb2;
    JDialog d1,d2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==mnew)
        {
            int n=JOptionPane.showConfirmDialog(this,"Do you save this File","Exit",JOptionPane.YES_NO_CANCEL_OPTION);
            if(n==JOptionPane.YES_OPTION)
            {
             JFileChooser jfc1=new JFileChooser();
               jfc1.setCurrentDirectory(new File("C:\\"));
               int m=jfc1.showSaveDialog(this);
             if(m==1)
             {
                 return;
             
             }
               File f2=jfc1.getSelectedFile();
               int n1=JOptionPane.showConfirmDialog(this, "Do You Really Want To Save The File");
             if(n1==JOptionPane.YES_OPTION)
             {
                 String a[]=t.getText().split("\n");
             
               Boolean b=false;
                try{
                   FileWriter fin=new FileWriter(f2);
                   BufferedWriter bin=new BufferedWriter(fin);
                   PrintWriter pout=new PrintWriter(bin);
                   
                   for(int i=0;i<a.length;i++)
                       pout.println();
                   b=true;
                   if(b==true)
                       setTitle(f2.getName()+"-Anushka's Notepad");
               }catch(Exception nfe1){
                   System.out.print(nfe1.toString());
               }
                t.setText("");
             }
             else
                 return;
              
            }
            else if(n==JOptionPane.NO_OPTION)
            {
                t.setText("");
            }
            else
            {
             return;
            }
            setTitle("Anushka's Notepad");
            
        }
        if(ae.getSource()==exit)
        {
            int n=JOptionPane.showConfirmDialog(this,"Do you want to exit","Exit",JOptionPane.YES_NO_CANCEL_OPTION);
             if(n==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
             
        }
        if(ae.getSource()==date)
        {
            Date d=new Date();
            String m=t.getText();
           t.setText(m+" "+d.toString());
        }
        if(ae.getSource()==open)
        {
            JFileChooser jfc = new JFileChooser();
            jfc.setCurrentDirectory(new File("F:\\java1\\io"));
            int n  = jfc.showOpenDialog(this);
            if(n==1)
            {return;}
            
            File f = jfc.getSelectedFile();
           //JOptionPane.showMessageDialog(this, " You have Selected :" + f.getPath());
           try{
            FileReader fin=new FileReader(f);
            BufferedReader br=new BufferedReader(fin);
            t.setText("");
            while(true)
            {
                String s=br.readLine();
                if(s==null)
                    break;
                t.append(s+"\n");
            setTitle(f.getName()+"-Anushka's Notepad");
            }
           }catch(Exception nfe)
           {
               System.out.print(nfe.toString());
               
           
           }}
           if(ae.getSource()==save)
           {
               JFileChooser jfc1=new JFileChooser();
               jfc1.setCurrentDirectory(new File("C:\\"));
               int m=jfc1.showSaveDialog(this);
             if(m==1)
             {
                 return;
             
             }
               File f2=jfc1.getSelectedFile();
               int n=JOptionPane.showConfirmDialog(this, "Do You Really Want to Save The File");
             if(n==JOptionPane.YES_OPTION)
             {
                 String a[]=t.getText().split("\n");
             
               Boolean b=false;
                try{
                   FileWriter fin=new FileWriter(f2);
                   BufferedWriter bin=new BufferedWriter(fin);
                   PrintWriter pout=new PrintWriter(bin);
                   
                   for(int i=0;i<a.length;i++)
                       pout.println();
                   b=true;
                   if(b==true)
                       setTitle(f2.getName()+"-Anushka's Notepad");
               }catch(Exception nfe1){
                   System.out.print(nfe1.toString());
               }
             }
             else
                 return;
              
           }
           
  
        if(ae.getSource()==cut)
        {
           /* String u=t.getSelectedText();
            int m=t.getSelectionStart();
            int n=t.getSelectionEnd();
            String s=t.getText();
            */
                   t.cut();
            //t.setText(u);
            //s=s-u;
            //t.setText(s);
            //t.setText(s);
        
        }
        if(ae.getSource()==copy)
        {
            t.copy();
        
        }
         if(ae.getSource()==paste)
        {
            t.paste();
        
        }
         if(ae.getSource()==find)
         {
             String a=t.getSelectedText();
             int m=t.getSelectionStart();
             int n=t.getSelectionEnd();
            t.findComponentAt(m, n);
         
         
         }
        if(ae.getSource()==bgcolor)
        {
            
            Color c1=JColorChooser.showDialog(this, "BackGround Color", Color.yellow);
            t.setBackground(c1);
                       
        }
        if(ae.getSource()==fgcolor)
        {
            Color c=JColorChooser.showDialog(this,"ForeGround Color" , Color.yellow);
        
        }
}
    
    public menu1()
    {
        t=new JTextArea();     
        jsp = new JScrollPane(t);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        jmb=new JMenuBar();
        
        file=new JMenu("File");
        edit=new JMenu("Edit");
        format=new JMenu("Format");
        help=new JMenu("Help");
        color=new JMenu("color");   
        mnew=new JMenuItem("New");
        open=new JMenuItem("Open");
        save=new JMenuItem("Save");
        saveas=new JMenuItem("SaveAs");
        exit=new JMenuItem("Exit");
        
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        find=new JMenuItem("Find");
        replace=new JMenuItem("Replace");
        
        font=new JMenuItem("Font");
  //      color=new JMenuItem("Color");
        date=new JMenuItem("Date");
        wordwrap=new JMenuItem("WordWrap");
        
        
        doc=new JMenuItem("Online Documentation");
        
        bgcolor=new JMenuItem("BgColor");
        fgcolor=new JMenuItem("FgColor");
        
        file.add(mnew);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(find);
        edit.add(replace);
        
        format.add(font);
        format.add(color);
        //format.add(fgcolor);
        format.add(date);
        format.add(wordwrap);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        help.add(doc);
        
        color.add(bgcolor);
        color.add(fgcolor);
        
        jmb.add(file);
        jmb.add(edit);
        jmb.add(format);
        jmb.add(help);
        
        this.setJMenuBar(jmb);
        
        Container c=getContentPane();
        c.add(jsp);
        setVisible(true);
        setSize(300,300);
        setTitle("Anushka's Notepad");
        
        mnew.addActionListener(this);
        exit.addActionListener(this);
        date.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        bgcolor.addActionListener(this);
        fgcolor.addActionListener(this);
        exit.addActionListener(this);
    }
    public static void main(String arg[])
    {
        menu1 m=new menu1();
    
    }

}
