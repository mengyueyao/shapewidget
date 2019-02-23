package shape.meng.com.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * Created by meng on 2018/7/3.
 */

public class RelativeLayoutShape extends RelativeLayout {

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

    public RelativeLayoutShape(Context context) {
        super(context);

    }
    public RelativeLayoutShape(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RelativeLayoutShape);
         strokeWidth = (int)typedArray.getDimension(R.styleable.LinerLayoutShape_strokeWidth,0f);  //描边宽度
         roundRadius = (int)typedArray.getDimension(R.styleable.LinerLayoutShape_roundRadius,0f); //  圆角半径
         strokeColor = typedArray.getColor(R.styleable.LinerLayoutShape_strokeColor, Color.parseColor("#00000000"));//边框颜色
         solidColor = typedArray.getColor(R.styleable.LinerLayoutShape_solidColor, Color.parseColor("#00000000"));//内部填充颜色
         shape = typedArray.getInt(R.styleable.LinerLayoutShape_shape,0);  //0：方形  1：圆形   默认是0    如果需要设置成圆形空间的宽高必须相等  否则为椭圆
         topleftRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_topleftRadius,0f); //上左圆角
         toprightRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_toprightRadius,0f); //上右圆角
         buttomleftRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_buttomleftRadius,0f); //下左圆角
         buttomrightRadius = (int) typedArray.getDimension(R.styleable.LinerLayoutShape_buttomrightRadius,0f); //下右圆角
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

    public RelativeLayoutShape(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    private void setsolidColor(int color){

        gd.setColor(color);
    }

    private void setstrokeColor(int color){

        gd.setStroke(strokeWidth,color);
    }
}
