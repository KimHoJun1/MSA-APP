package com.unico.exchange.online.service;


import com.unico.exchange.online.dto.AucDetailDTO;
import com.unico.exchange.online.entity.AucDetailEntity;
import com.unico.exchange.online.repository.AucDetailMapper;
import com.unico.exchange.online.repository.AucDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AucDetailService {
    /*    @Autowired
        private DiscoveryClient discoveryClient;*/
    @Autowired
//    private KafkaService kafkaService;
    private AucDetailRepository repository;
    private AucDetailMapper mapper;


    public List<AucDetailDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public AucDetailDTO findOneById(long aucNum) {
        return mapper.toDTO(repository.findById(aucNum).orElse(null));
    }

    public AucDetailDTO insertAuc(AucDetailDTO dto) {

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Object> result = new ArrayList<>();

        AucDetailEntity entity =
                AucDetailEntity.builder()
                        .aucStartPrice(dto.getAucStartPrice())
                        .aucEndPrice(dto.getAucEndPrice())
                        .build();
        repository.save(entity);
        return null;
    }

    public AucDetailDTO updateAuc(AucDetailDTO dto) {
        return null;
    }

    public boolean deleteAuc(AucDetailDTO dto) {
        return true;
    }
}
