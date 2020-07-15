package orientedGraph;

import java.util.*;

public class Graph{
	/**
	 * Vertices of the <code>Graph</code>
	 */
	private LinkedList<Vertex> vertices;
	/**
	 * Edges of the <code>Graph</code>
	 */
	private LinkedList<Edge> edges;
	
	/**
	 * Construct a new <code>Graph</code> object with a list of vertices and a list of edges
	 */
	public Graph() {
		this.vertices = new LinkedList<Vertex>();
		this.edges = new LinkedList<Edge>();
	}
	/**
	 * Get the list of vertices of the <code>Graph</code>
	 * @return the list of vertices of the <code>Graph</code>
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}
	/**
	 * Get the list of edges of the <code>Graph</code>
	 * @return the list of edges of the <code>Graph</code>
	 */
	public List<Edge> getEdges() {
		return edges;
	}
	/**
	 * Set the list of vertices of the <code>Graph</code>
	 * @param vertices
	 */
	public void setVertices(List<Vertex> vertices) {
		this.vertices.addAll(vertices);
	}
	/**
	 * Set the list of edges of the <code>Graph</code>
	 * @param edges
	 */
	public void setEdges(List<Edge> edges) {
		this.edges.addAll(edges);
	}
	/**
	 * Get the shortest path between the departure and the arrival by Dijkstra algorithm
	 * @param departure
	 * @param arrival
	 */
	public void getTheShortestPath(Vertex departure, Vertex arrival) {
		if (departure.equals(arrival)) { // The departure and the arrival is the same
			System.out.println("The departure " + departure.getID() + " and the arrival " + 
			                    arrival.getID() + " is the same!");
			return;
		}
		try {
			// Restore distances from departure to every vertex
			final Map<Vertex, Double> distances = new HashMap<Vertex, Double>();
			// Restore previous vertex in the path
			final Map<Vertex, Vertex> previousVertices = new HashMap<Vertex, Vertex>();
			// Restore distances from departure to every vertex
			PriorityQueue<Edge> nodes = new PriorityQueue<Edge>();
			boolean isAccessible = false;
			
			// Initialize distances, nodes, previous
			// Set distance from vertices to itself to 0, and others to Integer.Max_VALUE
			for (Vertex vertex: vertices) { // Traversal all Vertices
				Edge temp = new Edge(vertex, arrival);
				if (vertex.equals(departure)) {
					distances.put(vertex, 0.0);
					temp.setDistance(0.0);
					nodes.add(temp);
				}
				else {
					distances.put(vertex, Double.MAX_VALUE);
					nodes.add(temp);
				}
				// Put null as value and id of every vertex as key to previous
				previousVertices.put(vertex, null); // null -> vertex
			}
			
			while (!nodes.isEmpty()) {
				// Get the initial vertex(edge contains) of shortest distance from departure vertex
				Edge smallest = nodes.poll();
				
				if (smallest.getInitialVertex().equals(arrival) // Get the shortest path
						&& smallest.getDistance() != Double.MAX_VALUE) { // Is accessible
					final ArrayDeque<Vertex> path = new ArrayDeque<Vertex>();
					isAccessible = true;
					
					path.addFirst(smallest.getInitialVertex());
					Vertex previousVertex = previousVertices.get(smallest.getInitialVertex());
					
					while (previousVertices.get(previousVertex) != null) {
						path.addFirst(previousVertex);
						previousVertex = previousVertices.get(previousVertex); // Update previousVertex
					}
					printTheShortestPath(path, distances, departure, arrival);
					
					return;
				}
				
				if (distances.get(smallest.getInitialVertex()) == Double.MAX_VALUE) // Inaccessible
					break;
				
				// Traverse outVertices of the current smallest
				for (Vertex outVertex: smallest.getInitialVertex().getOutVertices()) {
					Double alt = distances.get(smallest.getInitialVertex()) + 
							outVertex.getDistance(smallest.getInitialVertex());
					if (alt < distances.get(outVertex)) { // Get a shorter path
						distances.put(outVertex, alt); // Update distances
						previousVertices.put(outVertex, smallest.getInitialVertex()); // Update previousVertices
						
						loop:
						for(Edge edge : nodes) { // Update nodes
							if (edge.getInitialVertex() == outVertex) {
								nodes.remove(edge);
								edge.setDistance(alt);
								nodes.add(edge);
								break loop; // Save running time
							}
						}
					}
				}
			}
			
			if (!isAccessible)
				System.out.println("There is no accessible path from " + departure.getID() + " to " + 
			                        arrival.getID() + "!");
			} catch (NullPointerException ex) {
				System.out.println("There is no accessible path from " + departure.getID() + " to " + 
                                    arrival.getID() + "!");
		}
	}
	/**
	 * Print the shortest path
	 * @param path
	 * @param distances
	 * @param departure
	 * @param arrival
	 */
	private static void printTheShortestPath(
			Deque<Vertex> path, Map<Vertex, Double> distances, Vertex departure, Vertex arrival) {
		System.out.print("The shortest path from " + departure.getID() + " to " + arrival.getID() + " is: " + 
	                      departure.getID());
		
		while (!path.isEmpty())
			System.out.print(" -> " + path.removeFirst().getID());
		
		System.out.println(".");
		System.out.println("And the smallest distance is " + distances.get(arrival) + ".");
	}

}
