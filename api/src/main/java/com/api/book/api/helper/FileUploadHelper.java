
// package com.api.book.api.helper;

// import java.io.File;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;

// import org.springframework.core.io.ClassPathResource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.multipart.MultipartFile;

// @Component
// public class FileUploadHelper {
//    // public final String UPLOAD_DIR = "D:\\springbootvs\\api\\src\\main\\resources\\image";
//    // System.out.println("✅ Upload directory: " + UPLOAD_DIR);
//    public FileUploadHelper() throws IOException{
// }
// public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
//     public boolean fileUpload(MultipartFile file) {

//         boolean isUploaded = false;
//         try {
//             Files.copy(
//                 file.getInputStream(),
//                 Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
//                 StandardCopyOption.REPLACE_EXISTING
                
//             );
            
//             isUploaded = true;
//         } catch(Exception e) {
//             e.printStackTrace();
//         }
//         return isUploaded;
//     }
// }
package com.api.book.api.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    
    public final String UPLOAD_DIR;
    
    public FileUploadHelper() throws IOException {
        String uploadPath;
        try {
            // Try to get classpath resource path
            uploadPath = new org.springframework.core.io.ClassPathResource("static/image/").getFile().getAbsolutePath();
        } catch (IOException e) {
            // Fallback if folder doesn't exist
            uploadPath = new File("src/main/resources/static/image").getAbsolutePath();
        }
        
        // Create directory if it doesn't exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
            System.out.println("✅ Created upload directory: " + uploadPath);
        }
        
        this.UPLOAD_DIR = uploadPath;
        System.out.println("✅ Upload directory initialized: " + this.UPLOAD_DIR);
    }
    
    public boolean fileUpload(MultipartFile file) {
        boolean isUploaded = false;
        try {
            Files.copy(
                file.getInputStream(),
                Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING
            );
            isUploaded = true;
            System.out.println("✅ File uploaded: " + file.getOriginalFilename());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return isUploaded;
    }
}