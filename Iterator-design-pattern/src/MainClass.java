import nodeIterator.Container;
import nodeIterator.MyIterator;
import nodeIterator.StudentArchive;

public class MainClass {
    public static void main(String[] args) {
        /*
        ** public class StudentArchive implements Container<String>
        */
        
        StudentArchive SA = new StudentArchive();
        
        System.out.println(SA.orderedIterator().next());
        //testSortingAndTraversing(SA);
    }
    
    public <T> void testSortingAndTraversing(StudentArchive SA) {
        MyIterator<String> iter = SA.orderedIterator();
        System.out.print("print left to right:  ");
        while(iter.hasNext()) {
            System.out.print(iter.next() + "  ");
        }
        System.out.println();
        
        MyIterator<String> riter = SA.orderedRIterator();
        System.out.print("print right to left:  ");
        while(riter.hasNext()) {
            System.out.print(riter.next() + "  ");
        }
        System.out.println();
    }
    
    public <T> void testFinding(Container<T> container, Object toFind) {
        boolean found = false;
        
        MyIterator<T> iter = container.iterator();
        while(iter.hasNext()) {
            Object currentObject = iter.next();
            
            if(currentObject.equals(toFind)) {
                found = true;
                break;
            }
        }
        
        if(found) {
            System.out.println("'" + toFind + "' found in the container");
        }
        else {
            System.out.println("'" + toFind + "' not found in the container");
        }
    }
    
    public <T> void testPrintLeftRight(Container<T> container) {
        MyIterator<T> iter = container.iterator();
        System.out.print("print left to right:  ");
        while(iter.hasNext()) {
            System.out.print(iter.next() + "  ");
        }
        System.out.println();
        
        MyIterator<T> riter = container.riterator();
        System.out.print("print right to left:  ");
        while(riter.hasNext()) {
            System.out.print(riter.next() + "  ");
        }
        System.out.println();
    }
    
    public <T> void testPrintTree(Container<T> container) {
        MyIterator<T> iter = container.iterator();
        ClientTree tree = new ClientTree();
        
        while(iter.hasNext()) {
            tree.insert((String) iter.next());
        }
        
        tree.printTree();
    }
}
