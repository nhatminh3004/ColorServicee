package com.example.demo.service;

import com.example.demo.entity.Color;

import java.util.List;

public interface ColorService {
    public Color addColor(Color color);
    public Color getColorByID(int colorID);
    public List<Color> getAllColor();
    public String deleteColorByID(int colorID);
    public Color updateColor(Color colorCurrent);

}
