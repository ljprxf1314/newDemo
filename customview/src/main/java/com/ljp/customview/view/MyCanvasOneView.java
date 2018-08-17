package com.ljp.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/16
 *     desc   : 绘制基础1-1
 *     version: 1.0
 * </pre>
 */

public class MyCanvasOneView extends View {

    private Paint paint;//画笔
    private Point point;//点

    Path path = new Path(); // 初始化 Path 对象

    public MyCanvasOneView(Context context) {
        super(context);
        init();
    }

    public MyCanvasOneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCanvasOneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();

//        Paint.Style.FILL：填充内部
//        Paint.Style.FILL_AND_STROKE  ：填充内部和描边
//        Paint.Style.STROKE  ：描边

//        Paint.setStyle(Style style) 设置绘制模式
//        Paint.setColor(int color) 设置颜色
//        Paint.setStrokeWidth(float width) 设置线条宽度
//        Paint.setTextSize(float textSize) 设置文字大小
//        Paint.setAntiAlias(boolean aa) 设置抗锯齿开关

        paint.setStyle(Paint.Style.STROKE);//画笔样式
        paint.setAntiAlias(true);//抗锯齿
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
//        canvas.drawCircle(200,200,100,paint);

        //绘制颜色
//        canvas.drawRGB(100, 200, 100);
//        canvas.drawARGB(100, 100, 200, 100);

        //画矩形
//        canvas.drawRect(100,400,600,500,paint);

        //画点
        //paint.setStrokeCap(Paint.Cap.ROUND);//设置点的形状:圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE)
        //canvas.drawPoint(50,50,paint);
        //float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        //canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
        //        8 /* 一共绘制四个点*/, paint);

        //画椭圆
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawOval(50, 50, 350, 200, paint);
//
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawOval(400, 50, 700, 200, paint);

        //画线
//        canvas.drawLine(200, 200, 800, 500, paint);
//        paint.setStrokeCap(Paint.Cap.SQUARE);
//        float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20, 150,
//                20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
//        canvas.drawLines(points, paint);//批量画法

        //画圆角矩形
//        canvas.drawRoundRect(100, 100, 500, 300, 50, 50, paint);
//        canvas.drawRoundRect(new RectF(200, 200, 600, 400),50,50,paint);

        //绘制弧形或扇形
        //left, top, right, bottom 描述的是这个弧形所在的椭圆；startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        //sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
//        paint.setStyle(Paint.Style.FILL); // 填充模式
//        canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint); // 绘制扇形
//        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint); // 绘制弧形
//        paint.setStyle(Paint.Style.STROKE); // 画线模式
//        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint); // 绘制不封口的弧形

        //使用path画自定义图形
//        paint.setStyle(Paint.Style.FILL);
//        path.addArc(200, 200, 400, 400, -225, 225);
//        path.arcTo(400, 200, 600, 400, -180, 225, false);
//        path.lineTo(400, 542);
//        canvas.drawPath(path, paint); // 绘制出 path 描述的图形（心形），大功告成

        //Path类
        //一、直接描述路径:
        //第一组： addXxx() ——添加子图形 :路径方向有两种：顺时针 (CW clockwise) 和逆时针 (CCW counter-clockwise)
//        path.addCircle(300, 300, 200, Path.Direction.CW);
//        canvas.drawPath(path, paint);
//        addOval(float left, float top, float right, float bottom, Direction dir) / addOval(RectF oval, Direction dir) 添加椭圆
//        addRect(float left, float top, float right, float bottom, Direction dir) / addRect(RectF rect, Direction dir) 添加矩形
//        addRoundRect(RectF rect, float rx, float ry, Direction dir) /
        // addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir) /
        // addRoundRect(RectF rect, float[] radii, Direction dir) /
        // addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir) 添加圆角矩形
//        addPath(Path path) 添加另一个 Path
        //第二组：xxxTo() ——画线（直线或曲线）
//        paint.setStyle(Paint.Style.STROKE);
//        path.lineTo(100, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
//        path.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
//        canvas.drawPath(path, paint);

//        quadTo(float x1, float y1, float x2, float y2) /
//        rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线

//        cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) /
//        rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) 画三次贝塞尔曲线

//        paint.setStyle(Paint.Style.STROKE);
//        path.lineTo(100, 100); // 画斜线
//        path.moveTo(200, 100); // 我移~~
//        path.lineTo(200, 0); // 画竖线
//        canvas.drawPath(path, paint);

//        arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) /
//        arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) /
//        arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形

        //arcTo(): startAngle:开始角度、sweepAngle:从开始角度要画多少个角度
//        paint.setStyle(Paint.Style.STROKE);
//        path.lineTo(100, 100);
//        path.arcTo(100, 100, 300, 300, -90, 90, true); // 强制移动到弧形起点（无痕迹）
//        canvas.drawPath(path, paint);

//        paint.setStyle(Paint.Style.STROKE);
//        path.lineTo(100, 100);
//        path.arcTo(100, 100, 300, 300, 0, 90, false); // 直接连线连到弧形起点（有痕迹）
//        canvas.drawPath(path, paint);

        // addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo()
//        paint.setStyle(Paint.Style.STROKE);
//        path.lineTo(100, 100);
//        path.addArc(100, 100, 300, 300, 90, 45);
//        canvas.drawPath(path, paint);

        //close() 封闭当前子图形
//        paint.setStyle(Paint.Style.STROKE);
//        path.moveTo(100, 100);
//        path.lineTo(200, 100);
//        path.lineTo(150, 150);
//        path.close(); // 使用 close() 封闭子图形。等价于 path.lineTo(100, 100)
//        canvas.drawPath(path, paint);

        //二、Path 方法第二类：辅助的设置或计算
        //Path.setFillType(Path.FillType ft) 设置填充方式
//        FillType 的取值有四个：
//        EVEN_ODD
//        WINDING （默认值）
//        INVERSE_EVEN_ODD
//        INVERSE_WINDING

        //绘制文字
        paint.setStrokeWidth(5);
        paint.setTextSize(38);//文字大小
        canvas.drawText("天地渺渺,与岁同生",50,400,paint);
    }
}
