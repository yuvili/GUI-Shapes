package ex4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{

	public static void main (String [] args) {
		try {
			String fileN = args[0];
			if (fileN.charAt(0)=='"') {
				fileN = fileN.substring(1);
			}
			if (fileN.charAt(fileN.length()-1)=='"') {
				fileN = fileN.substring(0, fileN.length()-1);
			}
			File fileX = new File(fileN);
			Scanner reader = new Scanner(fileX);
			int sorting = -1;
			try {
				sorting = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				// do nothing
			}
			while (sorting < 0 || sorting >6) {
				System.err.println("Not compatible sort method");
				System.out.println("Enter a new sort method  [0,6]");
				Scanner scan = new Scanner(System.in);
				boolean y = true;
				while (y) {
					try {
						sorting = scan.nextInt();
						if (sorting < 0 || sorting > 6) {
							System.err.println("Not compatible sort method");
							System.out.println("Enter sort method [0,6]");
						}
					} catch (InputMismatchException e) {
						scan = new Scanner(System.in);
						System.err.println("Not a number...");
						System.out.println("Enter a number [0,6]");
					}
					if (sorting >= 0 && sorting <= 6) {
						scan.close();
						y = false;
					}
				}
			}
			Ex4 win = new Ex4();
			GUI_Shape_Collection gsc = new Shape_Collection();
			gsc.load(fileN);
			Shape_Comp scomp = new Shape_Comp(sorting);
			win.init(gsc);
			gsc.sort(scomp);
			win.show();
			reader.close();
			System.out.println("***Sorting by compartor method " + sorting + "***");
			System.out.println(win.getInfo());
		}
		catch (Exception e) {
			String fileN="";
			Scanner scan = new Scanner(System.in);
			boolean fnf = true;
			while (fnf) {
				System.out.println("Enter a valid file name including file path");				
				fileN = scan.nextLine();
				File fileX = new File(fileN);
				try {
					Scanner reader = new Scanner(fileX);
					fnf = false;
				} catch (FileNotFoundException e1) {
					System.err.println("WRONG FILE NAME");
				}
			}
			System.out.println("Enter sort method [0,6]");
			int sorting = -1;
			try {
				sorting = scan.nextInt();
			} catch (InputMismatchException e2) {
				boolean y = true;
				while (y) {
					System.err.println("Did not enter a number...");
					System.out.println("Please enter a number in the range [0,6]");
					scan = new Scanner(System.in);
					try {
						sorting = scan.nextInt();
					} catch (InputMismatchException e3) {
						continue;
					}
					if (sorting >= 0 && sorting <= 6) {
						scan.close();
						y = false;
					}
					if (sorting < 0 || sorting > 6) {
						y = false;
					}
				}
			}
			while (sorting < 0 || sorting > 6) {
				System.err.println("Wrong sort method.");
				System.out.println("Enter a new sort method [0,6]");
				boolean y = true;
				while (y) {
					scan = new Scanner(System.in);
					try {
						sorting = scan.nextInt();
					} catch (InputMismatchException e3) {
						System.err.println("Not a number...\nPlease enter a number [0,6]");
						continue;
					}
					if (sorting >= 0 && sorting <= 6) {
						y = false;
						scan.close();
					}
					if (sorting < 0 || sorting > 6) {
						y = false;
					}
				}
			}
			scan.close();
			Ex4 win = new Ex4();
			GUI_Shape_Collection gsc = new Shape_Collection();
			gsc.load(fileN);
			Shape_Comp scomp = new Shape_Comp(sorting);
			win.init(gsc);
			gsc.sort(scomp);
			win.show();
			System.out.println("***Sorting by compartor method " + sorting + "***");
			System.out.println(win.getInfo());
		}
	}



	private GUI_Shape_Collection gsc;

	public Ex4() {
		this.gsc = new Shape_Collection();
	}

	@Override
	public void init(GUI_Shape_Collection g) {
		gsc = g;
		Rect2D bb = gsc.getBoundingBox();
		Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
		GUI_Shape s7 = new GUIShape(bb,false, Color.gray,0);
		gsc.add(s7);
		double m0 = Math.min(min.x(), min.y());
		double m1 = Math.max(max.x(), max.y());
		StdDraw.setScale(m0-0.1,m1+0.1);
	}

	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return gsc;
	}

	@Override
	public void show() {
		for(int i = 0; i< gsc.size(); i++) {
			GUI_Shape guiSh = gsc.get(i);	
			StdDraw.setPenRadius(0.01);
			StdDraw.setPenColor(guiSh.getColor());
			Point2D [] arrPoints = guiSh.getShape().getPoints();
			String geoName = guiSh.getShape().getClass().getSimpleName();

			if(guiSh.getShape() instanceof Point2D) {
				StdDraw.setPenColor(guiSh.getColor());
				StdDraw.point(arrPoints[0].x(), arrPoints[0].y());
			}
			if(guiSh.getShape() instanceof Rect2D) {
				double x = guiSh.getShape().centerOfMass().x();
				double y = guiSh.getShape().centerOfMass().y();
				StdDraw.setPenColor(guiSh.getColor());
				double Length = arrPoints[1].y() - arrPoints[0].y();
				double Width = arrPoints[1].x() - arrPoints[0].x();

				if (guiSh.isFilled()) {
					StdDraw.filledRectangle(x, y, Width/2.0, Length/2.0);}
				else {
					StdDraw.rectangle(x, y, Width/2.0, Length/2.0);
				}
			}
			if(guiSh.getShape() instanceof Triangle2D) {
				double[] xp = new double[3], yp = new double[3];
				xp[0] = arrPoints[0].x(); xp[1] = arrPoints[1].x(); xp[2] = arrPoints[2].x();
				yp[0] = arrPoints[0].y(); yp[1] = arrPoints[1].y(); yp[2] = arrPoints[2].y();
				StdDraw.setPenColor(guiSh.getColor());

				if (guiSh.isFilled()) {
					StdDraw.filledPolygon(xp, yp);
				}
				else {StdDraw.polygon(xp, yp);
				}
			}
			if(guiSh.getShape() instanceof Circle2D) {
				StdDraw.setPenColor(guiSh.getColor());
				if (guiSh.isFilled()) {
					StdDraw.filledCircle(arrPoints[0].x(), arrPoints[0].y(), arrPoints[1].y() - arrPoints[0].y());
				}
				else {StdDraw.circle(arrPoints[0].x(), arrPoints[0].y(), arrPoints[1].y() - arrPoints[0].y());
				}
			}
			if(guiSh.getShape() instanceof Segment2D) {
				StdDraw.setPenColor(guiSh.getColor());
				StdDraw.line(arrPoints[0].x(), arrPoints[0].y(), arrPoints[1].x(), arrPoints[1].y());
			}
		}
	}	


	@Override
	public String getInfo() {
		String s = "";
		for(int i = 0; i>gsc.size(); i++) {
			s+= gsc.get(i).toString();
		}	

		return s;
	}
}
