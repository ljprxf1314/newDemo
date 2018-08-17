package com.ljp.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Locale;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class MyDrawTextView extends View {

    //Canvas 的文字绘制方法有三个：drawText() drawTextRun() 和 drawTextOnPath()。
    private Paint paint;

    public MyDrawTextView(Context context) {
        super(context);
        init();
    }

    public MyDrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyDrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text = "Hello HenCoder";

        //1 Canvas 绘制文字的方式

        //1.1 drawText(String text, float x, float y, Paint paint):text 是文字内容，x 和 y 是文字的坐标。
        // 但需要注意：这个坐标并不是文字的左上角，而是一个与左下角比较接近的位置
//        canvas.drawText(text, 200, 100, paint);

        //1.2 drawTextRun()
        //声明：这个方法对中国人没用。所以如果你有兴趣，可以继续看；而如果你想省时间，直接跳过这个方法看后面的就好了，没有任何毒副作用。

        //1.3 drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint)
        //hOffset 和 vOffset。它们是文字相对于 Path 的水平偏移量和竖直偏移量，利用它们可以调整文字的位置。
//        Path path = new Path();
//        path.moveTo(100, 400);
//        path.lineTo(100, 400);
//        path.lineTo(200, 300);
//        path.lineTo(400, 500);
//        path.lineTo(600, 300);
//        canvas.drawPath(path, paint); // 把 Path 也绘制出来，理解起来更方便
//        canvas.drawTextOnPath("Hello HeCoder", path, 0, 0, paint);

        //1.4 StaticLayout
//        width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
//        align 是文字的对齐方向；
//        spacingmult 是行间距的倍数，通常情况下填 1 就好；
//        spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
//        includeadd 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
//        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
//
//        TextPaint textPaint = new TextPaint();
//        textPaint.setAntiAlias(true);
//        textPaint.setStyle(Paint.Style.STROKE);
//        textPaint.setTextSize(60);
//
//        String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
//        StaticLayout staticLayout1 = new StaticLayout(text1, textPaint, 600,
//                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
//        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
//        StaticLayout staticLayout2 = new StaticLayout(text2, textPaint, 600,
//                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
//
//        canvas.save();
//        canvas.translate(50, 100);
//        staticLayout1.draw(canvas);
//        canvas.translate(0, 300);
//        staticLayout2.draw(canvas);
//        canvas.restore();


        //2 Paint 对文字绘制的辅助
//        2.1.1 setTextSize(float textSize)
//        设置文字大小。
//        paint.setTextSize(18);
//        canvas.drawText(text, 100, 25, paint);
//        paint.setTextSize(36);
//        canvas.drawText(text, 100, 70, paint);
//        paint.setTextSize(60);
//        canvas.drawText(text, 100, 145, paint);
//        paint.setTextSize(84);
//        canvas.drawText(text, 100, 240, paint);

        //2.1.2 setTypeface(Typeface typeface)
        //设置字体。
//        paint.setTypeface(Typeface.DEFAULT);
//        canvas.drawText(text, 100, 150, paint);
//        paint.setTypeface(Typeface.SERIF);
//        canvas.drawText(text, 100, 300, paint);
//        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));
//        canvas.drawText(text, 100, 450, paint);

        //2.1.3 setFakeBoldText(boolean fakeBoldText):是否使用伪粗体。
//        paint.setFakeBoldText(false);
//        canvas.drawText(text, 100, 150, paint);
//        paint.setFakeBoldText(true);
//        canvas.drawText(text, 100, 230, paint);

        //2.1.4 setStrikeThruText(boolean strikeThruText):是否加删除线。
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStrikeThruText(true);
//        canvas.drawText(text, 100, 150, paint);

        //2.1.5 setUnderlineText(boolean underlineText):是否加下划线
//        paint.setUnderlineText(true);
//        canvas.drawText(text, 100, 150, paint);

        //2.1.6 setTextSkewX(float skewX):设置文字横向错切角度。其实就是文字倾斜度的啦。
//        paint.setTextSkewX(-0.5f);
//        canvas.drawText(text, 100, 150, paint);

        //2.1.7 setTextScaleX(float scaleX):设置文字横向放缩。也就是文字变胖变瘦。
//        paint.setTextScaleX(1);
//        canvas.drawText(text, 100, 150, paint);
//        paint.setTextScaleX(0.8f);
//        canvas.drawText(text, 100, 230, paint);
//        paint.setTextScaleX(1.2f);
//        canvas.drawText(text, 100, 310, paint);

        //2.1.8 setLetterSpacing(float letterSpacing):设置字符间距。默认值是 0。
//        paint.setLetterSpacing(0.2f);
//        canvas.drawText(text,100,100,paint);

        //2.1.9 setFontFeatureSettings(String settings):用 CSS 的 font-feature-settings 的方式来设置文字。
//        paint.setFontFeatureSettings("smcp"); // 设置 "small caps"canvas.drawText("Hello HenCoder", 100, 150, paint);
//        canvas.drawText(text,100,100,paint);

        //2.1.10 setTextAlign(Paint.Align align):设置文字的对齐方式。一共有三个值：LEFT CETNER 和 RIGHT。默认值为 LEFT。
//        Rect rect = new Rect();
//        paint.getTextBounds(text,0,text.length(),rect);//获取文字宽高
//        paint.setTextAlign(Paint.Align.LEFT);
//        canvas.drawText(text, 500, 150, paint);
//        paint.setTextAlign(Paint.Align.CENTER);
//        canvas.drawText(text, 500, 150+rect.height(), paint);
//        paint.setTextAlign(Paint.Align.RIGHT);
//        canvas.drawText(text, 500, 150+rect.height()  * 2, paint);

        //2.1.11 setTextLocale(Locale locale) / setTextLocales(LocaleList locales)
//        paint.setTextLocale(Locale.CHINA); // 简体中文canvas.drawText(text, 150, 150, paint);
//        paint.setTextLocale(Locale.TAIWAN); // 繁体中文canvas.drawText(text, 150, 150 + textHeight, paint);
//        paint.setTextLocale(Locale.JAPAN); // 日语canvas.drawText(text, 150, 150 + textHeight * 2, paint);

        //2.1.12 setHinting(int mode):设置是否启用字体的 hinting （字体微调）。

        //2.1.14 setSubpixelText(boolean subpixelText):是否开启次像素级的抗锯齿（ sub-pixel anti-aliasing ）。


        //2.2 测量文字尺寸类
        //2.2.1 float getFontSpacing():获取推荐的行距。
//        canvas.drawText(text, 100, 150, paint);
//        canvas.drawText(text, 100, 150 + paint.getFontSpacing(), paint);
//        canvas.drawText(text, 100, 150 + paint.getFontSpacing() * 2, paint);
//        Log.e("paint.getFontSpacing()",paint.getFontSpacing()+"");

        //2.2.2 FontMetircs getFontMetrics():获取 Paint 的 FontMetrics。
        //FontMetrics 是个相对专业的工具类，它提供了几个文字排印方面的数值：ascent, descent, top, bottom, leading。
        //ascent / descent: 上图中绿色和橙色的线，它们的作用是限制普通字符的顶部和底部范围。
        //top / bottom: 上图中蓝色和红色的线，它们的作用是限制所有字形（ glyph ）的顶部和底部范围。
        //leading 指的是行的额外间距，即对于上下相邻的两行，上行的 bottom 线和下行的 top 线的距离
        //leading 这个词的本意其实并不是行的额外间距，而是行距，即两个相邻行的 baseline之间的距离。
        canvas.drawText(text, 0, 100, paint);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        Log.e("ascent",fontMetrics.ascent+"");


        //2.2.3 getTextBounds(String text, int start, int end, Rect bounds):获取文字的显示范围。
//        Rect bounds = new Rect();
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text, 100, 200, paint);
//
//        paint.getTextBounds(text, 0, text.length(), bounds);
//        bounds.left += 100;
//        bounds.top += 200;
//        bounds.right += 100;
//        bounds.bottom += 200;
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawRect(bounds, paint);

        //2.2.4 float measureText(String text):测量文字的宽度并返回。
