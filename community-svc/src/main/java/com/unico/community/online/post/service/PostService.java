package com.unico.community.online.post.service;


import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.dto.PostSearchDTO;
import com.unico.community.online.post.dto.PostVODTO;
import com.unico.community.online.post.entity.PostEntity;
import com.unico.community.online.post.entity.PostVO;
import com.unico.community.online.post.kafka.PostKafkaService;
import com.unico.community.online.post.repository.PostMapper;
import com.unico.community.online.post.repository.PostRepository;
import com.unico.community.online.postCatg.entity.PostCatgEntity;
import com.unico.community.online.postCatg.repository.PostCatgRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
@Transactional
@AllArgsConstructor
public class PostService {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private PostKafkaService kafkaService;
    private PostRepository repository;
    private PostMapper mapper;
    private PostCatgRepository cRepository;


    public List<PostDTO> findAll(){
        return repository
                .findAll()
                .stream()
                .map(mapper::toPostDTO)
                .collect(Collectors.toList());
    }

    public List<PostDTO> findAllBySearchCondAndPaging(PostSearchDTO dto){
        return repository
                .findAllBySearchCondAndPaging(dto)
                .stream()
                .map(mapper::toPostDTO)
                .collect(Collectors.toList());
    }


    public PostDTO findOneById(PostVODTO voDTO){
        PostVO vo = PostVO.builder().postNum(voDTO.getPostNum()).postCatgUuid(voDTO.getPostCatgUuid()).build();
        return repository
                .findById(vo)
                .map(mapper::toPostDTO)
                .orElse(null);
    }
    public PostDTO insertPost(PostDTO dto){
        long postMaxNum = repository.getMaxPostNum();
        PostVO vo = PostVO.builder().postNum(postMaxNum).postCatgUuid(dto.getPostVO().getPostCatgUuid()).build();

        PostEntity entity =
                PostEntity.builder()
                .postVO(vo)
                .postContents(dto.getPostContents())
                .postTitle(dto.getPostTitle())
                .postUseYn(true)
                .userNum(dto.getUserNum())
                .build();

        repository.save(entity);
        return mapper.toPostDTO(entity);

    }

    public PostDTO updatePost(PostDTO dto){
        PostVO vo = PostVO.builder().postNum(dto.getPostVO().getPostNum()).postCatgUuid(dto.getPostVO().getPostCatgUuid()).build();
        PostEntity entity = repository.findById(vo).orElse(null);
        entity.update(dto);
        return mapper.toPostDTO(entity);
    }

    public boolean deletePost(PostDTO dto){
        PostVO vo = PostVO.builder().postNum(dto.getPostVO().getPostNum()).postCatgUuid(dto.getPostVO().getPostCatgUuid()).build();
        repository.deleteById(vo);
        return !repository.existsById(vo);
    }
}
