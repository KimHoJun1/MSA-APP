package com.unico.exchange.online.service;


import com.unico.exchange.online.dto.DealDetailDTO;
import com.unico.exchange.online.entity.DealDetailEntity;
import com.unico.exchange.online.repository.DealDetailMapper;
import com.unico.exchange.online.repository.DealDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DealDetailService {
    /*@Autowired
    private DiscoveryClient discoveryClient;*/
    @Autowired
//    private KafkaService kafkaService;
    private DealDetailRepository repository;
    private DealDetailMapper mapper;


    public List<DealDetailDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public DealDetailDTO findOneById(long dealNum) {
        return mapper.toDTO(repository.findById(dealNum).orElse(null));
    }

    public DealDetailDTO insertDeal(DealDetailDTO dto) {

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Object> result = new ArrayList<>();

        DealDetailEntity entity =
                DealDetailEntity.builder()
                        .aucNum(dto.getAucNum())
                        .dealTitle(dto.getDealTitle())
                        .dealStatusCd(dto.getDealStatusCd())
                        .goodsCount(dto.getGoodsCount())
                        .dealStartTime(dto.getDealStartTime())
                        .dealEndTime(dto.getDealEndTime())
                        .text(dto.getText())
                        .createTime(LocalDateTime.now())
                        .updateTime(null)
                        .regnNm(dto.getRegnNm())
                        .image1Path(dto.getImage1Path())
                        .image2Path(dto.getImage2Path())
                        .image3Path(dto.getImage3Path())
                        .image4Path(dto.getImage4Path())
                        .build();
        repository.save(entity);
        return null;
    }

    public DealDetailDTO updateDeal(DealDetailDTO dto) {
        return null;
    }

    public boolean deleteDeal(DealDetailDTO dto) {
        return true;
    }
}
