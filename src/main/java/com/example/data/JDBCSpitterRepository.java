package com.example.data;

import org.springframework.stereotype.Repository;
import com.example.Spitter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JDBCSpitterRepository implements SpitterRespository{
    private Map<String, Spitter> users=new HashMap<String, Spitter>();
    @Override
    public void save(Spitter spitter){
        spitter.setRegistationDate(new Date());
        users.put(spitter.getUsername(),spitter);
    }
    @Override
    public Spitter findByUsername(String username){
        return users.get(username);
    }
}