//        canvas.drawText(text, 100, 200, paint);
//        float textWidth = paint.measureText(text);
//        canvas.drawLine(100, 200, 100 + textWidth, 200, paint);

        //2.2.5 getTextWidths(String text, float[] widths):获取字符串中每个字符的宽度，并把结果填入参数 widths。

        //2.2.6 int breakText(String text, boolean measureForwards, float maxWidth, float[] measuredWidth)
        //这个方法也是用来测量文字宽度的。
        // text 是要测量的文字；measureForwards 表示文字的测量方向，true 表示由左往右测量；maxWidth 是给出的宽度上限；measuredWidth 是用于接受数据，
        // 而不是用于提供数据的：方法测量完成后会把截取的文字宽度（如果宽度没有超限，则为文字总宽度）赋值给 measuredWidth[0]。
//        int measuredCount = 9;
//        float[] measuredWidth = {0};// 宽度上限 300 （不够用，截断）measuredCount = paint.breakText(text, 0, text.length(), true, 300, measuredWidth);
//        canvas.drawText(text, 0, measuredCount, 150, 150, paint);// 宽度上限 400 （不够用，截断）
//        measuredCount = paint.breakText(text, 0, text.length(), true, 400, measuredWidth);
//        canvas.drawText(text, 0, measuredCount, 150, 150 + paint.getFontSpacing(), paint);// 宽度上限 500 （够用）
//        measuredCount = paint.breakText(text, 0, text.length(), true, 500, measuredWidth);
//        canvas.drawText(text, 0, measuredCount, 150, 150 + paint.getFontSpacing() * 2, paint);// 宽度上限 600 （够用）
//        measuredCount = paint.breakText(text, 0, text.length(), true, 600, measuredWidth);
//        canvas.drawText(text, 0, measuredCount, 150, 150 + paint.getFontSpacing() * 3, paint);

        //2.2.7 光标相关
        //2.2.7.1 getRunAdvance(CharSequence text, int start, int end, int contextStart, int contextEnd, boolean isRtl, int offset)
