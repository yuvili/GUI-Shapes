package ex4.geometry;

public class Triangle2D implements GeoShape{

	private Point2D _A;
	private Point2D _B;	
	private Point2D _C;

	public Triangle2D (Point2D a, Point2D b, Point2D c) {
		
			this._A = new Point2D(a);
			this._B = new Point2D(b);
			this._C = new Point2D(c);
	}
	
	public Triangle2D (Triangle2D tr) 
	{

		this(tr._A, tr._B, tr._C);
	}
	
	public Triangle2D(String s) {
		try {
			String[] a = s.split(",");
			double x = Double.parseDouble(a[0]);
			double y = Double.parseDouble(a[1]);
			_A= new Point2D(x,y);
			double z = Double.parseDouble(a[2]);
			double t = Double.parseDouble(a[3]);
			_B= new Point2D(z,t);
			double m = Double.parseDouble(a[4]);
			double n = Double.parseDouble(a[5]);
			_C= new Point2D(m,n);
		}
		catch(IllegalArgumentException e) {
			System.err.println("ERR: got wrong format string for Triangle2D init, got:"+s+"  should be of format: x,y,z,t,m,n");
			throw(e);
		}
	}
	public Triangle2D() {
		this._A= new Point2D(6,7);
		this._B=new Point2D(4,5);
		this._C= new Point2D(2,3);
	}

	public Point2D _A() {return new Point2D(_A);}
	public Point2D _B() {return new Point2D(_B);}
	public Point2D _C() {return new Point2D(_C);}

	@Override
	public boolean contains(Point2D ot) {
		Triangle2D tri0= new Triangle2D(_A,_B,_C);
		Triangle2D tri1= new Triangle2D(_A,_B,ot);
		Triangle2D tri2= new Triangle2D(_A,_C,ot);
		Triangle2D tri3= new Triangle2D(_B,_C,ot);	

		double ar= tri0.area();
		double ar1= tri1.area();
		double ar2= tri2.area();
		double ar3= tri3.area();

		return (ar1+ar2+ar3 == ar);
	}

	@Override
	public Point2D centerOfMass() {
		double x = (this._A.x() + this._B.x() + this._C.x())/3;
		double y = (this._A.y() + this._B.y() + this._C.y())/3;
		Point2D center = new Point2D(x,y);
		return center;
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() 
	{
		double AC= _C.distance(_A);
		double AB= _B.distance(_A);
		double BC= _C.distance(_B);

		double s = 0.5 *(AC+AB+BC);
		double ar = Math.sqrt(s*(s-AC)*(s-AB)*(s-BC));
		return ar;
	}

	@Override
	public double perimeter()
	{
		double AC= _C.distance(_A);
		double AB= _B.distance(_A);
		double BC= _C.distance(_B);

		double per = AC+AB+BC;
		return per;
	}
	
	public boolean equals(Object t)
	{
		if(t==null || !(t instanceof Triangle2D)) {return false;}
		Triangle2D t2 = (Triangle2D)t;
		return ((_A.x() == t2._A.x()) && (_B.x() == t2._B.x()) &&  (_C.x() == t2._C.x()) 
			&& (_A.y() == t2._A.y()) && (_B.y() == t2._B.y()) && (_C.x() == t2._C.x()));
	}

	@Override
	public void move(Point2D vec) {
		_A.move(vec);
		_B.move(vec);
		_C.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Triangle2D(this);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[3];
		ans[0] = new Point2D(this._C);
		ans[1] = new Point2D(this._B);
		ans[2] = new Point2D(this._A);
		return ans;
	}
	@Override
	public String toString() {
		return _A.toString()+","+ _B.toString()+","+ _C.toString();
	}
}
