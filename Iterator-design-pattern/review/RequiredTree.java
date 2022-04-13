public class RequiredTree {
    private class TreeNode {
        private TreeNode lNode;
        private TreeNode rNode;
        private String content;

        public TreeNode(String content){
            this.content = content;
            this.lNode = null;
            this.rNode = null;
        }
    }

    private TreeNode rTreeNode;
    private int size;

    public RequiredTree(){
        rTreeNode = null;
        size = 0;
    }
    
    public void clear(){
        rTreeNode = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private void insertImpl(TreeNode currNode, String content){
        if(rTreeNode == null){
            rTreeNode = new TreeNode(content);
            size = 0;
            return;
        }
        if(currNode.content.compareTo(content)>0){
            if(currNode.lNode!=null){
                insertImpl(currNode.lNode, content);
            } else {
                currNode.lNode = new TreeNode(content);
                size++;
            }
        } else {
            if(currNode.rNode!=null){
                insertImpl(currNode.rNode, content);
            } else {
                currNode.rNode = new TreeNode(content);
                size++;
            }
        }
    }
    public void insert(String content){
        insertImpl(rTreeNode, content);
    }
    private void printTreeImpl(TreeNode currNode, int indentation){
        if(currNode==null){
            return;
        }
        printTreeImpl(currNode.lNode, indentation+1);
        for(int i=0;i<indentation;i++){
            System.out.print('\t');
        }System.out.println(currNode.content);
        printTreeImpl(currNode.rNode, indentation+1);
    }
    public void printTree(){
        printTreeImpl(rTreeNode, 0);
    }
}
