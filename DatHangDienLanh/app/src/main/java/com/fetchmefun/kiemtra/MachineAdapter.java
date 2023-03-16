package com.fetchmefun.kiemtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fetchmefun.kiemtra.databinding.ItemMachineBinding;

import java.util.List;

public class MachineAdapter extends RecyclerView.Adapter<MachineAdapter.MachineViewHolder> {
    Context context ;
    List<Machine> machineList;

    public MachineAdapter(Context context, List<Machine> machineList) {
        this.context = context;
        this.machineList = machineList;
    }

    @NonNull
    @Override
    public MachineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMachineBinding machineBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_machine,
                parent,
                false
        );
        return new MachineViewHolder(machineBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MachineViewHolder holder, int position) {
        Machine machine = machineList.get(position);
        holder.machineBinding.setMachine(machine);
        String s0 = String.valueOf(machine.getQuantity());
        holder.machineBinding.machineQuantity.setText(s0);
        String s = String.valueOf(machine.isVoucher());
        holder.machineBinding.machineVoucher.setText(s);
    }

    @Override
    public int getItemCount() {
        return machineList.size();
    }

    public class MachineViewHolder extends RecyclerView.ViewHolder {
        private ItemMachineBinding machineBinding;

        public MachineViewHolder(ItemMachineBinding machineBinding) {
            super(machineBinding.getRoot());
            this.machineBinding = machineBinding;
        }
    }
}
