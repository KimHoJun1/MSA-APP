package com.unico.community.online.controller;


import com.unico.community.online.dto.CommunityDTO;
import com.unico.community.online.service.CommunityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@AllArgsConstructor
@RequestMapping( "/community" )
@RestController
public class CommunityController {

    private CommunityService service;

    @GetMapping("/v1")
    public List<CommunityDTO> findAll(){
        return service.findAll();
    }
    @GetMapping("/v1/{postNum}")
    public CommunityDTO findOneById(@PathVariable long postNum){
        return service.findOneById(postNum);
    }

    @PostMapping("/v1")
    public CommunityDTO insertPost(CommunityDTO dto){
        return service.insertPost(dto);
    }

    @PutMapping("/v1")
    public CommunityDTO updatePost(CommunityDTO dto){
        return service.updatePost(dto);
    }

    @DeleteMapping("/v1")
    public boolean deletePost(CommunityDTO dto){
        return service.deletePost(dto);
    }

}
