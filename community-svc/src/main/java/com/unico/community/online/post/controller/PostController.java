package com.unico.community.online.post.controller;


import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping( "/post" )
@RestController
public class PostController {

    private PostService service;

    @GetMapping("/v1")
    public List<PostDTO> findAll(){
        return service.findAll();
    }
    @GetMapping("/v1/{postNum}")
    public PostDTO findOneById(@PathVariable long postNum){
        return service.findOneById(postNum);
    }

    @PostMapping("/v1")
    public PostDTO insertPost(PostDTO dto){
        return service.insertPost(dto);
    }

    @PutMapping("/v1")
    public PostDTO updatePost(PostDTO dto){
        return service.updatePost(dto);
    }

    @DeleteMapping("/v1")
    public boolean deletePost(PostDTO dto){
        return service.deletePost(dto);
    }

}
