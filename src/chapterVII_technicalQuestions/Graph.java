package chapterVII_technicalQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
	List<Vertx> vertx;
	List<Edge> edges;
	int[] distnaces;
	
	Graph(){
		vertx = new ArrayList<Vertx>();
		edges = new ArrayList<Edge>();
	}
	
	public void addVertx(Vertx v) {
		vertx.add(v);
	}
	
	public void addEdge(Vertx v1, Vertx v2, int weight) {
		edges.add(new Edge(v1, v2, weight));
	}
	
	public int shortestPath(Vertx source, Vertx destination) {
		DijkstraShortestPaths dsp = new DijkstraShortestPaths(this);
		return dsp.shortestPath(source, destination);
		
	}

	public List<Vertx> getVertx() {
		return vertx;
	}

	public void setVertx(List<Vertx> vertx) {
		this.vertx = vertx;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public int[] getDistnaces() {
		return distnaces;
	}

	public void setDistnaces(int[] distnaces) {
		this.distnaces = distnaces;
	}

	public static void main(String[] args) {
		Vertx v1 = new Vertx(1);
		Vertx v2 = new Vertx(2);
		Vertx v3 = new Vertx(3);
		Vertx v4 = new Vertx(4);
		Vertx v5 = new Vertx(5);
		Vertx v6 = new Vertx(6);
		Vertx v7 = new Vertx(7);
		
		Graph g = new Graph();
		g.addVertx(v1);
		g.addVertx(v2);
		g.addVertx(v3);
		g.addVertx(v4);
		g.addVertx(v5);
		g.addVertx(v6);
		g.addVertx(v7);
		
		g.addEdge(v1, v2, 5);
		g.addEdge(v1, v3, 10);
		g.addEdge(v2, v4, 6);
		g.addEdge(v2, v5, 3);
		g.addEdge(v3, v5, 2);
		g.addEdge(v4, v5, 2);
		g.addEdge(v4, v6, 6);
		g.addEdge(v5, v7, 2);
		g.addEdge(v6, v7, 2);
		
		int distance = g.shortestPath(v1, v6);
		
		System.out.println("The minimum distance is: " + distance);
	}
}

class Edge {
	Vertx v1;
	Vertx v2;
	int weight;
	
	Edge(Vertx v1, Vertx v2, int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public Vertx getV1() {
		return v1;
	}

	public void setV1(Vertx v1) {
		this.v1 = v1;
	}

	public Vertx getV2() {
		return v2;
	}

	public void setV2(Vertx v2) {
		this.v2 = v2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}	
}

class Vertx {
	int value;
	
	Vertx (int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}	
}

class DijkstraShortestPaths {
	
	HashMap<Vertx, Integer> distances;
	HashMap<Vertx, Vertx> previous;
	List<Vertx> unsettled;
	List<Vertx> completed;
	Graph graph;
	
	public DijkstraShortestPaths(Graph g) {
		this.graph = g;
		distances = new HashMap<Vertx, Integer>();
		previous = new HashMap<Vertx, Vertx>();

		for(Vertx v: graph.getVertx()) {
			distances.put(v, Integer.MAX_VALUE);
		}
		
		unsettled = new ArrayList<Vertx>();
		completed = new ArrayList<Vertx>();
	}
	
	public int shortestPath(Vertx source, Vertx destination) {

		distances.replace(source, 0);
		unsettled.add(source);
		
		while(!unsettled.isEmpty()) {
			Vertx nextV = minimumDistanceOnTable();
			getDistances(nextV);
			completed.add(nextV);
			unsettled.remove(nextV);
		}
		
		Vertx v = destination;
		StringBuilder sb = new StringBuilder();
		
		while(previous.containsKey(v) ) {
		sb.append(v.getValue());
			sb.append(" > ");
			v = previous.get(v);
		}
		sb.append(source.getValue());
		
		System.out.println(sb.reverse().toString());
		return distances.get(destination);
	}

	
	public Vertx minimumDistanceOnTable() {
		int min = Integer.MAX_VALUE;
		Vertx minVertx = null;
		for(Vertx v : unsettled) {
			if(distances.get(v) <= min) {
				min = distances.get(v);
				minVertx = v;
			}
		}
		return minVertx;
	}
	
	public void getDistances(Vertx source) {		
		for(Edge e: graph.getEdges()) {
			Vertx nextVertx = null;
			Vertx sourceVertx = null;
			if(e.v1.getValue() == source.getValue()) {
				nextVertx = e.v2;
				sourceVertx = e.v1;
			}
			else if(e.v2.getValue() == source.getValue()) {
				nextVertx = e.v1;
				sourceVertx = e.v2;
			}
			else {
				continue;
			}
			if(completed.contains(nextVertx)) {
				continue;
			}
			else if(!unsettled.contains(nextVertx)) {
					unsettled.add(nextVertx);
			}
			
			int currentDistance = distances.get(nextVertx);
			
			int sourceDistance = distances.get(sourceVertx);
			
			int newDistance = e.getWeight() + sourceDistance;
			
			if(newDistance < currentDistance) {
				
				distances.replace(nextVertx, newDistance);
				previous.replace(nextVertx, sourceVertx);
	
			}
		}
	}
}
