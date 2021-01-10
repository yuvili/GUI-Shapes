package ex4;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{

	private ArrayList <GUI_Shape> _sc;

	public Shape_Collection() {
		this._sc = new ArrayList <GUI_Shape>();
	}

	@Override
	public GUI_Shape get(int i) {
		return _sc.get(i);
	}

	@Override
	public int size() {
		return _sc.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		return _sc.remove(i);
	}

	@Override
	public void add(GUI_Shape s) {
		_sc.add((GUIShape) s);	
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		_sc.add(i, (GUIShape) s);
	}

	@Override
	public GUI_Shape_Collection copy() {

		GUI_Shape_Collection gs = new  Shape_Collection();

		for(int i=0; i< _sc.size(); i++) {
			GUI_Shape gui = new GUIShape(_sc.get(i).toString());
			gs.add(gui);		
		}

		return  gs;
	}

	@Override
	public void sort(Comparator comp) {
		Collections.sort(_sc, comp);
	}

	@Override
	public void removeAll() {
		this._sc.removeAll(_sc);
	}

	@Override
	public void save(String file) {
		try {
			File filenew = new File(file);
			FileWriter myWriter = new FileWriter(filenew);
			
			myWriter.write(this.toString() + "\n");

			myWriter.close(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String file) {
		try {
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				GUIShape x = new GUIShape(data);
				_sc.add(x);
			}
			myReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Rect2D getBoundingBox() {
		double xMin = Double.MAX_VALUE;
		double yMin = Double.MAX_VALUE;
		double xMax= -Double.MAX_VALUE;
		double yMax = -Double.MAX_VALUE;

		for(int i=0; i < this._sc.size(); i++) {

			GeoShape guiS = this.get(i).getShape();
			Point2D[] points = guiS.getPoints();

			if(guiS instanceof  Circle2D) {
				Circle2D newCircle = new Circle2D((Circle2D)guiS);

				if(xMin > newCircle.centerOfMass().x() - newCircle.getRadius()) {
					xMin = newCircle.centerOfMass().x() - newCircle.getRadius();
				}
				if(yMin > newCircle.centerOfMass().y() - newCircle.getRadius()) {
					yMin = newCircle.centerOfMass().y() - newCircle.getRadius();
				}
				if(xMax < newCircle.centerOfMass().x() + newCircle.getRadius() ) {
					xMax = newCircle.centerOfMass().x() + newCircle.getRadius();
				}
				if(yMax < newCircle.centerOfMass().y() + newCircle.getRadius()) {
					yMax = newCircle.centerOfMass().y() + newCircle.getRadius();
				}				
			}
			else {
				for(int j=0; j<points.length; j++) {
					if(xMax<points[j].x()) {
						xMax=points[j].x();
					}
					if(xMin>points[j].x()) {
						xMin=points[j].x();
					}
					if(yMin>points[j].y()) {
						yMin=points[j].y();
					}
					if(yMax<points[j].y()) {
						yMax=points[j].y();
					}
				}
			}
		}
	
		return new Rect2D(new Point2D(xMin, yMin), new Point2D(xMax, yMax));
	}

	@Override
	public String toString() {
		String s= "";
		for (int i = 0; i<_sc.size(); i++) {
			if(i !=_sc.size()-1) {
				s= s+ _sc.get(i).toString()+ "\n";
			}
			else {
				s= s+ _sc.get(i).toString();
			}
		}

		return s;
	}
}
