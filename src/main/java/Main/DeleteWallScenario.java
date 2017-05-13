/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.JSpinner;
import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.Scenario;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JSpinnerOperator;

/**
 *
 * @author Валькирия
 */
public class DeleteWallScenario implements Scenario {
    public int runIt(Object param) {
        try{
    new ClassReference("Main.JavaApplication").startApplication();
    JButtonOperator addWallButton = new JButtonOperator(Window.addWall);
    JButtonOperator firstButton = new JButtonOperator(Window.but);
    JSpinnerOperator I = new JSpinnerOperator(Window.wallI);
    JSpinnerOperator J = new JSpinnerOperator(Window.wallJ);
    I.setValue(0);
    J.setValue(1);
    Window.spi1.setValue(0);
        Window.spj1.setValue(0);
        Window.spi2.setValue(0);
        Window.spj2.setValue(2);
    addWallButton.push();
    I.setValue(1);
    J.setValue(1);
    addWallButton.push();
    firstButton.push();
    Window.spi1.setValue(0);
        Window.spj1.setValue(0);
        Window.spi2.setValue(0);
        Window.spj2.setValue(2);
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
