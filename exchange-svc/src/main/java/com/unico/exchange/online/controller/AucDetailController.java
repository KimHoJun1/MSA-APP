package com.unico.exchange.online.controller;

import com.unico.exchange.online.dto.AucDetailDTO;
import com.unico.exchange.online.service.AucDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/auc")
@RestController
public class AucDetailController {

    private AucDetailService service;

    @GetMapping("/v1")
    public List<AucDetailDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/v1/{aucNum}")
    public AucDetailDTO findOneById(@PathVariable long aucNum) {
        return service.findOneById(aucNum);
    }

    @PostMapping("/v1")
    public AucDetailDTO insertAuc(AucDetailDTO dto) {
        return service.insertAuc(dto);
    }

    @PutMapping("/v1")
    public AucDetailDTO updateAuc(AucDetailDTO dto) {
        return service.updateAuc(dto);
    }

    @DeleteMapping("/v1")
    public boolean deleteAuc(AucDetailDTO dto) {
        return service.deleteAuc(dto);
    }

}
