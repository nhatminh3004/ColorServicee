package com.example.demo.restcontroller;

import com.example.demo.entity.Color;
import com.example.demo.repository.ColorRepository;
import com.example.demo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ColorRestController {
    @Autowired
    private ColorService colorService;
    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("/colors")
    public List<Color> getAllColor(){
        return colorService.getAllColor();
    }
    @Cacheable(value = "color",key = "#id")
    @GetMapping("/color/{id}")
    public Color getColorByID(@PathVariable int id){
        System.out.println("Load getColorByID from DB");
        return colorService.getColorByID(id);
    }
    @PostMapping("/color")
    public Color addNewColor(@RequestBody Color color) {
        return colorService.addColor(color);
    }
    @PutMapping("/color")
    @CachePut(value = "color",key = "#colorCurrent.colorID")
    public Color updateColor(@RequestBody Color colorCurrent){

        return colorService.updateColor(colorCurrent);
    }
    @DeleteMapping("/color/{id}")
    @CacheEvict(value = "color",allEntries = true)
    public String deleteColorByID(@PathVariable int id){
        return colorService.deleteColorByID(id);
    }
    @GetMapping("/getColorByProductId/{id}")
    @Cacheable(value = "colorProductID",key = "#id")
    public List<Color> getColorByProductId(@PathVariable int id){
        System.out.println("Load getColorByProductID from DB");
        return colorRepository.getColorByProductId(id);
    }

}
