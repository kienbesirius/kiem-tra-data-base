package com.fetchmefun.kiemtra;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Machine extends BaseObservable {
    private String typeMachine;
    private String manufacturer; // Hãng sản xuất
    @NonNull
    @PrimaryKey
    private String id;
    private int quantity;
    private String payment;
    private boolean voucher;

    @Ignore
    public Machine() {
        id = "";
    }

    @Bindable
    public String getTypeMachine() {
        return typeMachine;
    }

    public void setTypeMachine(String typeMachine) {
        this.typeMachine = typeMachine;
        notifyPropertyChanged(BR.typeMachine);
    }
    @Bindable
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        notifyPropertyChanged(BR.manufacturer);
    }
    @Bindable
    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
    @Bindable
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(BR.quantity);
    }
    @Bindable
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
        notifyPropertyChanged(BR.payment);
    }
    @Bindable
    public boolean isVoucher() {
        return voucher;
    }

    public void setVoucher(boolean voucher) {
        this.voucher = voucher;
        notifyPropertyChanged(BR.voucher);
    }

    public Machine(String typeMachine, String manufacturer, @NonNull String id, int quantity, String payment, boolean voucher) {
        this.typeMachine = typeMachine;
        this.manufacturer = manufacturer;
        this.id = id;
        this.quantity = quantity;
        this.payment = payment;
        this.voucher = voucher;
    }

}
