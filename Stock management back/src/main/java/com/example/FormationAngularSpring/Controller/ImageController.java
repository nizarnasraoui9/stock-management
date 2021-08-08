package com.example.FormationAngularSpring.Controller;


import com.example.FormationAngularSpring.Model.Entities.Image;
import com.example.FormationAngularSpring.Model.IRepository.IImageRepository;
import com.example.FormationAngularSpring.Model.ServiceImp.ImageServiceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/image")
    public class ImageController {

    @Autowired
    IImageRepository imageRepository;
    @Autowired
    ImageServiceImpl imageservice;



  /*  @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        Image fileName = imageservice.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
}
   // @PostMapping("/upload")
    //public Image uplaodImage(@RequestParam("myFile") MultipartFile file) throws IOException {

        //Image img = new Image( file.getOriginalFilename(),file.getContentType(),file.getBytes() );


       // final Image savedImage = imageRepository.save(img);


      //  System.out.println("Image saved");


        //return savedImage;
//

*/
}


