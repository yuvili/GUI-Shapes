package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;

class Triangle2DTest {

	@Test
	void testTriangle2DPoint2DPoint2DPoint2D() {
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1._C(),c1);
		assertEquals(t1._B(), b1);
		assertEquals(t1._A(), a1);

		Point2D a2 = new Point2D(10,5);
		Point2D b2 = new Point2D (6,5);
		Point2D c2 = new Point2D (2,5);
		Triangle2D t2 = new Triangle2D(a2,b2,c2);
		assertEquals(t2._C(),c2);
		assertEquals(t2._B(), b2);
		assertEquals(t2._A(), a2);
	}
	@Test
	void testTriangle2DTriangle2D() {
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		Triangle2D t2 = new Triangle2D(t1);
		assertEquals(t2._C(),c1);
		assertEquals(t2._B(), b1);
		assertEquals(t2._A(), a1);
	}
	@Test
	void testTriangle2DString() {
		String s = "10.0,5.0,6.0,10.0,2.0,7.0";
		Triangle2D t1 = new Triangle2D(s);
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		assertEquals(t1._C(),c1);
		assertEquals(t1._B(), b1);
		assertEquals(t1._A(), a1);
	}
	@Test
	void testTriangle2D() {
		Point2D a1 = new Point2D(6,7);
		Point2D b1 =new Point2D(4,5);
		Point2D c1 = new Point2D(2,3);
		Triangle2D t1 = new Triangle2D();
		assertEquals(t1._C(),c1);
		assertEquals(t1._B(), b1);
		assertEquals(t1._A(), a1);
	}
	@Test
	void test_A() {
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1._A(), a1);
	}
	@Test
	void test_B() {
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1._B(), b1);
	}
	@Test
	void test_C() {
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1._C(),c1);
	}
	@Test
	void testContains() {
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		Point2D p1 = new Point2D (0,0);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1.contains(p1),false);
	}
	@Test
	void testCenterOfMass() {
		Point2D a1 = new Point2D(10,5);
		Point2D b1 = new Point2D (6,10);
		Point2D c1 = new Point2D (2,7);
		Point2D p1 = new Point2D (6,7.333333333333333);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1.centerOfMass(), p1);
	}
	@Test
	void testArea() {
		Point2D a1 = new Point2D(7,3);
		Point2D b1 = new Point2D (2,10);
		Point2D c1 = new Point2D (2,3);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1.area(), 17.5);

		Point2D a2 = new Point2D(10,5);
		Point2D b2 = new Point2D (6,5);
		Point2D c2 = new Point2D (2,5);
		Triangle2D t2 = new Triangle2D(a2,b2,c2);
		assertEquals(t2.area(), 0);
	}
	@Test
	void testPerimeter() {
		Point2D a1 = new Point2D(7,3);
		Point2D b1 = new Point2D (2,10);
		Point2D c1 = new Point2D (2,3);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1.perimeter(), 20.602325267042627);
	}
	@Test
	void testequalsObject(){
		Point2D a1 = new Point2D(7,3);
		Point2D b1 = new Point2D (2,10);
		Point2D c1 = new Point2D (2,3);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1.equals(b1), false);
	}
	@Test
	void testMove() {
		Point2D a1 = new Point2D(2,4);
		Point2D b1 = new Point2D(8,10);
		Point2D c1 = new Point2D (2,3);
		Triangle2D t1 = new Triangle2D (a1,b1,c1);
		t1.move(b1);
		assertEquals(t1._C().x(), 10);
		assertEquals(t1._C().y(), 13);
		assertEquals(t1._B().x(), 16);
		assertEquals(t1._B().y(), 20);
		assertEquals(t1._A().x(), 10);
		assertEquals(t1._A().y(), 14);
	}
	@Test
	void testCopy() {
		Point2D a1 = new Point2D(7,3);
		Point2D b1 = new Point2D (2,10);
		Point2D c1 = new Point2D (2,3);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		Triangle2D t2 =(Triangle2D) (t1.copy());
		assertEquals(t2._A(), a1);
		assertEquals(t2._B(), b1);
		assertEquals(t2._C(), c1);
	}
	@Test
	void testGetPoints() {
		Point2D a1 = new Point2D(7,3);
		Point2D b1 = new Point2D (2,10);
		Point2D c1 = new Point2D (2,3);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1.getPoints()[0], c1);
		assertEquals(t1.getPoints()[1], b1);
		assertEquals(t1.getPoints()[2], a1);
	}
	@Test
	void testToString() {
		Point2D a1 = new Point2D(7,3);
		Point2D b1 = new Point2D (2,10);
		Point2D c1 = new Point2D (2,3);
		Triangle2D t1 = new Triangle2D(a1,b1,c1);
		assertEquals(t1.toString(), "7.0,3.0,2.0,10.0,2.0,3.0");
	}
}
