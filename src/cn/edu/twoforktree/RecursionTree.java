package cn.edu.twoforktree;

/**
 * Description:ͨ���ݹ���������
 * Author: Hey
 * Date: 2015/12/10
 */
public class RecursionTree {

    private BinaryNode root;

    public void insert(Integer value){
        root=insert(value,root);
    }

    /**
     * ����
     * @param value
     * @param node
     * @return
     */
    public BinaryNode insert(Integer value,BinaryNode node){
        if(node==null){
            return new BinaryNode(value,null,null);
        }

        int compareResult=value.compareTo(node.getValue());

        if(compareResult<0){
            node.leftChild=insert(value,node.leftChild);
        }else if(compareResult>0){
            node.rightChild=insert(value,node.rightChild);
        }else{

        }

        return node;
    }

    public BinaryNode remove(Integer value,BinaryNode node){
        if(node==null)
            return null;
        int compareResult=value.compareTo(node.getValue());

        if(compareResult<0){
            node.leftChild=remove(value,node.leftChild);
        }else if(compareResult>0){
            node.rightChild=remove(value,node.rightChild);
        }else if(node.leftChild!=null&&node.rightChild!=null){
            node.setValue(findMin(node.rightChild).getValue());
            node.rightChild=remove(node.getValue(),node.rightChild);
        }else{
            node=(node.leftChild!=null)?node.leftChild:node.rightChild;
        }

        return node;
    }

    /**
     * ���������Ƿ����ĳ��Ԫ��
     * @param value
     * @return
     */
    public boolean contains(Integer value){
        return contains(value,this.root);
    }

    /**
     * ���������Ƿ����ĳ��Ԫ��
     * @param value
     * @param node
     * @return
     */
    public boolean contains(Integer value,BinaryNode node){
        if(node==null)
            return false;
        int compareResult=value.compareTo(node.getValue());

        if(compareResult==0){
            return true;
        }else if(compareResult<0){
            return contains(value,node.leftChild);
        }else {
            return contains(value,node.rightChild);
        }
    }

    public BinaryNode findMin(BinaryNode node){
        if(node==null)
            return null;
        else if(node.leftChild==null)
            return node;

        return findMin(node.leftChild);
    }

    /**
     * �������Ԫ��
     * @param node
     * @return
     */
    public BinaryNode findMax(BinaryNode node){

        BinaryNode current=node;
        BinaryNode parent=null;
        while(current!=null){
            parent=current;
            current=current.rightChild;
        }
        return parent;
    }

    /**
     * ��������
     * @param node
     */
    public void inOrder(BinaryNode node){
        if(node==null)
            return;
        inOrder(node.leftChild);
        System.out.println(node.getValue());
        inOrder(node.rightChild);
    }


    public static void main(String []args){
        RecursionTree tree=new RecursionTree();
        tree.insert(45);
        tree.insert(90);
        tree.insert(40);
        tree.insert(43);
        tree.insert(13);
        tree.insert(50);

        tree.inOrder(tree.root);

        System.out.println(tree.contains(41));

        tree.remove(40,tree.root);

        tree.inOrder(tree.root);
    }
    
}
