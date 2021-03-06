package ali.app.simpledrawing2dgraphicsanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private static final int NONE = 0;
    private static final int TRIANGLE = 1;
    private static final int CIRCLE = 2;
    private static final int RECTANGLE = 3;

    public boolean fillFlag = false;

    private int figure;

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public boolean getFillFlag() {
        return fillFlag;
    }

    public void setFillFlag(boolean fillFlag) {
        this.fillFlag = fillFlag;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        Paint paint;

        switch (figure) {
            case TRIANGLE: {
                paint = new Paint();
                paint.setColor(Color.GREEN);

                if(fillFlag) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                else {
                    paint.setStyle(Paint.Style.STROKE);
                }

                paint.setStrokeWidth(10f);

                Point point1_draw = new Point(width/2, 0);
                Point point2_draw = new Point(0, height);
                Point point3_draw = new Point(width, height);

                Path path = new Path();
                path.moveTo(point1_draw.x, point1_draw.y);
                path.lineTo(point2_draw.x, point2_draw.y);
                path.lineTo(point3_draw.x, point3_draw.y);
                path.lineTo(point1_draw.x, point1_draw.y);
                path.close();
                canvas.drawPath(path, paint);
                break;
            }
            case CIRCLE: {
                paint = new Paint();
                paint.setColor(Color.BLUE);

                if(fillFlag) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                else {
                    paint.setStyle(Paint.Style.STROKE);
                }

                paint.setStrokeWidth(10f);

                canvas.drawCircle(width/2, height/2, width/2, paint);
                break;
            }
            case RECTANGLE: {
                paint = new Paint();
                paint.setColor(Color.BLACK);

                if(fillFlag) {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                else {
                    paint.setStyle(Paint.Style.STROKE);
                }

                paint.setStrokeWidth(10f);

                canvas.drawRect(0, 0, width, height, paint);
                break;
            }
            case NONE: {
                break;
            }
            default:
                break;

        }
    }
}
