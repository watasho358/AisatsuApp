package jp.techacademy.watanabe.shouta.aisatsuapp;
 
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        } else {
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (hourOfDay >= 2 && hourOfDay <= 9 && minute >= 0 && minute <= 59) {
                            TextView textView = findViewById(R.id.textView);
                            textView.setText("おはよう");
                        } else if (hourOfDay >= 10 && hourOfDay <= 17 && minute >= 0 && minute <= 59) {
                            TextView textView = findViewById(R.id.textView);
                            textView.setText("こんにちは");
                        } else if (hourOfDay >= 18 && hourOfDay <= 23 && minute >= 0 && minute <= 59) {
                            TextView textView = findViewById(R.id.textView);
                            textView.setText("こんばんは");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}