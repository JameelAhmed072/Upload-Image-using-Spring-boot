package com.example.service;

import com.example.entity.ImageData;
import com.example.repository.StorageRepository;
import com.example.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());

        if(imageData != null){
            return "file uploaded succssfully : "+ file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageName = storageRepository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageName.get().getImageData());
        return images;
    }
}
