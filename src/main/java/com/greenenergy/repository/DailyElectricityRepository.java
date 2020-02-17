package com.greenenergy.repository;

import com.greenenergy.model.DailyElectricity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository for all operations related to {@link DailyElectricity}.
 *
 * @author javad talebi
 */
public interface DailyElectricityRepository extends CrudRepository<DailyElectricity, Long> {

    List<DailyElectricity> findAllByPanelId(Long panelId);
}
