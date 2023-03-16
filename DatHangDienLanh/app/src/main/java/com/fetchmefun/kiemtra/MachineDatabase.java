package com.fetchmefun.kiemtra;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Machine.class}, version = 1)
public abstract class MachineDatabase extends RoomDatabase {
    public abstract MachineDAO getMachineDAO();

    private static MachineDatabase instance;

    public static synchronized MachineDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            MachineDatabase.class,
                            "machine_data.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
