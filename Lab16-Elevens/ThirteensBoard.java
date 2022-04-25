import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class ThirteensBoard extends Board {
    private static final int BOARD_SIZE = 10;
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    
    public ThirteensBoard() {
        super(BOARD_SIZE, POINT_VALUES);
    }
    
    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2 && containsPairSum13(selectedCards)) {
            return true;
        } else if (selectedCards.size() == 1 && containsK(selectedCards)) {
            return true;
        }
        return false;
    }

    public boolean anotherPlayIsPossible() {
        if (containsPairSum13(cardIndexes()) || containsK(cardIndexes())) {
            return true;
        }
        return false;
    }

    private boolean containsPairSum13(List<Integer> selectedCards) {
        for (int i = 0; i < selectedCards.size() - 1; i++) {
            for (int j = i + 1; j < selectedCards.size(); j++) {
                if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 13) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsK(List<Integer> selectedCards) {
        boolean king = false;
        for (int i = 0; i < selectedCards.size(); i++) {
            int points = cardAt(selectedCards.get(i)).pointValue();
            if (cardAt(selectedCards.get(i)).rank() == "king") {
                king = true;
            }
        }
        
        if (king) {
            return true;
        }
        return false;
    }
}