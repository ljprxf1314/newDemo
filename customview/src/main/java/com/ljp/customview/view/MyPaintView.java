package com.ljp.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.ComposeShader;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SumPathEffect;
import android.graphics.SweepGradient;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ljp.customview.R;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/17
 *     desc   : Paint:详解1-2
 *     version: 1.0
 * </pre>
 */

public class MyPaintView extends View {

    private Paint paint;
    private String text = "Hello HenCoder";

   /* Paint 的 API 大致可以分为 4 类：
        颜色
        效果
        drawText() 相关
        初始化*/

    public MyPaintView(Context context) {
        super(context);
        init();
    }

    public MyPaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyPaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //一、颜色
        //1.1基本颜色
        //setColor(int color)
//        paint.setColor(Color.parseColor("#009688"));
//        canvas.drawRect(30, 30, 230, 180, paint);
//        paint.setColor(Color.parseColor("#FF9800"));
//        canvas.drawLine(300, 30, 450, 180, paint);
//        paint.setColor(Color.parseColor("#E91E63"));
//        canvas.drawText("HenCoder", 500, 130, paint);

        //setARGB(int a, int r, int g, int b)
//        paint.setARGB(100, 255, 0, 0);
//        canvas.drawRect(0, 0, 200, 200, paint);
//        paint.setARGB(100, 0, 0, 0);
//        canvas.drawLine(0, 0, 200, 200, paint);


        //setShader(Shader shader) 设置 Shader

        /*LinearGradient 线性渐变 :x0 y0 x1 y1：渐变的两个端点的位置
                                color0 color1 是端点的颜色
                                tile：端点范围之外的着色规则，类型是 TileMode:CLAMP、REPEAT、MIRROR*/
//        Shader shader = new LinearGradient(100, 100, 200, 200, Color.parseColor("#E91E63"),
//                Color.parseColor("#303F9F"), Shader.TileMode.REPEAT);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);

        /*RadialGradient 辐射渐变:centerX centerY：辐射中心的坐标
                               radius：辐射半径
                               centerColor：辐射中心的颜色
                               edgeColor：辐射边缘的颜色
                               tileMode：辐射范围之外的着色模式*/
//        Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
//                Color.parseColor("#303F9F"), Shader.TileMode.REPEAT);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);

       /* SweepGradient 扫描渐变:cx cy ：扫描的中心
                    color0：扫描的起始颜色
                color1：扫描的终止颜色
           */
//        Shader shader = new SweepGradient(300, 300, Color.parseColor("#E91E63"),
//                Color.parseColor("#303F9F"));
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);

        /*BitmapShader:bitmap：用来做模板的 Bitmap 对象
                tileX：横向的 TileMode
                tileY：纵向的 TileMode。
                */
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//        Shader shader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
//        paint.setShader(shader);
//        canvas.drawCircle(100, 100, 100, paint);

//        float x = getWidth() / 2;
//        float y = getHeight() / 2;
//        float radius = Math.min(getWidth(), getHeight()) / 2;
//        canvas.drawCircle(x, y, radius,paint);
//        canvas.drawRect(0,0,getWidth(),getHeight(),paint);


       /* ComposeShader 混合着色器(这块没有走通搞明白)
                */
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//关闭硬件加速
        // 第一个 Shader：头像的 Bitmap
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP    , Shader.TileMode.CLAMP);
        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.bianfuxia);
        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        // ComposeShader：结合两个 Shader
        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_OUT);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 300, paint);

        //PorterDuff.Mode 一共有 17 个，可以分为两类：
//        Alpha 合成 (Alpha Compositing)
//        混合 (Blending)

        //1.2 setColorFilter(ColorFilter colorFilter)

        //1.3 setXfermode(Xfermode xfermode):要想使用 setXfermode() 正常绘制，必须使用离屏缓存 (Off-screen Buffer)
        // 把内容绘制在额外的层上，再把绘制好的内容贴回 View 中
//        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
//        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
//
//        Bitmap rectBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rect);
//        Bitmap circleBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
//
//        canvas.drawBitmap(rectBitmap, 0, 0, paint); // 画方
//        paint.setXfermode(xfermode); // 设置 Xfermode
//        canvas.drawBitmap(circleBitmap, 0, 0, paint); // 画圆
//        paint.setXfermode(null); // 用完及时清除 Xfermode
//
//        canvas.restoreToCount(saved);


        //二、效果
        //setAntiAlias (boolean aa) 设置抗锯齿

        //setStyle(Paint.Style style)

        //setStrokeWidth(float width)设置线条粗细
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(1);
//        canvas.drawCircle(150, 125, 100, paint);
//        paint.setStrokeWidth(5);
//        canvas.drawCircle(400, 125, 100, paint);
//        paint.setStrokeWidth(40);
//        canvas.drawCircle(650, 125, 100, paint);

        //setStrokeCap(Paint.Cap cap):BUTT 平头、ROUND 圆头、SQUARE 方头。默认为 BUTT

        //setStrokeJoin(Paint.Join join):MITER 尖角、 BEVEL 平角和 ROUND 圆角。默认为 MITER
