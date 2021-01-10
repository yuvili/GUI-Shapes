package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;
import java.util.InputMismatchException;

import ex4.geometry.*;

public class GUIShape implements GUI_Shape{

	private GeoShape _gs;
	private boolean _fill;
	private Color _color;
	private int _tag;

	public GUIShape (GeoShape geo, boolean fi, Color col, int n) {

		this._gs = geo;
		this._fill = fi;
		this._color = col;
		this._tag = n;
	}

	public GUIShape(GUIShape gus){
		this(gus._gs, gus._fill, gus._color, gus._tag);
	}
	
	public GUIShape(){
		this._gs = new Rect2D(); 
		this._fill = true;
		this._color = Color.BLACK;
		this._tag = 3;
	}

	public GUIShape (String str) {
		try {
			String[] dat = str.split(",");
			this._color = new Color(Integer.parseInt(dat[1]));
			if(dat[2].equals("true")) {
				this._fill = true;
			}
			else {
				this._fill = false;
			}
			this._tag = Integer.parseInt(dat[3]);
			String x = dat[4];
				if(x.equals("Point2D")) {
					this._gs = new Point2D(dat[5]+","+""+dat[6]);
				}
				if(x.equals("Circle2D")) {
					this._gs= new Circle2D(dat[5]+","+""+dat[6]+","+""+dat[7]);
				}
				if(x.equals("Rect2D")) {
					this._gs= new Rect2D(dat[5]+","+""+dat[6]+","+""+dat[7]+","+""+dat[8]);
				}
				if(x.equals("Segment2D")) {
					this._gs= new Segment2D(""+dat[5]+","+""+dat[6]+","+""+dat[7]+","+""+dat[8]);
				}
				if(x.equals("Triangle2D")){
					this._gs= new Triangle2D(""+dat[5]+","+""+dat[6]+","+""+dat[7]+","+""+dat[8]+","+""+dat[9]+","+""+dat[10]);
				}
			
				if(this._gs == null) {throw new InputMismatchException();}
		}
		catch(InputMismatchException e) {
			System.err.println("Error, shape will set to default");
			
			this._gs = new Rect2D();
			this._fill = true;
			this._color = Color.BLACK;
			this._tag = 3;
		}
	}
	@Override
	public GeoShape getShape() {
		return this._gs;
	}

	@Override
	public void setShape(GeoShape g) {
		if (g instanceof Point2D) {
			this._gs = new Point2D((Point2D)g);
		}
		if (g instanceof Circle2D) {
			this._gs = new Circle2D((Circle2D)g);
		}
		if (g instanceof Rect2D) {
			this._gs = new Rect2D((Rect2D)g);
		}
		if (g instanceof Segment2D) {
			this._gs = new Segment2D((Segment2D)g);
		}
		if (g instanceof Triangle2D) {
			this._gs = new Triangle2D((Triangle2D)g);	
		}
	}

	@Override
	public boolean isFilled() {return this._fill;}

	@Override
	public void setFilled(boolean filled) {
		this._fill = filled;
	}

	@Override
	public Color getColor() {
		return this._color;
	}

	@Override
	public void setColor(Color cl) {
		this._color =new Color(cl.getRGB());
	}

	@Override
	public int getTag() {
		return this._tag;
	}

	@Override
	public void setTag(int tag) {
		this._tag = tag;
	}

	@Override
	public GUI_Shape copy() {
		GUIShape gs = new GUIShape(this);
		return gs;
	}
	@Override
	public String toString() {
		return "GUIShape," +(this._color.getRGB()&0xffffff)+","+this._fill+","+ this._tag 
				+ ","+ this._gs.getClass().getSimpleName()+","+this._gs.toString();
	}
}