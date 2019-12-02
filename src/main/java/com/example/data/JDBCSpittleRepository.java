package com.example.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.Spittle;

@Repository
public class JDBCSpittleRepository implements SpittleRespository {

    @Override
    public List<Spittle> findSpittles(){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < 20; i++) {
            spittles.add(new Spittle(Long.valueOf(i),"Spittle " + i, new Date(),"Peter",Double.valueOf(i),Double.valueOf(i)));
        }
        return spittles;
    }
}
