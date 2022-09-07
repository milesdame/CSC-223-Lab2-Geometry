package input.components.segment;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

public class SegmentNodeTest {
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
