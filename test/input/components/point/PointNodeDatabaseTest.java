/**
 * Unit testing for PointNodeDatabase class.
 * 
 * @author: Hanna King
 * @date: 9/6
 */

package input.components.point;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.Iterator;

import input.components.point.PointNode;

public class PointNodeDatabaseTest {


	protected static final String ANONYMOUS = "__UNNAMED";
	
	/*
	 * default constructor, just check _set is initialized
	 */
	@Test
	void testPointNodeDatabase()
	{
		PointNodeDatabase pnd = new PointNodeDatabase();
		assertEquals(0, pnd._set.size());
	}
	
	/*
	 * empty list in
	 * not empty list in
	 */
	@Test
	void testPointNodeDatabaseList_empty()
	{
		PointNodeDatabase pnd = new PointNodeDatabase(new ArrayList<PointNode>());
		assertEquals(0, pnd._set.size());
	}
	
	@Test
	void testPointNodeDatabaseList_notempty()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		assertEquals(1, pnd._set.size());
	}
	
	/*
	 * null PointNode in -> just let it happen
	 * normal PointNode in
	 * same in again
	 */
	@Test
	void testPut_null()
	{
		PointNodeDatabase pnd = new PointNodeDatabase();
		pnd.put(null);
		assertTrue(pnd.contains(null));
		assertEquals(1, pnd._set.size());
	}
	
	@Test
	void testPut_normalonce()
	{
		PointNodeDatabase pnd = new PointNodeDatabase();
		PointNode point = new PointNode(4.5, 5.6);
		pnd.put(point);
		assertTrue(pnd.contains(point));
		assertEquals(1, pnd._set.size());
	}
	
	@Test
	void testPut_normaltwice()
	{
		PointNodeDatabase pnd = new PointNodeDatabase();
		PointNode point = new PointNode(4.5, 5.6);
	
		pnd.put(point);
		pnd.put(point);
		assertTrue(pnd.contains(point));
		assertEquals(1, pnd._set.size());
	}
	
	/*
	 * null in
	 * null not in
	 * in, end
	 * in, front
	 * in, middle
	 * not in
	 */
	@Test
	void testContainsPointNode_nullin()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(null);
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertTrue(pnd.contains(null));
	}
	
	@Test
	void testContainsPointNode_nullnotin()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertFalse(pnd.contains(null));
	}
	
	@Test
	void testContainsPointNode_end()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		PointNode last = new PointNode(2.2, 3.3);
		list.add(last);
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertTrue(pnd.contains(last));
	}
	
	@Test
	void testContainsPointNode_first()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		PointNode first = new PointNode(4.5, 5.6);
		list.add(first);
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertTrue(pnd.contains(first));
	}
	
	@Test
	void testContainsPointNode_middle()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		PointNode mid = new PointNode(7.7, 3.0);
		list.add(mid);
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertTrue(pnd.contains(mid));
	}
	
	@Test
	void testContainsPointNode_notin()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertFalse(pnd.contains(new PointNode(3.0, 7.7)));
	}
	
	/*
	 * x matches, y doesn't
	 * x doesn't, y matches
	 * neither match (not in)
	 * both match (end)
	 * both match (first)
	 * both match (middle)
	 */
	@Test
	void testContainsDoubleDouble_xmatchesydoesnt()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertFalse(pnd.contains(7.7, 5.7));
	}
	@Test
	void testContainsDoubleDouble_xdoesntymatches()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertFalse(pnd.contains(10.09, 5.6));
	}
	@Test
	void testContainsDoubleDouble_notin()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertFalse(pnd.contains(12.00001, 0.8));
	}
	@Test
	void testContainsDoubleDouble_inend()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertTrue(pnd.contains(2.2, 3.3));
	}
	@Test
	void testContainsDoubleDouble_infirst()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertTrue(pnd.contains(4.5, 5.6));
	}
	@Test
	void testContainsDoubleDouble_inmiddle()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertTrue(pnd.contains(7.7, 3.0));
	}
	
	/*
	 * null
	 * normal with name
	 * normal without name
	 */
	@Test
	void testgetName_null()
	{
		PointNodeDatabase pnd = new PointNodeDatabase();
		
		assertThrows(Exception.class, () -> {pnd.getName(null);});
	}
	
	@Test
	void getName_normalwithname()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		PointNode point = new PointNode("a", 4.5, 5.6);
		list.add(point);
		list.add(new PointNode(7.7, 3.0));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals("a", point.getName());
	}
	
	@Test
	void getName_normalwithoutname()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		PointNode point = new PointNode(4.5, 5.6);
		list.add(point);
		list.add(new PointNode(7.7, 3.0));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(ANONYMOUS, point.getName());
	}
	
	/*
	 * x matches, y doesn't
	 * x doesn't, y matches
	 * neither match
	 * both match (end, name)
	 * both match (first, name)
	 * both match (middle, name)
	 * both match (no name)
	 */
	@Test
	void testGetNameDoubleDouble_xmatchesydoesnt()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode("a", 4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(null, pnd.getName(7.7, 5.7));
	}
	@Test
	void testGetNameDoubleDouble_xdoesntymatches()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode("a", 4.5, 5.6));
		list.add(new PointNode("b", 7.7, 3.0));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(null, pnd.getName(0.6, 3.0));
	}
	@Test
	void testGetNameDoubleDouble_neitherin()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode("a", 4.5, 5.6));
		list.add(new PointNode("b", 7.7, 3.0));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(null, pnd.getName(0.0, 0.0));
	}
	@Test
	void testGetNameDoubleDouble_inend()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode("a", 4.5, 5.6));
		list.add(new PointNode("b", 7.7, 3.0));
		list.add(new PointNode("gerald", 4.7, 2.22));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals("gerald", pnd.getName(4.7, 2.22));
	}
	@Test
	void testGetNameDoubleDouble_infirst()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode("a", 4.5, 5.6));
		list.add(new PointNode("b", 7.7, 3.0));
		list.add(new PointNode("gerald", 4.7, 2.22));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals("a", pnd.getName(4.5, 5.6));
	}
	@Test
	void testGetNameDoubleDouble_inmiddle()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode("a", 4.5, 5.6));
		list.add(new PointNode("b", 7.7, 3.0));
		list.add(new PointNode("gerald", 4.7, 2.22));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals("b", pnd.getName(7.7, 3.0));
	}
	
	@Test
	void testGetNameDoubleDouble_noname()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode("a", 4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode("gerald", 4.7, 2.22));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(ANONYMOUS, pnd.getName(7.7, 3.0));
	}
	
	/*
	 * null
	 * normal
	 */
	@Test
	void testGetPointPointNode_null()
	{
		PointNodeDatabase pnd = new PointNodeDatabase();
		assertEquals(null, pnd.getPoint(null));
	}
	
	@Test
	void testGetPointPointNode_normal()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		PointNode point = new PointNode(4.5, 5.6);
		list.add(point);
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(point, pnd.getPoint(point));
	}
	
	/*
	 * x matches, y doesn't
	 * x doesn't, y matches
	 * neither match
	 * both match (end)
	 * both match (first)
	 * both match (middle)
	 */
	@Test
	void testGetPointDoubleDouble_xmatchesydoesnt()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(null, pnd.getPoint(4.5, 8.9));
	}
	@Test
	void testGetPointDoubleDouble_xdoesntymatches()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(null, pnd.getPoint(0.0, 3.3));
	}
	@Test
	void testGetPointDoubleDouble_neitherin()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(null, pnd.getPoint(0.0, 4.0));
	}
	@Test
	void testGetPointDoubleDouble_inend()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		list.add(new PointNode(7.7, 3.0));
		PointNode last = new PointNode(2.2, 3.3);
		list.add(last);
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(last, pnd.getPoint(2.2, 3.3));
	}
	
	@Test
	void testGetPointDoubleDouble_infirst()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		PointNode first = new PointNode(4.5, 5.6);
		list.add(first);
		list.add(new PointNode(7.7, 3.0));
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(first, pnd.getPoint(4.5, 5.6));
	}
	
	@Test
	void testGetPointDoubleDouble_inmiddle()
	{
		ArrayList<PointNode> list = new ArrayList<PointNode>();
		list.add(new PointNode(4.5, 5.6));
		PointNode mid = new PointNode(7.7, 3.0);
		list.add(mid);
		list.add(new PointNode(2.2, 3.3));
		
		PointNodeDatabase pnd = new PointNodeDatabase(list);
		
		assertEquals(mid, pnd.getPoint(7.7, 3.0));
	}
}
