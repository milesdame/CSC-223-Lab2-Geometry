package input.components.segment;

import static org.junit.Assert.assertThrows;
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

	private PointNode a = new PointNode("A", 3, 6);
	private PointNode b = new PointNode("B", 2, 4);
	private PointNode c = new PointNode("C", 4, 4);

	private PointNode d = new PointNode("D", 0, 0);
	private PointNode e = new PointNode("E", 6, 0);
	private PointNode x = new PointNode("X", 3, 3);

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
    	PointNode a = new PointNode("A", 3, 6);

    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();

    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(a, forA);
    	SegmentNodeDatabase db = new SegmentNodeDatabase(lhm);

    	assertEquals(lhm, db._adjLists);
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_normalnormal()
    {
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();
    	forA.add(b);
    	forA.add(c);

    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(a, forA);
    	SegmentNodeDatabase db = new SegmentNodeDatabase(lhm);

    	assertEquals(lhm, db._adjLists);
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_normalnull()
    {
    	PointNode a = new PointNode("A", 3, 6);

    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(a, null);
    	SegmentNodeDatabase db = new SegmentNodeDatabase(lhm);

    	assertEquals(lhm, db._adjLists);
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_nullempty()
    {
    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();

    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(null, forA);
    	SegmentNodeDatabase db = new SegmentNodeDatabase(lhm);

    	assertEquals(lhm, db._adjLists);
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_nullnormal()
    {
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	LinkedHashSet<PointNode> forA = new LinkedHashSet<PointNode>();
    	forA.add(b);
    	forA.add(c);

    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(null, forA);
    	SegmentNodeDatabase db = new SegmentNodeDatabase(lhm);

    	assertEquals(lhm, db._adjLists);
    }
    @Test
    void testSegmentNodeDatabaseLinkedHashMap_nullnull()
    {
    	LinkedHashMap<PointNode, Set<PointNode>> lhm = new LinkedHashMap<PointNode, Set<PointNode>>();
    	lhm.put(null, null);
    	SegmentNodeDatabase db = new SegmentNodeDatabase(lhm);

    	assertEquals(lhm, db._adjLists);
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
		assertEquals(10, db.numUndirectedEdges());
		
	}

	@Test
	void testNumUndirectedEdges_afteradding()
	{
		SegmentNodeDatabase db = build();

		PointNode y = new PointNode("Y", 6, 3);
    	db.addUndirectedEdge(a, y);
    	assertEquals(11, db.numUndirectedEdges());
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
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Check if db is empty
    	assertEquals(0, db.asUniqueSegmentList().size());

    	// Add segment to db
    	db.addUndirectedEdge(e, x);
    	SegmentNode node1 = new SegmentNode(e, x);
    	List<SegmentNode> list = db.asSegmentList();

    	// Check if segment was added
    	assertTrue(list.contains(node1));
    	assertEquals(2, db.asUniqueSegmentList().size());
	}
	@Test
	void testAddUndirectedEdge_newin()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Check if db is empty
    	assertEquals(0, db.asUniqueSegmentList().size());

    	// Add segment to db
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(c, b);
    	SegmentNode node1 = new SegmentNode(b, c);
    	List<SegmentNode> list = db.asSegmentList();

    	// Check if segment was added
    	assertTrue(list.contains(node1));
    	assertEquals(3, db._adjLists.size());
	}
	@Test
	void testAddUndirectedEdge_newnull()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Check if db is empty
    	assertEquals(0, db.asUniqueSegmentList().size());

    	// Add segment but one point is null
    	db.addUndirectedEdge(c, b);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(a, null);
    	assertEquals(3, db._adjLists.size());

	}
	@Test
	void testAddUndirectedEdge_innew()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	
    	// Add segment to db
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(c, b);
    	db.addUndirectedEdge(c, x);
    	SegmentNode node1 = new SegmentNode(c, x);
    	List<SegmentNode> list = db.asSegmentList();

    	// Check if segment was added
    	assertTrue(list.contains(node1));
    	assertEquals(4, db._adjLists.size());
	}
	@Test
	void testAddUndirectedEdge_inin()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode e = new PointNode("E", 6, 0);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Check if db is empty
    	assertEquals(0, db.asUniqueSegmentList().size());

    	// Add segment to db
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(c, e);
    	SegmentNode node1 = new SegmentNode(e, c);
    	List<SegmentNode> list = db.asSegmentList();

    	// Check if segment was added
    	assertTrue(list.contains(node1));
    	assertEquals(4, db._adjLists.size());
	}
	@Test
	void testAddUndirectedEdge_innull()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Add segment but one point is null
    	db.addUndirectedEdge(c, b);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(a, null);
    	assertEquals(3, db._adjLists.size());
	}
	@Test
	void testAddUndirectedEdge_nullnew()
	{
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Add segment but one point is null
    	db.addUndirectedEdge(c, b);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(null, e);
    	assertEquals(3, db._adjLists.size());
	}
	@Test
	void testAddUndirectedEdge_nullin()
	{
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Check if db is empty
    	assertEquals(0, db.asUniqueSegmentList().size());

    	// Add segment but one point is null
    	db.addUndirectedEdge(c, b);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(null, c);
    	assertEquals(3, db._adjLists.size());
	}
	@Test
	void testAddUndirectedEdge_nullnull()
	{
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Check if db is empty
    	assertEquals(0, db.asUniqueSegmentList().size());

    	// Add segment but one point is null
    	db.addUndirectedEdge(c, b);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(null, null);
    	assertEquals(3, db._adjLists.size());
	}
	@Test
	void testAddUndirectedEdge_sameforboth()
	{
    	PointNode e = new PointNode("E", 6, 0);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Add segment
    	db.addUndirectedEdge(e, e);
    	assertEquals(0, db._adjLists.size());
	}

	/*
	 * addAdjacencyList - prob not all necessary
	 * point in, empty
	 * point in, not empty
	 * point in , null
	 * point not in, empty
	 * point not in, not empty
	 * point not in , null
	 * null, empty
	 * null, not empty
	 * null, null
	 */
	@Test
	void testAddAdjacencyList_pointin_empty()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		db._adjLists.put(a, null);

		LinkedHashSet<PointNode> empty = new LinkedHashSet<PointNode>();

		db.addAdjacencyList(a, empty);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(a, empty);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);
	}
	@Test
	void testAddAdjacencyList_pointin_nonempty() {
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		db._adjLists.put(a, null);

		LinkedHashSet<PointNode> nonEmpty = new LinkedHashSet<PointNode>();
		nonEmpty.add(b);
		nonEmpty.add(c);

		db.addAdjacencyList(a, nonEmpty);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(a, nonEmpty);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);
	}
	@Test
	void testAddAdjacencyList_pointin_null()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		db._adjLists.put(a, null);

		db.addAdjacencyList(a, null);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(a, null);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);
	}
	@Test
	void testAddAdjacencyList_pointnotin_empty()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		LinkedHashSet<PointNode> empty = new LinkedHashSet<PointNode>();

		db.addAdjacencyList(a, empty);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(a, empty);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);

	}

	@Test
	void testAddAdjacencyList_pointnotin_nonempty()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		LinkedHashSet<PointNode> nonEmpty = new LinkedHashSet<PointNode>();
		nonEmpty.add(b);
		nonEmpty.add(c);

		db.addAdjacencyList(a, nonEmpty);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(a, nonEmpty);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);

	}
	@Test
	void testAddAdjacencyList_pointnotin_null()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();

		db.addAdjacencyList(a, null);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(a, null);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);
	}
	@Test
	void testAddAdjacencyList_null_empty()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		LinkedHashSet<PointNode> empty = new LinkedHashSet<PointNode>();

		db.addAdjacencyList(null, empty);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(null, empty);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);
	}
	@Test
	void testAddAdjacencyList_null_nonempty()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();
		LinkedHashSet<PointNode> nonEmpty = new LinkedHashSet<PointNode>();
		nonEmpty.add(b);
		nonEmpty.add(c);

		db.addAdjacencyList(null, nonEmpty);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(null, nonEmpty);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);
	}
	@Test
	void testAddAdjacencyList_null_null()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();

		db.addAdjacencyList(null, null);

		LinkedHashMap<PointNode, Set<PointNode>> expected = new LinkedHashMap<PointNode, Set<PointNode>>();
		expected.put(null, null);

		LinkedHashMap<PointNode, Set<PointNode>> actual = db._adjLists;

		assertEquals(expected, actual);
	}

	/*
	 * asSegmentList
	 * empty
	 * not empty
	 */

	@Test
	void testAsSegmentList_empty() {
		SegmentNodeDatabase db = new SegmentNodeDatabase();

		List<SegmentNode> expected = new ArrayList<SegmentNode>();
		List<SegmentNode> actual = db.asSegmentList();

		assertEquals(expected, actual);
	}

	@Test
	void testAsSegmentList_nonEmpty() {
		SegmentNodeDatabase db = this.babyBuild();

		ArrayList<SegmentNode> expected = new ArrayList<SegmentNode>();
		expected.add(new SegmentNode(a, b));
		expected.add(new SegmentNode(a, c));
		expected.add(new SegmentNode(b, a));
		expected.add(new SegmentNode(b, c));
		expected.add(new SegmentNode(c, a));
		expected.add(new SegmentNode(c, b));

		ArrayList<SegmentNode> actual = (ArrayList<SegmentNode>) db.asSegmentList();

		for (int i=0; i < expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}

	}

	/*
	 * asUniqueSegmentList
	 * empty
	 * not empty
	 */

	@Test
	void testAsUniqueSegmentList_empty()
	{
		SegmentNodeDatabase db = new SegmentNodeDatabase();

		List<SegmentNode> expected = new ArrayList<SegmentNode>();
		List<SegmentNode> actual = db.asUniqueSegmentList();

		assertEquals(expected, actual);
	}

	@Test
	void testAsUniqueSegmentList_nonempty()
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Check if db is empty
    	assertEquals(0, db.asUniqueSegmentList().size());

    	// Add segments
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(c, d);
    	db.addUndirectedEdge(e, x);
    	assertEquals(6, db.asUniqueSegmentList().size());
	}
	@Test
	void testAsUniqueSegmentList_redundancy()
	{

	}

	@Test
	void testAsUniqueSegmentList_nonEmptyAllUnique() {
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Add segments
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(c, d);
    	db.addUndirectedEdge(e, x);
    	assertEquals(6, db.asUniqueSegmentList().size());
	}

	@Test
	void testAsUniqueSegmentList_nonEmptyNonUnique() {
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	// Add segments
    	db.addUndirectedEdge(e, x);
    	db.addUndirectedEdge(e, x);
    	assertEquals(2, db.asUniqueSegmentList().size());
	}
}
