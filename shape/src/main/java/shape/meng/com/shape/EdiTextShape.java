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

    public EdiTextShape(Context context) {
        super(context);

    }
    public EdiTextShape(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EdiTextShape);
        int strokeWidth = (int)typedArray.getDimension(R.styleable.EdiTextShape_strokeWidth,0f);  //描边宽度
        int roundRadius = (int)typedArray.getDimension(R.styleable.EdiTextShape_roundRadius,0f); //  圆角半径
        int strokeColor = typedArray.getColor(R.styleable.EdiTextShape_strokeColor, Color.parseColor("#00000000"));//边框颜色
        int solidColor = typedArray.getColor(R.styleable.EdiTextShape_solidColor, Color.parseColor("#00000000"));//内部填充颜色
        int shape = typedArray.getInt(R.styleable.EdiTextShape_shape,0);  //0：方形  1：圆形   默认是0    如果需要设置成圆形空间的宽高必须相等  否则为椭圆
        int topleftRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_topleftRadius,0f); //上左圆角
        int toprightRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_toprightRadius,0f); //上右圆角
        int buttomleftRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_buttomleftRadius,0f); //下左圆角
        int buttomrightRadius = (int) typedArray.getDimension(R.styleable.EdiTextShape_buttomrightRadius,0f); //下右圆角
        GradientDrawable gd = new GradientDrawable();//创建drawable
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

}
