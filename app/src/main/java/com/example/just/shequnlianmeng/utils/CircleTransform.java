package com.example.just.shequnlianmeng.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;

import com.squareup.picasso.Transformation;

/**
 * Created by T-BayMax on 2017/3/15.
 */

public class CircleTransform implements Transformation {
    private String name;

    public CircleTransform(String name) {
        this.name = name;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();   //回收垃圾
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);//定义一个渲染器
        paint.setShader(shader);//设置渲染器
        paint.setAntiAlias(true);//设置抗拒齿，图片边缘相对清楚

        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);//绘制图形

       /* Paint paint = new Paint();
*/

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setAlpha(100);
        RectF oval2 = new RectF(0, 0, size, size);// 设置个新的长方形，扫描测量
        //paint.setAlpha(0);
        canvas.drawArc(oval2, 0, 180, true, paint);
        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线

        Paint paintText = new Paint();
        paintText.setAntiAlias(true);
        paintText.setStyle(Paint.Style.STROKE);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setStrokeWidth(1);
        paintText.setTextSize(20);
        paintText.setTypeface(Typeface.MONOSPACE);// 设置一系列文字属性
         paintText.setColor(Color.WHITE);
        paintText.setTextAlign(Paint.Align.CENTER);// 文字水平居中
        //  paintText.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        canvas.drawText(name, r, size * 5 / 6, paintText);// 设置文字竖直方向居中
        squaredBitmap.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return "circle";
    }
}
