/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Валькирия
 */
import java.util.ArrayList;
import javax.swing.*;
import org.netbeans.jemmy.*;
import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.*;
import org.netbeans.jemmy.explorer.*;
import Main.*;
public class WindowTester implements Scenario {
    public int runIt(Object param) {
        try{
    new ClassReference("Main.Window").startApplication();
    JButtonOperator firstButton = new JButtonOperator(Window.but);
    firstButton.push(); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
	    return(1);
        }
  return(0);
}
}
