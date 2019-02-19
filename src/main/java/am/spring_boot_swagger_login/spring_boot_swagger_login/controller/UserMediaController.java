package am.spring_boot_swagger_login.spring_boot_swagger_login.controller;

import am.spring_boot_swagger_login.spring_boot_swagger_login.dtoMapper.UserMediaDTOUtil;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.dto.UserMediaCreatingDTO;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.User;
import am.spring_boot_swagger_login.spring_boot_swagger_login.model.entity.UserMedia;
import am.spring_boot_swagger_login.spring_boot_swagger_login.repository.UserMediaRepository;
import am.spring_boot_swagger_login.spring_boot_swagger_login.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest/usermedia")
public class UserMediaController {

    private final UserMediaRepository userMediaRepository;
    private final UserRepository userRepository;


    public UserMediaController(UserMediaRepository userMediaRepository, UserRepository userRepository) {
        this.userMediaRepository = userMediaRepository;
        this.userRepository = userRepository;
    }



    @PostMapping("/addPhoto")
    public ResponseEntity addUserPhoto(@RequestBody UserMediaCreatingDTO userMediaCreatingDTO) {
        UserMedia userMedia = userMediaRepository.save(UserMediaDTOUtil.convertToEntity(userMediaCreatingDTO));
        return new ResponseEntity<>(userMedia, HttpStatus.OK);
    }

    @DeleteMapping("/removePhoto")
    public ResponseEntity removePhoto(@RequestParam Long id) {
        Optional<UserMedia> optionalUserMedia = userMediaRepository.findById(id);
        //optionalUserMedia.ifPresent(userMediaRepository::delete);
        if (optionalUserMedia.isPresent()){
            userMediaRepository.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }

    @GetMapping("/getPhotoById")
    public ResponseEntity getPhotoById(@RequestParam Long id) {
        Optional<UserMedia> optionalUserMedia = userMediaRepository.findById(id);
        if (optionalUserMedia.isPresent()) {
            UserMedia userMedia = optionalUserMedia.get();
            return new ResponseEntity<>(userMedia, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

/*
    @GetMapping("/getPhotosByUserId")
    public ResponseEntity getUserPhotosByUserId(@RequestParam Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        //Iterable<UserMedia> optionalUserMedia = userMediaRepository.findAll();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            Iterable<UserMedia> userMediaIterable = userMediaRepository.findAll();
            UserMedia userMedia = userMediaIterable.
            if(id )

            //return new ResponseEntity<>(userMedia, HttpStatus.OK);
            return new ResponseEntity<>(userMediaRepository.findById(id), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        //return new ResponseEntity<>(userMediaRepository.findAll(), HttpStatus.OK);
    }*/

}
