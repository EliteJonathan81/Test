/**
 * Class that defines a triangle of various side lengths.
 * This class can only be accessed from within the package.
 * @author jg971
 * @version 1
 * @release 04/11/16
 */
class Triangle {
	
	private float sideA;
	private float sideB;
	private float sideC;
	
	
	/**
	 * Creates a new triangle with all sides of length 1.
	 */
	Triangle(){
		sideA = 1.0f; 
		sideB = 1.0f;
		sideC = 1.0f;
	}
	
	/**
	 * Creates a new triangle with manually specified side lengths.
	 * @param sideAPar, sideBPar, sideCPar - the sides of the triangle.
	 * If any of these are invalid all sides will be set to 1 and an error message will
	 * be printed.
	 */
	Triangle(float sideAPar, float sideBPar, float sideCPar){	
		if (sideAPar > 0 && sideBPar > 0 && sideCPar > 0) {
			sideA = sideAPar;
			sideB = sideBPar;
			sideC = sideCPar;
		}
		else {
			System.out.println("Side lengths must be > 0, they've all been set to 1.");
			sideA = 1.0f;
			sideB = 1.0f;
			sideC = 1.0f;
		}	
	}
	
	/**
	 * @return the length of the first side of the triangle.
	 */
	float getSideA() {
		return sideA;
	}
	
	/**
	 * @param sideAPar - sets the length of the first side of the triangle to this value.
	 * If this is <= 0 it will print an error message.
	 */
	void setSideA(float sideAPar) {
		if (sideAPar > 0) {
			sideA = sideAPar;
		}
		else {
			System.out.println("Side length must be > 0.");
		}
	}
	
	/**
	 * The following mutators and accessors get / set the 2nd and 3rd side lengths.
	 */
	float getSideB() {
		return sideB;
	}
	void setSideB(float sideBPar) {
		
		if (sideBPar > 0) {
			sideB = sideBPar;
		}
		else {
			System.out.println("Side length must be > 0.");
		}
		
	}
	float getSideC() {
		return sideC;
	}
	void setSideC(float sideCPar) {
		
		if (sideCPar > 0) {
			sideC = sideCPar;
		}
		else {
			System.out.println("Side length must be > 0.");
		}
		
	}
	
	
	/**
	 * @return the perimeter of the triangle.
	 */
	float calcPerimeter(){
		return (float)(sideA + sideB + sideC);
	}
	
	/**
	 * @return the area of the triangle.
	 */
	float calcArea(){
		/* Uses Heron's formula. Local variable s in Heron's formula is half the 
		 * perimeter */
		float s = calcPerimeter() / 2;
		return (float)(Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)));
		
	}
	
	
}



/**
 * This program outputs the area and perimeter of 3 different triangles.
 */
public class Lab4ex2 {

	public static void main(String[] args) {
		float[][] sideVals = { {3.0f, 4.0f, 5.0f} , {10.0f, 11.3f, 13.1f}, 
			{15.0f, 20.0f, 24.0f} };
		
		for (int i = 0; i < 3; i++){
			Triangle myTriangle = new Triangle(sideVals[i][0], sideVals[i][1], 
				sideVals[i][2]);
			System.out.format("perimeter: %.2f\n", myTriangle.calcPerimeter());
			System.out.format("area: %.2f\n", myTriangle.calcArea());
			System.out.print( i < 2 ? "\n" : "");
		}

	}

}





