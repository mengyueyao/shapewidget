package shape.meng.com.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * Created by meng on 2018/7/3.
 */

public class TextShape extends AppCompatTextView {

    private int strokeWidth;

    private int roundRadius;

    private int strokeColor;

    private int solidColor;

    private int shape;

    private int topleftRadius;

    private int toprightRadius;

    private int buttomleftRadius;

    private int buttomrightRadius;

    private GradientDrawable gd;

    public void setSolidColor(int solidColor) {

        setsolidColor(solidColor);
    }

    public void setStrokeColor(int color){

        setstrokeColor(color);
    }

    public TextShape(Context context) {
        super(context);

    }
    public TextShape(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextShape);
         strokeWidth = (int)typedArray.getDimension(R.styleable.TextShape_strokeWidth,0f);  //描边宽度
         roundRadius = (int)typedArray.getDimension(R.styleable.TextShape_roundRadius,0f); //  圆角半径
         strokeColor = typedArray.getColor(R.styleable.TextShape_strokeColor, Color.parseColor("#00000000"));//边框颜色
         solidColor = typedArray.getColor(R.styleable.TextShape_solidColor, Color.parseColor("#00000000"));//内部填充颜色
         shape = typedArray.getInt(R.styleable.TextShape_shape,0);  //0：方形  1：圆形   默认是0    如果需要设置成圆形空间的宽高必须相等  否则为椭圆
         topleftRadius = (int) typedArray.getDimension(R.styleable.TextShape_topleftRadius,0f); //上左圆角
         toprightRadius = (int) typedArray.getDimension(R.styleable.TextShape_toprightRadius,0f); //上右圆角
         buttomleftRadius = (int) typedArray.getDimension(R.styleable.TextShape_buttomleftRadius,0f); //下左圆角
         buttomrightRadius = (int) typedArray.getDimension(R.styleable.TextShape_buttomrightRadius,0f); //下右圆角
        gd = new GradientDrawable();//创建drawable
        if(roundRadius==0){

            float[] radius = {topleftRadius,topleftRadius,toprightRadius,toprightRadius,buttomrightRadius,buttomrightRadius,buttomleftRadius,buttomleftRadius};

            gd.setCornerRadii(radius);

        }else{

            gd.setCornerRadius(roundRadius);
        }

        gd.setShape(shape);
        gd.setColor(solidColor);
        gd.setStroke(strokeWidth, strokeColor);
        typedArray.recycle();
        setBackground(gd);

    }

    public TextShape(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }
    public void setRadius(int topleftRadius,int toprightRadius,int buttomleftRadius,int buttomrightRadius) {

        float[] radiu = {topleftRadius,topleftRadius,toprightRadius,toprightRadius,buttomrightRadius,buttomrightRadius,buttomleftRadius,buttomleftRadius};

        gd.setCornerRadii(radiu);
    }

    private void setsolidColor(int color){

        gd.setColor(color);
    }

    private void setstrokeColor(int color){

        gd.setStroke(strokeWidth,color);
    }
}
