package cn.edu.Huffman;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/4
 */
public class Stack {

    private Node[] nodes;
    private int theSize;

    public Stack(int theSize) {
        theSize = 0;
        this.theSize = theSize;
    }

    public boolean push(Node node) {
        if (theSize >= nodes.length)
            return false;
        nodes[theSize++] = node;
        return true;
    }

    public Node pop() {
        if (theSize <= 0)
            return null;
        return nodes[--theSize];
    }

    public Node peek() {
        if (theSize == 0)
            return null;
        return nodes[theSize - 1];
    }

    public String getCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < theSize; i++) {
            sb.append(nodes[i].getCh());
        }
        return sb.toString();
    }

}
