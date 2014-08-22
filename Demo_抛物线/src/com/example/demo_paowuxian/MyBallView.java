package com.example.demo_paowuxian;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MyBallView extends View{
	private static final int NUM = 6;
	private static final int DURATION = 3000;
	private Ball[] balls = new Ball[NUM];
	private float[] startYs = new float[]{80,220,400,500,600,650};
	private int[] colors = {0xffff0000,0xffCD00CD,0xff0000ff,0xff776644,0xffDB7093,0xff2F4F4F};
	private AnimatorUpdateListener updateListener = new AnimatorUpdateListener() {
		private boolean[] isFirsts = new boolean[]{true,true,true,true,true,true};
		@Override
		public void onAnimationUpdate(ValueAnimator arg0) {
			float x = (Float) arg0.getAnimatedValue();
			for (int i = 0; i < NUM; i++) {
				if(isFirsts[i]){
					double a = (balls[i].getEndY()-balls[i].getStartY())/(Math.pow(balls[i].getEndX()-balls[i].getOffset(), 2)-Math.pow(balls[i].getStartX()-balls[i].getOffset(), 2));
					double b = balls[i].getStartY()-Math.pow(balls[i].getStartX()-balls[i].getOffset(), 2)*a;
					balls[i].setA(a);
					balls[i].setB(b);
					isFirsts[i] = false;
				}

				balls[i].setCurX(x);
				balls[i].setCurY((int) (Math.pow(x-balls[i].getOffset(), 2)*balls[i].getA()+balls[i].getB()));
				balls[i].getPath().lineTo(x, balls[i].getCurY());

			}
			invalidate();
		}
	};
	private float startX = 17,endX = 300;
	private float endY = 700;
	private float offset = 80;
	@SuppressLint("NewApi")
	public MyBallView(Context context) {
		super(context);
		for (int i = 0; i < NUM; i++) {
			Ball ball = new Ball();
			Paint paint = new Paint();
			paint.setColor(colors[i]);
			paint.setAntiAlias(true);
			paint.setStyle(Style.STROKE);
			ball.setPaint(paint);
			ball.setStartX(startX);
			ball.setEndX(endX);
			ball.setStartY(startYs[i]);
			ball.setEndY(endY);
			ball.setOffset(offset);
			ball.setRadius(10);
			ball.setPath(new Path());
			ball.resetPath();
			balls[i] = ball;
		}

		anim = ValueAnimator.ofFloat(startX,endX);
		anim.setDuration(DURATION);
		anim.setRepeatCount(-1);
		anim.setInterpolator(new AccelerateDecelerateInterpolator());
		anim.addUpdateListener(updateListener );
		anim.addListener(listener);
		anim.start();
	}

	ValueAnimator anim;
	AnimatorListener listener = new AnimatorListener() {
		@Override
		public void onAnimationStart(Animator arg0) {

		}
		@Override
		public void onAnimationRepeat(Animator arg0) {
			for (int i = 0; i < NUM; i++) {
				balls[i].resetPath();
			}
		}
		@Override
		public void onAnimationEnd(Animator arg0) {

		}
		@Override
		public void onAnimationCancel(Animator arg0) {

		}
	};

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (int i = 0; i < NUM; i++) {
			balls[i].draw(canvas);
		}


	}
}
