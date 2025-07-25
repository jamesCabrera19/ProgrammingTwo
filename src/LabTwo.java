import java.util.Scanner;

public class LabTwo {

	// method to get user input, triangle sides 1,2,3, color
	public static Triangle getUsrInput(Scanner usrInput ) {
	    // array to store numbers from user
	    int[] sides = new int[3];
	    // loop to store user entered values
	    for (int i = 0; i < 3;) {
	        System.out.println("Enter side " + (i+1) + ": ");
	        // check to ensure that only int values are entered
	        if (usrInput.hasNextInt()) {
	        	int value = usrInput.nextInt();
	        	// secondary check to ensure no negative values are entered
	        	if(value > 0) {
	        		sides[i] = value;
			        i++;
	        	}else {
	                System.out.println("Please enter a number greater than zero.");
	        	}
	        }else {
            	usrInput.next(); 
                System.out.println("Please enter a valid integer.");
            }
	    }
	    // creating a triangle object with user entered values
	    Triangle t = new Triangle(sides[0], sides[1], sides[2]);

	    usrInput.nextLine(); 

	    System.out.print("Color of the triangle: ");
	    String color = usrInput.nextLine();
	    t.setColor(color);

	    System.out.print("Fill the triangle? (y/n): ");
	    String isFilled = usrInput.nextLine().trim().toLowerCase();

	    if (isFilled.equals("y")) {
	        t.setFilled(true);
	    } else {
	        t.setFilled(false);
	    }

	    return t;
	}
	
	public static void main(String[] args) {
		// creating Scanner object to access input
	    Scanner usrInput = new Scanner(System.in);

	    // variable that creates and stores Triangle.
		Triangle t = getUsrInput( usrInput );
		
		// triangle output
		System.out.println(t + " color: " +t.getColor() +" is filled: "+ t.getFilled());
		System.out.println();
		System.out.println("Triangle Area: " + t.getArea() + ". Triagle Perimeter: " + t.getPerimeter());

		// closing the scanner object to avoid memory leaks
	    usrInput.close();
	}
	
}
class GeometricObject{
	// data fields
	private  String color;
	private boolean filled;
	
	// constructors
	public GeometricObject() {
		this.color = "";
		this.filled = false;
	}
	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	
	// set and get methods
	public String getColor() {
		return color;
	}
	public boolean getFilled() {
		return filled;
	}
	// set methods
	public void setColor(String color) {
		this.color = color;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
}

class Triangle extends GeometricObject{
	// data fields
	private double side1;
	private double side2; 
	private double side3; 
	
	// no-arg constructor
	public Triangle() {
		this.side1 = 1.0;
		this.side2 = 1.0;
		this.side3 = 1.0;
	}
	
	// constructor
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	// get and set methods
	public double getSideOne() {
		return side1;
	}
	public double getSideTwo() {
		return side2;
	}public double getSideThree() {
		return side3;
	}
	// set methods.
	public void setSideOne(double side) {
		this.side1 = side;
	}
	public void setSideTwo(double side) {
		this.side2 = side;
	}
	public void setSideThree(double side) {
		this.side3 = side;
	}
	// other methods
	// area method - gets area of the triangle
	public double getArea() {
		return 0.5 * side1 * side2;
	}
	// perimeter method
	public double getPerimeter() {
		return side1+ side2 + side3;
	}

	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 +" side3 = " + side3;
	}
	
}