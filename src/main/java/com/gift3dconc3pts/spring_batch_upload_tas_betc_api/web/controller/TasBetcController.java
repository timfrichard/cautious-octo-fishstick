package com.gift3dconc3pts.spring_batch_upload_tas_betc_api.web.controller;

import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.dtos.TasBetcDTO;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.dtos.TasBetcResponseDTO;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.entities.TasBetc;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.mapper.TasBetcMapper;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.services.TasBetcService;
import com.google.common.collect.Lists;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("tasBetc")
@RequiredArgsConstructor
public class TasBetcController {

    private final TasBetcService tasBetcService;
    private final TasBetcMapper tasBetcMapper;

    @PostMapping()
    public TasBetcDTO saveTasBetc(@Valid @RequestBody final TasBetcDTO tasBetcDTO) {

        log.info("Incoming TAS-BETC: {}-{}", tasBetcDTO.getGwaTas(), tasBetcDTO.getBetc());

        return tasBetcService.save(tasBetcDTO);
    }

    @PostMapping("/saveAll")
    public TasBetcResponseDTO savePurchaseOrders(@RequestBody final TasBetcResponseDTO tasBetcResponseDTO) {

        List<TasBetc> tasBetcs = Lists.newArrayList();
        tasBetcResponseDTO.getTasBetcDTOS().forEach(tasBetcDTO -> tasBetcs.add(tasBetcMapper.dtoTasBetcToTasBetc(tasBetcDTO)));

        return TasBetcResponseDTO.builder().tasBetcDTOS(tasBetcService.saveAll(tasBetcs)).build();
    }

}
