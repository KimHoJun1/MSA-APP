package com.unico.exchange.online.controller;

import com.unico.exchange.online.dto.DealDetailDTO;
import com.unico.exchange.online.service.DealDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/deal")
@RestController
public class DealDetailController {

    private DealDetailService service;

    @GetMapping("/v1")
    public List<DealDetailDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/v1/{dealNum}")
    public DealDetailDTO findOneById(@PathVariable long dealNum) {
        return service.findOneById(dealNum);
    }

    @PostMapping("/v1")
    public DealDetailDTO insertDeal(@RequestBody DealDetailDTO dto) { return service.insertDeal(dto); }

    @PutMapping("/v1")
    public DealDetailDTO updateDeal(DealDetailDTO dto) { return service.updateDeal(dto); }

    @DeleteMapping("/v1")
    public boolean deleteDeal(DealDetailDTO dto) {
        return service.deleteDeal(dto);
    }

    @GetMapping("/test")
    public String test() {
        return "hello";
    }


}
