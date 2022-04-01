package miu.edu.demo.controller;

import miu.edu.demo.domain.dto.UserDto;
import miu.edu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService service;


    @GetMapping("/")
    public List<UserDto> getPosts(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        var user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public void save(@RequestBody UserDto uDto) {
        service.save(uDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postId, @RequestBody UserDto uDto) {
        service.update(postId, uDto);
    }


    
}
