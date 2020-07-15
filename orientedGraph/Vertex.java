package orientedGraph;

import java.util.*;

public class Vertex implements Comparable<Vertex> {
	/**
	 * The id of the <code>Vertex</code>
	 */
	private String id;
	/**
	 * The in vertices of the <code>Vertex</code>
	 */
	private List<Vertex> inVertices;
	/**
	 * The out vertices of the <code>Vertex</code>
	 */
	private List<Vertex> outVertices;
	/**
	 * The in edges of the <code>Vertex</code>
	 */
	private List<Edge> inEdges;
	/**
	 * The out edges of the <code>Vertex</code>
	 */
	private List<Edge> outEdges;
	
	/**
	 * Construct a new <code>Vertex</code> object with default properties
	 */
	public Vertex() {
		inVertices = new LinkedList<Vertex>();
		outVertices = new LinkedList<Vertex>();
		inEdges = new LinkedList<Edge>();
		outEdges = new LinkedList<Edge>();
	}
	/**
	 * Construct a new <code>Vertex</code> object
	 * @param id
	 * @param demand the demand of the <code>Vertex</code> 
	 */
	public Vertex(String id) {
		this.id = id;
		inVertices = new LinkedList<Vertex>();
		outVertices = new LinkedList<Vertex>();
		inEdges = new LinkedList<Edge>();
		outEdges = new LinkedList<Edge>();
	}	
	/**
	 * Get the id of the <code>Vertex</code>
	 * @return the id of the <code>Vertex</code>
	 */
	public String getID() {
		return id;
	}
	/**
	 * Get the in vertices of the <code>Vertex</code>
	 * @return the in vertices of the <code>Vertex</code>
	 */
	public List<Vertex> getInVertices() {
		return inVertices;
	}
	/**
	 * Get the out vertices of the <code>Vertex</code>
	 * @return the out vertices of the <code>Vertex</code>
	 */
	public List<Vertex> getOutVertices() {
		return outVertices;
	}
	/**
	 * Get the in edges of the <code>Vertex</code>
	 * @return the in edges of the <code>Vertex</code>
	 */
	public List<Edge> getInEdges() {
		return inEdges;
	}
	/**
	 * Get the out edges of the <code>Vertex</code>
	 * @return the out edges of the <code>Vertex</code>
	 */
	public List<Edge> getOutEdges() {
		return outEdges;
	}
	/**
	 * Set the id of the <code>Vertex</code>
	 * @param id
	 */
	public void setID(String id) {
		this.id = id;
	}
	/**
	 * Get the number of inVertices of the <code>Vertex</code>
	 * @return the number of inVertices of the <code>Vertex</code>
	 */
	public int getNumberOfInVertices() {
		return inVertices.size();
	}
	/**
	 * Get the number of outVertices of the <code>Vertex</code>
	 * @return the number of outVertices of the <code>Vertex</code>
	 */
	public int getNumberOfOutVertices() {
		return outVertices.size();
	}
	/**
	 * Get the number of inEdges of the <code>Vertex</code>
	 * @return the number of inEdges of the <code>Vertex</code>
	 */
	public int getNumberOfinEdges() {
		return inEdges.size();
	}
	/**
	 * Get the number of OutEdges of the <code>Vertex</code>
	 * @return the number of OutEdges of the <code>Vertex</code>
	 */
	public int getNumberOfOutEdges() {
		return outEdges.size();
	}
	/**
	 * Get distance between another <code>Vertex</code> and the current <code>Vertex</code>
	 * @param anotherVertex
	 * @return the distance between another vertex and this
	 */
	public Double getDistance(Vertex anothervertex) {
		boolean hasVertex = false;
		Double distance = Double.MAX_VALUE;
		
		loopForInVertices:
		for (Edge edge: inEdges) { // Traversal inEdges
			if (anothervertex.equals(edge.getInitialVertex())) {
				hasVertex = true;
				distance = edge.getDistance();
				break loopForInVertices; // Save running time;
			}
		}
			
		if (!hasVertex) {
			loopForOutVertices:
			for (Edge edge: outEdges) { // Traversal outEdges
				if (anothervertex.equals(edge.getTerminalVertex())) {
					hasVertex = true;
					distance = edge.getDistance();
					break loopForOutVertices; // Save running time
				}
			}
		}
		
		return distance;		
	}
	/**
	 * Add an in vertex to the current <code>Vertex</code>
	 * @param inVertex
	 */
	public void addInVertex(Vertex inVertex) {
		if (!inVertices.contains(inVertex))
			inVertices.add(inVertex);
	}
	/**
	 * Add a out vertex to the current <code>Vertex</code>
	 * @param outVertex
	 */
	public void addOutVertex(Vertex outVertex) {
		if (!outVertices.contains(outVertex))
			outVertices.add(outVertex);
	}
	/**
	 * Add an in edge to the current <code>Vertex</code>
	 * @param inEdge
	 */
	public void addInEdge(Edge inEdge) {
		if (!inEdges.contains(inEdge))
			inEdges.add(inEdge);
	}
	/**
	 * Add a out edge to the current <code>Vertex</code>
	 * @param outEdge
	 */
	public void addOutEdge(Edge outEdge) {
		if (!outEdges.contains(outEdge))
			outEdges.add(outEdge);
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
