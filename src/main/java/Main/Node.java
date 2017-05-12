package Main;

/**
 * Created by Валькирия on 24.11.2016.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Валькирия
 */
public class Node {
    private int i;
    private int j;
    private Node father;
    private int weight;
    private byte wall;
    public Node(int _i,int _j,int _weight,byte _wall)
    {
        i=_i;
        j=_j;
        weight=_weight;
        wall=_wall;
    }
    Node(){
        i=0;
        j=0;
        weight=10000000;
        wall=0;
    }
    Node(Node other)
    {
        i=other.i;
        j=other.j;
        weight=other.weight;
        wall=other.wall;
    }
    public boolean isDiag(Node other){
        if(other.getI()==getI()||other.getJ()==getJ())
            return false;
        return true;
    }
    public int getI(){return i;}
    public int getJ(){return j;}
    public int getWeight(){return weight;}
    public void setWeight(int w){weight=w;}
    public int distantion(Node other){
        return (int)(10*Math.sqrt((i-other.i)*(i-other.i)+(j-other.j)*(j-other.j)));
    }
    public byte isWall()
    {
        return wall;
    }
    public void setFather(Node f){father=f;}
    public Node getFather(){return father;}
}

