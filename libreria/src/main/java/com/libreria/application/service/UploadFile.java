
package com.libreria.application.service;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Wstov
 */
public class UploadFile {
    private final String FOLDER = "images//";
    private final String IMG_DEFAULT = "default.jpg";
    
    public String upload(MultipartFile multipartFile) throws IOException{
        if(!multipartFile.isEmpty()){
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename()); //trae la ruta donde se esta guardando la img y se concatena
            Files.write(path, bytes); // pat": toma la ruta donde esta la img y con bytes: cada imagen se coloca en el arreglo de bytes
        }
        return IMG_DEFAULT;
    }
}
