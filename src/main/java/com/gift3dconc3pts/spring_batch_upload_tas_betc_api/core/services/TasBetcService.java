package com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.services;

import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.dtos.TasBetcDTO;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.entities.TasBetc;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.mapper.TasBetcMapper;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.repositories.TasBetcRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TasBetcService {

    private final TasBetcMapper tasBetcMapper;
    private final TasBetcRepository tasBetcRepository;

    public TasBetcDTO save(TasBetcDTO tasBetcDTO) {

        log.info("Saving a single TAS-BETC: {}", tasBetcDTO.getGwaTas());
        return tasBetcMapper.tasBetcToTasBetcDto(tasBetcRepository.save(tasBetcMapper.dtoTasBetcToTasBetc(tasBetcDTO)));
    }

    public List<TasBetcDTO> saveAll(final List<? extends TasBetc> tasBetcs) {

        log.info("Saving a list of TAS-BETC size: {}", tasBetcs.size());
        ArrayList<TasBetc> returnTasBetcs = Lists.newArrayList(tasBetcRepository.saveAll(tasBetcs));

        ArrayList<TasBetcDTO> returnTasBetcDtos = Lists.newArrayList();
        returnTasBetcs.forEach(tasBetc -> returnTasBetcDtos.add(tasBetcMapper.tasBetcToTasBetcDto(tasBetc)));

        return returnTasBetcDtos;
    }
}
