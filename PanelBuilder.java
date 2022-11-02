import javax.swing.*;
import java.awt.*;

import java.util.List;

public class PanelBuilder extends JFrame {
    GameLogic gl = new GameLogic();

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
        JPanel res = new JPanel(new GridLayout(1, 6));
        res.add(button);
        res.add(label);
        return res;
    }

    public void moveCounterUpdater(JLabel noOfMovesLabel, int noOfMovesCounter) {
        noOfMovesLabel.setText("  Move number: " + noOfMovesCounter);
    }

    public void gameRestart(List<JButton> buttonsList) {     //

        List<String> currentOrder = gl.randomizeList(false);
        moveCounterUpdater(new JLabel(),0); //nollställer antalet drag, skickar in en ny label för dragen
        interfaceUpdater(buttonsList, currentOrder);
        messageUpdater(new JLabel(),false);
    /*    currentOrder = gameLogic.randomizeList(false);
        noOfMovesCounter = 0;
        panelBuilder.moveCounter(noOfMovesLabel,noOfMovesCounter);
        //   moveCounter();
        message.setText("         ");
        interfaceUpdater();


     */
    }
    public void messageUpdater(JLabel message, boolean win){
        if (win){
            message.setText("Congratulations, you won!!!");
        } else {
            message.setText("         ");
        }
    }

 /*   public void gameOver() {
        if (gameLogic.isSorted(currentOrder)) {
            message.setText("Congratulations, you won!!!");
            revalidate();
            repaint();
        }
    }

  */
    // Uppdaterar grafiken till current state
    public void interfaceUpdater(List<JButton> buttonsList, List<String> currentOrder) {
        int i = 0;
        for (JButton button : buttonsList) {
            button.setText(currentOrder.get(i++));
        }
        revalidate();
        repaint();
        if (gl.isSorted(currentOrder))
            messageUpdater(new JLabel(),true);
        //gameOver();
    }

}