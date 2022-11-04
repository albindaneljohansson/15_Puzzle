import javax.swing.*;
import java.awt.*;

import java.util.List;

public class PanelBuilder extends JFrame {


    public JPanel gamePanel(List<JButton> buttonList, List<String> randomNumbers) {
        int i = 0;
        JPanel res = new JPanel(new GridLayout(4, 4));
        for (JButton button : buttonList) {
            button.setText(randomNumbers.get(i++));
            res.add(button);
        }
        return res;
    }

    public JPanel upperPanel(JButton button, JLabel label) {
        JPanel res = new JPanel(new GridLayout(1, 2));
        res.add(button);
        res.add(label);
        return res;
    }
}