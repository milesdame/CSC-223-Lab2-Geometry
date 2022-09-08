package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Collection;

import input.components.point.PointNode;


class SegmentNodeDatabaseTest
{
	private PointNode pt00 = new PointNode(0.0, 0.0);
	private PointNode pt01 = new PointNode(0.0, 1.0);
	private PointNode pt11 = new PointNode(1.0, 1.0);
	private PointNode pt10 = new PointNode(1.0, 0.0);
	
    public SegmentNodeDatabase build()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }

    public SegmentNodeDatabase babyBuild()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	
    	return db;
    }    
    
    
    
    
    
      
    /*
     * default constructor
     * just one test, check it fills _adjLists
     * 
     */
    @Test
    void testSegmentNodeDatabase()
    {
    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	
    	assertEquals(0, db._adjLists.size());
    }
    
    /*
     * constructor, linkedhashmap - probably not all of these are necessary
     * normal, empty in
     * normal, normal in
     * normal null
     * null normal
     * null empty
     * null null
     * check it properly fills _adjLists
     */
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_normalempty()
    {     	
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_normalnormal()
    {
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = LinkedHashMapNormalNormal();
    	SegmentNodeDatabase db = new SegmentNodeDatabase(lhm);
    	
    	assertTrue(lhm.equals(db._adjLists));
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_normalnull()
    {
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_nullempty()
    {
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_nullnormal()
    {
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_nullnull()
    {
    	
    }
    @Test
    void
    testSegmentNodeDatabaseLinkedHashMap_nullmapin()
    {
    	
    }
    
    /*
     * numUndirectedEdges
     * empty
     * after adding one
     * after adding another
     */
    @Test
    void testNumUndirectedEdges_empty()
    {
    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	
    	assertEquals(0, db.numUndirectedEdges());
    }
    
	@Test
	void testNumUndirectedEdges_stuffin()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(20, db.numUndirectedEdges());
	}
	
	@Test
	void testNumUndirectedEdges_afteradding()
	{
		SegmentNodeDatabase db = build();
		
		PointNode m = new PointNode("M", 3, 3);    	  	
		PointNode y = new PointNode("Y", 3, 3);    	  	
    	db.addUndirectedEdge(m, y);
    	
    	assertEquals(22, db.numUndirectedEdges());
	}
	
	
	/*
	 * addUndirectedEdge - prob not all necessary
	 * new, new
	 * new, already in
	 * new, null
	 * already in, new
	 * already in, already in
	 * already in, null
	 * null, new
	 * null, already in
	 * null null
	 * same object for both
	 */
	@Test
	void testAddUndirectedEdge_newnew()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	
    	// Check if db is empty
    	assertEquals(0, db.asSegmentList().size());
    	
    	// Add segment to db
    	db.addUndirectedEdge(e, x);
    	SegmentNode node1 = new SegmentNode(e, x);
    	List<SegmentNode> list = db.asSegmentList();
    	
    	// Check if segment was added
    	assertTrue(list.contains(node1));
    	assertEquals(1, db.asSegmentList().size());
	}
	@Test
	void testAddUndirectedEdge_newin()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	
    	// Check if db is empty
    	assertEquals(0, db.asSegmentList().size());
    	
    	// Add segment to db
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(c, b);
    	SegmentNode node1 = new SegmentNode(b, c);
    	List<SegmentNode> list = db.asSegmentList();
    	
    	// Check if segment was added
    	assertTrue(list.contains(node1));
    	assertEquals(3, db.asSegmentList().size());
	}
	@Test
	void testAddUndirectedEdge_newnull()
	{
		
	}
	@Test
	void testAddUndirectedEdge_innew()
	{
		
	}
	@Test
	void testAddUndirectedEdge_inin()
	{
		
	}
	@Test
	void testAddUndirectedEdge_innull()
	{
		
	}
	@Test
	void testAddUndirectedEdge_nullnew()
	{
		
	}
	@Test
	void testAddUndirectedEdge_nullin()
	{
		
	}
	@Test
	void testAddUndirectedEdge_nullnull()
	{
		
	}
	@Test
	void testAddUndirectedEdge_sameforboth()
	{
		
	}
	
	/*
	 * addAdjecencyList - prob not all necessary
	 * point in, empty
	 * point in, not empty no double
	 * point in, not empty double
	 * point in , null
	 * point not in, empty
	 * point not in, not empty no double
	 * point not in, not empty double
	 * point not in , null
	 * null, empty
	 * null, not empty no double
	 * null, not empty double
	 * null, null
	 */
	@Test
	void testAddAdjacencyList_pointinempty()
	{
		
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		
	}
	@Test
	void testAddAdjacencyList_pointinunique()
	{
		
	}
	@Test
	void testAddAdjacencyList_pointinredundant()
	{
		
	}
	@Test
	void testAddAdjacencyList_pointinnull()
	{
		
	}
	@Test
	void testAddAdjacencyList_pointnotinempty()
	{
		
	}
	@Test
	void testAddAdjacencyList_pointnotinunique()
	{
		
	}
	@Test
	void testAddAdjacencyList_pointnotinredundant()
	{
		
	}
	@Test
	void testAddAdjacencyList_pointnotinnull()
	{
		
	}
	@Test
	void testAddAdjacencyList_nullempty()
	{
		
	}
	@Test
	void testAddAdjacencyList_nullunique()
	{
		
	}
	@Test
	void testAddAdjacencyList_nullredundant()
	{
		
	}
	@Test
	void testAddAdjacencyList_nullnull()
	{
		
	}
	
	/*
	 * asSegmentList
	 * empty
	 * not empty
	 */
	@Test
	void testAsSegmentList_stuffin()
	{
		
	}
	
	@Test
	void testAsSegmentList_empty() {
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		
		List<SegmentNode> expected = new ArrayList<SegmentNode>(); 
		List<SegmentNode> actual = db.asSegmentList();
		
		assertSame(expected, actual);
	}
	
	@Test
	void testAsSegmentList_nonEmpty() {
//		PointNode pt1 = new PointNode(0.0, 0.0);
//		PointNode pt2 = new PointNode(1.0, 1.0);
//		PointNode pt3 = new PointNode(2.0, 2.0);
//		Set<PointNode> pointSet = new LinkedHashSet<PointNode>();
//		pointSet.add(pt2);
//		pointSet.add(pt3);
//		LinkedHashMap<PointNode, Set<PointNode>> map = new LinkedHashMap<PointNode, Set<PointNode>>();
//		SegmentNodeDatabase db = new SegmentNodeDatabase(map);
//		
//		ArrayList<SegmentNode> expected = new ArrayList<SegmentNode>(); 
//		ArrayList<SegmentNode> actual = db.asSegmentList();
//		
//		assertSame(expected, actual);
	}
	
	/*
	 * asUniqueSegmentList
	 * empty
	 * not empty all unique
	 * not empty some double
	 */

	@Test
	void testAsUniqueSegmentList_empty()
	{
		
	}
	@Test
	void testAsUniqueSegmentList_allunique()
	{
		
	}
	@Test
	void testAsUniqueSegmentList_redundancy()
	{
		
	}
	
	@Test
	void testAsUniqueSegmentList_nonEmptyAllUnique() {
		
	}
	
	@Test
	void testAsUniqueSegmentList_nonEmptyNonUnique() {
		
	}
	
	
	public LinkedHashMap<PointNode, Set<PointNode>> LinkedHashMapNormalNormal()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	
    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();
    	forA.add(b);
    	forA.add(c);
    	
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(a, forA);
   	
    	return lhm;
   	}
	
	public LinkedHashMap<PointNode, Set<PointNode>> LinkedHashMapNormalEmpty()
	{
		PointNode a = new PointNode("A", 3, 6);
    	
    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();
    	
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(a, forA);
   	
    	return lhm;
   	}
	
	public LinkedHashMap<PointNode, Set<PointNode>> LinkedHashMapNormalNull()
	{
		PointNode a = new PointNode("A", 3, 6);
    	
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(a, null);
   	
    	return lhm;
   	}
	
	public LinkedHashMap<PointNode, Set<PointNode>> LinkedHashMapNullNormal()
	{
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	
    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();
    	forA.add(b);
    	forA.add(c);
    	
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(null, forA);
   	
    	return lhm;
   	}
	
	public LinkedHashMap<PointNode, Set<PointNode>> LinkedHashMapNullEmpty()
	{  	
    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();
    	
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(null, forA);
   	
    	return lhm;
   	}
	
	public LinkedHashMap<PointNode, Set<PointNode>> LinkedHashMapNullNull()
	{  	
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(null, null);
   	
    	return lhm;
   	}
}
