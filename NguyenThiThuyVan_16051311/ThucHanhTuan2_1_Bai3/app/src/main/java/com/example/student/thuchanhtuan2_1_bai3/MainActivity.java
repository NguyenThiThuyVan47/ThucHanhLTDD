package com.example.student.thuchanhtuan2_1_bai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_NamDuongLich;
    TextView txt_Result;
    Button btn_ChuyenDoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_NamDuongLich = (EditText) findViewById(R.id.editText_NamDuongLich);
        txt_Result = (TextView) findViewById(R.id.textView_Result);
        btn_ChuyenDoi = (Button) findViewById(R.id.button_Change);

        btn_ChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int namDuong = Integer.parseInt(edt_NamDuongLich.getText().toString());

                ChuyenDoiNamDuong cd = new ChuyenDoiNamDuong(namDuong);
                txt_Result.setText(cd.getCan() + " " + cd.getChi());
            }
        });
    }

    class ChuyenDoiNamDuong {
        int Nam;
        String can;
        String chi;

        public ChuyenDoiNamDuong(int nam) {
            Nam = nam;
        }

        public int getNam() {
            return Nam;
        }

        public void setNam(int nam) {
            Nam = nam;
        }

        public String getCan() {
            int temp = this.Nam % 10;

            switch (temp) {
                case 0: {
                    this.can = "Canh";
                    break;
                }
                case 1: {
                    this.can = "Tân";
                    break;
                }
                case 2: {
                    this.can = "Nhâm";
                    break;
                }
                case 3: {
                    this.can = "Quý";
                    break;
                }
                case 4: {
                    this.can = "Giáp";
                    break;
                }
                case 5: {
                    this.can = "Ất";
                    break;
                }
                case 6: {
                    this.can = "Bính";
                    break;
                }
                case 7: {
                    this.can = "Đinh";
                    break;
                }
                case 8: {
                    this.can = "Mậu";
                    break;
                }
                case 9: {
                    this.can = "Kỷ";
                    break;
                }
                default: {
                    this.can = "False";
                    break;
                }
            }
            return this.can;
        }

        public String getChi() {
            int temp1 = Nam % 12;

            switch (temp1) {
                case 0: {
                    this.chi = "Thân";
                    break;
                }
                case 1: {
                    this.chi = "Dậu";
                    break;
                }
                case 2: {
                    this.chi = "Tuất";
                    break;
                }
                case 3: {
                    this.chi = "Hợi";
                    break;
                }
                case 4: {
                    this.chi = "Tý";
                    break;
                }
                case 5: {
                    this.chi = "Sửu";
                    break;
                }
                case 6: {
                    this.chi = "Dần";
                    break;
                }
                case 7: {
                    this.chi = "Mẹo";
                    break;
                }
                case 8: {
                    this.chi = "Thìn";
                    break;
                }
                case 9: {
                    this.chi = "Tỵ";
                    break;
                }
                case 10: {
                    this.chi = "Ngọ";
                    break;
                }
                case 11: {
                    this.chi = "Mùi";
                    break;
                }
                default: {
                    this.chi = "Sai";
                    break;
                }
            }
            return this.chi;
        }
    }
}
