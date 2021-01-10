package ex4.geometry;

public class Circle2D implements GeoShape {

	private Point2D _center;
	private double _radius;

	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		try { this._radius = rad;

		if (0 > rad) {
			throw new IllegalArgumentException();
		}
		}
		catch(IllegalArgumentException e) {
			System.err.println("ERR: got wrong format double for Circle2D radius , got:"+rad+
					" should be of format: 0<=radius");

			this._radius = 1;
		}
	}

	public Circle2D(String s) {
		try {
			String[] a = s.split(",");
			double x = Double.parseDouble(a[0]);
			double y = Double.parseDouble(a[1]);
			_center= new Point2D(x,y);
			_radius = Double.parseDouble(a[2]);
		}
		catch(IllegalArgumentException e) {
			System.err.println("ERR: got wrong format string for Circle2D init, got:"+s+"  should be of format: x,y,z");
			throw(e);
		}
	}

	public Circle2D (Circle2D cir) 
	{
		this(cir._center ,cir._radius );
	}

	public Circle2D() {
		this._center= new Point2D(0,0);
		this._radius = 3.14;
	}

	public Point2D getCenter() {return this._center;}
	public double getRadius() {return this._radius;}

	public String toString() { return _center.toString()+", "+_radius;}

	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}

	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}

	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}

	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}

	public boolean equals(Object c)
	{
		if(c==null || !(c instanceof Circle2D)) {return false;}
		Circle2D c2 = (Circle2D)c;
		return (_center.x() == c2._center.x() && _center.y() == c2._center.y() && _radius == c2._radius);
	}

	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}

}
