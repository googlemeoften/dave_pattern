package cn.edu.twoforktree;

/**
 * Description:
 * Author: Hey
 * Date: 2015/12/8
 */
public class TwoForkTree<T> {

    public Node root;

    //????
    public boolean insert(int value) {

        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node parent = null;
        Node current = root;
        while (true) {
            parent = current;
            if (current.getValue() > newNode.getValue()) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    break;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    break;
                }
            }
        }
        return true;
    }

    //????
    public Node find(Integer value) {

        if (root == null)
            return null;

        Node current = root;
        while (true) {
            if (current == null)
                return null;
            else if (current.getValue() == value)
                return current;
            else if (current.getValue() > value)
                current = current.leftChild;
            else
                current = current.rightChild;
        }

    }

    public Node remove(int value){

        if(root==null)
            return null;
        Node parent=null;
        Node current=root;
        boolean isLeftChild=false;

        while(true){

            if(current==null)
                return null;
            else if(current.getValue()==value)
                break;
            else if(current.getValue()>value){
                parent=current;
                current=current.leftChild;
                isLeftChild=true;
            }
            else{
                parent=current;
                current=current.rightChild;
                isLeftChild=false;
            }
        }

        if(current.leftChild==null&&current.rightChild==null){
            if(isLeftChild)
                parent.leftChild=null;
            else
                parent.rightChild=null;
            return current;
        }else if(current.leftChild!=null&&current.rightChild==null){
            if(isLeftChild)
                parent.leftChild=current.leftChild;
            else
                parent.rightChild=current.leftChild;
        }else if(current.rightChild!=null&&current.leftChild==null){
            if(isLeftChild)
                parent.leftChild=current.rightChild;
            else
                parent.rightChild=current.rightChild;
        }else{

            Node succor=getSuccor(current);
            if(isLeftChild)
                parent.leftChild=succor;
            else
                parent.rightChild=succor;
            succor.rightChild=current.rightChild;

        }

        return current;
    }

    /**
     * 获得节点的后继
     * @param node
     * @return
     */
    private Node getSuccor(Node node){
        Node current=node.leftChild;
        Node parent=node;
        Node subParent=null;
        while(current!=null){
            subParent=parent;
            parent=current;
            current=current.leftChild;
        }
        if(parent.rightChild!=null){
            subParent.leftChild=parent.rightChild;
        }else {
            subParent.leftChild=null;
        }
        return parent;
    }


    /**
     *中序遍历
     * @param node
     */
    private void inOrder(Node node){

        if(node!=null){
            inOrder(node.leftChild);
            System.out.println(node);
            inOrder(node.rightChild);
        }
    }

    //前序遍历
    public void beforeOrder(Node node){
        if(node!=null){
            System.out.println(node);
            beforeOrder(node.leftChild);
            beforeOrder(node.rightChild);
        }
    }

    //后序遍历
    public void afterOrder(Node node){
        if(node!=null){
            afterOrder(node.leftChild);
            afterOrder(node.rightChild);
            System.out.println(node);
        }
    }

    public static void main(String [] args){
        TwoForkTree tree=new TwoForkTree();
        tree.insert(45);
        tree.insert(90);
        tree.insert(40);
        tree.insert(43);
        tree.insert(13);
        tree.insert(50);

//        System.out.println(tree.find(44));
//
//        System.out.println(tree.root);
//        System.out.println("-------------");
        tree.inOrder(tree.root);
        System.out.println("-------------");
//        tree.afterOrder(tree.root);
//        System.out.println("-------------");
//        tree.beforeOrder(tree.root);
        tree.remove(40);
        System.out.println("-------------");
        tree.inOrder(tree.root);




    }
}
