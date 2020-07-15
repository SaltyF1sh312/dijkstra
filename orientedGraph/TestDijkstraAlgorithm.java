package orientedGraph;

import java.util.*;

public class TestDijkstraAlgorithm {
	
	public static void main(String[] args) {
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		Vertex v6 = new Vertex("v6");
		Vertex v7 = new Vertex("v7");
		Vertex v8 = new Vertex("v8");
		Vertex v9 = new Vertex("v9");
		
		Edge e1 = new Edge(v1, v2, 6.0);
		Edge e2 = new Edge(v1, v3, 3.0);
		Edge e3 = new Edge(v1, v4, 1.0);
		Edge e4 = new Edge(v2, v5, 1.0);
		Edge e5 = new Edge(v3, v2, 2.0);
		Edge e6 = new Edge(v3, v4, 2.0);
		Edge e7 = new Edge(v4, v6, 10.0);
		Edge e8 = new Edge(v5, v4, 6.0);
		Edge e9 = new Edge(v5, v6, 4.0);
		Edge e10 = new Edge(v5, v7, 3.0);
		Edge e11 = new Edge(v5, v8, 6.0);
		Edge e12 = new Edge(v6, v5, 10.0);
		Edge e13 = new Edge(v6, v7, 2.0);
		Edge e14 = new Edge(v7, v8, 4.0);
		Edge e15 = new Edge(v9, v5, 2.0);
		Edge e16 = new Edge(v9, v8, 3.0);
		
		Graph graph = new Graph();
		
		graph.setVertices(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9));
		graph.setEdges(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16));
		
		graph.getTheShortestPath(v1, v8);
		graph.getTheShortestPath(v1, v6);
		graph.getTheShortestPath(v4, v8);
		graph.getTheShortestPath(v1, v1);
		graph.getTheShortestPath(v8, v1);
		graph.getTheShortestPath(v1, new Vertex());
	}

}
