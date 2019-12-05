package lethekhoi.ltk.hcmus.gamechooseanimals;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalsActivity extends AppCompatActivity {

    int mCurrentime = 0;
    Handler mHandler = new Handler();
    TableLayout tableLayout;
    String[] mArrayNameImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        tableLayout = findViewById(R.id.tableLayout);
        mArrayNameImage = getResources().getStringArray(R.array.arrayAnimal);
        Intent intent = getIntent();
        int time = intent.getIntExtra("currentTime", -1);
        countDownTime(time);


//        0 1 2 =>3 * i + j
//        3 4 5
//        6 7 8
        int valuehinh = 0;
        int index = 0;
        for (int i = 0; i < 6; i++) {   //3*i+j
            TableRow tableRow = new TableRow(this);
            for (int j = 0; j < 3; j++) {
                final ImageView imageView = new ImageView(this);
                valuehinh = getResources().getIdentifier(mArrayNameImage[index++], "drawable", getPackageName());
                imageView.setTag(valuehinh);
                imageView.setImageResource(valuehinh);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent();
                        intent1.putExtra("currentTime", mCurrentime);
                        intent1.putExtra("valueHinh", Integer.parseInt(imageView.getTag().toString()));
                        setResult(RESULT_OK, intent1);
                        mHandler.removeCallbacks(runnable);
                        finish();
                    }
                });
                tableRow.addView(imageView);
            }
            //layout param : chỉnh giao diện
//            TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams();
//            layoutParams.setMargins(20, 20, 20, 20);
//            tableLayout.setLayoutParams(layoutParams);
            tableLayout.addView(tableRow);
        }


    }

    private void countDownTime(int time) {
        mCurrentime = time;
        mHandler.postDelayed(runnable, 1000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mCurrentime < 5) {
                mCurrentime++;
                mHandler.postDelayed(runnable, 1000);
            } else {
                mHandler.removeCallbacks(runnable);
                Intent intent = new Intent();
                intent.putExtra("currentTime", 1);
                setResult(RESULT_CANCELED, intent);
                finish();
                Toast.makeText(AnimalsActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
            }
        }
    };
}