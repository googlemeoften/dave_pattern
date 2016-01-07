package cn.edu.graph.dijkstra;

import cn.edu.graph.Queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/7
 */
public class Dijkstra {
    private static final int INFINITY = 999999;

    private Vertex[] vertexs;

    //节点个数
    private int theSize;

    public Dijkstra(int size) {
        this.theSize = 0;
        vertexs = new Vertex[size];
    }

    public void addVertex(String label) {
        vertexs[theSize++] = new Vertex(label);
    }

    //添加边
    public void addEdge(int start, int end, int weight) {
        vertexs[start - 1].addEdge(weight, vertexs[end - 1]);
    }

    /**
     * 最短路径查找
     *
     * @param source
     * @param target
     */
    public void dijkstra(int source, int target) {
        Vertex s = vertexs[source - 1];
        s.distance = 0;

        Queue queue = new Queue();

        queue.enQueue(s);

        while (!queue.isEmpty()) {
            Vertex temp = (Vertex) queue.deQueue();
            Edge minEdge = getMin(temp);
            temp.isInTree = true;
            if (minEdge == null)
                break;
            queue.enQueue(minEdge.vertex);

        }
        print(target);
    }


    public void print(int index) {
        Vertex target = vertexs[index - 1];

        while (true) {
            System.out.println(target.label);
            target = target.parent;
            if (target == null)
                break;
        }
    }

    /**
     * 返回最小的边
     *
     * @param vertex
     * @return
     */
    public Edge getMin(Vertex vertex) {

        int minDistance = INFINITY;
        Edge minEdge = null;

        Edge temp = null;
        Iterator<Edge> it = vertex.edgeList.iterator();

        while (it.hasNext()) {
            temp = it.next();

            if (temp.weight < minDistance) {
                minDistance = temp.weight;
                minEdge = temp;
            }

            if (temp.weight < temp.vertex.distance) {
                temp.vertex.distance = temp.weight + vertex.distance;
                temp.vertex.parent = vertex;
            }
        }
        return minEdge;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(7);
        dijkstra.addVertex("v1");
        dijkstra.addVertex("v2");
        dijkstra.addVertex("v3");
        dijkstra.addVertex("v4");
        dijkstra.addVertex("v5");
        dijkstra.addVertex("v6");
        dijkstra.addVertex("v7");

        dijkstra.addEdge(1, 2, 2);
        dijkstra.addEdge(1, 4, 1);
        dijkstra.addEdge(2, 4, 3);
        dijkstra.addEdge(2, 5, 10);

        dijkstra.addEdge(3, 6, 5);
        dijkstra.addEdge(4, 3, 2);
        dijkstra.addEdge(4, 6, 8);
        dijkstra.addEdge(4, 7, 4);

        dijkstra.addEdge(4, 5, 2);
        dijkstra.addEdge(5, 7, 6);
        dijkstra.addEdge(7, 6, 1);

        dijkstra.dijkstra(1, 6);
    }

    private class Vertex {

        protected String label;
        //判断该节点是否已经被访问过
        protected boolean isInTree;
        //从s到该点的最短路径
        protected int distance;
        //最短路径中的前趋
        protected Vertex parent;
        //表示从该点出度的所有边
        protected List<Edge> edgeList;


        public Vertex(String label) {
            this.label = label;
            this.isInTree = false;
            this.distance = INFINITY;
            this.edgeList = new ArrayList<>(4);
        }

        public void addEdge(int weight, Vertex vertex) {
            this.edgeList.add(new Edge(weight, vertex));
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label='" + label + '\'' +
                    ", isInTree=" + isInTree +
                    ", distance=" + distance +
                    ", parent=" + parent +
                    '}';
        }
    }

    private class Edge {
        //权
        protected int weight;
        //边的后继节点
        protected Vertex vertex;

        public Edge(int weight, Vertex vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", vertex=" + vertex +
                    '}';
        }
    }

}
