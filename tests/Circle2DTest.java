package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;

class Circle2DTest {

	@Test
	void testCircle2DPoint2DDouble() {
		Point2D p1 = new Point2D(2,3);
		double rad1= 0.14;
		Circle2D c1 = new Circle2D (p1,rad1);
		assertEquals(c1.centerOfMass(),p1);
		assertEquals(c1.getRadius(), rad1);
	}
	@Test
	void testCircle2DString() {
		String s = "2,3,0.14";
		Circle2D c1 = new Circle2D(s);
		Point2D p1 = new Point2D(2,3);

		assertEquals(c1.getRadius(), 0.14);
		assertEquals(c1.centerOfMass(), p1);
	}
	@Test
	void testCircle2DCircle() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 1.5;
		Circle2D c1 = new Circle2D(p1,rad1);
		Circle2D c2 = new Circle2D(c1);

		assertEquals(c2.centerOfMass(),p1);
		assertEquals(c2.getRadius(), rad1);
	}
	@Test
	void testCircle2D() { 
		Circle2D c1 = new Circle2D();

		assertEquals(c1.getRadius(), 3.14);
		assertEquals(c1.centerOfMass(),new Point2D(0,0));
	}
	@Test
	void testPoint2DgetCenter() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 1.5;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.centerOfMass(), p1);
	}
	@Test
	void testGetRadius() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 1.5;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.getRadius(), rad1);
		
		double rad2 = -2.4;
		Circle2D c2 = new Circle2D(p1,rad2);
		assertEquals(c2.getRadius(), 1);
	}
	@Test
	void testToString() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 1.5;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.toString(), "8.0,6.0, 1.5");
	}
	@Test
	void testContains() {
		Point2D p1 = new Point2D(8,6);
		Point2D p2 = new Point2D(2,3);
		double rad1 = 1.5;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.contains(p2), false);
	}
	@Test
	void testCenterOfMass() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 1.5;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.centerOfMass(), p1);
	}
	@Test
	void testArea() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 0.54321;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.area(), 0.9270120624831106);
	}
	@Test
	void testPerimeter() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 0.54321;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.perimeter(), 3.4130890907130227);
	}
	@Test
	void testequalsObject(){
		Point2D p1 = new Point2D(8,6);
		double rad1 = 0.54321;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.equals(p1), false);		
	}
	@Test
	void testMove() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 0.54321;
		Circle2D c1 = new Circle2D(p1,rad1);
		c1.move(p1);
		assertEquals(c1.centerOfMass().x(), 16.0);
		assertEquals(c1.centerOfMass().y(), 12.0);
	}
	@Test
	void testCopy() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 0.54321;
		Circle2D c1 = new Circle2D(p1,rad1);
		Circle2D c2 = (Circle2D)(c1.copy());
		assertEquals(c2.centerOfMass(), p1);
		assertEquals(c2.getRadius(), rad1);
	}
	@Test
	void testGetPoints() {
		Point2D p1 = new Point2D(8,6);
		double rad1 = 0.54321;
		Circle2D c1 = new Circle2D(p1,rad1);
		assertEquals(c1.getPoints()[0], p1);
		assertEquals(c1.getPoints()[1].y(), 6.54321);
	}
}
