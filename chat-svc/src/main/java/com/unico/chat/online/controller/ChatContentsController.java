package com.unico.chat.online.controller;

import com.unico.chat.online.dto.ChatContentsDTO;
import com.unico.chat.online.dto.ChatDTO;
import com.unico.chat.online.service.ChatContentsService;
import com.unico.chat.online.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/chatcontents")
@RestController
public class ChatContentsController {

    private ChatContentsService service;

    @GetMapping("/v1")
    public List<ChatContentsDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/v1/{chatSeq}")
    public ChatContentsDTO findOneById(@PathVariable BigDecimal chatSeq) {
        return service.findOneById(chatSeq);
    }

    @PostMapping("/v1")
    public ChatContentsDTO insertChatContents(ChatContentsDTO dto) {
        return service.insertChatContents(dto);
    }

    @PutMapping("/v1")
    public ChatContentsDTO updateChat(ChatContentsDTO dto) {
        return service.updateChatContents(dto);
    }

    @DeleteMapping("/v1")
    public boolean deleteChatContents(ChatContentsDTO dto) {
        return service.deleteChatContents(dto);
    }

}
