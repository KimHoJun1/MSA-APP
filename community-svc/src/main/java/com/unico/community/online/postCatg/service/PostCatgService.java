package com.unico.community.online.postCatg.service;

import com.unico.community.online.postCatg.dto.PostCatgDTO;
import com.unico.community.online.postCatg.repository.PostCatgMapper;
import com.unico.community.online.postCatg.repository.PostCatgRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PostCatgService {

    private PostCatgMapper mapper;
    private PostCatgRepository repository;

    public List<PostCatgDTO> findAll(){
        return repository
                .findAll()
                .stream()
                .map(mapper::toPostCatgDTO)
                .collect(Collectors.toList());
    }
}
