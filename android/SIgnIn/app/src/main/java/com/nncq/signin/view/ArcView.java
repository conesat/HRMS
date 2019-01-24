package com.nncq.signin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;



public class ArcView extends View {


    int type = 0;

    int color = Color.rgb(180, 180, 180);


    public ArcView(Context context) {
        super(context, null);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    RectF rect=new RectF();
    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (type == 0) {
            color = Color.rgb(180, 180, 180);
        } else if (type == 1) {
            color = Color.rgb(35, 222, 25);
        }
        int W = getWidth() / 4 * 3;
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        rect.set(-(getHeight()-getWidth())/2,0,getWidth()+(getHeight()-getWidth())/2,getHeight());
        paint.setStrokeWidth((getHeight() - W));
        paint.setColor(Color.rgb(250,250,250));
        canvas.drawArc(rect, 0, 360, false, paint);

        rect.set((int) (getWidth() - W) / 2, (int) (getHeight() - W) / 2, (int) (getWidth() - W) / 2 + W, (getHeight() - W) / 2 + W);
        paint.setStrokeWidth(10);
        paint.setColor(color);
        canvas.drawArc(rect, 0, 360, false, paint);

        paint.setColor(Color.rgb(25, 154, 222));
        canvas.drawArc(rect, 0, (int) (360), false, paint);

    }

    public void setProcess(int type) {
        this.type = type;
    }

}
