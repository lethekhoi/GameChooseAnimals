package lethekhoi.ltk.hcmus.gamechooseanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView mImgHinhGoc, mImgHinhChon;
    ImageButton mImgPlay;
    FrameLayout mFrameLayout;
    TextView mTxtTime;
    String[] mArrayNameImage;
    int mValueHinhGoc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        even();
    }

    private void init() {
        mImgHinhChon = findViewById(R.id.imageviewHinhChon);
        mImgHinhGoc = findViewById(R.id.imageviewHinhGoc);
        mImgPlay = findViewById(R.id.imagebuttonPlay);
        mFrameLayout = findViewById(R.id.framelayout);
        mTxtTime = findViewById(R.id.textviewThoiGian);
    }

    private void even() {
        mImgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFrameLayout.setVisibility(View.GONE);
                randomImage();
            }
        });
    }

    private void randomImage() {
        mArrayNameImage = getResources().getStringArray(R.array.arrayAnimal);     //lấy hình trong drawable
        Log.d("BBB", mArrayNameImage.length + "");
        //random hinh
        Collections.shuffle(Arrays.asList(mArrayNameImage));
        mValueHinhGoc = getResources().getIdentifier(mArrayNameImage[0], "drawable", getPackageName());
        mImgHinhGoc.setImageResource(mValueHinhGoc);
        //gan vao image hinh goc
    }
}
