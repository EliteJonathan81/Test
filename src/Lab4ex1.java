
/**
 * Class that defines a 2d point in space.
 * This class can only be accessed from within the package.
 * @author jg971
 * @version 1
 * @release 04/11/16
 */


class Point {
	
	private double x;
	private double y;
		
	/**
	 * Constructor to set the x co-ord & y co-ord to be their default values (1).
	 */
	Point(){
		x = 1;
		y = 1;
	}
		
	/**
	 * Constructor to set x and y co-ordinates according to parameters.
	 * @param xParam - value to set the x co-ord.
	 * @param yParam - value to set the y co-ord.
	 */
	Point(int xParam, int yParam){
		x = xParam;
		y = yParam;
	}
		
	/**
	 * @param xParam - sets the x co-ordinate to this value.
	 */
	void setx(double xParam){
		x = xParam;
	}
	
	/**
	 * @param yParam - sets the y co-ordinate to this value.
	 */
	void sety(double yParam){
		y = yParam;
	}
	
	/**
	 * @returns the x co-ordinate.
	 */
	double getx(){
		return x;
	}
	
	
	/**
	 * @return the y co-ordinate.
	 */
	double gety(){
		return y;
	}
	
	
	/**
	 * @param point2 - another object of this class.
	 * @return the euclidian distance between this point and "point2".
	 */
	double calcDist(Point point2){
		double diffX = (x - point2.getx());
		double diffY = (y - point2.gety());
		return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY,2));
	}
	
}


/**
 * This program outputs the distance between 3 sets of 2 points.
 */
public class Lab4ex1 {

	public static void main(String[] args) {
		
		int[][] Point1Vals = { {5,14} , {10,4}, {3,3} };
		int[][] Point2Vals = { {10,3} , {1,6}, {10,10} };
		
		for (int i = 0; i < 3; i++){
			Point Point1 = new Point(Point1Vals[i][0], Point1Vals[i][1]);
			Point Point2 = new Point(Point2Vals[i][0], Point2Vals[i][1]);
			//System.out.format("Distance: %.2f", Point1.calcDist(Point2));
			System.out.print("Distance: " + Point1.calcDist(Point2));
			System.out.println( i < 2 ? "\n" : "");
		}
		
	}

}
