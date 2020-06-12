package shape.meng.com.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


/**
 * Created by meng on 2018/7/3.
 */

public class EdiTextShape extends AppCompatEditText {

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

    public EdiTextShape(Context context) {
        super(context);

    }
    public EdiTextShape(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EdiTextShape);
         strokeWidth = (int)typedArray.getDimension(R.styleable.EdiTextShape_strokeWidth,0f);  //描边宽度
         roundRadius = (int)typedArray.getDimension(R.styleable.EdiTextShape_roundRadius,0f); //  圆角半径
         strokeColor = typedArray.getColor(R.styleable.EdiTextShape_strokeColor, Color.parseColor("#00000000"));//边框颜色
         solidColor = typedArray.getColor(R.styleable.EdiTextShape_solidColor, Color.parseColor("#00000000"));//内部填充颜色
         shape = typedArray.getInt(R.styleable.EdiTextShape_shape,0);  //0：方形  1：圆形   默认是0    如果需要设置成圆形空间的宽高必须相等  否则为椭圆
         topleftRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_topleftRadius,0f); //上左圆角
         toprightRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_toprightRadius,0f); //上右圆角
         buttomleftRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_buttomleftRadius,0f); //下左圆角
         buttomrightRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_buttomrightRadius,0f); //下右圆角
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

    public EdiTextShape(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public void setTopleftRadius(int radius) {

        float[] radiu = {radius,radius,toprightRadius,toprightRadius,buttomrightRadius,buttomrightRadius,buttomleftRadius,buttomleftRadius};

        gd.setCornerRadii(radiu);
    }

    public void setToprightRadius(int radius){

        float[] radiu = {topleftRadius,topleftRadius,radius,radius,buttomrightRadius,buttomrightRadius,buttomleftRadius,buttomleftRadius};

        gd.setCornerRadii(radiu);
    }

    public void setButtomleftRadius(int radius) {

        float[] radiu = {topleftRadius,topleftRadius,toprightRadius,toprightRadius,buttomrightRadius,buttomrightRadius,radius,radius};

        gd.setCornerRadii(radiu);
    }

    public void setButtomrightRadius(int radius){

        float[] radiu = {topleftRadius,topleftRadius,toprightRadius,toprightRadius,radius,radius,buttomleftRadius,buttomleftRadius};

        gd.setCornerRadii(radiu);
    }

    private void setsolidColor(int color){

        gd.setColor(color);
    }

    private void setstrokeColor(int color){

        gd.setStroke(strokeWidth,color);
    }
}
