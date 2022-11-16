package com.example.demo.repository;

import com.example.demo.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ColorRepository extends JpaRepository<Color,Integer> {
    @Modifying
    @Transactional
    @Query(value = "select * from colors where productID= :id ", nativeQuery = true)
    public List<Color> getColorByProductId(@Param("id") int id);
}
