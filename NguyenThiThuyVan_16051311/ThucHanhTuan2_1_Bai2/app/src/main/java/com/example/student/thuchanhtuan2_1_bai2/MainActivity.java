package com.example.student.thuchanhtuan2_1_bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt_Fah, edt_Cel;
    Button btn_FtoC, btn_CtoF, btn_Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Fah = (EditText) findViewById(R.id.editText_Fah);
        edt_Cel = (EditText) findViewById(R.id.editText_Cel);

        btn_FtoC = (Button) findViewById(R.id.button_FtoC);
        btn_CtoF = (Button) findViewById(R.id.button_CtoF);
        btn_Clear = (Button) findViewById(R.id.button_Clear);

        btn_FtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nhietdof = Double.parseDouble(edt_Fah.getText().toString());

                double nhietdoc = ((nhietdof - 32)*5/9);
                edt_Cel.setText("" + (nhietdoc*1.0));
            }
        });

        btn_CtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nhietdoc = Double.parseDouble(edt_Cel.getText().toString());

                double nhietdof = nhietdoc*9/5 + 32;
                edt_Fah.setText("" + (nhietdof*1.0));
            }
        });

        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_Fah.setText("");
                edt_Cel.setText("");
            }
        });

    }
}
