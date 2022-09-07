/**
* Write a succinct, meaningful description of the class here. You should avoid wordiness
* and redundancy. If necessary, additional paragraphs should be preceded by <p>,
* the html tag for a new paragraph.
*
* <p>Bugs: (a list of bugs and / or other problems)
*
* @author Miles Dame
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
		_adjLists = new LinkedHashMap<PointNode, Set<PointNode>>();
	}
	
	public int numUndirectedEdges() {
		// TODO
	}
	
	/**
	 * 
	 * @param n1
	 * @param n2
	 */
	private void addDirectedEdge(PointNode n1, PointNode n2) {
		Set<PointNode> pointSet = new LinkedHashSet<PointNode>();
		pointSet.add(n2);
		_adjLists.put(n2, pointSet);
	}
	
	/**
	 * 
	 * @param n1 
	 * @param n2
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

