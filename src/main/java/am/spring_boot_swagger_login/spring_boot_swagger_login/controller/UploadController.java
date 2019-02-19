package am.spring_boot_swagger_login.spring_boot_swagger_login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/rest/upload1")
public class UploadController {


/*
    //Save the uploaded file to this folder
    //private static String UPLOADED_FOLDER = "//C://Users//A.D//Desktop//IMAGE123//";
    private static String UPLOADED_FOLDER = "C://JAVAJAVAJAVA//SARGIS TASKS//spring_boot_swagger_login2_1//src//main//resources//image//";


    @PostMapping("/upload") // //new annotation since 4.3
    public ResponseEntity singleFileUpload(@RequestParam("file") MultipartFile file,
                                           RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
*/
}
