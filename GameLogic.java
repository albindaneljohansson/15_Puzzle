import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic {
    //   List<JButton> sortedButtonList = new ArrayList<>(); //om denna -> använda konstruktor för att sätta värdena


    //test att lägga en kommentar i en av filerna jag klonade.

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
            if (!inputList.get(i).equals(getSortedStringList().get(i))){
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

    private boolean isSolvable(List<String> rList) {
        int countInversions = 0;

        for (int i = 0; i < rList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(rList.get(j)) > Integer.parseInt(rList.get(i)))
                    countInversions++;
            }
        }

        return countInversions % 2 == 0;
    }
}
