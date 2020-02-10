package prob6;

public class RectTriangle extends Shape{
	private double width;
	private double height;
	public RectTriangle(double width, double height) { //삼각형
		this.width = width;
		this.height = height;
		area = width * height * 0.5; //직각삼각형 넓이
		perimeter = width+height+Math.sqrt( Math.pow(width,2)+Math.pow(height, 2) ); //직각삼각형 둘레
	}
	public double getArea() {
		return area;
	}
	public double getPerimeter() {
		return perimeter; 
	}
}
