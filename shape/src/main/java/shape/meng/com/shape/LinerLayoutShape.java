package shape.meng.com.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.widget.LinearLayout;


/**
 * Created by meng on 2018/7/3.
 */

public class LinerLayoutShape extends LinearLayout {

    private int strokeWidth = 0;

    private int roundRadius = 0;

    private int strokeColor = 0;

    private int solidColor = 0;

    private int shape = 0;

    private int topleftRadius = 0;

    private int toprightRadius = 0;

    private int buttomleftRadius = 0;

    private int buttomrightRadius = 0;

    private int startColor = 0;
    private int endColor = 0;
    private int centerColor = 0;
    private int gradientType = 0;
    private int gradientOrientation = 0;

    private GradientDrawable gd;

    public void setSolidColor(int solidColor) {
        setsolidColor(solidColor);
    }

    public void setStrokeColor(int color) {
        setstrokeColor(color);
    }

    public LinerLayoutShape(Context context) {
        super(context);
        gd = new GradientDrawable();//创建drawable
        if (roundRadius == 0) {
            float[] radius = {topleftRadius, topleftRadius, toprightRadius, toprightRadius, buttomrightRadius, buttomrightRadius, buttomleftRadius, buttomleftRadius};
            gd.setCornerRadii(radius);
        } else {
            gd.setCornerRadius(roundRadius);
        }
        gd.setShape(shape);
        if (startColor != 0 || endColor != 0) {
            // 设置渐变颜色
            gd.setColors(new int[]{
                    startColor,  // 开始颜色
                    endColor   // 结束颜色
            });
            GradientDrawable.Orientation orientation;
            // 设置渐变方向 (角度)
            switch (gradientOrientation) {
                case 1:
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;  // 从上往下渐变
                    break;
                case 2:
                    orientation = GradientDrawable.Orientation.BOTTOM_TOP;  // 从下往上渐变
                    break;
                case 3:
                    orientation = GradientDrawable.Orientation.RIGHT_LEFT;  // 从右往左渐变
                    break;
                case 4:
                    orientation = GradientDrawable.Orientation.TL_BR;  // 从左上角到右下角的
                    break;
                case 5:
                    orientation = GradientDrawable.Orientation.TR_BL;  // 从右上到左下
                    break;
                case 6:
                    orientation = GradientDrawable.Orientation.BL_TR;  // 从左下到右上
                    break;
                case 7:
                    orientation = GradientDrawable.Orientation.BR_TL;  // 从右下到左上
                    break;
                default:
                    orientation = GradientDrawable.Orientation.LEFT_RIGHT;  // 从左到右的渐变
                    break;
            }
            gd.setOrientation(orientation);  // 默认从左到右的渐变
            // 设置渐变类型 (默认为线性渐变)
            switch (gradientType) {
                case 1:
                    gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);  // 径向渐变，从中心向外扩散的圆形渐变
                    break;
                case 2:
                    gd.setGradientType(GradientDrawable.SWEEP_GRADIENT);  // 扫描线渐变，沿着中心点的角度变化
                    break;
                default:
                    gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);  // 线性渐变，沿着一条直线进行渐变
                    break;
            }

        } else {
            gd.setColor(solidColor);
        }
        gd.setStroke(strokeWidth, strokeColor);
        setBackground(gd);

    }

    public LinerLayoutShape(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LinerLayoutShape);
        strokeWidth = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_strokeWidth, 0f);  //描边宽度
        roundRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_roundRadius, 0f); //  圆角半径
        strokeColor = typedArray.getColor(R.styleable.LinerLayoutShape_strokeColor, Color.parseColor("#00000000"));//边框颜色
        solidColor = typedArray.getColor(R.styleable.LinerLayoutShape_solidColor, Color.parseColor("#00000000"));//内部填充颜色
        shape = typedArray.getInt(R.styleable.LinerLayoutShape_shape, 0);  //0：方形  1：圆形   默认是0    如果需要设置成圆形空间的宽高必须相等  否则为椭圆
        topleftRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_topleftRadius, 0f); //上左圆角
        toprightRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_toprightRadius, 0f); //上右圆角
        buttomleftRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_buttomleftRadius, 0f); //下左圆角
        buttomrightRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_buttomrightRadius, 0f); //下右圆角
        gradientType = typedArray.getInt(R.styleable.EdiTextShape_gradientType, 0);
        startColor = typedArray.getInt(R.styleable.EdiTextShape_startColor, 0);
        endColor = typedArray.getInt(R.styleable.EdiTextShape_endColor, 0);
        centerColor = typedArray.getInt(R.styleable.EdiTextShape_centerColor, 0);
        gradientOrientation = typedArray.getInt(R.styleable.EdiTextShape_angle, 0);
        gd = new GradientDrawable();//创建drawable
        if (roundRadius == 0) {
            float[] radius = {topleftRadius, topleftRadius, toprightRadius, toprightRadius, buttomrightRadius, buttomrightRadius, buttomleftRadius, buttomleftRadius};
            gd.setCornerRadii(radius);
        } else {
            gd.setCornerRadius(roundRadius);
        }
        gd.setShape(shape);
        if (startColor != 0 || endColor != 0) {
            // 设置渐变颜色
            gd.setColors(new int[]{
                    startColor,  // 开始颜色
                    endColor   // 结束颜色
            });
            GradientDrawable.Orientation orientation;
            // 设置渐变方向 (角度)
            switch (gradientOrientation) {
                case 1:
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;  // 从上往下渐变
                    break;
                case 2:
                    orientation = GradientDrawable.Orientation.BOTTOM_TOP;  // 从下往上渐变
                    break;
                case 3:
                    orientation = GradientDrawable.Orientation.RIGHT_LEFT;  // 从右往左渐变
                    break;
                case 4:
                    orientation = GradientDrawable.Orientation.TL_BR;  // 从左上角到右下角的
                    break;
                case 5:
                    orientation = GradientDrawable.Orientation.TR_BL;  // 从右上到左下
                    break;
                case 6:
                    orientation = GradientDrawable.Orientation.BL_TR;  // 从左下到右上
                    break;
                case 7:
                    orientation = GradientDrawable.Orientation.BR_TL;  // 从右下到左上
                    break;
                default:
                    orientation = GradientDrawable.Orientation.LEFT_RIGHT;  // 从左到右的渐变
                    break;
            }
            gd.setOrientation(orientation);  // 默认从左到右的渐变
            // 设置渐变类型 (默认为线性渐变)
            switch (gradientType) {
                case 1:
                    gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);  // 径向渐变，从中心向外扩散的圆形渐变
                    break;
                case 2:
                    gd.setGradientType(GradientDrawable.SWEEP_GRADIENT);  // 扫描线渐变，沿着中心点的角度变化
                    break;
                default:
                    gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);  // 线性渐变，沿着一条直线进行渐变
                    break;
            }

        } else {
            gd.setColor(solidColor);
        }
        gd.setStroke(strokeWidth, strokeColor);
        typedArray.recycle();
        setBackground(gd);

    }


    public void setRadius(int topleftRadius, int toprightRadius, int buttomleftRadius, int buttomrightRadius) {

        float[] radiu = {topleftRadius, topleftRadius, toprightRadius, toprightRadius, buttomrightRadius, buttomrightRadius, buttomleftRadius, buttomleftRadius};

        gd.setCornerRadii(radiu);
    }

    private void setsolidColor(int color) {

        gd.setColor(color);
    }

    private void setstrokeColor(int color) {

        gd.setStroke(strokeWidth, color);
    }

    private void setStrokeWidth(int width){
        gd.setStroke(width, strokeColor);
    }

    private void setStrokeWidthColor(int width,int color){
        gd.setStroke(width, color);
    }
}
