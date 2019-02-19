package am.spring_boot_swagger_login.spring_boot_swagger_login.controller;

import am.spring_boot_swagger_login.spring_boot_swagger_login.dtoMapper.UserDTOUtil;
import am.spring_boot_swagger_login.spring_boot_swagger_login.dtoMapper.UserMediaDTOUtil;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.dto.UserCreatingDTO;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.User;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.UserMedia;
import am.spring_boot_swagger_login.spring_boot_swagger_login.repository.UserMediaRepository;
import am.spring_boot_swagger_login.spring_boot_swagger_login.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

//import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/rest/user")
public class MainController {

    private final UserRepository userRepository;
    private final UserMediaRepository userMediaRepository;

    @Autowired
    public MainController(UserRepository userRepository, UserMediaRepository userMediaRepository) {
        this.userRepository = userRepository;
        this.userMediaRepository = userMediaRepository;
    }





    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://JAVAJAVAJAVA//SARGIS TASKS//spring_boot_swagger_login2_1//src//main//resources//image//";
/*
    //@PostMapping(value = "/addfotki", produces = {"application/json"}, consumes = {"multipart/form-data"})
    //@PostMapping(value = "/addfotki", consumes = {"multipart/form-data"})
    @RequestMapping(value="/addfotki", method=RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody UserCreatingDTO userCreatingDTO,
                                  @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        User user = userRepository.save(UserDTOUtil.convertToEntity(userCreatingDTO));

            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                //return new ResponseEntity<>(user, HttpStatus.OK);
                redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");

            } catch (IOException e) {
                e.printStackTrace();
            }

        String photoUrl = (UPLOADED_FOLDER + file.getOriginalFilename());
                //.replaceAll("/", "\\/");
        UserMedia userMedia = new UserMedia();
            userMedia.setPhotoUrl(photoUrl);
            userMedia.setUser_id(user.getId());
            userMediaRepository.save(userMedia);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/

/*
    @RequestMapping(value="/addUserAndPhoto", method=RequestMethod.POST)
    public ResponseEntity addUserAndPhoto(@RequestBody UserCreatingDTO userCreatingDTO, HttpServletResponse response, HttpServletRequest request)
    {
        User user = userRepository.save(UserDTOUtil.convertToEntity(userCreatingDTO));


        try {
            MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipart=multipartRequest.getFile(it.next());
            //String fileName=user.getId()+".png";



            byte[] bytes=multipart.getBytes();
            String photoUrl = multipart.getOriginalFilename();
            BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream("src/main/resources/image/"+photoUrl));

            stream.write(bytes);
            stream.close();
            return new ResponseEntity<>("upload success", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Upload fialed", HttpStatus.BAD_REQUEST);
        }

        //UserMedia userMedia = new UserMedia();
        //userMedia.setPhotoUrl(photoUrl);
        //userMedia.setUser_id(user.getId());
        //userMediaRepository.save(userMedia);

        //return new ResponseEntity<>(user, HttpStatus.OK);
    }
*/
//, produces = {"application/json"}, consumes = {"multipart/form-data"}
    @RequestMapping(value="/addfotki", method=RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<?> addUser(@RequestBody UserCreatingDTO userCreatingDTO,
                                     @RequestParam("file") MultipartFile file) {

        User user = userRepository.save(UserDTOUtil.convertToEntity(userCreatingDTO));

        if (file.isEmpty()) {
            //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return new ResponseEntity<>(user, HttpStatus.OK);
            //redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        String photoUrl = (UPLOADED_FOLDER + file.getOriginalFilename());
        //.replaceAll("/", "\\/");
        UserMedia userMedia = new UserMedia();
        userMedia.setPhotoUrl(photoUrl);
        userMedia.setUser_id(user.getId());
        userMediaRepository.save(userMedia);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }








    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserCreatingDTO userCreatingDTO) {
        User user = userRepository.save(UserDTOUtil.convertToEntity(userCreatingDTO));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity getUserList() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        //optionalUser.ifPresent(userRepository::delete);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserCreatingDTO userCreatingDTO, @RequestParam Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userCreatingDTO.getFirstName());
            user.setLastName(userCreatingDTO.getLastName());
            user.setBirthDate(userCreatingDTO.getBirthDate());
            user.setPhoneNumber(userCreatingDTO.getPhoneNumber());
            user.setEMail(userCreatingDTO.getEMail());
            user.setUserPassword(userCreatingDTO.getUserPassword());
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get")
    public ResponseEntity getUserById(@RequestParam Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
