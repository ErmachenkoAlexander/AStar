/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Валькирия
 */

import Main.WindowTester;
import java.util.ArrayList;
import Main.JavaApplication;
import junit.framework.TestCase;
import org.junit.Test;
import javax.swing.SwingUtilities;
import Main.Window;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WindowTest  extends TestCase{
     protected void setUp() throws Exception {
       String[] args=new String[1];
         JavaApplication.main(args);
        //Thread.sleep(1000);
    }
    protected void tearDown() throws Exception {

    }
    
   public void testButton() throws InterruptedException
   {
    final Runnable r=new Runnable(){
            public void run(){
       WindowTester tester=new WindowTester();
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
        tr.join();
        try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
        String expPath=Window.Path.getText();
        assertEquals(expPath, "Путь: i: 0 j: 0 i: 0 j: 1 ");
}
}
