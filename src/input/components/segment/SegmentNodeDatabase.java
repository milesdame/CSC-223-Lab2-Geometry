/**
 * A SegmentNodeDatabase is built upon an adjacency list that represents a geometry figure.
 * The adjacency list is a LinkedHashMap.
 * Each entry in this map is:
 * - key = a PointNode that represents a vertex of the figure
 * - value = a set of PointNodes that represents a directed edge from the key node to each node in the set
 *
 * An undirected edge exists between two points in the adjacency list if both points exist as a key and they exist in each other's value sets.
 * 
 * @author Miles Dame, Sophie Ngo
 * @date September 9, 2022
 */
package input.components.segment;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import input.components.point.PointNode;

/**
 * A SegmentNodeDatabase is built upon an adjacency list that represents a geometry figure.
 * The adjacency list is a LinkedHashMap.
 * Each entry in this map is:
 * - key = a PointNode that represents a vertex of the figure
 * - value = a set of PointNodes that represents a directed edge from the key node to each node in the set
 *
 * An undirected edge exists between two points in the adjacency list if both points exist as a key and they exist in each other's value sets.
 */
public class SegmentNodeDatabase {

	protected LinkedHashMap<PointNode, Set<PointNode>> _adjLists;

	/**
	 * Creates a new SegmentNodeDatabase with an empty adjacency list
	 */
	public SegmentNodeDatabase() {
		_adjLists = new LinkedHashMap<PointNode, Set<PointNode>>();

	}

	/**
	 * Creates a new SegmentNodeDatabase and initializes the adjacency list with a
	 * map with a point and its connected points
	 * @param LinkedHashMap<PointNode, Set<PointNode>> map - map with a key
	 * 		  that is a point and a value that is a set of connected points
	 */
	public SegmentNodeDatabase(LinkedHashMap<PointNode, Set<PointNode>> map) {
		_adjLists = new LinkedHashMap<PointNode, Set<PointNode>>(map);
	}

	/**
	 * Returns the amount of undirected edges in the adjacency list.
	 * @return int value of the total amount of undirected edges in the adj list
	 */
	public int numUndirectedEdges() {
		int sum = 0;

		for (Set<PointNode> set : _adjLists.values()) {
			sum = sum + set.size();
		}

		return sum;
	}

	/**
	 * Given two points, adds a directed edge from the first point to the second point.
	 * @param n1 - the first PointNode
	 * @param n2 - the second PointNode
	 */
	private void addDirectedEdge(PointNode n1, PointNode n2) {
		Set<PointNode> pointSet = new LinkedHashSet<PointNode>();
		pointSet.add(n2);
		_adjLists.put(n2, pointSet);
	}

	/**
	 * Given two points, adds an undirected edge between them.
	 * This is attained by adding a directed edge between them in both directions.
	 * @param n1 - the first PointNode (though order does not matter)
	 * @param n2 - the second PointNode (though order does not matter)
	 */
	public void addUndirectedEdge(PointNode n1, PointNode n2) {
		if (_adjLists.containsKey(n1) == true) { _adjLists.get(n1).add(n2);}
		else {
			this.addDirectedEdge(n1, n2);
		}

		if (_adjLists.containsKey(n2) == true) { _adjLists.get(n2).add(n1);}
		else {
			this.addDirectedEdge(n2, n1);
		}
	}

	/**
	 * Takes a given point and a set of its connecting points and adds it to the adjacency list if it does not already exist
	 * @param point
	 * @param list - list of points that are connected to point
	 */
	public void addAdjacencyList(PointNode point, Set<PointNode> list) {
		_adjLists.putIfAbsent(point, list);
	}
	
	/**
	 * Creates a list of all segments in the database
	 * @return a list of all segments in the database
	 */
	public List<SegmentNode> asSegmentList() {
		//Create an ArrayList to store the SegmentNodes
		ArrayList<SegmentNode> list = new ArrayList();

		// Loop through each key
		for(Map.Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) {
			Set<PointNode> values = entry.getValue();

			// For each key iterate through the values and add a segment with that key and the current value
			Iterator<PointNode> itr = values.iterator();
			while (itr.hasNext()) {
				PointNode point = (PointNode)itr.next();
				SegmentNode node = new SegmentNode(entry.getKey(), point);
				list.add(node);
			}
		}

		return list;

	}
	
	/**
	 * Creates a list of all segments in the database while checking to make sure there are no duplicates
	 * @return a list of all unique segments in the database
	 */
	public List<SegmentNode> asUniqueSegmentList() {
		//Create an ArrayList to store the SegmentNodes
		LinkedHashSet<SegmentNode> set = new LinkedHashSet();

		// Loop through each key
		for(Map.Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) {
			Set<PointNode> values = entry.getValue();

			// For each key iterate through the values and add a segment with that key and the current value
			Iterator<PointNode> itr = values.iterator();
			while (itr.hasNext()) {
				PointNode point = (PointNode)itr.next();
				SegmentNode node = new SegmentNode(entry.getKey(), point);
				set.add(node);
			}
		}

		ArrayList<SegmentNode> list = new ArrayList(set);
		return list;

	}

}
