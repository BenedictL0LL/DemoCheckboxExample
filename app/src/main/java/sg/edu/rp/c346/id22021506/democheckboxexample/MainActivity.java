package sg.edu.rp.c346.id22021506.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEnabled=findViewById(R.id.checkBoxDiscount);
        btnCheck =findViewById(R.id.buttonCheck);
        tvShow =findViewById(R.id.textView);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbEnabled.isChecked()){
                    tvShow.setText("The discount is given.");
                }else{
                    tvShow.setText("No discount is given.");
                }
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbEnabled.isChecked()){
                    Toast.makeText(getApplicationContext(), "The discount is given.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "The discount is not given.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if(cbEnabled.isChecked()) {
            double pay = calcPay(100, 20);
            tvShow.setText("The discount is given. You need to pay " + pay);
        }
        else {
            double pay = calcPay(100, 0);
            tvShow.setText("The discount is not given. You need to pay " + pay);
        }

    }
    private double calcPay(double price, double discount) {
        double pay = price * (1 - discount / 100);
        return pay;
    }


    }
