package undirectedGraph;

public class Edge implements Comparable<Edge> {
	/**
	 * The initial vertex of the <code>Edge</code>
	 */
	private Vertex firstVertex;
	/**
	 * The terminal vertex of the <code>Edge</code>
	 */
	private Vertex secondVertex;
	/**
	 * The distance of the <code>Edge</code>
	 */
	private Double distance;
	
	/**
	 * Construct a new <code>Edge</code> object with default properties
	 */
	public Edge() {
		
	}
	/**
	 * Construct a new <code>Edge</code> object with 
	 * the default id of vertex, the initial vertex, the terminal vertex, and the default distance
	 * @param initialVertex
	 * @param terminalVertex
	 */
	public Edge(Vertex firstVertex, Vertex secondVertex) {
		this.firstVertex = firstVertex;
		this.secondVertex = secondVertex;
		this.distance = Double.MAX_VALUE;
	}
	/**
	 * Construct a new <code>Edge</code> object with 
	 * the id of vertex, the initial vertex, the terminal vertex, and the distance
	 * @param id
	 * @param initialVertex
	 * @param terminalVertex
	 * @param distance
	 */
	public Edge(Vertex firstVertex, Vertex secondVertex, Double distance) {
		this.firstVertex = firstVertex;
		this.secondVertex = secondVertex;
		this.distance = distance;
		firstVertex.addNeighborEdge(this);
		firstVertex.addNeighborVertex(secondVertex);
		secondVertex.addNeighborEdge(this);
		secondVertex.addNeighborVertex(firstVertex);
	}
	
	public Edge(Edge edge) {
		this.firstVertex = edge.getFirstVertex();
		this.secondVertex = edge.getSecondVertex();
		this.distance = edge.getDistance();
	}
	/**
	 * Get the initial vertex of the <code>Edge</code>
	 * @return the initial vertex of the <code>Edge</code>
	 */
	public Vertex getFirstVertex() {
		return firstVertex;
	}
	/**
	 * Get the terminal vertex of the <code>Edge</code>
	 * @return the terminal vertex of the <code>Edge</code>
	 */
	public Vertex getSecondVertex() {
		return secondVertex;
	}
	/**
	 * Get the distance of the <code>Edge</code>
	 * @return the distance of the <code>Edge</code>
	 */
	public Double getDistance() {
		return distance;
	}
	/**
	 * Set the distance of the <code>Edge</code>
	 * @param distance
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public void free() {
		firstVertex.removeNeighborEdge(this);
		firstVertex.removeNeighborVertex(secondVertex);
		secondVertex.removeNeighborEdge(this);
		secondVertex.removeNeighborVertex(firstVertex);
		setDistance(Double.MAX_VALUE);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((firstVertex == null) ? 0 : firstVertex.hashCode());
		result = prime * result + ((secondVertex == null) ? 0 : secondVertex.hashCode());
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
		
		Edge other = (Edge) object;
		if (distance != other.getDistance())
			return false;
		
		if (firstVertex == null) {
			if (other.getFirstVertex() != null)
				return false;
		}
		else if (!firstVertex.equals(other.getFirstVertex()))
			return false;
		
		if (secondVertex == null) {
			if (other.getSecondVertex() != null)
				return false;
		}
		else if (!secondVertex.equals(other.getSecondVertex()))
			return false;		
		return true;
	}

	@Override
	public String toString() {
		return "Edge [firstVertex=" + firstVertex + ", secondVertex=" + secondVertex + 
				", distance=" + distance + "]";
	}

	@Override
	public int compareTo(Edge o) {
		int temp;
		
		if (distance < o.getDistance())
			return -1;
		else if (distance > o.getDistance())
			return 1;
		else if ((temp = firstVertex.compareTo(o.getFirstVertex())) != 0)
			return temp;
		else
			return secondVertex.compareTo(o.getSecondVertex());
	}
	
}
