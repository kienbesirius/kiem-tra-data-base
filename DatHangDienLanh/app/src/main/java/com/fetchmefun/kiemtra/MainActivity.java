package com.fetchmefun.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.fetchmefun.kiemtra.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding mBindingMain;
    public MainActivityClickHandlers mClickHandlers;
    private MachineDatabase machineDatabase;
    private Machine machine;
    private RadioButton typeMachine;
    private RadioButton payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBindingMain = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBindingMain.getRoot());
        mClickHandlers = new MainActivityClickHandlers();
        mBindingMain.setClickHandlers(mClickHandlers);
        machineDatabase = MachineDatabase.getInstance(this);

    }

    public class MainActivityClickHandlers{
        public void onClickBtnInsert(View view){
            typeMachine = findViewById( mBindingMain.radioGroupTypemachine.getCheckedRadioButtonId());
            payment = findViewById( mBindingMain.radioGroupThanhToan.getCheckedRadioButtonId());
            if(!typeMachine.isChecked()){
                Toast.makeText(MainActivity.this, "Chọn loại máy", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!payment.isChecked()){
                Toast.makeText(MainActivity.this, "Chọn thanh toán", Toast.LENGTH_SHORT).show();
                return;
            }
            if(mBindingMain.edtSoLuong.getText().toString().equals("") ||mBindingMain.edtHangSanXuat.getText().toString().equals("") ||mBindingMain.edtMaMay.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            if(mBindingMain.edtMaMay.getText().toString().contains(" ")){
                Toast.makeText(MainActivity.this, "Mã máy không chứa dấu cách", Toast.LENGTH_SHORT).show();
                return;
            }

            machine = new Machine(
                    typeMachine.getText().toString(),
                    mBindingMain.edtHangSanXuat.getText().toString().trim(),
                    mBindingMain.edtMaMay.getText().toString().trim(),
                    Integer.parseInt(mBindingMain.edtSoLuong.getText().toString().trim()),
                    payment.getText().toString(),
                    mBindingMain.checkboxVoucher.isChecked()
            );
            machineDatabase.getMachineDAO().insert(machine);
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }
        public void onClickBtnRefill(View view){
            mBindingMain.edtHangSanXuat.setText("");
            mBindingMain.edtMaMay.setText("");
            mBindingMain.edtSoLuong.setText("");
            mBindingMain.checkboxVoucher.setChecked(false);
            typeMachine.setChecked(false);
            payment.setChecked(false);
        }
    }
}