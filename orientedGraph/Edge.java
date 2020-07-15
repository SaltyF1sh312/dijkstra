package orientedGraph;

public class Edge implements Comparable<Edge> {
	/**
	 * The initial vertex of the <code>Edge</code>
	 */
	private Vertex initialVertex;
	/**
	 * The terminal vertex of the <code>Edge</code>
	 */
	private Vertex terminalVertex;
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
	public Edge(Vertex initialVertex, Vertex terminalVertex) {
		this.initialVertex = initialVertex;
		this.terminalVertex = terminalVertex;
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
	public Edge(Vertex initialVertex, Vertex terminalVertex, Double distance) {
		this.initialVertex = initialVertex;
		this.terminalVertex = terminalVertex;
		this.distance = distance;
		initialVertex.addOutVertex(terminalVertex);
		initialVertex.addOutEdge(this);
		terminalVertex.addInVertex(initialVertex);
		terminalVertex.addInEdge(this);
	}
	/**
	 * Get the initial vertex of the <code>Edge</code>
	 * @return the initial vertex of the <code>Edge</code>
	 */
	public Vertex getInitialVertex() {
		return initialVertex;
	}
	/**
	 * Get the terminal vertex of the <code>Edge</code>
	 * @return the terminal vertex of the <code>Edge</code>
	 */
	public Vertex getTerminalVertex() {
		return terminalVertex;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((initialVertex == null) ? 0 : initialVertex.hashCode());
		result = prime * result + ((terminalVertex == null) ? 0 : terminalVertex.hashCode());
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
		
		if (initialVertex == null) {
			if (other.getInitialVertex() != null)
				return false;
		}
		else if (!initialVertex.equals(other.getInitialVertex()))
			return false;
		
		if (terminalVertex == null) {
			if (other.getTerminalVertex() != null)
				return false;
		}
		else if (!terminalVertex.equals(other.getTerminalVertex()))
			return false;		
		return true;
	}

	@Override
	public String toString() {
		return "Edge [initialVertex=" + initialVertex + ", terminalVertex=" + terminalVertex + 
				", distance=" + distance + "]";
	}

	@Override
	public int compareTo(Edge o) {
		int temp;
		
		if (distance < o.getDistance())
			return -1;
		else if (distance > o.getDistance())
			return 1;
		else if ((temp = initialVertex.compareTo(o.getInitialVertex())) != 0)
			return temp;
		else
			return terminalVertex.compareTo(o.getTerminalVertex());
	}
	
}
