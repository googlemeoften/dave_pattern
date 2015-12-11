package cn.edu.avltree;

/**
 * Description:平衡二叉树
 * Author: Hey
 * Date: 2015/12/11
 */
public class AVLTree {

    private AVLNode root;

    public void insert(Integer value){
        root=insert(value,root);
    }

    private AVLNode insert(Integer value,AVLNode node){
        if(node==null)
            return new AVLNode(value);

        int compareResult=value.compareTo(node.value);

        if (compareResult<0){
            node.leftChild=insert(value,node.leftChild);

            if(height(node.leftChild)-height(node.rightChild)==2){
                if((value-node.leftChild.value)<0){
                    node=rotateWithLeftChild(node);
                }else {
                    node=doubleWithLeftChild(node);
                }
            }
        }else if(compareResult>0){
            node.rightChild=insert(value,node.rightChild);
            if(height(node.rightChild)-height(node.leftChild)==2){
                if((value-node.rightChild.value)>0){
                    node=rotateWithRightChild(node);
                }else {
                    if(value==15)
                        System.out.print(node);
                    node=doubleWithRightChild(node);
                }
            }
        }

        node.height=Math.max(height(node.leftChild), height(node.rightChild))+1;
        return node;
    }

    /**
     * 左旋
     * @param k2
     * @return
     */
    public AVLNode rotateWithLeftChild(AVLNode k2){
        AVLNode k1=k2.leftChild;
        k2.leftChild=k1.rightChild;
        k1.rightChild=k2;
        k2.height=Math.max(height(k2.leftChild),height(k2.rightChild))+1;
        k1.height=Math.max(height(k1.leftChild),height(k1.rightChild))+1;
        return k1;
    }

    /**
     * 右旋
     * @param k2
     * @return
     */
    public AVLNode rotateWithRightChild(AVLNode k2){
        AVLNode k1= k2.rightChild;
        k2.rightChild=k1.leftChild;
        k1.leftChild=k2;
        k2.height=Math.max(height(k2.leftChild),height(k2.rightChild))+1;
        k1.height=Math.max(height(k1.leftChild),height(k1.rightChild))+1;
        return k1;
    }

    /**
     * 左双旋
     * @param k3
     * @return
     */
    public AVLNode doubleWithLeftChild(AVLNode k3){
        k3.leftChild=rotateWithRightChild(k3.leftChild);
        return rotateWithLeftChild(k3);
    }

    /**
     * 右双旋
     * @param k3
     * @return
     */
    public AVLNode doubleWithRightChild(AVLNode k3){
        k3.rightChild=rotateWithLeftChild(k3.rightChild);
        return rotateWithRightChild(k3);
    }


    public void preOrder(AVLNode node){
        if(node==null)
            return;

        System.out.println(node);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    public int height(AVLNode node) {
        return node==null?-1:node.height;
    }

    public static void main(String [] args){
        AVLTree tree=new AVLTree();
//        tree.insert(45);
//        tree.insert(90);
//        tree.insert(40);
//        tree.insert(43);
//        tree.insert(13);
//        tree.insert(50);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(16);
        tree.insert(15);
        tree.insert(14);
        tree.insert(13);
        tree.insert(12);
        tree.insert(11);
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);

        tree.preOrder(tree.root);
    }

    private static class AVLNode {
        int value;
        int height;
        AVLNode leftChild;
        AVLNode rightChild;

        public AVLNode(Integer value){this(value, null, null);}
        public AVLNode(Integer value,AVLNode leftChild,AVLNode rightChild){
            this.value=value;
            this.leftChild=leftChild;
            this.rightChild=rightChild;
        }

        @Override
        public String toString() {
            return "AVLNode{" +
                    "value=" + value +
                    ", height=" + height +
                    '}';
        }
    }
}

