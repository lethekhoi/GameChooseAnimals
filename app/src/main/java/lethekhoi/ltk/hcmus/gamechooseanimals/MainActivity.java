package lethekhoi.ltk.hcmus.gamechooseanimals;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView mImgHinhGoc, mImgHinhChon;
    ImageButton mImgPlay;
    FrameLayout mFrameLayout;
    TextView mTxtTime;
    String[] mArrayNameImage;
    int mValueHinhGoc = 0;
    int mCurrentime = 0;
    Handler mHandler = new Handler();
    int Request_Code_Animal = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        event();
    }

    private void event() {
        mImgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFrameLayout.setVisibility(View.GONE);
                randomImage();
                countDownTime(0);
            }
        });
        mImgHinhChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnimalsActivity.class);
                intent.putExtra("currentTime", mCurrentime);
                mHandler.removeCallbacks(runnable);
                startActivityForResult(intent, Request_Code_Animal);

            }
        });
    }

    private void countDownTime(int time) {
        mCurrentime = time;
        mHandler.postDelayed(runnable, 1000);
    }

    private void randomImage() {
        mArrayNameImage = getResources().getStringArray(R.array.arrayAnimal);
        Collections.shuffle(Arrays.asList(mArrayNameImage));
        mValueHinhGoc = getResources().getIdentifier(mArrayNameImage[0], "drawable", getPackageName());
        mImgHinhGoc.setImageResource(mValueHinhGoc);
    }

    private void init() {
        mImgHinhChon = findViewById(R.id.imageviewHinhChon);
        mImgHinhGoc = findViewById(R.id.imageviewHinhGoc);
        mImgPlay = findViewById(R.id.imagebuttonPlay);
        mFrameLayout = findViewById(R.id.framelayout);
        mTxtTime = findViewById(R.id.textviewThoiGian);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mCurrentime < 5) {
                mTxtTime.setText("Time : " + (5 - mCurrentime++));
                mHandler.postDelayed(runnable, 1000);
            } else {
                mHandler.removeCallbacks(runnable);
                Toast.makeText(MainActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
            }
        }
    };
}