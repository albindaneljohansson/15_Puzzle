import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    JLabel message = new JLabel();
    JButton newGame = new JButton("New game");

    int noOfMovesCounter = 0;

    JLabel noOfMovesLabel = new JLabel("  Antal drag: ");
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();

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

    List<JButton> buttonsList = new ArrayList<>();


    GameLogic gameLogic = new GameLogic();
    List<String> currentOrder = new ArrayList<>();
    List<String> sortedList = new ArrayList<>();



    //boolean isDemo;

    // Lägga till en boolean isDemo som skickas med i anropet för att skapa currentOrder
    // så att den blir i nummerordning istället för ranodmiserad.
    public Main() {
        buttonsList = List.of(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16);
        setLayout(new BorderLayout());
        currentOrder = gameLogic.randomizeList(true);//boolean som är false i def. men som sätts till true för demo
        PanelBuilder panelBuilder = new PanelBuilder();
        JPanel gamePanel = panelBuilder.gamePanel(buttonsList, currentOrder);
        add(gamePanel, BorderLayout.CENTER);

        add(upperPanel, BorderLayout.NORTH);
        upperPanel.setLayout(new GridLayout(1,6));
        upperPanel.add(newGame);
        upperPanel.add(noOfMovesLabel);

        if (gameLogic.isSolvable(currentOrder)){
            System.out.println("woohoo!");
        }





        lowerPanel.add(message);
        add(lowerPanel, BorderLayout.SOUTH);

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

        newGame.addActionListener(l -> gameRestart());

        //standard avslutning
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //För samtliga if-else-satser återstår att kontrollera om ordningen har blivit korrekt.

        String tempButton;
        int tempButtonNr = currentOrder.indexOf(((JButton) e.getSource()).getText());
        //Testa om tom knapp är till höger om klickad
        if ((e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 ||
                e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 ||
                e.getSource() == b9 || e.getSource() == b10 || e.getSource() == b11 ||
                e.getSource() == b13 || e.getSource() == b14 || e.getSource() == b15)
                && currentOrder.get(tempButtonNr + 1).equals("")) {

            Collections.swap(currentOrder, tempButtonNr, tempButtonNr + 1);
            noOfMovesCounter++;
            moveCounter();
            interfaceUpdater();

            //Testa om tom knapp är till vänster om klickad
        } else if ((e.getSource() == b2 || e.getSource() == b3 || e.getSource() == b4 ||
                e.getSource() == b6 || e.getSource() == b7 || e.getSource() == b8 ||
                e.getSource() == b10 || e.getSource() == b11 || e.getSource() == b12 ||
                e.getSource() == b14 || e.getSource() == b15 || e.getSource() == b16)
                && currentOrder.get(tempButtonNr - 1).equals("")) {

            Collections.swap(currentOrder, tempButtonNr, tempButtonNr - 1);
            noOfMovesCounter++;
            moveCounter();
            interfaceUpdater();

            //Testa om tom knapp är under klickad
        } else if ((e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || e.getSource() == b4 ||
                e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 || e.getSource() == b8 ||
                e.getSource() == b9 || e.getSource() == b10 || e.getSource() == b11 || e.getSource() == b12)
                && currentOrder.get(tempButtonNr + 4).equals("")) {

            Collections.swap(currentOrder, tempButtonNr, tempButtonNr + 4);
            noOfMovesCounter++;
            moveCounter();
            interfaceUpdater();

            //Testa om tom knapp är över klickad
        } else if ((e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 || e.getSource() == b8 ||
                e.getSource() == b9 || e.getSource() == b10 || e.getSource() == b11 || e.getSource() == b12 ||
                e.getSource() == b13 || e.getSource() == b14 || e.getSource() == b15 || e.getSource() == b16)
                && currentOrder.get(tempButtonNr - 4).equals("")) {

            Collections.swap(currentOrder, tempButtonNr, tempButtonNr - 4);
            noOfMovesCounter++;
            moveCounter();
            interfaceUpdater();
        }
    }

    public void gameOver() {
        if (gameLogic.isSorted(currentOrder)){
            message.setText("Congratulations, you won!!!");
            revalidate();
            repaint();
            System.out.println("vinst");
        }
    }

    public void interfaceUpdater() {
        int i = 0;
        for (JButton button : buttonsList) {
            button.setText(currentOrder.get(i++));
        }
            revalidate();
            repaint();
            gameOver();
    }

    public void gameRestart() {
        currentOrder = gameLogic.randomizeList(false);
        noOfMovesCounter = 0;
        moveCounter();
        message.setText("         ");
        interfaceUpdater();

    }

    public void moveCounter(){
        noOfMovesLabel.setText("  Antal drag: "+noOfMovesCounter);
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}