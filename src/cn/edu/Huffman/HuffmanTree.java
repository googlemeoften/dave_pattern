package cn.edu.Huffman;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/2
 */
public class HuffmanTree implements Comparable {

    private Node root;

    public HuffmanTree() {
        this.root = new Node();
    }

    public HuffmanTree(Node node) {
        this.root = node;
    }

    public HuffmanTree(char ch, int value) {
        this.root = new Node(ch, value);
    }

    public Node getRoot() {
        return root;
    }

    public HuffmanTree mergerTree(HuffmanTree tree) {
        Node leftChild = this.getRoot();
        Node rightChild = tree.getRoot();

        leftChild.setLeftChild(true);
        rightChild.setLeftChild(false);

        Node node = new Node(null, leftChild.getValue()+ rightChild.getValue());
        leftChild.parent = node;
        rightChild.parent = node;

        node.leftChild =leftChild;
        node.rightChild = rightChild;
        return new HuffmanTree(node);
    }

    @Override
    public int compareTo(Object o) {
        return root.compareTo(((HuffmanTree) o).getRoot());
    }


    public void preOrder(Node node){
        if(node==null)
            return;
        if(node.getCh()!=null){
            System.out.println(node);
        }
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }
}
