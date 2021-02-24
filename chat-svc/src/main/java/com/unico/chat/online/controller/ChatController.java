package com.unico.chat.online.controller;

import com.unico.chat.online.dto.ChatDTO;
import com.unico.chat.online.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/chat")
@RestController
public class ChatController {

    private ChatService service;

    @GetMapping("/v1")
    public List<ChatDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/v1/{chatNum}")
    public ChatDTO findOneById(@PathVariable long chatNum) {
        return service.findOneById(chatNum);
    }

    @PostMapping("/v1")
    public ChatDTO insertChat(@RequestBody ChatDTO dto) {
        System.out.println(dto.toString());
        return service.insertChat(dto);
    }

    @PutMapping("/v1")
    public ChatDTO updateChat(ChatDTO dto) {
        return service.updateChat(dto);
    }

    @DeleteMapping("/v1")
    public boolean deleteChat(ChatDTO dto) {
        return service.deleteChat(dto);
    }

    @GetMapping("/test")
    public String test() {
        return "hello";
    }


}
