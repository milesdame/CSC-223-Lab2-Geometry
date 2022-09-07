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
    
    /*
     * constructor, linkedhashmap
     * normal, empty in
     * normal, normal in
     * empty, empty in
     * empty, normal in
     * check it properly fills _adjLists
     */
    
    /*
     * numUndirectedEdges
     * empty
     * after adding one
     * after adding another
     */

	@Test
	void testNumUndirectedEdges()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(10, db.numUndirectedEdges());
	}
	
	/*
	 * addDirectedEdge - private, no test?
	 * 
	 */
	
	/*
	 * addUndirectedEdge
	 * new, new
	 * new, already in
	 * already in, new
	 * already in, already in
	 * null, already in
	 * null, new
	 * already in, null
	 * new, null
	 */
	
	/*
	 * addAdjecencyList -
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
	
	/*
	 * asSegmentList
	 * empty
	 * not empty
	 */
	
	/*
	 * asUniqueSegmentList
	 * empty
	 * not empty all unique
	 * not empty some double
	 */
}
