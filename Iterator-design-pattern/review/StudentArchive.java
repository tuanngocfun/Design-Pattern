import java.util.Arrays;

public class StudentArchive implements Container<String>{
    private String[] studentsList = {"Nam","Hanh","Viet","Dung"};
    
    @Override public Iterator<String> getIterator(){
        return new ForwardIterator(studentsList, 0);
    }
    @Override public Iterator<String> getReverseIterator(){
        return new BackwardIterator(studentsList, studentsList.length-1);
    }

    private String[] sortedStudentList = null;

    public void initiateSortedStudentList(){
        sortedStudentList = Arrays.copyOfRange(studentsList, 0, studentsList.length);
        Arrays.sort(sortedStudentList);
    }
    public Iterator<String> getOrderedIterator(){
        if(sortedStudentList==null){
            initiateSortedStudentList();
        }
        return new ForwardIterator(sortedStudentList, 0);
    }
    public Iterator<String> getOrderedReversalIterator(){
        if(sortedStudentList==null){
            initiateSortedStudentList();
        }
        return new BackwardIterator(sortedStudentList, sortedStudentList.length-1);
    }
}
