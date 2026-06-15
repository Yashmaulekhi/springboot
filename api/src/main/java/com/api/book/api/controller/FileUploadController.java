package com.api.book.api.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.api.helper.FileUploadHelper;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class FileUploadController {
    @Autowired
    FileUploadHelper FileUploadhelper;
    
    
    @PostMapping("/image")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        String a=file.getContentType();
       // return ResponseEntity.ok("working");

        try{
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is not created");
        }
        if(!a.equals("image/png")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is only of png");
        }
        boolean f=FileUploadhelper.fileUpload(file);
        if( f){
            //return ResponseEntity.ok("File is uploaded");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
        }
        }
    catch(Exception e ){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
    }
    return ResponseEntity.ok("wrong format only png");
    }}

//     @GetMapping("/image/{filename}")
//     public ResponseEntity<?> getImage(@PathVariable String filename) {
//         try {
//             String uploadDir = "D:\\springbootvs\\api\\src\\main\\resources\\image";
//             java.nio.file.Path filePath = Paths.get(uploadDir).resolve(filename);
            
//             if (!Files.exists(filePath)) {
//                 return ResponseEntity.notFound().build();
//             }
            
//             Resource resource = new FileSystemResource(filePath);
//             return ResponseEntity.ok()
//                 .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"")
//                 .contentType(MediaType.IMAGE_PNG)
//                 .body(resource);
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                 .body("Error retrieving file: " + e.getMessage());
//         }
//     }
// }

