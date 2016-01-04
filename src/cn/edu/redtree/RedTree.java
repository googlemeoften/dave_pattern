package cn.edu.redtree;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/2
 */
public class RedTree {

    /*
     *参考资料：http://blog.csdn.net/v_july_v/article/details/6105630
     *关于红黑数的操作：
     * 打破树平衡的情况：
     *      1、如果当前结点的父结点是红色且祖父结点的另一个子结点（叔叔结点）是红色
     *      2、当前节点的父节点是红色,叔叔节点是黑色，当前节点是其父节点的右子
     *      3、当前节点的父节点是红色,叔叔节点是黑色，当前节点是其父节点的左子
     * 解决方案：
     *      1、将当前节点的父节点和叔叔节点涂黑，祖父结点涂红，把当前结点指向祖父节点，从新的当前节点重新开始算法
     *      2、当前节点的父节点做为新的当前节点，以新当前节点为支点左旋。
     *      3、父节点变为黑色，祖父节点变为红色，在祖父节点为支点右旋
     */
    private Node root;
    private Node currentNode;

    public void insert(Integer value) {
        root = insert(value, root, root);


    }

    public Node insert(Integer value, Node parent, Node node) {
        if (node == null) {
            currentNode = node = new Node(value, parent, false);
            return node;
        }

        int result = value.compareTo(node.getValue());

        if (result < 0)
            node.leftChild = insert(value, node, node.leftChild);
        else if (result > 0)
            node.rightChild = insert(value, node, node.rightChild);

        return node;
    }

    /**
     * 调整树结构
     */
    public void adjustTree() {
        Node parent = currentNode.parent;
        Node grandNode = parent.parent;
        Node uncleNode;
        boolean isLeftChild = false;

        if (parent.leftChild == currentNode) {
            uncleNode = parent.parent.rightChild;
            isLeftChild = true;
        } else
            uncleNode = parent.parent.leftChild;
        while ((!parent.isBlack() && !uncleNode.isBlack()) || !parent.isBlack() && uncleNode.isBlack()) {

            if (!parent.isBlack() && !uncleNode.isBlack()) {
                fristSituation(parent, grandNode, uncleNode);
            }

            if (!parent.isBlack() && uncleNode.isBlack()) {
                if (!isLeftChild)
                    rotateWithLeftChild(parent, grandNode);
                else
                    rotateWithLeftChild(parent, grandNode);
            }
        }


    }

    /**
     * 第一种情况：父节点和叔叔节点都是红色
     */
    public void fristSituation(Node parent, Node grandNode, Node uncleNode) {

        parent.setBlack(true);
        uncleNode.setBlack(true);
    }

    /**
     * 第二种情况：父节点红色，叔叔节点黑色
     */
    public void secondSituation(Node parent, Node grandNode, Node uncleNode) {

    }

    /**
     * 向左旋
     *
     * @return
     */
    public void rotateWithLeftChild(Node parent, Node grandNode) {
        Node k1 = currentNode.leftChild;

        k1.parent = parent;
        parent.rightChild = k1;
        parent = currentNode.leftChild;
        parent.parent = currentNode;
        if (grandNode != null) {
            grandNode.leftChild = currentNode;
            currentNode.parent = grandNode;
        }
    }

    /**
     * 向右旋
     *
     * @return
     */
    public void rotateWithRightChild(Node parent, Node grandNode) {
        Node k1 = currentNode.rightChild;

        k1.parent = parent;
        parent.leftChild = k1;

        parent.parent = currentNode;
        currentNode.rightChild = parent;

        if (grandNode != null) {
            grandNode.leftChild = currentNode;
            currentNode.parent = grandNode;
        }
    }

    public void preOrder(Node node) {
        if (node == null)
            return;
        else {
            System.out.println(node);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public static void main(String[] args) {
        RedTree tree = new RedTree();
        tree.insert(30);
        tree.insert(40);
        tree.insert(25);
        tree.insert(20);
        tree.insert(21);
        tree.preOrder(tree.root);
    }

}
