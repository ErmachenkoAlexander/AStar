package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Валькирия on 30.11.2016.
 */
public class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JavaApplication.setEnds(Window.getNumbers());
       JavaApplication.activate();
       JavaApplication.prepare();
    }
}
