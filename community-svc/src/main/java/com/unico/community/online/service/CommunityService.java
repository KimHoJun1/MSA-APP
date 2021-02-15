package com.unico.community.online.service;


import com.netflix.discovery.converters.Auto;
import com.unico.community.online.dto.CommunityDTO;
import com.unico.community.online.entity.CommunityEntity;
import com.unico.community.online.kafka.KafkaService;
import com.unico.community.online.repository.CommunityMapper;
import com.unico.community.online.repository.CommunityRepository;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CommunityService {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private KafkaService kafkaService;
    private CommunityRepository repository;
    private CommunityMapper mapper;


    public List<CommunityDTO> findAll(){
        return mapper.toDTOList(repository.findAll());
    }
    public CommunityDTO findOneById(long postNum){
        return mapper.toDTO(repository.findById(postNum).orElse(null));
    }
    public CommunityDTO insertPost(CommunityDTO dto){

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Object> result = new ArrayList<>();
//
//        discoveryClient.getInstances("user-svc").forEach(instance->{
//            String url = instance.getUri().toString() + "/users/one/v1/"+dto.getUserId();
//            ResponseEntity res =  restTemplate.exchange(url, HttpMethod.GET,null,Object.class);
//        });
//

        CommunityEntity entity =
                CommunityEntity.builder()
                .contents(dto.getContents())
                .userId(dto.getUserId())
                .userNm(dto.getUserNm())
                .build();
        return null;
    }

    public CommunityDTO updatePost(CommunityDTO dto){
        return null;
    }

    public boolean deletePost(CommunityDTO dto){
        return true;
    }
}
