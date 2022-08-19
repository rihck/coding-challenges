package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Build Graph Structure and Represent the Following Graph (Undirected / Unweighted / Cyclic)
 * https://github.com/rihck/coding-challenges/blob/master/images/graphExample.png
 */
public class BuildOwnGraph {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex(new Vertex(0));
        myGraph.addVertex(new Vertex(1));
        myGraph.addVertex(new Vertex(2));
        myGraph.addVertex(new Vertex(3));
        myGraph.addVertex(new Vertex(4));
        myGraph.addVertex(new Vertex(5));
        myGraph.addVertex(new Vertex(6));
        myGraph.addEdge(new Vertex(3), new Vertex(1));
        myGraph.addEdge(new Vertex(3), new Vertex(4));
        myGraph.addEdge(new Vertex(4), new Vertex(2));
        myGraph.addEdge(new Vertex(4), new Vertex(5));
        myGraph.addEdge(new Vertex(1), new Vertex(2));
        myGraph.addEdge(new Vertex(1), new Vertex(0));
        myGraph.addEdge(new Vertex(0), new Vertex(2));
        myGraph.addEdge(new Vertex(6), new Vertex(5));

        myGraph.showConnections();
    }

    static class Graph{
        int nodesSize = 0;
        Map<Integer, List<Vertex>> adjacentList = new HashMap();

        void addVertex(Vertex vertex){
            adjacentList.put(vertex.value, new ArrayList<>());
            this.nodesSize++;
        }

        void addEdge(Vertex vertex1, Vertex vertex2){
            this.adjacentList.get(vertex1.value).add(vertex2);

            this.adjacentList.get(vertex2.value).add(vertex1);
        }

        void showConnections(){
            adjacentList.forEach((k, v) -> {
                System.out.println("Index: " + k + " ---> " + v);
            });
        }
    }

    static class Vertex {
        int value;

        public Vertex(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }

}
