package com.example.data;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.Spittle;

public interface SpittleRespository {
    public List<Spittle> findSpittles();
}
