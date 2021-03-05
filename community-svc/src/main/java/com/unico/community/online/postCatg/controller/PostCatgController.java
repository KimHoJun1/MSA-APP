package com.unico.community.online.postCatg.controller;

import com.unico.community.online.postCatg.dto.PostCatgDTO;
import com.unico.community.online.postCatg.service.PostCatgService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "/postCatg" )
public class PostCatgController {

    private PostCatgService service;

    @GetMapping("/list/v1")
    public List<PostCatgDTO> findAll(){
        return service.findAll();
    }

}


