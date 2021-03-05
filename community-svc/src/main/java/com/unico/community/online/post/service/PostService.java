package com.unico.community.online.post.service;


import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.entity.PostEntity;
import com.unico.community.online.post.entity.PostVO;
import com.unico.community.online.post.kafka.PostKafkaService;
import com.unico.community.online.post.repository.PostMapper;
import com.unico.community.online.post.repository.PostRepository;
import com.unico.community.online.postCatg.entity.PostCatgEntity;
import com.unico.community.online.postCatg.repository.PostCatgRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public PostDTO findOneById(long postNum){
        return repository
                .findById(postNum)
                .map(mapper::toPostDTO)
                .orElse(null);
    }
    public PostDTO insertPost(PostDTO dto){
        PostCatgEntity cEntity = cRepository.findById(dto.getPostVO().getPostCatgUuid()).orElse(null);

        PostEntity entity =
                PostEntity.builder()
                .postVO(PostVO.builder().postNum(dto.getPostVO().getPostNum()).postCatgUuid(dto.getPostVO().getPostCatgUuid()).build())
                .postContents(dto.getPostContents())
                .postTitle(dto.getPostTitle())
                .postUseYn(true)
                .userNum(dto.getUserNum())
                .build();
        entity.setPostCatgEntity(cEntity);

        repository.saveAndFlush(entity);

        return mapper.toPostDTO(entity);

    }

    public PostDTO updatePost(PostDTO dto){
        return null;
    }

    public boolean deletePost(PostDTO dto){
        return true;
    }
}
