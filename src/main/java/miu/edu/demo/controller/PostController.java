package miu.edu.demo.controller;

import miu.edu.demo.domain.PostV2;
import miu.edu.demo.domain.dto.PostDto;
import miu.edu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService service;


    @GetMapping
    public List<PostDto> getPosts(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable int id) {
        var post = service.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public void save(@RequestBody PostDto p) {
        service.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postId, @RequestBody PostDto pDto) {
        service.update(postId, pDto);
    }

    @GetMapping("/v2") // /post/v2/{id}
    public ResponseEntity<PostV2> getPostV2(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "someValue");
        return ResponseEntity.ok()
                .headers(headers)
                .body(new PostV2(111,"title v2", "content v2", "author v2"));
    }

    @GetMapping("/")
    public List<PostDto> getAllWithTitle(@RequestParam(value = "title", required = false) String title) {
        return title == null ? service.findAll() : service.findAllPostsByTitle(title);
    }

}