//        int offsetX = 100;
//        int offsetY = 200;
//        int length = text.length();
//        float advance = paint.getRunAdvance(text, 0, length, 0, length, false, length);
//        canvas.drawText(text, offsetX, offsetY, paint);
//        canvas.drawLine(offsetX + advance, offsetY - 50, offsetX + advance, offsetY + 10, paint);

//        String text1 = "Hello HenCoder \uD83C\uDDE8\uD83C\uDDF3";
//        canvas.drawText(text, offsetX, offsetY, paint);
//        length = text1.length();
//        float advance1 = paint.getRunAdvance(text1, 0, length, 0, length, false, length);
//        float advance2 = paint.getRunAdvance(text1, 0, length, 0, length, false, length - 1);
//        float advance3 = paint.getRunAdvance(text1, 0, length, 0, length, false, length - 2);
//        float advance4 = paint.getRunAdvance(text1, 0, length, 0, length, false, length - 3);
//        canvas.drawLine(offsetX + advance4, offsetY - 50, offsetX + advance4, offsetY + 10, paint);
//        float advance5 = paint.getRunAdvance(text1, 0, length, 0, length, false, length - 4);
//        canvas.drawLine(offsetX + advance5, offsetY - 50, offsetX + advance5, offsetY + 10, paint);
//        float advance6 = paint.getRunAdvance(text1, 0, length, 0, length, false, length - 5);

        //2.2.7.2 getOffsetForAdvance(CharSequence text, int start, int end, int contextStart, int contextEnd, boolean isRtl, float advance)
        //text 是要测量的文字；start end 是文字的起始和结束坐标；contextStart contextEnd 是上下文的起始和结束坐标；isRtl 是文字方向；
        // advance是给出的位置的像素值。填入参数，对应的字符偏移量将作为返回值返回。
        //getOffsetForAdvance() 配合上 getRunAdvance() 一起使用，就可以实现「获取用户点击处的文字坐标」的需求。


        //2.2.8 hasGlyph(String string):检查指定的字符串中是否是一个单独的字形 (glyph）

    }
}
