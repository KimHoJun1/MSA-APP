package com.unico.community.online.post.controller;


import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.dto.PostSearchDTO;
import com.unico.community.online.post.dto.PostVODTO;
import com.unico.community.online.post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@AllArgsConstructor
@RequestMapping( "/post" )
@RestController
public class PostController {

    private PostService service;

    @GetMapping("/v1")
    public ResponseEntity<List<PostDTO>> findAll(){
        ResponseEntity<List<PostDTO>> result = null;

        try{
            result = ResponseEntity.ok(service.findAll());
        }catch(Exception e){

        }
        return result;
    }


    @PostMapping("/search/paging/v1")
    public ResponseEntity<List<PostDTO>> findAllBySearchCondAndPagind(@RequestBody PostSearchDTO dto){
        ResponseEntity<List<PostDTO>> result = null;

        try{
            result = ResponseEntity.ok(service.findAllBySearchCondAndPaging(dto));
        }catch(Exception e){

        }
        return result;

    }



    @GetMapping("/v1/{postNum}")
    public ResponseEntity<PostDTO> findOneById(@PathVariable PostVODTO voDTO){
        ResponseEntity<PostDTO> result = null;

        try{
            result = ResponseEntity.ok(service.findOneById(voDTO));
        }catch(Exception e){

        }
        return result;
    }

    @PostMapping("/v1")
    public ResponseEntity<PostDTO> insertPost(@RequestBody PostDTO dto) throws Exception {
        ResponseEntity<PostDTO> result = null;
        log.info("insertPost : " + dto);
        try{
            result = ResponseEntity.ok(service.insertPost(dto));
        }catch(Exception e){
            throw new Exception(e);
        }
        return result;
    }

    @PutMapping("/v1")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO dto){
        ResponseEntity<PostDTO> result = null;

        try{
            result = ResponseEntity.ok(service.updatePost(dto));
        }catch(Exception e){

        }
        return result;
    }

    @DeleteMapping("/v1")
    public ResponseEntity<Boolean> deletePost(@RequestBody PostDTO dto){
        ResponseEntity<Boolean> result = null;

        try{
            result = ResponseEntity.ok(service.deletePost(dto));
        }catch(Exception e){

        }
        return result;
    }

}
