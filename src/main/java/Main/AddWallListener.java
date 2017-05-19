/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Main.JavaApplication.maxInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Валькирия
 */
public class AddWallListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int i=((Number) Window.wallI.getValue()).intValue();
        int j=((Number) Window.wallJ.getValue()).intValue();
        try
        {
        JavaApplication.Map[i][j]=new Node(i,j,maxInt,(byte)1);
        }
        catch(Exception re)
        {
            
        }
    }
}

