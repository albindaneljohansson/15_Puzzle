import javax.swing.*;
import java.awt.*;

import java.util.List;

public class PanelBuilder extends JFrame {

    public JPanel gamePanel (List<JButton> buttonList, List<String>randomNumbers){//anropa randomizeList för att sätta siffror på knapparna direkt när panelen skapas
        int i=0;
        JPanel res = new JPanel(new GridLayout(4,4));
        for (JButton button: buttonList) {
            button.setText(randomNumbers.get(i++));
            res.add(button);
        }
        return res;
    }

    public JPanel gamePanelFromList (List<JButton> list){ //alt ifall man använder en lista för att lagra knapparna ist för arrayen
        JPanel panel = new JPanel(new GridLayout(4,4));
        for (JButton button:list) {
            panel.add(button);
        }
        return panel;
    }

}