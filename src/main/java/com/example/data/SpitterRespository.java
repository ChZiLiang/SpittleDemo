package com.example.data;

import com.example.Spitter;

public interface SpitterRespository {
    public void save(Spitter spitter);
    public Spitter findByUsername(String username);
}
