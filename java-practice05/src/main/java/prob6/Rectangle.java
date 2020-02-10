package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;
	public Rectangle(double width, double height) {//사각형
		this.width = width;
		this.height = height;
		area = width*height;
		perimeter = (width+height) * 2; //사각형 둘레 
	}
	
	public double getArea() {
		return area;
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	public void resize(double s) {
		width = width * s;
		height = height * s;
		perimeter = (width+height)*2;
		area = width*height;
	}
}
