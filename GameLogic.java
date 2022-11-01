import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic extends MouseAdapter {
    //   List<JButton> sortedButtonList = new ArrayList<>(); //om denna -> använda konstruktor för att sätta värdena


    public List<String> getSortedStringList() {
        List<String> sortedStringList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            sortedStringList.add(""+(i+1));
        }
        sortedStringList.add("");
        return sortedStringList;
    }

    public boolean isSorted (List<String> inputList){
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) != getSortedStringList().get(i)){
                return false;
            }
        }
        return true;
    }
    public List<String> randomizeList (boolean isDemo){
        List<String> rList =  getSortedStringList();
        if (!isDemo) {
            Collections.shuffle(rList);
        }
        return rList;
    }



    // en mouseClicked med lambdas för Nytt spel som randomiserar alla knappar
    @Override
    public void mouseClicked(MouseEvent e) {




        //  if (e.getSource()) //knapparna inuti spelet, när man flyttar runt knapparna.
    }
}
//om klick bredvid tomma rutan (lodrät/vågrät) byta plats
// Scanna av alla knappar efter varje drag för att se om det är rätt ordning en lista med

//             - X -
//               |