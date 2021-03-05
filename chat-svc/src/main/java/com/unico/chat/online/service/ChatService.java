package com.unico.chat.online.service;


import com.unico.chat.online.dto.ChatDTO;
import com.unico.chat.online.entity.ChatEntity;
//import com.unico.chat.online.kafka.KafkaService;
import com.unico.chat.online.repository.ChatMapper;
import com.unico.chat.online.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ChatService {
    /*@Autowired
    private DiscoveryClient discoveryClient;*/
    @Autowired
//    private KafkaService kafkaService;
    private ChatRepository repository;
    private ChatMapper mapper;


    public List<ChatDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public ChatDTO findOneById(long chtNum) {
        return mapper.toDTO(repository.findById(chtNum).orElse(null));
    }

    public ChatDTO insertChat(ChatDTO dto) {

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Object> result = new ArrayList<>();

        ChatEntity entity =
                ChatEntity.builder()
                        .chtNum(dto.getChtNum())
                        .hostUserNum(dto.getHostUserNum())
                        .guestUserNum(dto.getGuestUserNum())
                        .build();

        repository.save(entity);
        return null;
    }

    public ChatDTO updateChat(ChatDTO dto) {
        return null;
    }

    public boolean deleteChat(ChatDTO dto) {
        return true;
    }
}
