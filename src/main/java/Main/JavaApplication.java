package Main;
/**
 * Created by Валькирия on 24.11.2016.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 **/
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author Валькирия
 */
public class JavaApplication {

    /**
     * @param args the command line arguments
     */
    static public ArrayList<Integer> ends;
    static public final int maxInt=200000;
    static public ArrayList<Node> Open;
    static public ArrayList<Node> Close;
    static private Node StartPoint;
    static private Node FinishPoint;
    static public Node[][] Map;
    static public int diag;
    static public int dir;
    static public Window win;
    static public ArrayList<Node> path;
    public static void main(String[] args) {
       win=new Window();
          Window.createGUI();
          prepare();
    }
    public static void prepare()
    {
         JavaApplication.Map=new Node[10][10];
         for(int i=0;i<10;i++)
                  for(int j=0;j<10;j++)
                    Map[i][j]=new Node(i,j,maxInt,(byte)0);
        JavaApplication.Open=new ArrayList();
        JavaApplication.Close=new ArrayList();
    }
    
    
    public static void activate()
    {
        diag=14;
        dir=10;
        setEnds(Window.getNumbers());
        boolean ok=true;
        if(win!=null){
        ArrayList<Integer> coord=new ArrayList<>(Window.getNumbers());
       
        for(int i=0;i<4;i++)
            if(coord.get(i)>10||coord.get(i)<0) {
                JOptionPane.showMessageDialog(null, "значение не должно быть больше 10 или меньше 0");
                ok=false;
            }
        }
            if(ok) {
                    
                path = AStar();
                if(win!=null)
                Window.setRes(path);
            }
    }
    static public void setEnds(ArrayList<Integer> coord)
    {
        
        StartPoint = Map[coord.get(0)][coord.get(1)];
        FinishPoint = Map[coord.get(2)][coord.get(3)];
        ends=coord;
        if(StartPoint!=null)
        Open.add(StartPoint);
    }
    static public ArrayList<Node> AStar()
    {
        ArrayList<Node> res=new ArrayList();
        Node cur=new Node();
        for(;;){
            int min=10000000;
            int size=Open.size();
            for(int i=0;i<size;i++)
            {
                int F=Open.get(i).distantion(FinishPoint)+Open.get(i).getWeight();
                if(F<min){
                    min=F;
                    cur=Open.get(i);
                }
            }
           Open.remove(cur);
            Close.add(cur);
            if(cur==FinishPoint)
            {
                Node next=FinishPoint;
                for(;next!=StartPoint;){
                    next=next.getFather();
                    res.add(next);
                }

                return res;
            }
            for(int i=cur.getI()-1;i<cur.getI()+2;i++)
                for(int j=cur.getJ()-1;j<cur.getJ()+2;j++)
               if(i<9&&i>-1&&j<9&&j>-1)
                {
                   if((i!=cur.getI()||j!=cur.getJ())&&i>-1&&j>-1)
                        if(Map[i][j].isWall()==0&&!Close.contains(Map[i][j]))
                        {
                            int dist;
                            if(i!=cur.getI()&&j!=cur.getJ())
                                dist=diag;
                            else
                                dist=dir;
                            if(!Open.contains(Map[i][j]))
                            {
                                Open.add(Map[i][j]);
                                Map[i][j].setWeight(dist+cur.getWeight());
                                Map[i][j].setFather(cur);
                            }
                            else
                            if(Map[i][j].getWeight()>dist+cur.getWeight()){
                                Map[i][j].setWeight(dist+cur.getWeight());
                                Map[i][j].setFather(cur);
                            }
                        }

                }
            if(Open.isEmpty())
                return new ArrayList<Node>();


        }
    }
}

