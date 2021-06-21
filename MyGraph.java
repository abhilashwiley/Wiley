package com.wiley;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

public class MyGraph<T extends Comparable<T>> {

	private Map<T, List<T>> map = new HashMap<>();

	public void addNewVertex(T vertex) {
		map.put(vertex, new LinkedList<T>());
	}

	public void addNewEdge(T sourceVertex, T destinationVertex, boolean bidirectional) {

		if (!map.containsKey(sourceVertex))
			addNewVertex(sourceVertex);

		if (!map.containsKey(destinationVertex))
			addNewVertex(destinationVertex);

		map.get(sourceVertex).add(destinationVertex);

		if (bidirectional)
			map.get(destinationVertex).add(sourceVertex);
	}

	public void displayGraph() {
		for (Map.Entry<T, List<T>> e : map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

	public int vertexCount() {
		return map.size();
	}

	public int edgeCount(boolean isBiDir) {
		int sum = 0;
		for (Map.Entry<T, List<T>> e : map.entrySet()) {
			sum += e.getValue().size();
		}

		return isBiDir ? sum / 2 : sum;
	}

	public void checkShortestPath(T source, T destination) {
		Map<T, T> prev = new HashMap<>();
		Map<T, Integer> distance = new HashMap<>();
		Map<T, Boolean> visit = new HashMap<>();
		for (T key : map.keySet()) {
			distance.put(key, 0);
			visit.put(key, false);
		}

		Queue<T> q = new LinkedList<T>();
		q.add(source);
		visit.put(source, true);
		while (!q.isEmpty()) {
			T vertex = q.poll();
			for (T k : map.get(vertex)) {
				if (!visit.get(k)) {
					distance.put(k, distance.get(vertex) + 1);
//					System.out.println(k+" "+distance.get(vertex)+1);
					visit.put(k, true);
					prev.put(k, vertex);
					q.add(k);
				}
			}
		}
		System.out.println(distance.get(destination));
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
		MyGraph<String> graph = new MyGraph<String>();
		graph.addNewEdge("A", "B", true);
		graph.addNewEdge("A", "C", true);
		graph.addNewEdge("D", "E", true);
		graph.addNewEdge("C", "D", true);
		graph.addNewEdge("E", "F", true);
		graph.addNewEdge("F", "A", true);

		graph.displayGraph();

		System.out.println("Vertices in a graph : " + graph.vertexCount());

		System.out.println("Edges in graph : " + graph.edgeCount(true));

		System.out.println(graph.checkPath("A", "E"));

		graph.checkShortestPath("D", "B");
	}

}
