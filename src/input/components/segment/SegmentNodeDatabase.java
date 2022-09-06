package input.components.segment;

import java.util.Collection;
import java.util.LinkedHashMap;
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
	
	private void addDirectedEdge(PointNode n1, PointNode n2) {
		// TODO
	}
	
	public void addUndirectedEdge(PointNode n1, PointNode n2) {
		// TODO
	}
	
	public void addAdjacencyList(PointNode n1, List<PointNode>) {
		// TODO
	}
	
	public List<SegmentNode> asSegmentList() {
		// TODO
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		// TODO
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<PointNode> get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PointNode> put(PointNode key, Set<PointNode> value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PointNode> remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends PointNode, ? extends Set<PointNode>> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<PointNode> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Set<PointNode>> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<PointNode, Set<PointNode>>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}

