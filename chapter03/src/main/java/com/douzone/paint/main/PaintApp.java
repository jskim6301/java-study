package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.Circle;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.point.Rect;
import com.douzone.paint.point.Triangle;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.text.GraphicText;


public class PaintApp {
	public static void main(String[] args) {
		Point point1 = new Point(2,5);
		point1.setX(2);
		point1.setY(5);
		//drawPoint(point1);
		draw(point1);
		
		
		
		Point point2 = new Point(10,50);
		//drawPoint(point2);
		draw(point2);
		
		
		//point2.show(true);
		//point2.show(false);
		
		ColorPoint point3 = new ColorPoint(50,100,"red");
		//drawPoint(point3);
		draw(point3);
		
		//point3.show(false);
		//point3.show(true);
		
		
		Rect rect = new Rect();
		//drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
		//drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
		//drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("hello"));
		
		
		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Circle);
		System.out.println(circle instanceof Shape);
		//오류 : class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다
		//System.out.println(circle instanceof Rect); => 이 경우는 hierachy 관계가 옆에 있는 경우이다
		System.out.println(circle instanceof Drawable);
		
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Rect);
		System.out.println(s instanceof Drawable);
	}
	
	public static void draw(Drawable d) {
		d.draw();
	}
	
	
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}
	
	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawRect(Triangle triangle) {
//		triangle.draw();
//	}
	
	public static void drawPoint(Point point) {
		point.show();
	}
	

}
