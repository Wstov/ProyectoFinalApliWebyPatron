/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.application.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Wstov
 */
public class UploadFileUser {

    private final String FOLDER = "imagesuser//";
    private final String IMG_DEFAULT = "defaultuser.webp";

    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename()); //trae la ruta donde se esta guardando la img y se concatena
            Files.write(path, bytes); // pat": toma la ruta donde esta la img y con bytes: cada imagen se coloca en el arreglo de bytes
            return multipartFile.getOriginalFilename();
        }
        return IMG_DEFAULT;
    }

    public void delete(String nameFile) {
        File file = new File(FOLDER + nameFile);
        file.delete();
    }
    
    
}
