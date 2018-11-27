package shape.meng.com.shapewidget;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import shape.meng.com.shape.EdiTextShape;
import shape.meng.com.shape.LinerLayoutShape;
import shape.meng.com.shape.TextShape;

public class MainActivity extends AppCompatActivity {

    private TextShape tv_sh;

    private LinerLayoutShape ll_sh;

    private EdiTextShape edt_sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_sh = findViewById(R.id.tv_sh);

        ll_sh = findViewById(R.id.ll_sh);

        edt_sh = findViewById(R.id.edt_sh);

        tv_sh.setSolidColor(getResources().getColor(R.color.colorAccent));



    }
}
