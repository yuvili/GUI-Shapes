package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class Shape_CollectionTest {

	@Test
	void testShape_Collection() {
		ArrayList <GUI_Shape> al= new ArrayList<GUI_Shape>();
		GUIShape gui = new GUIShape();
		al.add(gui);
		assertEquals(al.get(0).getShape(), new Rect2D());
		assertEquals(al.get(0).isFilled(), true);
		assertEquals(al.get(0).getColor(), Color.BLACK);
		assertEquals(al.get(0).getTag(), 3);
	}
	@Test
	void testGet() {
		Shape_Collection sc = new Shape_Collection();
		Rect2D r = new Rect2D();
		boolean fi = false;
		Color col= Color.black;
		int tag = 1;
		GUIShape gui = new GUIShape(r,fi,col,tag);
		sc.add(gui);
		assertEquals(sc.get(0), gui);
	}
	@Test
	void testSize() {
		Rect2D r = new Rect2D();
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui = new GUIShape(r,filled1,color1,tag1);

		Triangle2D tr = new Triangle2D();
		boolean filled2 = false;
		Color color2= Color.black;
		int tag2 = 2;
		GUIShape gui2 = new GUIShape(tr,filled2,color2,tag2);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui); sc.add(gui2);
		assertEquals(sc.size(), 2);
	}
	@Test
	void testRemoveElementAt() {
		Rect2D r = new Rect2D();
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(r,filled1,color1,tag1);

		Triangle2D tr = new Triangle2D();
		boolean filled2 = false;
		Color color2= Color.black;
		int tag2 = 2;
		GUIShape gui2 = new GUIShape(tr,filled2,color2,tag2);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1); sc.add(gui2);
		assertEquals(sc.removeElementAt(0), gui1);
	}
	@Test
	void testAdd() {
		Rect2D r = new Rect2D();
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(r,filled1,color1,tag1);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1); 
		assertEquals(sc.get(0) , gui1);
	}
	@Test
	void testAddAt() {
		Rect2D r = new Rect2D();
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(r,filled1,color1,tag1);

		Triangle2D tr = new Triangle2D();
		boolean filled2 = false;
		Color color2= Color.black;
		int tag2 = 2;
		GUIShape gui2 = new GUIShape(tr,filled2,color2,tag2);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1); sc.addAt(gui2,0);
		assertEquals(sc.get(0), gui2);
	}
	@Test
	void testCopy() {
		Rect2D r = new Rect2D();
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(r,filled1,color1,tag1);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1); 
		Shape_Collection sc1 = (Shape_Collection)sc.copy();
		assertEquals(sc1.get(0).getShape(), sc.get(0).getShape());
		assertEquals(sc1.get(0).isFilled(), sc.get(0).isFilled());
		assertEquals(sc1.get(0).getColor(), sc.get(0).getColor());
		assertEquals(sc1.get(0).getTag(), sc.get(0).getTag());

	}
	@Test
	void testSort() {
		Rect2D r = new Rect2D();
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(r,filled1,color1,tag1);

		Triangle2D tr = new Triangle2D();
		boolean filled2 = false;
		Color color2= Color.black;
		int tag2 = 2;
		GUIShape gui2 = new GUIShape(tr,filled2,color2,tag2);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1); sc.add(gui2);
		int comp1 = 1;
		Shape_Comp comp = new Shape_Comp(comp1);

		sc.sort(comp);
		assertEquals(sc.get(0), gui2);
		assertEquals(sc.get(1), gui1);
	}
	@Test
	void testRemoveAll() {
		Rect2D r = new Rect2D();
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(r,filled1,color1,tag1);

		Triangle2D tr = new Triangle2D();
		boolean filled2 = false;
		Color color2= Color.black;
		int tag2 = 2;
		GUIShape gui2 = new GUIShape(tr,filled2,color2,tag2);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1); sc.add(gui2);
		sc.removeAll();
		assertEquals(sc.size(), 0);
	}
	@Test
	void testSave() {
		 Shape_Collection sc = new Shape_Collection();
	        String file = "C:\\Users\\ASUS\\Documents\\test_ShapeColi";
	        sc.add(new GUIShape("GUIShape,0,false,1,Segment2D,0.0,1.0,1.0,0.0"));
	        sc.add(new GUIShape("GUIShape,16756655,false,2,Rect2D,0.0,2.0,1.0,4.0"));
	        sc.add(new GUIShape("GUIShape,255,true,3,Triangle2D,9.32,0.0,4.5,9.0,3.14,8.0"));
	        sc.add(new GUIShape("GUIShape,16762880,true,4,Circle2D,9.0,7.0, 5.0"));
	        sc.save(file);
	        File tmpDir = new File("C:\\Users\\ASUS\\Documents\\test_ShapeColi");
	        boolean file_exists = tmpDir.exists();
	        assertTrue(file_exists);
	}
		@Test
		void testLoad() {
			Shape_Collection sc = new Shape_Collection();
	        sc.load("C:\\Users\\ASUS\\Documents\\test_ShapeColi");
	        assertTrue(sc.get(0).toString().equals("GUIShape,0,false,1,Segment2D,0.0,1.0,1.0,0.0"));
	        assertTrue(sc.get(1).toString().equals("GUIShape,16756655,false,2,Rect2D,0.0,2.0,1.0,4.0"));
	        assertTrue(sc.get(2).toString().equals("GUIShape,255,true,3,Triangle2D,9.32,0.0,4.5,9.0,3.14,8.0"));
	        assertTrue(sc.get(3).toString().equals("GUIShape,16762880,true,4,Circle2D,9.0,7.0, 5.0"));
		}
	@Test
	void testGetBoundingBox() {
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(0,2);
		Point2D p3 = new Point2D(4.5,9);
		Point2D p4 = new Point2D(9.32,0);
		Point2D p5 = new Point2D(3.14,8);
		Point2D p6 = new Point2D(9,7);
		Point2D p7 = new Point2D(1,0);
		Point2D p8 = new Point2D(0,1);
		double rad = 5; 

		Segment2D s1 = new Segment2D(p8,p7);
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(s1,filled1,color1,tag1);

		Rect2D r1 = new Rect2D(p1,p2);
		Color color2= Color.pink;
		int tag2 = 2;
		GUIShape gui2 = new GUIShape(r1,filled1,color2,tag2);

		Triangle2D t1 = new Triangle2D(p4,p3,p5);
		boolean filled2 = true;
		Color color3= Color.blue;
		int tag3 = 3;
		GUIShape gui3 = new GUIShape(t1,filled2,color3,tag3);

		Circle2D c1 = new Circle2D(p6,rad);
		Color color4= Color.orange;
		int tag4 = 4;
		GUIShape gui4 = new GUIShape(c1,filled2,color4,tag4);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1);sc.add(gui2);sc.add(gui3);sc.add(gui4);

		Point2D pBox1 = new Point2D(0,0);
		Point2D pBox2 = new Point2D(9.32,9);
		Rect2D box1 = new Rect2D(sc.getBoundingBox());
		assertEquals(box1._C(), pBox1);
	}
	@Test
	void testToString() {
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(0,4);
		Point2D p3 = new Point2D(4.5,9);
		Point2D p4 = new Point2D(9.32,0);
		Point2D p5 = new Point2D(3.14,8);
		Point2D p6 = new Point2D(9,7);
		Point2D p7 = new Point2D(1,0);
		Point2D p8 = new Point2D(0,1);
		double rad = 5; 

		Segment2D s1 = new Segment2D(p8,p7);
		boolean filled1 = false;
		Color color1= Color.black;
		int tag1 = 1;
		GUIShape gui1 = new GUIShape(s1,filled1,color1,tag1);

		Rect2D r1 = new Rect2D(p1,p2);
		Color color2= Color.pink;
		int tag2 = 2;
		GUIShape gui2 = new GUIShape(r1,filled1,color2,tag2);

		Triangle2D t1 = new Triangle2D(p4,p3,p5);
		boolean filled2 = true;
		Color color3= Color.blue;
		int tag3 = 3;
		GUIShape gui3 = new GUIShape(t1,filled2,color3,tag3);

		Circle2D c1 = new Circle2D(p6,rad);
		Color color4= Color.orange;
		int tag4 = 4;
		GUIShape gui4 = new GUIShape(c1,filled2,color4,tag4);

		Shape_Collection sc = new Shape_Collection();
		sc.add(gui1);sc.add(gui2);sc.add(gui3);sc.add(gui4);

		assertEquals(sc.toString(), "GUIShape,0,false,1,Segment2D,0.0,1.0,1.0,0.0" + "\n"
				+ "GUIShape,16756655,false,2,Rect2D,0.0,2.0,1.0,4.0" + "\n"
				+ "GUIShape,255,true,3,Triangle2D,9.32,0.0,4.5,9.0,3.14,8.0" + "\n"
				+ "GUIShape,16762880,true,4,Circle2D,9.0,7.0, 5.0");
	}

}
