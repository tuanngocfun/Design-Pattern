package nodeIterator;

import java.util.Arrays;

public  class StudentArchive implements Container<String> {
    private String[] students = {"Nam", "Hanh", "Viet", "Dung"};
    
    @Override
    public MyIterator<String> iterator() {
        return new MyForwardIterator(0, students);
    }
    
    @Override
    public MyIterator<String> riterator() {
        return new MyReverseIterator(students.length - 1, students);
    }
    
    /////////////////////////////////////////////////////////////
    private String[] sortedStudents = null;
    
    public void instantiateSortedStudents() {
        sortedStudents = Arrays.copyOfRange(students, 0, students.length);
        Arrays.sort(sortedStudents);
    }
    
    public MyIterator<String> orderedIterator() {
        if(sortedStudents == null) {
            instantiateSortedStudents();
        }

        return new MyForwardIterator(0, sortedStudents);
    }
    
    public MyIterator<String> orderedRIterator() {
        if(sortedStudents == null) {
            instantiateSortedStudents();
        }
        
        return new MyReverseIterator(sortedStudents.length - 1, sortedStudents);
    }
}
