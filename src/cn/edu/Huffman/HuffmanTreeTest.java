package cn.edu.Huffman;

import java.util.*;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/2
 */
public class HuffmanTreeTest {

    public static void main(String[] args) {

       // String str = "你若安好便是晴天,你们很好,你们很高兴吗？";
        String str="ABBCCCDDDDFFFFF";
        char[] chars = str.toCharArray();
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (maps.containsKey(chars[i])) {
                maps.put(chars[i], maps.get(chars[i]) + 1);
            } else {
                maps.put(chars[i], 1);
            }
        }

        Heap heap = new Heap(maps.size());
        List<HuffmanTree>trees=new ArrayList<>();

        Set<Character> keys = maps.keySet();
        for(Character key:keys){
            HuffmanTree tree= new HuffmanTree(key,maps.get(key));
            trees.add(tree);
            heap.insert(tree);
        }

        HuffmanTree tree=getHuffmanTree(heap);

       // tree.preOrder(tree.getRoot());
        StringBuilder builder=new StringBuilder();

        for(int i=0;i<trees.size();i++){
            StringBuilder sb=new StringBuilder();

            Node current = trees.get(i).getRoot();;
            do{
               if(current.isLeftChild())
                   sb.append("0");
                else
                   sb.append("1");
                current= current.parent;
            }while (current!=tree.getRoot());
            builder.append(sb.reverse().toString());
            System.out.println(sb.toString());
        }

        char[] codes=builder.toString().toCharArray();

        Node node =tree.getRoot();
        for(int i=0;i<codes.length;i++){

            if(codes[i]=='1')
                node = node.rightChild;
            else
                node = node.leftChild;

            if(node.getCh()!=null){
                System.out.println(node.getCh());
                node=tree.getRoot();
            }
        }





    }

    public static HuffmanTree getHuffmanTree(Heap heap) {

        HuffmanTree tree1 = null;
        HuffmanTree tree2 = null;

        HuffmanTree temp = null;

        while (heap.getTheSize() > 1) {
            tree1 = heap.remove();
            tree2 = heap.remove();
            temp = tree1.mergerTree(tree2);
            heap.insert(temp);
        }
        return heap.remove();
    }

}
