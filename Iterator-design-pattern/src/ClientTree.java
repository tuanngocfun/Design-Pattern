public class ClientTree {
    private class TreeNode {
        String content;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(String content) {
            this.content = content;
            left = null;
            right = null;
        }
    }
    
    private TreeNode root;
    private int size;
    
    public ClientTree() {
        size = 0;
        root = null;
    }
    
    public void clear() {
        root = null;
        size = 0;
    }
    
    public boolean empty() {
        return size() == 0;
    }
    
    public int size() {
        return size;
    }
    
    private void insertImpl(TreeNode currentNode, String content) {
        if(root == null) {
            root = new TreeNode(content);
            size++;
            return;
        }
        
        if(currentNode.content.compareTo(content) > 0) {
            if(currentNode.left != null) {
                insertImpl(currentNode.left, content);
            }
            else {
                currentNode.left = new TreeNode(content);
                size++;
            }
        }
        else {
            if(currentNode.right != null) {
                insertImpl(currentNode.right, content);
            }
            else {
                currentNode.right = new TreeNode(content);
                size++;
            }
        }
    }
    
    public void insert(String content) {
        insertImpl(root, content);
    }
    
    private void printTreeImpl(TreeNode currentNode, int indent) {
        if(currentNode == null)
            return;
        
        printTreeImpl(currentNode.left, indent + 1);
        
        for(int i = 0; i < indent; i++)
            System.out.print('\t');
        System.out.println(currentNode.content);
        
        printTreeImpl(currentNode.right, indent + 1);
    }
    
    public void printTree() {
        printTreeImpl(root, 0);
    }
}
