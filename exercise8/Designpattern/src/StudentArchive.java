import java.util.Iterator;
import java.util.List;

import javax.swing.tree.TreeNode;

public class StudentArchive{
    private static String[] studentsList = {"Nam","Thanh","Viet","Dung"};
    private static List<TreeNode> children;


    public StudentArchive(){

    }
    public StudentArchive(String[] name, List<TreeNode> childrenNode){
        studentsList = name;
        children = childrenNode;
    }

    public void printTree(StringBuilder buffer, String prefix, String childrenPrefix){
        buffer.append(prefix);
        buffer.append(studentsList);
        buffer.append('\n');
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                ((StudentArchive) next).printTree(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                ((StudentArchive) next).printTree(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    @Override public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        printTree(buffer, "", "");
        return buffer.toString();
    }

    public static void main(String[] args) {
        StudentArchive studentArchive = new StudentArchive();
        StringBuilder builder = new StringBuilder();
        studentArchive.printTree(builder, "", "     ");
    }
}