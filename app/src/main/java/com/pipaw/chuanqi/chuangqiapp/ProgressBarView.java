package com.pipaw.chuanqi.chuangqiapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ProgressBarView extends View {

	private int newProgress;
	private Paint mPaint;

	public ProgressBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setColor(0xff0080ff);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRect(0, 0, newProgress * getWidth() / 100, getHeight(),
				mPaint);
	}

	public void setProgress(int newProgress) {
		this.newProgress = newProgress;
		invalidate();
	}

	@Override
	public void setVisibility(int visibility) {
		super.setVisibility(visibility);
		if (visibility == View.GONE) {
			newProgress = 0;
			invalidate();
		}
	}

}
