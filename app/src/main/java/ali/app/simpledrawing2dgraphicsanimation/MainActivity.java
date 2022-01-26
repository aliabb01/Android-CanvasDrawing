package ali.app.simpledrawing2dgraphicsanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private DrawView drawView;
    private Button triangleBtn;
    private Button circleBtn;
    private Button rectangleBtn;
    private Button clearBtn;
    private CheckBox fillBtn;

    private boolean fillFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView = (DrawView) findViewById(R.id.view);

        triangleBtn = (Button) findViewById(R.id.triangleBtn);
        circleBtn = (Button) findViewById(R.id.circleBtn);
        rectangleBtn = (Button) findViewById(R.id.rectangleBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        fillBtn = (CheckBox) findViewById(R.id.fillBtn);

        triangleBtn.setOnClickListener(triangleBtnClick);
        circleBtn.setOnClickListener(circleBtnClick);
        rectangleBtn.setOnClickListener(rectangleBtnClick);
        clearBtn.setOnClickListener(clearBtnClick);
        fillBtn.setOnCheckedChangeListener(fillFlagChange);
    }

    public void setFigure(final int figure, final boolean fillFlag) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                drawView.setFigure(figure);
                drawView.setFillFlag(fillFlag);
                drawView.invalidate();
            }
        });
    }

    CompoundButton.OnCheckedChangeListener fillFlagChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            fillFlag = isChecked;
        }
    };

    View.OnClickListener triangleBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFigure(1, fillFlag);
        }
    };

    View.OnClickListener circleBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFigure(2, fillFlag);
        }
    };

    View.OnClickListener rectangleBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFigure(3, fillFlag);
        }
    };

    View.OnClickListener clearBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setFigure(0, fillFlag);
        }
    };
}