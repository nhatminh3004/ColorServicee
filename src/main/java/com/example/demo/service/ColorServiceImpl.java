package com.example.demo.service;

import com.example.demo.entity.Color;
import com.example.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Color addColor(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public Color getColorByID(int colorID) {
        return colorRepository.findById(colorID).orElse(null);
    }

    @Override
    public List<Color> getAllColor() {
        return colorRepository.findAll();
    }

    @Override
    public String deleteColorByID(int colorID) {
        colorRepository.deleteById(colorID);
        return "Delete Succed Color :" + colorID;
    }

    @Override
    public Color updateColor(Color colorCurrent) {
        Color colorKhiUpdate =new Color();
            colorRepository.findById(colorCurrent.getColorID()).ifPresent(colorUpdate -> {
                colorUpdate.setColorID(colorCurrent.getColorID());
                colorUpdate.setCode(colorCurrent.getCode());
                colorUpdate.setName(colorCurrent.getName());
                colorUpdate.setProductID(colorCurrent.getProductID());
                colorKhiUpdate.setColorID(colorCurrent.getColorID());
                colorKhiUpdate.setCode(colorCurrent.getCode());
                colorKhiUpdate.setName(colorCurrent.getName());
                colorKhiUpdate.setProductID(colorCurrent.getProductID());
                colorRepository.save(colorKhiUpdate);
            });
        return colorKhiUpdate;
    }
}
