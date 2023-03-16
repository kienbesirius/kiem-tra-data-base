package com.fetchmefun.kiemtra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.fetchmefun.kiemtra.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding main2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(main2Binding.getRoot());

        main2Binding.rcvData.setLayoutManager(new LinearLayoutManager(this));
        MachineDatabase machineDatabase = MachineDatabase.getInstance(this);
        MachineAdapter machineAdapter = new MachineAdapter(this, machineDatabase.getMachineDAO().selectAll());
        main2Binding.rcvData.setAdapter(machineAdapter);
        main2Binding.rcvData.setHasFixedSize(true);
    }
}