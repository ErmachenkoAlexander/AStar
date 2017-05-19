/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newTests;

import Main.JavaApplication;
import Main.Window;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author Валькирия
 */
public class WindowTest extends TestCase{
    
    protected void setUp() throws Exception {
       String[] args=new String[1];
         JavaApplication.main(args);
        //Thread.sleep(1000);
    }
    protected void tearDown() throws Exception {

    }
    
    public void testBadData()
    {
        final Runnable r=new Runnable(){
            public void run(){
       BadDataScenario tester=new BadDataScenario();
       Window.Path.setText(new String());
       tester.runIt(new Object());              
       
   }
             };  
        Thread tr=new Thread(){
            public void run(){
                
                try{
                    SwingUtilities.invokeAndWait(r);
                }
                catch(InvocationTargetException e)
                {}
                catch(InterruptedException e)
                {}
               
            }
        };
        tr.start();
        try {
            tr.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
        String expPath=Window.Path.getText();
        assertEquals(expPath, "Путь: i: 0 j: 0 i: 0 j: 1 ");  
   }
    
     public void testDeleteWall()
    {
        final Runnable r=new Runnable(){
            public void run(){
       DeleteWallScenario tester=new DeleteWallScenario();
       Window.Path.setText(new String());
       tester.runIt(new Object());              
       
   }
             };  
        Thread tr=new Thread(){
            public void run(){
                
                try{
                    SwingUtilities.invokeAndWait(r);
                }
                catch(InvocationTargetException e)
                {}
                catch(InterruptedException e)
                {}
               
            }
        };
        tr.start();
        try {
            tr.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
        String expPath=Window.Path.getText();
        assertEquals(expPath, "Путь: i: 0 j: 0 i: 0 j: 1 ");  
    }
    public void testAdd2Wall()
    {
        final Runnable r=new Runnable(){
            public void run(){
       Add2WallScenario tester=new Add2WallScenario();
       Window.Path.setText(new String());
       tester.runIt(new Object());              
       
   }
             };  
        Thread tr=new Thread(){
            public void run(){
                
                try{
                    SwingUtilities.invokeAndWait(r);
                }
                catch(InvocationTargetException e)
                {}
                catch(InterruptedException e)
                {}
               
            }
        };
        tr.start();
        try {
            tr.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
        String expPath=Window.Path.getText();
        assertEquals(expPath, "Путь: i: 0 j: 0 i: 1 j: 0 i: 2 j: 1 i: 1 j: 2 ");  
    }
    
   
   public void testAddWall()
   {
     final Runnable r=new Runnable(){
            public void run(){
       AddWallTester tester=new AddWallTester();
       Window.Path.setText(new String());
       tester.runIt(new Object());              
       
   }
             };  
        Thread tr=new Thread(){
            public void run(){
                
                try{
                    SwingUtilities.invokeAndWait(r);
                }
                catch(InvocationTargetException e)
                {}
                catch(InterruptedException e)
                {}
               
            }
        };
        tr.start();
        try {
            tr.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
        String expPath=Window.Path.getText();
        assertEquals(expPath, "Путь: i: 0 j: 0 i: 1 j: 1 ");  
   }
    
}
