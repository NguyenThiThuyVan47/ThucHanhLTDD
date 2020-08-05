package com.example.student.thuchanhtuan2_1_bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_Soa, edt_Sob;
    TextView txt_Result;
    Button btn_Tong, btn_Hieu, btn_Tich, btn_Thuong, btn_Uscln, btn_Thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Soa = (EditText) findViewById(R.id.editText_Soa);
        edt_Sob = (EditText) findViewById(R.id.editText_Sob);

        txt_Result = (TextView) findViewById(R.id.textView_Result);

        btn_Tong = (Button) findViewById(R.id.button_Tong);
        btn_Hieu = (Button) findViewById(R.id.button_Hieu);
        btn_Tich = (Button) findViewById(R.id.button_Tich);
        btn_Thuong = (Button) findViewById(R.id.button_Thuong);
        btn_Uscln = (Button) findViewById(R.id.button_Uscln);
        btn_Thoat = (Button) findViewById(R.id.button_Thoat);

        btn_Tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(edt_Soa.getText().toString());
                double b = Double.parseDouble(edt_Sob.getText().toString());

                txt_Result.setText("" + (a+b));
            }
        });

        btn_Hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(edt_Soa.getText().toString());
                double b = Double.parseDouble(edt_Sob.getText().toString());

                txt_Result.setText("" + (a-b));
            }
        });

        btn_Tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(edt_Soa.getText().toString());
                double b = Double.parseDouble(edt_Sob.getText().toString());

                txt_Result.setText("" + (a*b));
            }
        });

        btn_Thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(edt_Soa.getText().toString());
                double b = Double.parseDouble(edt_Sob.getText().toString());

                txt_Result.setText("" + (a/b));
            }
        });

        btn_Uscln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edt_Soa.getText().toString());
                int b = Integer.parseInt(edt_Sob.getText().toString());

                UocChungLonNhat ucln = new UocChungLonNhat(a,b);
                txt_Result.setText(ucln.getUCLN());
            }
        });

        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    class UocChungLonNhat{
        int a,b;
        int temp1, temp2;

        public UocChungLonNhat(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public String getUCLN(){
            temp1 = a;
            temp2 = b;

            while (temp1 != temp2){
                if(temp1 >  temp2){
                    temp1 -= temp2;
                }else {
                    temp2 -= temp1;
                }
            }
            return "" + temp1;
        }
    }
}
