package com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasBetcResponseDTO {

    private List<TasBetcDTO> tasBetcDTOS;
}
