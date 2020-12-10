package com.xlab.services;


import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.xlab.dtos.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class PhotoService {


    private final Cloudinary cloudinary;

    @Autowired
    public PhotoService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }


    public String getPhotoUrl(PhotoDto dto) {

        String remoteIconUrl = "fetch:" + getIcon(dto.getWeatherStatus());
        return
                cloudinary.url()
                        .transformation(new Transformation().overlay(remoteIconUrl)
                                .gravity("faces")
                                .width(250))
                        .type("fetch")
                        .imageTag(dto.getImageUrl());
    }


    protected String getIcon(String weatherStatus) {
        switch (weatherStatus) {
            case "Rain":
                return Base64.getEncoder().encodeToString("http://icons.iconarchive.com/icons/sonya/swarm/256/Rain-icon.png".getBytes());
            case "Clouds":
                return Base64.getEncoder().encodeToString("http://icons.iconseeker.com/ico/weather/cloudy.ico".getBytes());
            case "Sunny":
                return Base64.getEncoder().encodeToString("https://openclipart.org/image/2400px/svg_to_png/176605/1364574715.png".getBytes());
            default:
                return Base64.getEncoder().encodeToString("https://openclipart.org/image/2400px/svg_to_png/176605/1364574715.png".getBytes());
        }
    }


}
