import java.util.*;

public class ArrayListProbs {
    public ArrayListProbs() {

    }

    public void makeListAndPrint(int num, int limit) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int index = 0; index < num; index++) {
            Random random = new Random();
            int rand = random.nextInt(limit) + 1;
            list.add(new Integer(rand));
        }
        System.out.println(list);
    }

    public ArrayList<Integer> addOne(ArrayList<Integer> list) {
        for (int index = 0; index < list.size(); index++) {
            list.set(index, list.get(index) + 1);
        }
        return list;
    }

    public ArrayList<Integer> minToFront(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) < min) {
                min = list.get(index);
            }
        }
        list.add(0, min);
        return list;
    }

    public ArrayList<String> removeDupes(ArrayList<String> list) {
        for (int index = 1; index < list.size(); index++) {
            if (list.get(index - 1).equals(list.get(index))) {
                list.remove(index - 1);
                index--;
            }
        }
        return list;
    }

    public ArrayList<Integer> swapPairs(ArrayList<Integer> list) {
        for (int index = 1; index < list.size(); index+=2) {
            int temp = list.get(index - 1);
            list.set(index - 1, list.get(index));
            list.set(index, temp);
        }
        return list;
    }

    public ArrayList<String> removeLenN(ArrayList<String> list, int n) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).length() == n) {
                list.remove(index);
                index--;
            }
        }
        return list;
    }

    public int dumbestPerson(ArrayList<Person> list) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIQ() < min) {
                min = list.get(i).getIQ();
                index = i;
            }
        }
        return index;
    }
    
    public Book highestPricedBook(ArrayList<Book> list) {
        double max = Integer.MIN_VALUE;
        int i = 0;
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getPrice() > max) {
                max = list.get(index).getPrice();
                i = index;
            }
        }
        return list.get(i);
    }
    
    public ArrayList<Book> banBook(ArrayList<Book> list, Book book) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getTitle().equals(book.getTitle())) {
                list.remove(index);
                index--;
            }
        }
        return list;
    }
    
    public double bookstoreValue(Bookstore store) {
        double total = 0;
        for (Book book : store.inventory) {
            total += book.getPrice();
        }
        return total;
    }
}