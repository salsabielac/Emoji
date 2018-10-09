package com.example.salsa.library;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView myImageView = (ImageView) findViewById(R.id.imgview);
                Emojifier emoji = new Emojifier();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable=true;

                Bitmap myBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.cabela, options);

                // Paint myRectPaint = new Paint();
                // myRectPaint.setStrokeWidth(5);
                // myRectPaint.setColor(Color.RED);
                // myRectPaint.setStyle(Paint.Style.STROKE);

                // FaceDetector faceDetector = new FaceDetector.Builder(getApplicationContext()).setTrackingEnabled(false).build();
                // if(!faceDetector.isOperational()){
                //     new AlertDialog.Builder(v.getContext()).setMessage("Could not set up the face detector!").show();
                //     return;
                // }

                // Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
                // SparseArray<Face> faces = faceDetector.detect(frame);


                Bitmap tempBitmap = Bitmap.createBitmap(myBitmap.getWidth(), myBitmap.getHeight(), Bitmap.Config.RGB_565);
                //Canvas tempCanvas = new Canvas(tempBitmap);
                //tempCanvas.drawBitmap(myBitmap, 0, 0, null);

                // for(int i=0; i<faces.size(); i++) {
                //     Face thisFace = faces.valueAt(i);
                //     float x1 = thisFace.getPosition().x;
                //     float y1 = thisFace.getPosition().y;
                //     float x2 = x1 + thisFace.getWidth();
                //     float y2 = y1 + thisFace.getHeight();
                //     tempCanvas.drawRoundRect(new RectF(x1, y1, x2, y2), 2, 2, myRectPaint);
                // }
                myImageView.setImageBitmap(emoji.detectFaces(getApplicationContext(), myBitmap));
                //myImageView.setImageDrawable(new BitmapDrawable(v,tempBitmap));
            }
        });
    }
}