package com.example.student.thuchanhtuan2_1_bai4;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_HoTen, edt_Cmnd, edt_BoSung;
    Button btn_Send;
    RadioGroup rad_BangCap;
    CheckBox ckbox_docbao, ckbox_docsach, ckbox_coding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_HoTen = (EditText) findViewById(R.id.editText_HoTen);
        edt_Cmnd = (EditText) findViewById(R.id.editText_Cmnd);
        edt_BoSung = (EditText) findViewById(R.id.editText_bosung);

        rad_BangCap = (RadioGroup) findViewById(R.id.rad_group);

        ckbox_docbao = (CheckBox) findViewById(R.id.checkBox_DocBao);
        ckbox_docsach = (CheckBox) findViewById(R.id.checkBox_DocSach);
        ckbox_coding = (CheckBox) findViewById(R.id.checkBox_DocCoding);

        btn_Send = (Button) findViewById(R.id.button_GuiThongTin);
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInformation();
            }
        });
    }
    public void displayInformation(){
        // Condition for Hoten feild
        String ten  = edt_HoTen.getText() + "";
        ten = ten.trim();
        if(ten.length() < 3){
            Toast.makeText(this, "Tên phải có ít nhất 3 ký tự", Toast.LENGTH_LONG).show();
            edt_HoTen.requestFocus();
            return;
        }

        // Condition for CMND feild
        String cmnd = edt_Cmnd.getText() + "";
        cmnd = cmnd.trim();
        if(cmnd.length() != 9){
            Toast.makeText(this, "CMND phải có 9 chữ số", Toast.LENGTH_LONG).show();
            edt_Cmnd.requestFocus();
            return;
        }

        // Condition for BangCap feild
        String bangcap = "";
        int bc = rad_BangCap.getCheckedRadioButtonId();
        if( bc == -1){
            Toast.makeText(this, "Bằng cấp phải được chọn",Toast.LENGTH_LONG).show();
            return;
        }

        RadioButton radioButton = (RadioButton) findViewById(bc);
        bangcap = radioButton.getText() + "";

        // Condition for SoThich feild
        String sothich = "";
        if(ckbox_docbao.isChecked())
            sothich += ckbox_docbao.getText() + "\n";
        if(ckbox_docsach.isChecked())
            sothich += ckbox_docsach.getText() + "\n";
        if(ckbox_coding.isChecked())
            sothich += ckbox_coding.getText() + "\n";

        String thongtinbosung = edt_BoSung.getText()+"";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        String msg = "Họ tên: " + ten + "\n";
        msg += "CMND: " + cmnd + "\n";
        msg += "Bằng cấp: " + bangcap + "\n";
        msg += "Sở thích: " + sothich + "\n";
        msg += "--------------//--------------\n";
        msg += "---Thông tin bổ sung--- \n";
        msg += thongtinbosung + "\n";
        msg += "--------------//--------------\n";
        builder.setMessage(msg);
        builder.create().show();

    }
}
