package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Rect2DTest {

	@Test
	void testRect2DPoint2DPoint2D() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1._B(), p2);
		assertEquals(r1._C(), p1);
		
		Point2D p3 = new Point2D(2,4);
		Point2D p4 = new Point2D(8,4);
		Rect2D r2 = new Rect2D (p3,p4);
		assertEquals(r2._B(), p4);
		assertEquals(r2._C(), p3);
	}
	@Test
	void testRect2DRect2D() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1._B(), p2);
		assertEquals(r1._C(), p1);
	}
	@Test
	void testRect2DString() {
		String s = "2.0,4.3,8.9,10.2";
		Rect2D r1 = new Rect2D(s);
		Point2D p1 = new Point2D(2.0,4.3);
		Point2D p2 = new Point2D(8.9,10.2);
		assertEquals(r1._B(), p2);
		assertEquals(r1._C(), p1);
	}
	@Test
	void testRect2D(){
		Point2D p1 = new Point2D(4.0,6.0);
		Point2D p2 = new Point2D(1.0,3.0);
		Rect2D r1 = new Rect2D();
		assertEquals(r1._B(), p1);
		assertEquals(r1._C(), p2);	
	}
	@Test
	void test_B() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1._B(), p2);
	}
	@Test
	void test_C() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1._C(), p1);
	}
	@Test
	void testContains() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		Point2D p3 = new Point2D(6,7);
		assertEquals(r1.contains(p3), true);
	}
	@Test
	void testCenterOfMass() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		Point2D p3 = new Point2D(5,7);
		assertEquals(r1.centerOfMass(), p3);
	}
	@Test
	void testArea() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1.area(), 36);
		
		Point2D p3 = new Point2D(2,4);
		Point2D p4 = new Point2D(8,4);
		Rect2D r2 = new Rect2D (p3,p4);
		assertEquals(r2.area(), 0);
	}
	@Test
	void testPerimeter() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1.perimeter(), 24);
		
		Point2D p3 = new Point2D(2,4);
		Point2D p4 = new Point2D(8,4);
		Rect2D r2 = new Rect2D (p3,p4);
		assertEquals(r2.perimeter(), 12.0);
	}
	@Test
	void testGetWeidth() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1.getWeidth(), 6);
	}
	@Test
	void testGetHeight() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1.getHeight(), 6);
	}
	@Test
	void testequalsObject(){
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1.equals(p2), false);
	}
	@Test
	void testMove() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		r1.move(p2);
		assertEquals(r1._C().x(), 10);
		assertEquals(r1._C().y(), 14);
		assertEquals(r1._B().x(), 16);
		assertEquals(r1._B().y(), 20);
	}
	@Test
	void testCopy() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		Rect2D r2 = (Rect2D)(r1.copy());
		assertEquals(r2._B(), p2);
		assertEquals(r2._C(), p1);
	}
	@Test
	void testGetPoints() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1.getPoints()[0], p1);
		assertEquals(r1.getPoints()[1],p2);
	}
	@Test
	void testToString() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D (p1,p2);
		assertEquals(r1.toString(), "2.0,4.0,8.0,10.0");
	}
}
