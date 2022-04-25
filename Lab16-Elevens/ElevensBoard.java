import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class ElevensBoard extends Board {
    private static final int BOARD_SIZE = 9;
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
    
    public ElevensBoard() {
        super(BOARD_SIZE, POINT_VALUES);
    }

    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2 && containsPairSum11(selectedCards)) {
            return true;
        } else if (selectedCards.size() == 3 && containsJQK(selectedCards)) {
            return true;
        }
        return false;
    }

    public boolean anotherPlayIsPossible() {
        if (containsPairSum11(cardIndexes()) || containsJQK(cardIndexes())) {
            return true;
        }
        return false;
    }

    private boolean containsPairSum11(List<Integer> selectedCards) {
        for (int i = 0; i < selectedCards.size() - 1; i++) {
            for (int j = i + 1; j < selectedCards.size(); j++) {
                if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 11) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsJQK(List<Integer> selectedCards) {
        boolean jack = false;
        boolean queen = false;
        boolean king = false;
        for (int i = 0; i < selectedCards.size(); i++) {
            int points = cardAt(selectedCards.get(i)).pointValue();
            if (cardAt(selectedCards.get(i)).rank() == "jack") {
                jack = true;
            }
            else if (cardAt(selectedCards.get(i)).rank() == "queen") {
                queen = true;
            }
            else {
                king = true;
            }
        }

        if (jack && queen && king) {
            return true;
        }
        return false;
    }
}
