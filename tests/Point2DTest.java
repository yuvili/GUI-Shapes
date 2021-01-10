package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex.Ex3;
import ex4.geometry.Point2D;

class Point2DTest {

	@Test
	void testPoint2Ddoubledouble() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.x(),2.0);
		assertEquals(p1.y(),3.0);
	}
	@Test
	void testPoint2DPoint2D() {
		Point2D p1 = new Point2D(2,3);
		Point2D p2 = new Point2D(p1);
		
		assertEquals(p2.x(),2.0);
		assertEquals(p2.y(),3.0);
	}
	@Test
	void testPoint2DString() {
		String p1="2.0,3.0";
		Point2D p2 = new Point2D(p1);
		assertEquals(p2.x(),2.0);
		assertEquals(p2.y(),3.0);
	}
	@Test
	void testX() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.x(),(2));		
	}
	@Test
	void testY() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.y(),(3));
	}
	@Test
	void testIx() {
		Point2D p1 = new Point2D(2.5,3.2);
		assertEquals(p1.ix(),(2));
	}
	@Test
	void testIy() {
		Point2D p1 = new Point2D(2.5,3.2);
		assertEquals(p1.iy(),(3));
	}
	@Test
	void testAdd() {
		Point2D p1 = new Point2D(2,3);
		Point2D p2 = new Point2D(4,6);
		assertEquals(p2.x(),4);
		assertEquals(p2.y(),6);
	}
	@Test
	void testToString() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.toString(),"2.0,3.0");
	}
	@Test
    void testDistancePoint2D() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.distance(p1),0);
	}
	@Test
	void testEqualsObject() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.equals(p1), true);
	}
	@Test
	void testClose2equalsPoint2DDouble() {
		Point2D p1 = new Point2D(2,3);
		Point2D p2 = new Point2D(4.5756,0.65656);
		assertEquals(p1.close2equals(p2, p1.EPS), false);
	}
	@Test
	void testClose2equalsPoint2D() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.close2equals(p1, p1.EPS), true);
	}
	@Test
	void testVector() {
		Point2D p1 = new Point2D(2,3);
		Point2D p2 = new Point2D(4,6);
		Point2D p3 = new Point2D(2,3);
		assertEquals(p1.vector(p2),p3);		
	}
	@Test
	void testContains() {
		Point2D p1 = new Point2D(2,3);
		Point2D p2 = new Point2D(4,6);
		assertEquals(p1.contains(p2), false);
	}
	@Test
	void testCenterOfMass() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.centerOfMass(), p1);
	}
	@Test
	void testArea() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.area(),0);
	}
	@Test
	void testPerimeter() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.perimeter(),0);
	}
	@Test
	void testMove() {
		Point2D p1 = new Point2D(2,3);
		Point2D p2 = new Point2D(4,6);
		p1.move(p2);
		assertEquals(p1.x(), 6);
		assertEquals(p1.y(), 9);
	}
	@Test
	void testCopy() {
		Point2D p1 = new Point2D(2,3);
		assertEquals(p1.copy(), p1);
	}
	@Test
	void testGetPoints() {
		Point2D p1 = new Point2D(2,3);
		Point2D[] p2 = p1.getPoints();
		assertEquals(p2[0], p1);		
	}
}
