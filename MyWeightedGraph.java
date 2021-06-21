package com.wiley;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import javafx.util.Pair;

public class MyWeightedGraph<T extends Comparable<T>, U> {

	private Map<T, List<Pair<T, U>>> map = new HashMap<>();

	public void addNewVertex(T vertex) {
		map.put(vertex, new LinkedList<Pair<T, U>>());
	}

	public void addNewEdge(T sourceVertex, T destinationVertex, U weight, boolean bidirectional) {

		if (!map.containsKey(sourceVertex))
			addNewVertex(sourceVertex);

		if (!map.containsKey(destinationVertex))
			addNewVertex(destinationVertex);

		map.get(sourceVertex).add(new Pair(destinationVertex, weight));

		if (bidirectional)
			map.get(destinationVertex).add(new Pair(sourceVertex, weight));
	}

	public void displayGraph() {
		for (Entry<T, List<Pair<T, U>>> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

	public int vertexCount() {
		return map.size();
	}

	public int edgeCount(boolean isBiDir) {
		int sum = 0;
		for (Entry<T, List<Pair<T, U>>> e : map.entrySet()) {
			sum += e.getValue().size();
		}

		return isBiDir ? sum / 2 : sum;
	}

	public boolean checkShortestPath(T source, T destination) {
		Queue<T> q = new LinkedList<T>();
		q.add(source);
		while (!q.isEmpty()) {
			T vertex = q.poll();
			for (Pair<T, U> k : map.get(vertex)) {
				if (( k.getKey()).compareTo(destination) == 0) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean checkPath(T source, T destination) {
		if (map.containsKey(source) && map.containsKey(destination)) {
			if (map.get(source).contains(destination))
				return true;
			else if (map.get(destination).contains(source))
				return true;
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		MyWeightedGraph<String, Integer> graph = new MyWeightedGraph<String, Integer>();
		graph.addNewEdge("A", "B", 10, true);
		graph.addNewEdge("A", "C", 15, true);
		graph.addNewEdge("D", "E", 20, true);
		graph.addNewEdge("C", "D", 25, true);
		graph.addNewEdge("E", "F", 26, true);
		graph.addNewEdge("F", "A", 5, true);

		graph.displayGraph();

		System.out.println("Vertices in a graph : " + graph.vertexCount());

		System.out.println("Edges in graph : " + graph.edgeCount(true));

		System.out.println(graph.checkPath("A", "F"));
	}

}



















