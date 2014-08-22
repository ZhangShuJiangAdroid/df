package com.example.demo_paowuxian;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Ball {
	private float startX;
	private float startY;
	private float endX;
	private float endY;
	private float offset;
	private Paint paint;
	private float radius;
	private float curX;
	private float curY;
	private double a;
	private double b;
	
	private Path path;
	
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public void draw(Canvas canvas){
		canvas.drawPath(path, paint);
		canvas.drawCircle(curX, curY, radius, paint);
	}
	public float getStartX() {
		return startX;
	}
	public void setStartX(float startX) {
		this.startX = startX;
	}
	public float getStartY() {
		return startY;
	}
	public void setStartY(float startY) {
		this.startY = startY;
	}
	public float getEndX() {
		return endX;
	}
	public void setEndX(float endX) {
		this.endX = endX;
	}
	public float getEndY() {
		return endY;
	}
	public void setEndY(float endY) {
		this.endY = endY;
	}
	public float getOffset() {
		return offset;
	}
	public void setOffset(float offset) {
		this.offset = offset;
	}
	public Paint getPaint() {
		return paint;
	}
	public void setPaint(Paint paint) {
		this.paint = paint;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public float getCurX() {
		return curX;
	}
	public void setCurX(float curX) {
		this.curX = curX;
	}
	public float getCurY() {
		return curY;
	}
	public void setCurY(float curY) {
		this.curY = curY;
	}
	
	public void resetPath() {
		path.reset();
		path.moveTo(startX, startY);
	}
	
}
