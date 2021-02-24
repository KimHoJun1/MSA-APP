package com.unico.chat.online.service;


import com.unico.chat.online.dto.ChatContentsDTO;

import com.unico.chat.online.entity.ChatContentsEntity;

//import com.unico.chat.online.kafka.KafkaService;
import com.unico.chat.online.repository.ChatContentsMapper;
import com.unico.chat.online.repository.ChatContentsRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ChatContentsService {
    /*    @Autowired
        private DiscoveryClient discoveryClient;*/
    @Autowired
//    private KafkaService kafkaService;
    private ChatContentsRepository repository;
    private ChatContentsMapper mapper;


    public List<ChatContentsDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public ChatContentsDTO findOneById(BigDecimal chtSeq) {
        return mapper.toDTO(repository.findById(chtSeq).orElse(null));
    }

    public ChatContentsDTO insertChatContents(ChatContentsDTO dto) {

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Object> result = new ArrayList<>();

        ChatContentsEntity entity =
                ChatContentsEntity.builder()
                        .chtNum(dto.getChtNum())
                        .chtLine(dto.getChtLine())
                        .chtCreateTime(LocalDateTime.now())
                        .build();
        return null;
    }

    public ChatContentsDTO updateChatContents(ChatContentsDTO dto) {
        return null;
    }

    public boolean deleteChatContents(ChatContentsDTO dto) {
        return true;
    }
}
