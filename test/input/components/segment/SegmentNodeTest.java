package input.components.segment;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

public class SegmentNodeTest
{
	/*
	 * null in for p1
	 * null in for p2
	 * null in for both
	 * normal PointNode in for both
	 */
	@Test
	void testSegmentNode_nullp1()
	{
		PointNode point = new PointNode(3.0, 4.0);
		SegmentNode sn = new SegmentNode(null, point);
		
		assertEquals(null, sn.getPoint1());
		assertEquals(point, sn.getPoint2());
	}
	@Test
	void testSegmentNode_nullp2()
	{
		PointNode point = new PointNode(3.0, 4.0);
		SegmentNode sn = new SegmentNode(point, null);
		
		assertEquals(point, sn.getPoint1());
		assertEquals(null, sn.getPoint2());
	}
	@Test
	void testSegmentNode_nullboth()
	{		
		SegmentNode sn = new SegmentNode(null, null);
		
		assertEquals(null, sn.getPoint1());
		assertEquals(null, sn.getPoint2());
	}
	@Test
	void testSegmentNode_normal()
	{
		PointNode point1 = new PointNode(3.0, 4.0);
		PointNode point2 = new PointNode(1000.8, 3.0987);
		SegmentNode sn = new SegmentNode(point1, point2);
		
		assertEquals(point1, sn.getPoint1());
		assertEquals(point2, sn.getPoint2());
	}
	
	/**
	 * equals
	 * - is null
	 * - not a segment node
	 * - point1 is not equal
	 * - point2 is not equal
	 * - neither points are equal
	 * - both points are equal
	 */
	@Test
	void testEquals_null() {
		SegmentNode thisNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(2.0, 2.0));
		SegmentNode thatNode = null;
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_notSegmentNode() {
		SegmentNode thisNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(2.0, 2.0));
		Integer that = 3;
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(that);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_point1NotEqual() {
		SegmentNode thisNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(2.0, 2.0));
		SegmentNode thatNode = new SegmentNode(new PointNode(3.0, 3.0), new PointNode(2.0, 2.0));
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_point2NotEqual() {
		SegmentNode thisNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(2.0, 2.0));
		SegmentNode thatNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(3.0, 3.0));
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_neitherEqual() {
		SegmentNode thisNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(2.0, 2.0));
		SegmentNode thatNode = new SegmentNode(new PointNode(3.0, 3.0), new PointNode(4.0, 4.0));
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_bothEqual() {
		SegmentNode thisNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(2.0, 2.0));
		SegmentNode thatNode = new SegmentNode(new PointNode(1.0, 1.0), new PointNode(2.0, 2.0));
		
		Boolean expected = true;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
}
