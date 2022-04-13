public class Client {
    public static void main(String[] args) {
        StudentArchive studentArchive = new StudentArchive();
        System.out.println(studentArchive.getOrderedIterator().next());
        System.out.println("<<<------------------------------------------------------------------------------------->>>");
        RequiredTree tree = new RequiredTree();
        tree.insert("Nam");
        tree.insert("Hanh");
        tree.insert("Viet");
        tree.insert("Dung");
        tree.printTree();
        System.out.println("<<<-------------------------------------------------------------------------------------->>>");
        Container<String> container = new StudentArchive();
        findStudentInList(container, "Dung");
        System.out.println("<<<-------------------------------------------------------------------------------------->>>");
        StudentArchive sa = new StudentArchive();
        printSorterdStudentList(sa);
        System.out.println();
        printRequiredTree(container);
    }

    public static <T> void printSorterdStudentList(StudentArchive studentArchive){
        Iterator<String> iterator = studentArchive.getOrderedIterator();
        System.out.println("Print left to right:");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n<<---------------------------------------------------------->>");
        Iterator<String> rIterator = studentArchive.getOrderedReversalIterator();
        System.out.println("Print right to left:");
        while(rIterator.hasNext()){
            System.out.print(rIterator.next()+" ");
        }
        System.out.println("\n<<<------------------------------------------------------------------------------------->>>");
    } 
    public static <T> void findStudentInList(Container<T> container, Object toFind){
        boolean contain = false;
        Iterator<T> iterator = container.getIterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(toFind)){
                contain = true;
                break;
            }
        }
        if(contain){
            System.out.println("The student "+toFind+" is actually in a list.");
        } else {
            System.out.println("The student "+toFind+" is not actually in a list.");
        }
    }
    public static <T> void printRequiredTree(Container<T> container){
        Iterator<T> iterator = container.getIterator();
        RequiredTree tree = new RequiredTree();
        while(iterator.hasNext()){
            tree.insert((String)iterator.next());
        }
        tree.printTree();
    }
}
