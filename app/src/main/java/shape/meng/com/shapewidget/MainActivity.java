package shape.meng.com.shapewidget;

import android.graphics.Color;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import shape.meng.com.shape.EdiTextShape;
import shape.meng.com.shape.LinerLayoutShape;
import shape.meng.com.shape.RelativeLayoutShape;
import shape.meng.com.shape.TextShape;

public class MainActivity extends AppCompatActivity {

    private TextShape tv_sh;

    private LinerLayoutShape ll_sh;

    private EdiTextShape edt_sh;

    private RelativeLayoutShape rl_shape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_sh = findViewById(R.id.tv_sh);

        ll_sh = findViewById(R.id.ll_sh);

        edt_sh = findViewById(R.id.edt_sh);

        tv_sh.setSolidColor(getResources().getColor(R.color.colorAccent));

        edt_sh.setStrokeColor(getResources().getColor(R.color.colorAccent));

        rl_shape = findViewById(R.id.rl_shape);

        rl_shape.setRadius(15,15,0,15);



    }
}
