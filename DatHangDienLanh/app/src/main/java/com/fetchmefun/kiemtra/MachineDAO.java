package com.fetchmefun.kiemtra;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MachineDAO {
    @Insert
    void insert(Machine machine);

    @Query("SELECT * FROM Machine")
    List<Machine> selectAll();
}
