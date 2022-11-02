import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    JLabel message = new JLabel("    ");
    JLabel noOfMovesLabel = new JLabel("  Move number: ");

    int noOfMovesCounter = 0;


    JButton newGame = new JButton("New game");
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();
    JButton b10 = new JButton();
    JButton b11 = new JButton();
    JButton b12 = new JButton();
    JButton b13 = new JButton();
    JButton b14 = new JButton();
    JButton b15 = new JButton();
    JButton b16 = new JButton();

    List<JButton> buttonsList;
    List<String> currentOrder;

    GameLogic gameLogic = new GameLogic();
    PanelBuilder panelBuilder = new PanelBuilder();


    public Main() {

        buttonsList = List.of(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16);

        currentOrder = gameLogic.randomizeList(true);//true = ger nummer i korrekt ordning (för demo)

        JPanel gamePanel = panelBuilder.gamePanel(buttonsList, currentOrder);
        JPanel upperPanel = panelBuilder.upperPanel(newGame, noOfMovesLabel);

        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.CENTER);
        add(upperPanel, BorderLayout.NORTH);
        add(message,BorderLayout.SOUTH);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);

        //newGame.addActionListener(l -> gameRestart());
        newGame.addActionListener(l -> panelBuilder.gameRestart(buttonsList));

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<JButton> buttonsListForward_1 = List.of(b1, b2, b3, b5, b6, b7, b9, b10, b11, b13, b14, b15);
        List<JButton> buttonsListBackward_1 = List.of(b2, b3, b4,b6, b7, b8, b10, b11, b12, b14, b15, b16);
        int tempButtonNr = currentOrder.indexOf(((JButton) e.getSource()).getText());

        for (int i=0; i<12; i++){
            if (e.getSource() == buttonsListForward_1.get(i) && currentOrder.get(tempButtonNr + 1).equals("")) {
                Collections.swap(currentOrder, tempButtonNr, tempButtonNr + 1);
              //  actionPerformedSupport();
            }
        }

        for (int i=0; i<12; i++){
            if (e.getSource() == buttonsListBackward_1.get(i) && currentOrder.get(tempButtonNr - 1).equals("")) {
                Collections.swap(currentOrder, tempButtonNr, tempButtonNr - 1);
             //   actionPerformedSupport();
            }
        }

         for (int i=0; i<12; i++){
            if (e.getSource() == buttonsList.get(i) && currentOrder.get(tempButtonNr + 4).equals("")) {
                Collections.swap(currentOrder, tempButtonNr, tempButtonNr + 4);
               // actionPerformedSupport();
            }
        }

        for (int i=4; i<16; i++){
            if (e.getSource() == buttonsList.get(i) && currentOrder.get(tempButtonNr - 4).equals("")) {
                Collections.swap(currentOrder, tempButtonNr, tempButtonNr - 4);
                //actionPerformedSupport();
            }
        }
        actionPerformedSupport();
    }
    //  Supportmetod till actionlistener
    public void actionPerformedSupport(){
        noOfMovesCounter++;
        panelBuilder.moveCounterUpdater(noOfMovesLabel,noOfMovesCounter);
     //   moveCounterUpdater();
        panelBuilder.interfaceUpdater(buttonsList,currentOrder);
        //interfaceUpdater();
        System.out.println("ett varv i supporten utfört");
    }
    // Kontrollerar nuvarande position mot löst spel
    public void gameOver() {
        if (gameLogic.isSorted(currentOrder)) {
            message.setText("Congratulations, you won!!!");
            revalidate();
            repaint();
        }
    }
    // Uppdaterar grafiken till current state
    public void interfaceUpdater() {
        int i = 0;
        for (JButton button : buttonsList) {
            button.setText(currentOrder.get(i++));
        }
        revalidate();
        repaint();
        gameOver();
    }
    // Initierar nytt spel
    public void gameRestart() {     //
        currentOrder = gameLogic.randomizeList(false);
        noOfMovesCounter = 0;
        panelBuilder.moveCounterUpdater(noOfMovesLabel,noOfMovesCounter);
     //   moveCounterUpdater();
        message.setText("         ");
        interfaceUpdater();

    }
    // Räknar drag
  //  public void moveCounterUpdater() {
//        noOfMovesLabel.setText("  Move number: " + noOfMovesCounter);
  //  }



    public static void main(String[] args) {
        Main m = new Main();
    }
}