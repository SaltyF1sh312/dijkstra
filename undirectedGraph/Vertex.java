package undirectedGraph;

import java.util.*;

public class Vertex implements Comparable<Vertex> {
	/**
	 * The id of the <code>Vertex</code>
	 */
	private String id;
	/**
	 * The neighbor vertices of the <code>Vertex</code>
	 */
	private List<Vertex> neighborVertices;
	/**
	 * The neighbor edges of the <code>Vertex</code>
	 */
	private List<Edge> neighborEdges;
	
	/**
	 * Construct a new <code>Vertex</code> object with default properties
	 */
	public Vertex() {
		neighborVertices = new LinkedList<Vertex>();
		neighborEdges = new ArrayList<Edge>();
	}
	/**
	 * Construct a new <code>Vertex</code> object
	 * @param id
	 * @param demand the demand of the <code>Vertex</code> 
	 */
	public Vertex(String id) {
		this.id = id;
		neighborVertices = new LinkedList<Vertex>();
		neighborEdges = new ArrayList<Edge>();
	}	
	/**
	 * Get the id of the <code>Vertex</code>
	 * @return the id of the <code>Vertex</code>
	 */
	public String getID() {
		return id;
	}
	/**
	 * Get the neighbor vertices of the <code>Vertex</code>
	 * @return the neighbor vertices of the <code>Vertex</code>
	 */
	public List<Vertex> getNeighborVertices() {
		return neighborVertices;
	}
	/**
	 * Get the neighbor edges of the <code>Vertex</code>
	 * @return the neighbor edges of the <code>Vertex</code>
	 */
	public List<Edge> getNeighborEdges() {
		return neighborEdges;
	}
	/**
	 * Set the id of the <code>Vertex</code>
	 * @param id
	 */
	public void setID(String id) {
		this.id = id;
	}
	/**
	 * Get the number of neighborVertices of the <code>Vertex</code>
	 * @return the number of neighborVertices of the <code>Vertex</code>
	 */
	public int getNumberOfNeighborVertices() {
		return neighborVertices.size();
	}
	/**
	 * Get the number of neighborEdges of the <code>Vertex</code>
	 * @return the number of neighborEdges of the <code>Vertex</code>
	 */
	public int getNumberOfNeighborEdges() {
		return neighborEdges.size();
	}
	/**
	 * Get distance between another <code>Vertex</code> and the current <code>Vertex</code>
	 * @param anotherVertex
	 * @return the distance between another vertex and this
	 */
	public Double getDistance(Vertex anothervertex) {
		Double distance = Double.MAX_VALUE; // Inaccessible default
		loop:
		for (Edge edge: neighborEdges) { // Traversal inEdges
			if (anothervertex.equals(edge.getFirstVertex()) || anothervertex.equals(edge.getSecondVertex())) {
				distance = edge.getDistance();
				break loop; // Save running time;
			}
		}
		
		return distance;		
	}
	/**
	 * Add a neighbor vertex to the current <code>Vertex</code>
	 * @param neighborVertex
	 */
	protected void addNeighborVertex(Vertex neighborVertex) {
		if (!neighborVertices.contains(neighborVertex)) {
			neighborVertices.add(neighborVertex);
		}
	}
	/**
	 * Add a neighbor edge to the current <code>Vertex</code>
	 * @param neighborEdge
	 */
	protected void addNeighborEdge(Edge neighborEdge) {
		if (!neighborEdges.contains(neighborEdge))
			neighborEdges.add(neighborEdge);
	}
	
	protected void removeNeighborVertex(Vertex neighborVertex) {
		if (neighborVertices.contains(neighborVertex))
			neighborVertices.remove(neighborVertex);
	}
	
	protected void removeNeighborEdge(Edge neighborEdge) {
		if (neighborEdges.contains(neighborEdge))
			neighborEdges.remove(neighborEdge);
	}
	
	public void free() {
		for (int i = 0; i < neighborEdges.size(); i++)
			neighborEdges.get(i).free();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		
		Vertex other = (Vertex) object;
		if (id == null) {
			if (other.getID() != null)
				return false;
		}
		else if (!id.equals(other.getID()))
			return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Vertex [id=" + id + "]";
	}
	
	@Override
	public int compareTo(Vertex o) {
		return id.compareTo(o.getID());
	}
	
}
