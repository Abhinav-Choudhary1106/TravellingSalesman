package christofides;

import java.util.Objects;

public class Edge {
	public Node u;
    public Node v;
    public double weight;
    public Edge(Node u, Node v) {
        this.u = u;
        this.v = v;
        weight = computeWeight();
    }
    
    public double getEdgeWeight() {
    	return this.weight;
    }

    public int compareWeightTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }
    
    public Node getUEdge() {
    	return this.u;
    }
    
    public Node getVEdge() {
    	return this.v;
    }

    // Euclidean distance calculation
    private double computeWeight() {
        // Return infinite weight if nodes are null
        if(Objects.isNull(u) || Objects.isNull(v)) return Integer.MAX_VALUE;
        return latLonDistance();
    }

    // Calculate distance between two points in latitude and longitude.
    private double latLonDistance() {
        final double R = 6371.0; // Radius of the earth

        double latDistance = Math.toRadians(v.x - u.x);
        double lonDistance = Math.toRadians(v.y - u.y);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(u.x)) * Math.cos(Math.toRadians(v.x))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }
}