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
public class WindowTest  extends TestCase{
     protected void setUp() throws Exception {
         String[] args=new String[1];
         JavaApplication.main(args);
    }
    protected void tearDown() throws Exception {

    }
    
   public void testButton()
   {
        final Runnable r=new Runnable(){
            public void run(){
        Window.spi1.setValue(0);
        Window.spj1.setValue(0);
        Window.spi2.setValue(0);
        Window.spj2.setValue(2);
       WindowTester tester=new WindowTester();
       Window.Path.setText(new String());
       tester.runIt(new Object());
       String path=Window.Path.getText();
       String expPath="Путь: i: 0 j: 0 i: 1 j: 0 i: 2 j: 0 i: 3 j: 1 i: 2 j: 2 i: 1 j: 2 ";
       assertEquals(expPath,path);
   }
             };  
        Thread tr=new Thread(){
            public void run(){
                try{
                    SwingUtilities.invokeAndWait(r);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        tr.start();
}
}