//        paint.setColor(Color.parseColor("#009688"));
//        paint.setStrokeWidth(15);
//        Path path = new Path();
//        path.moveTo(100,100);
//        path.lineTo(100,100);
//        path.lineTo(400,100);
//        path.lineTo(100,400);
//        paint.setStrokeJoin(Paint.Join.BEVEL);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawPath(path,paint);

        //setStrokeMiter(float miter):对于 setStrokeJoin() 的一个补充，它用于设置 MITER 型拐角的延长线的最大值

        //色彩优化:Paint 的色彩优化有两个方法： setDither(boolean dither) 和 setFilterBitmap(boolean filter)

        //setPathEffect(PathEffect effect):来给图形的轮廓设置效果。对 Canvas 所有的图形绘制有效，
        //      也就是 drawLine() drawCircle() drawPath() 这些方法
//        paint.setStyle(Paint.Style.STROKE);
//        PathEffect pathEffect = new DashPathEffect(new float[]{10, 5}, 10);
//        paint.setPathEffect(pathEffect);
//        canvas.drawCircle(300, 300, 200, paint);
        /*PathEffect 分为两类，单一效果的 CornerPathEffect DiscretePathEffect DashPathEffect PathDashPathEffect ，
                            和组合效果的 SumPathEffect ComposePathEffect。*/
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        Path path = new Path();
//        path.moveTo(100,400);
//        path.lineTo(100,400);
//        path.lineTo(200,300);
//        path.lineTo(400,500);
//        path.lineTo(600,300);
        //(1)CornerPathEffect
//        PathEffect pathEffect = new CornerPathEffect(20);
//        paint.setPathEffect(pathEffect);
//        canvas.drawPath(path, paint);
        //(2)DiscretePathEffect
//        PathEffect pathEffect = new DiscretePathEffect(20, 5);
//        paint.setPathEffect(pathEffect);
//        canvas.drawPath(path, paint);
        //(3)DashPathEffect
//        PathEffect pathEffect = new DashPathEffect(new float[]{20, 10, 5, 10}, 0);
//        paint.setPathEffect(pathEffect);
//        canvas.drawPath(path, paint);
        //(4)PathDashPathEffect:style 的类型为 PathDashPathEffect.Style ，是一个 enum ，具体有三个值：
                //TRANSLATE：位移
                //ROTATE：旋转
                //MORPH：变体
//        Path dashPath = new Path(); // 使用一个图形来做 dash
//        dashPath.addCircle(0,0,5, Path.Direction.CW);
//        PathEffect pathEffect = new PathDashPathEffect(dashPath, 40, 0,
//                PathDashPathEffect.Style.MORPH.TRANSLATE);
//        paint.setPathEffect(pathEffect);
//        canvas.drawPath(path, paint);
        //(5)SumPathEffect:这是一个组合效果类的 PathEffect
//        PathEffect dashEffect = new DashPathEffect(new float[]{20, 10}, 0);
//        PathEffect discreteEffect = new DiscretePathEffect(20, 5);
//        SumPathEffect pathEffect = new SumPathEffect(dashEffect, discreteEffect);
//        paint.setPathEffect(pathEffect);
//        canvas.drawPath(path, paint);
        //(6)ComposePathEffect:这也是一个组合效果类的 PathEffect 。不过它是先对目标 Path 使用一个 PathEffect，
                // 然后再对这个改变后的 Path 使用另一个 PathEffect。
//        PathEffect dashEffect = new DashPathEffect(new float[]{20, 10}, 0);
//        PathEffect discreteEffect = new DiscretePathEffect(20, 5);
//        ComposePathEffect pathEffect = new ComposePathEffect(dashEffect, discreteEffect);
//        paint.setPathEffect(pathEffect);
//        canvas.drawPath(path, paint);


        //setShadowLayer(float radius, float dx, float dy, int shadowColor):给绘制文字下面加上一层阴影
//        paint.setShadowLayer(10, 0, 0, Color.RED);
//        paint.setTextSize(80);
//        canvas.drawText(text, 80, 300, paint);


        //setMaskFilter(MaskFilter maskfilter):(设置的是在绘制层上方的附加效果)MaskFilter 有两种： BlurMaskFilter 和 EmbossMaskFilter。

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bianfuxia);
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//关闭硬件加速
        //(1)BlurMaskFilter:style 是模糊的类型。一共有四种：
            //NORMAL: 内外都模糊绘制
            //SOLID: 内部正常绘制，外部模糊
            //INNER: 内部模糊，外部不绘制
            //OUTER: 内部不绘制，外部模糊（什么鬼？）
//        paint.setMaskFilter(new BlurMaskFilter(getWidth()/2, BlurMaskFilter.Blur.SOLID));
//        canvas.drawBitmap(bitmap, 0, 0, paint);
        //(2)EmbossMaskFilter:
//        paint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));
//        canvas.drawBitmap(bitmap, 0, 0, paint);

        //getFillPath(Path src, Path dst):通过 getFillPath(src, dst) 方法就能获取这个实际 Path。
        // 方法的参数里，src 是原 Path ，而 dst 就是实际 Path 的保存位置。 getFillPath(src, dst) 会计算出实际 Path，然后把结果保存在 dst 里。
//        paint.getFillPath(path,)

        //四、初始化类
        /*4.1 reset()
        重置 Paint 的所有属性为默认值。相当于重新 new 一个，不过性能当然高一些啦。
        4.2 set(Paint src)
        把 src 的所有属性全部复制过来。相当于调用 src 所有的 get 方法，然后调用这个 Paint的对应的 set 方法来设置它们。
        4.3 setFlags(int flags)
        批量设置 flags。相当于依次调用它们的 set 方法。例如：  java paint.setFlags(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);*/

    }
}
