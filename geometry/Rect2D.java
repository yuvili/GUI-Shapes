package ex4.geometry;

public class Rect2D implements GeoShape{

	private Point2D _B;
	private Point2D _C;

	public Rect2D(Point2D b, Point2D c) { 
		double xMin;
		double yMin;
		double xMax;
		double yMax;

		xMin = Math.min(c.x(), b.x());
		yMin = Math.min(c.y(), b.y());
		xMax = Math.max(c.x(), b.x());
		yMax = Math.max(c.y(), b.y());

		this._C = new Point2D(xMin,yMin);
		this._B = new Point2D(xMax,yMax);
	}

	public Rect2D(Rect2D rec) {
		this(rec._C , rec._B);
	}

	public Rect2D(String s) {
		try {
			String[] a = s.split(",");
			double x = Double.parseDouble(a[0]);
			double y = Double.parseDouble(a[1]);
			_C= new Point2D(x,y);
			double z = Double.parseDouble(a[2]);
			double t = Double.parseDouble(a[3]);
			_B= new Point2D(z,t);
		}
		catch(IllegalArgumentException e) {
			System.err.println("ERR: got wrong format string for Rect2D init, got:"+s+"  should be of format: x,y,z,t");
			throw(e);
		}
	}

	public Rect2D() {
		this._B = new Point2D(4.0,6.0);
		this._C = new Point2D(1.0,3.0);
	}

	public Point2D _B() {return new Point2D(_B);}
	public Point2D _C() {return new Point2D(_C);}

	@Override
	public boolean contains(Point2D ot) {
		return ((ot.x() >= this._C.x()) && (ot.x() <= this._B.x()) && (ot.y() >= this._C.y()) && 
				(ot.y() <= this._B.y()));
	}
	@Override
	public Point2D centerOfMass() {

		double cenX= 0.5*(this._B.x() + this._C.x());
		double cenY= 0.5*(this._B.y() + this._C.y());

		return new Point2D(cenX , cenY);
	}
	@Override
	public double area()
	{	
		return (this.getWeidth() * this.getHeight());
	}

	@Override
	public double perimeter() {
		
		return ((this.getWeidth() + this.getHeight()) * 2);
	}

	public double getWeidth() {
		double x1= Math.abs(this._B.x()); 
		double x2= Math.abs(this._C.x()); 
		return Math.abs(x1-x2);
	}

	public double getHeight(){
		double y1= Math.abs(this._B.y()); 
		double y2= Math.abs(this._C.y()); 
		return Math.abs(y1-y2);
	}
	
	public boolean equals(Object r)
	{
		if(r==null || !(r instanceof Rect2D)) {return false;}
		Rect2D r2 = (Rect2D)r;
		return ( (_B.x() == r2._B.x()) && (_C.x() == r2._C.x()) && (_B.y() == r2._B.y()) && (_C.y() == r2._C.y()));
	}
	
	@Override
	public void move(Point2D vec) {
		_C.move(vec);
		_B.move(vec);

	}
	@Override
	public GeoShape copy() {
		return new Rect2D(this._B, this._C);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._C);
		ans[1] = new Point2D(this._B);
		return ans;
	}
	@Override
	public String toString() {
		return _C.toString()+","+ _B.toString();
	}
}