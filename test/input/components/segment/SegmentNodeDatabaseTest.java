package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeDatabaseTest
{
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
     * empty, empty in
     * empty, normal in
     * empty null
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
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_normalnull()
    {
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_emptyempty()
    {
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_emptynormal()
    {
    	
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_emptynull()
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
    
    /*
     * numUndirectedEdges
     * empty
     * after adding one
     * after adding another
     */
    @Test
    void testNumUndirectedEdges_empty()
    {
    	
    }
    
	@Test
	void testNumUndirectedEdges_stuffin()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(10, db.numUndirectedEdges());
	}
	
	@Test
	void testNumUndirectedEdges_afteradding()
	{
		
	}
	
	/*
	 * addDirectedEdge
	 * same object
	 * new, new
	 * new, already in
	 * new, null
	 * already in, new
	 * already in, already in
	 * already in, null
	 * null, new
	 * null, already in
	 * null null
	 */
	@Test
	void testAddDirectedEdge_newnew()
	{
		
	}
	@Test
	void testAddDirectedEdge_newin()
	{
		
	}
	@Test
	void testAddDirectedEdge_newnull()
	{
		
	}
	@Test
	void testAddDirectedEdge_innew()
	{
		
	}
	@Test
	void testAddDirectedEdge_inin()
	{
		
	}
	@Test
	void testAddDirectedEdge_innull()
	{
		
	}
	@Test
	void testAddDirectedEdge_nullnew()
	{
		
	}
	@Test
	void testAddDirectedEdge_nullin()
	{
		
	}
	@Test
	void testAddDirectedEdge_nullnull()
	{
		
	}
	@Test
	void testAddDirectedEdge_sameforboth()
	{
		
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
		
	}
	@Test
	void testAddUndirectedEdge_newin()
	{
		
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
	void testAsSegmentList_empty()
	{
		
	}
	@Test
	void testAsSegmentList_stuffin()
	{
		
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
}
