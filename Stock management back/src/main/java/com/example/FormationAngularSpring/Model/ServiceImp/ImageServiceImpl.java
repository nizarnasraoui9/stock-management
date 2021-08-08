package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Image;
import com.example.FormationAngularSpring.Model.IRepository.IImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl {


    @Autowired
    private IImageRepository imageRepository;

   /* public Image storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Image dbFile = new Image(fileName, file.getContentType(), file.getBytes());

            return imageRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Optional<Image> getFile(String fileId) {
        return imageRepository.findById(fileId);
                //.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
}*/
}
