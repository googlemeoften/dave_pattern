package cn.edu.graph.topo;

import cn.edu.graph.Queue;

import java.util.LinkedList;

/**
 * @Description:拓扑排序是对有向无圈图的顶点的一种排序 method: 找到任意一个没有入边的顶点
 * @Author:Hey
 * @Date:2016/1/4
 */
public class TopoSort {

    private Vertex[] vertexs;
    private int theSize;

    public TopoSort(int size) {
        this.theSize = 0;
        vertexs = new Vertex[size];
    }

    public void addVertex(String label) {
        vertexs[theSize++] = new Vertex(label);
    }

    /**
     * 点start到end可达
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        vertexs[end - 1].inDegree++;
        vertexs[start - 1].add(vertexs[end - 1]);
    }

    public void topoSort() {
        Vertex vertex = getZoro();
        Queue queue = new Queue();
        queue.enQueue(vertex);

        while (!queue.isEmpty()) {
            vertex = (Vertex) queue.deQueue();
           // if (vertex != null) {
                vertex.decDegree();
                Vertex zoro=getZoro();
                if(zoro !=null)
                    queue.enQueue(zoro);
                System.out.println(vertex.label);
           // }
        }
    }

    /**
     * 获得入度为零的节点
     *
     * @return
     */
    private Vertex getZoro() {
        for (int i = 0; i < theSize; i++) {
            if (vertexs[i].inDegree == 0 && vertexs[i].isVisited == false) {
                vertexs[i].isVisited = true;
                return vertexs[i];
            }
        }
        return null;
    }

    private class Vertex {
        protected String label;
        protected int inDegree;//入度
        protected boolean isVisited;
        protected LinkedList<Vertex> vList;

        public Vertex(String label) {
            inDegree = 0;
            this.label = label;
            isVisited = false;
            vList = new LinkedList<>();
        }

        public void add(Vertex vertex) {
            vList.add(vertex);
        }

        public Vertex getVertx() {
            return vList.getFirst();
        }

        public void decDegree() {
            if (vList.size() > 0)
                for (Vertex v : vList) {
                    v.inDegree--;
                }
        }

        public Vertex remove() {
            return vList.remove();
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "inDegree=" + inDegree +
                    ", label='" + label + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        TopoSort topoSort = new TopoSort(7);
        topoSort.addVertex("v1");
        topoSort.addVertex("v2");
        topoSort.addVertex("v3");
        topoSort.addVertex("v4");
        topoSort.addVertex("v5");
        topoSort.addVertex("v6");
        topoSort.addVertex("v7");

        topoSort.addEdge(1, 2);
        topoSort.addEdge(1, 3);
        topoSort.addEdge(1, 4);
        topoSort.addEdge(2, 4);
        topoSort.addEdge(2, 5);
        topoSort.addEdge(3, 6);
        topoSort.addEdge(4, 3);
        topoSort.addEdge(4, 6);
        topoSort.addEdge(4, 7);
        topoSort.addEdge(5, 4);
        topoSort.addEdge(5, 7);
        topoSort.addEdge(7, 6);

        topoSort.topoSort();
    }
}
