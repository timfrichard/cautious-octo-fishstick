package com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.mapper;

import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.dtos.TasBetcDTO;
import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.entities.TasBetc;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TasBetcMapper {

    TasBetcMapper tasBetcMapper = Mappers.getMapper(TasBetcMapper.class);

    TasBetc dtoTasBetcToTasBetc(TasBetcDTO tasBetcDTO);

    TasBetcDTO tasBetcToTasBetcDto(TasBetc tasBetc);
}
