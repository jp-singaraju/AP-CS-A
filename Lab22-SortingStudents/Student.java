import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private int studentID;

    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public String getName() {
        return this.name;
    }

    public int getStudentID() {
        return this.studentID;
    }

    @Override
    public String toString() {
        return this.studentID + ": " + this.name;
    }

    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
        if (this.name.equals(other.name) && this.studentID == other.studentID) {
            return true;
        }
        return false;
    }
    
    @Override
    public int compareTo(Student other) {
        if (this.name.compareTo(other.name) == 0) {
            if (equals(other)) {
                return 0;
            } else {
                return -1;
            }
        }
        return this.name.compareTo(other.name);
    }
    
    public void selectionSort(List<Student> list) {
        for (int index = 0; index < list.size() - 1; index++) {
            int minIndex = index;
            for (int index2 = index + 1; index2 < list.size(); index2++) {
                if (list.get(index2).compareTo(list.get(minIndex)) < 0) {
                    minIndex = index2;
                }
            }
            Student temp = list.get(minIndex);
            list.set(minIndex, list.get(index));
            list.set(index, temp);
        }
    }
    
    public void insertionSort(List<Student> list) {
        for (int index = 0; index < list.size() - 1; index++) {
            if (list.get(index + 1).compareTo(list.get(index)) < 0) {
                Student temp = list.get(index);
                list.set(index, list.get(index + 1));
                list.set(index + 1, temp);
                for (int index2 = index; index2 > 0; index2--) {
                    if (list.get(index2).compareTo(list.get(index2 - 1)) < 0) {
                        Student temp2 = list.get(index2);
                        list.set(index2, list.get(index2 - 1));
                        list.set(index2 - 1, temp2);
                    }
                }
            }
        }
    }
    
    // Compare to student id
    /*
    public int compareTo(Student other) {
        if (this.studentID > other.studentID) {
            return 1;
        } else if (this.studentID < other.studentID) {
            return -1;
        }
        return 0;
    }
    */
}
