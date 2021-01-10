package ex4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class GUIShapeTest {

	@Test
	void testGUIShapeGeoShapeBooleanColorInt() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		assertEquals(gui1.getShape(), r1);
		assertEquals(gui1.isFilled(), fill);
		assertEquals(gui1.getColor(), col);
		assertEquals(gui1.getTag(), tag);
	}
	@Test
	void testGUIShapeGUIShape() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		GUIShape gui2 = new GUIShape(gui1);
		assertEquals(gui2.getShape(), r1);
		assertEquals(gui2.isFilled(), fill);
		assertEquals(gui2.getColor(), col);
		assertEquals(gui2.getTag(), tag);
	}
	@Test
	void testGUIShape() { 
		GUIShape gui1 = new GUIShape();
		assertEquals(gui1.getShape(),new Rect2D());
		assertEquals(gui1.isFilled(),true);
		assertEquals(gui1.getColor(),Color.black);
		assertEquals(gui1.getTag(), 3);
	}
	@Test
	void testGUIShapeString(){
		String s = "GUIShape,0,false,0,Point2D,0.2,0.4";
		GUIShape gui1 = new GUIShape(s);
		Point2D p1 = new Point2D(0.2,0.4);

		assertEquals(gui1.getShape(), p1);
		assertEquals(gui1.isFilled(), false);
		assertEquals(gui1.getColor(), Color.BLACK);
		assertEquals(gui1.getTag(), 0);
	}
	@Test
	void testGetShape() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui = new GUIShape(r1,fill,col,tag);
		assertEquals(gui.getShape(), r1);
	}
	@Test
	void testSetShape() {
		Rect2D r = new Rect2D();
		Segment2D seg1 = new Segment2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui = new GUIShape(r,fill,col,tag);
		gui.setShape(seg1);
		assertEquals(gui.getShape(), seg1);		
	}
	@Test
	void testIsFilled() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		assertEquals(gui1.isFilled(), fill);
	}
	@Test
	void testSetFilled() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		gui1.setFilled(true);
		assertEquals(gui1.isFilled(), true);
	}
	@Test
	void testGetColor() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		assertEquals(gui1.getColor(), col);
	}
	@Test
	void testSetColor() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		gui1.setColor(Color.BLUE);
		assertEquals(gui1.getColor(), Color.BLUE);
	}
	@Test
	void testGetTag() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		assertEquals(gui1.getTag(), tag);
	}
	@Test
	void testSetTag() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		gui1.setTag(2);
		assertEquals(gui1.getTag(), 2);
	}
	@Test
	void testCopy() {
		Rect2D r1 = new Rect2D();
		boolean fill = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		GUIShape gui2 = (GUIShape)(gui1.copy());
		assertEquals(gui2.getShape(), r1);
		assertEquals(gui2.isFilled(), fill);
		assertEquals(gui2.getColor(), col);
		assertEquals(gui2.getTag(), tag);
	}
	@Test
	void testToString() {
		Point2D p1 = new Point2D(2,4);
		Point2D p2 = new Point2D(8,10);
		Rect2D r1 = new Rect2D(p1,p2);
		boolean fill = false;
		Color col= Color.GREEN;
		int tag = 1;
		GUIShape gui1 = new GUIShape(r1,fill,col,tag);
		assertEquals(gui1.toString(), "GUIShape,65280,false,1,Rect2D,2.0,4.0,8.0,10.0");
	}
}
