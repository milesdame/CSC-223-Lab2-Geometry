package input.components.point;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import utilities.math.MathUtilities;

public class PointNodeTest2 {
	
	/**
	 * equals
	 * - is null
	 * - not a PointNode
	 * - only x is not equal
	 * - only y is not equal
	 * - both are not equal
	 * - both are equal
	 */
	@Test
	void testEquals_null() {
		PointNode thisNode = new PointNode(0.0, 0.0);
		PointNode thatNode = null;
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_notPointNode() {
		PointNode thisNode = new PointNode(0.0, 0.0);
		Integer nonNode = 3;
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(nonNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_xNotEqual() {
		PointNode thisNode = new PointNode(0.0, 0.0);
		PointNode thatNode = new PointNode(1.0, 0.0);
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_yNotEqual() {
		PointNode thisNode = new PointNode(0.0, 0.0);
		PointNode thatNode = new PointNode(0.0, 1.0);
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_neitherEqual() {
		PointNode thisNode = new PointNode(0.0, 1.0);
		PointNode thatNode = new PointNode(1.0, 0.0);
		
		Boolean expected = false;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testEquals_bothEqual() {
		PointNode thisNode = new PointNode(1.0, 2.0);
		PointNode thatNode = new PointNode(1.0, 2.0);
		
		Boolean expected = true;
		Boolean actual = thisNode.equals(thatNode);
		
		assertEquals(expected, actual);
	}
	
	// getX
	
	void testGetX() {
		PointNode node = new PointNode(1.0, 3.0);
		
		double expected = 1.0;
		double actual = node.getX();
		
		assertTrue(MathUtilities.doubleEquals(expected, actual));
	}
	
	// getY
	
	void testGetY() {
		PointNode node = new PointNode(1.0, 3.0);
		
		double expected = 3.0;
		double actual = node.getY();
		
		assertTrue(MathUtilities.doubleEquals(expected, actual));
	}
	
	// getName
	
	void testGetName() {
		PointNode node = new PointNode("name", 1.0, 3.0);
		
		String expected = "name";
		String actual = node.getName();
		
		assertEquals(expected, actual);
	}
	
	// constructor(x,y)
	
	void testConstructor_x_y() {
		PointNode node = new PointNode(1.0, 2.0);
		
		assertTrue(MathUtilities.doubleEquals(1.0, node.getX()));
		assertTrue(MathUtilities.doubleEquals(2.0, node.getY()));
		assertEquals("__UNNAMED", node.getName());
	}
	
	// constructor(name,x,y)
	
	void testConstructor_name_x_y() {
		PointNode node = new PointNode("name", 1.0, 2.0);
		
		assertTrue(MathUtilities.doubleEquals(1.0, node.getX()));
		assertTrue(MathUtilities.doubleEquals(2.0, node.getY()));
		assertEquals("name", node.getName());
	}

}
