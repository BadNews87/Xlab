package com.xlab.controllers;

import com.xlab.dtos.PhotoDto;
import com.xlab.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/photos")
public class PhotoController {

    private final PhotoService photoService;


    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    public String getPhotoUrl(@RequestBody PhotoDto dto){
//        String imageUrl = "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-8/15418460_769207176560513_6205921274320581410_o.jpg?oh=e788aa26f37efa29dce55b53dab4cb9c&oe=59257779";
//        String status = "Rain";
        return photoService.getPhotoUrl(dto);
    }


}
