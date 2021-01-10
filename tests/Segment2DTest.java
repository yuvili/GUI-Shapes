package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;

class Segment2DTest {

	@Test
	void testSegment2DPoint2DPoint2D() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		assertEquals(seg1._B(), p1);
		assertEquals(seg1._A(), p2);
	}
	@Test
	void testSegment2DSegment2D() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		Segment2D seg2 = new Segment2D(seg1);
		assertEquals(seg2._B(), p1);
		assertEquals(seg2._A(), p2);
	}
	@Test
	void testSegment2DString() {
		String s = "2.0,4.3,8.9,10.2";
		Segment2D seg1 = new Segment2D(s);
		Point2D p1 = new Point2D(2.0,4.3);
		Point2D p2 = new Point2D(8.9,10.2);
		assertEquals(seg1._A(), p2);
		assertEquals(seg1._B(), p1);
	}
	@Test
	void testSegment2D() {
		Point2D p1 = new Point2D(2,5);
		Point2D p2 = new Point2D(8,13.0908);
		Segment2D seg1 = new Segment2D();
		assertEquals(seg1._A(), p2);
		assertEquals(seg1._B(), p1);
	}
	@Test
	void test_A() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		assertEquals(seg1._A(), p2);
	}
	@Test
	void test_B() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		assertEquals(seg1._B(), p1);
	}
	@Test
	void testContains() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		Point2D p3 = new Point2D(5,7);
		assertEquals(seg1.contains(p3), true);
	}
	@Test
	void testCenterOfMass() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		Point2D p3 = new Point2D(5,7);
		assertEquals(seg1.centerOfMass(), p3);
		
		Point2D p4 = new Point2D(2,4);
		Segment2D seg2 = new Segment2D (p4,p4);
		assertEquals(seg2.centerOfMass(), p4);
	}
	@Test
	void testArea() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		assertEquals(seg1.area(), 0);
	}
	@Test
	void testPerimeter() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		assertEquals(seg1.perimeter(), 16.97056274847714);
	}
	void testequalsObject(){
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D(p1,p2);
		assertEquals(seg1.equals(p2), false);
	}
	@Test
	void testMove() {
		Point2D p1 = new Point2D(2,3);
		Point2D p2 = new Point2D(4,6);
		Segment2D seg1 = new Segment2D (p1,p2);
		seg1.move(p2);
		assertEquals(seg1._A().x(), 8);
		assertEquals(seg1._A().y(), 12);
		assertEquals(seg1._B().x(), 6);
		assertEquals(seg1._B().y(), 9);
	}
	@Test
	void testCopy() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		Segment2D seg2 = (Segment2D)(seg1.copy());
		assertEquals(seg2._A(), p2);
		assertEquals(seg2._B(), p1);
	}
	@Test
	void testGetPoints() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		assertEquals(seg1.getPoints()[0], p1);
		assertEquals(seg1.getPoints()[1],p2);
	}
	@Test
	void testToString() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Segment2D seg1 = new Segment2D (p1,p2);
		assertEquals(seg1.toString(), "2.0,4.0,8.0,10.0");
	}
}
