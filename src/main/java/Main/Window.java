package Main;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JSpinner;

public class Window
{
    static public JSpinner spi1;
    static public JSpinner spj1;
    static public JSpinner spi2;
    static public JSpinner spj2; 
    static public JSpinner wallI;
    static public JSpinner wallJ;
    static public JFrame frame;
    static public JLabel Path;
    static public JButton but;
    static public JButton addWall;
  static  public void createGUI()
    {
        frame = new JFrame(" frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         spi1 = new JSpinner();
         spj1 = new JSpinner();
         wallI = new JSpinner();
         wallJ = new JSpinner();
         spi2 = new JSpinner();
         spj2 = new JSpinner();
         Path=new JLabel("");
          but=new JButton("старт");
         but.addActionListener(new Listener());
          addWall = new JButton("добавить");
         addWall.addActionListener(new AddWallListener());
         frame.setLayout(new FlowLayout());
        frame.getContentPane().add(spi1);
        frame.getContentPane().add(spj1);
        frame.getContentPane().add(spi2);
        frame.getContentPane().add(spj2);
        frame.getContentPane().add(wallI);
        frame.getContentPane().add(wallJ);
        frame.getContentPane().add(addWall);
        frame.getContentPane().add(but);
        frame.getContentPane().add(Path);
        frame.setPreferredSize(new Dimension(200, 100));
        frame.pack();
        frame.setVisible(true);
    }
    static public ArrayList<Integer> getNumbers(){
        ArrayList<Integer> res=new ArrayList();
        res.add(((Number) spi1.getValue()).intValue());
        res.add(((Number) spj1.getValue()).intValue());
        res.add(((Number) spi2.getValue()).intValue());
        res.add(((Number) spj2.getValue()).intValue());
        return res;
    }
   static public void setRes(ArrayList<Node> path)
    {
        String str=new String();
        int size=path.size();
        str="Путь: ";
        for(int i=size-1;i>-1;i--)
        {
            str+="i: "+Integer.toString(path.get(i).getI())+" ";
            str+="j: "+Integer.toString(path.get(i).getJ())+" ";
        }
        Path.setText(str);
    }
}
/**
 * Created by Валькирия on 30.11.2016.
 */
