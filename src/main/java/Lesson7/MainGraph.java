/*
 *       Created by Alexander on 22/04/2020
 */

package Lesson7;

public class MainGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(7,8);
        graph.addEdge(4,7);
        graph.addEdge(8,3);
        graph.addEdge(8,9);
        graph.addEdge(9,1);
        graph.addEdge(4,9);
        graph.addEdge(2,5);
        graph.addEdge(6,9);

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.findDist(9));
        System.out.println(bfp.findDist(5));
    }
}
