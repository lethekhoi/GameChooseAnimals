package lethekhoi.ltk.hcmus.gamechooseanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView mImgHinhGoc, mImgHinhChon;
    ImageButton mImgPlay;
    FrameLayout mFrameLayout;
    TextView mTxtTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mImgHinhChon = findViewById(R.id.imageviewHinhChon);
        mImgHinhGoc = findViewById(R.id.imageviewHinhGoc);
        mImgPlay = findViewById(R.id.imagebuttonPlay);
        mFrameLayout = findViewById(R.id.framelayout);
        mTxtTime = findViewById(R.id.textviewThoiGian);
    }
}
