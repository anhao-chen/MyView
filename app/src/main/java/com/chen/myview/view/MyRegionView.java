package com.chen.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zehua_chen on 2016/6/21.
 */
public class MyRegionView extends View {
    public MyRegionView(Context context) {
        this(context, null);
    }

    public MyRegionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRegionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect1 = new Rect(100, 100, 400, 200);
        Rect rect2 = new Rect(200, 0, 300, 300);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        
        canvas.drawRect(rect1, paint);
        canvas.drawRect(rect2, paint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);
        
        region1.op(region2, Region.Op.INTERSECT);

        Paint paint_fill = new Paint();
        paint_fill.setColor(Color.GREEN);
        paint_fill.setStyle(Paint.Style.FILL);
        drawRegion(canvas, region1, paint_fill);
    }

    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();
        while(iter.next(r)) {
            canvas.drawRect(r, paint);
        }

    }
}
