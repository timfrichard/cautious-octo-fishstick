package com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.repositories;

import com.gift3dconc3pts.spring_batch_upload_tas_betc_api.core.model.entities.TasBetc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasBetcRepository extends CrudRepository<TasBetc, Long> {
}
