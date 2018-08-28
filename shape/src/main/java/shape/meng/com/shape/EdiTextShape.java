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
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextShape);
        int strokeWidth = (int)typedArray.getDimension(R.styleable.TextShape_strokeWidth,0f);  //描边宽度
        int roundRadius = (int)typedArray.getDimension(R.styleable.TextShape_roundRadius,0f); //  圆角半径
        int strokeColor = typedArray.getColor(R.styleable.TextShape_strokeColor, Color.parseColor("#00000000"));//边框颜色
        int solidColor = typedArray.getColor(R.styleable.TextShape_solidColor, Color.parseColor("#00000000"));//内部填充颜色
        int shape = typedArray.getInt(R.styleable.TextShape_shape,0);  //0：方形  1：圆形   默认是0    如果需要设置成圆形空间的宽高必须相等  否则为椭圆
        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setShape(shape);
        gd.setColor(solidColor);
        gd.setCornerRadius(roundRadius);
        gd.setStroke(strokeWidth, strokeColor);
        typedArray.recycle();
        setBackground(gd);

    }

    public EdiTextShape(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

}
