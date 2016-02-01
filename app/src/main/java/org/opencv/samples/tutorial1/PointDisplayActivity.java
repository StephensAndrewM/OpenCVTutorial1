package org.opencv.samples.tutorial1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnTouchListener;

import java.io.File;
import java.util.Objects;

public class PointDisplayActivity extends Activity implements OnTouchListener {

    private ImageView boxImageView;
    private ImageView pieceImageView;

    private String boxImageURL;
    private String pieceImageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_display);

        boxImageView = (ImageView) findViewById(R.id.box_image);
        pieceImageView = (ImageView) findViewById(R.id.piece_image);
//        imageView.setOnTouchListener(PointDisplayActivity.this);

        // Get Image URL
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            long saveTime = extras.getLong("origSaveTime");

            File sd = Environment.getExternalStorageDirectory();
            File pieceDirectory = new File(sd, "jig/pieces/");
            File boxDirectory = new File(sd, "jig/box/");

            String filename = saveTime + ".png";
            File piecesFile = new File(pieceDirectory, filename);
            File boxFile = new File(boxDirectory, filename);

            Bitmap boxImage = BitmapFactory.decodeFile(boxFile.getAbsolutePath());
            boxImageView.setImageBitmap(boxImage);

            Bitmap pieceImage = BitmapFactory.decodeFile(piecesFile.getAbsolutePath());
            pieceImageView.setImageBitmap(pieceImage);

        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.d("x", "Activity Touch");

        /*if (!Objects.equals(imageURL2, "")) {
            Intent intent = new Intent(getBaseContext(), PointDisplayActivity.class);
            intent.putExtra("imageToDisplay", imageURL2);
            intent.putExtra("imageToDisplay2", "");
            startActivity(intent);
        } else {
            Intent intent = new Intent(getBaseContext(), Tutorial1Activity.class);
            startActivity(intent);
        }*/

        return false;
    }
}
