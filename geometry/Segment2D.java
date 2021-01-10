package ex4.geometry;

public class Segment2D implements GeoShape{

	private Point2D _A;
	private Point2D _B;	

	public Segment2D(Point2D b, Point2D a) {
		
			this._A = new Point2D(a);
			this._B = new Point2D(b);
	}

	public Segment2D(Segment2D seg) 
	{
		this(seg._B, seg._A);
	}

	public Segment2D(String s) {
		try {
			String[] a = s.split(",");
			double x = Double.parseDouble(a[0]);
			double y = Double.parseDouble(a[1]);
			_B= new Point2D(x,y);
			double z = Double.parseDouble(a[2]);
			double t = Double.parseDouble(a[3]);
			_A= new Point2D(z,t);
		}
		catch(IllegalArgumentException e) {
			System.err.println("ERR: got wrong format string for Segment2D init, got:"+s+"  should be of format: x,y,z,t");
			throw(e);
		}
	}
	public Segment2D() {
		this._B = new Point2D(2,5);
		this._A = new Point2D(8,13.0908);
	}

	public Point2D _A() {return new Point2D(_A);}
	public Point2D _B() {return new Point2D(_B);}

	@Override
	public boolean contains(Point2D ot) {
		return (_B.distance(ot) + _A.distance(ot) == _B.distance(_A));
	}

	@Override
	public Point2D centerOfMass()
	{
		double cenX= 0.5*(this._B.x() + this._A.x());
		double cenY= 0.5*(this._B.y() + this._A.y());

		return new Point2D(cenX , cenY);
	}

	/**
	 */
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		return (_B.distance(_A)) * 2;
	}
	
	public boolean equals(Object s)
	{
		if(s==null || !(s instanceof Segment2D)) {return false;}
		Segment2D s2 = (Segment2D)s;
		return ( (_A.x() == s2._A.x()) && (_B.x() == s2._B.x()) && (_A.y() == s2._A.y()) && (_B.y() == s2._B.y()));
	}

	@Override
	public void move(Point2D vec) {
		_B.move(vec);
		_A.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment2D(this);
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._B);
		ans[1] = new Point2D(this._A);
		return ans;
	}
	@Override
	public String toString() {
		return _B.toString()+","+ _A.toString();
	}
}