package input.components.point;

import utilities.math.MathUtilities;

/**
 * A 2D Point (x, y).
 */
public class PointNode
{
	protected static final String ANONYMOUS = "__UNNAMED";

	protected double _x;
	public double getX() { return this._x; }

	protected double _y; 
	public double getY() { return this._y; }

	protected String _name; 
	public String getName() { return _name; }

	/**
	 * Create a new Point with the specified coordinates.
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y)
	{
		_name = ANONYMOUS;
		_x = x;
		_y = y;
	}

	/**
	 * Create a new Point with the specified coordinates.
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y)
	{
		_name = name;
		_x = x;
		_y = y;
	}

	/**
	 * Returns the hash code of this object.
	 * @return the hash code of this object
	 */
	@Override
	public int hashCode()
	{
		return Double.valueOf(_x).hashCode() + Double.valueOf(_y).hashCode();
	}

	/**
	 * Checks whether a given PointNode is equal to this PointNode. Returns false if given a non-PointNode or if
	 * any of its contents do not match.
	 * @param obj - object to check
	 * @return whether the PointNodes are equal
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) { return false; }
		if (!obj instanceof PointNode) { return false; } 
		
		if (!obj.getX() == _x) { return false; }
		if (!obj.getY() == _y) { return false; }
		if (!obj.getName().equals(_name)) { return false; }
		
		return true;
	}

	/**
	 * Returns a string version of the PointNode as:
	 * name: (x, y)
	 * @return string version of this object
	 */
    @Override
    public String toString()
    {
		return _name + ": (" + _x + ", " + _y + ")";
	}
}