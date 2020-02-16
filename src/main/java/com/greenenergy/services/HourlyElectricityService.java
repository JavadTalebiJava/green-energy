package com.greenenergy.services;

import com.greenenergy.model.HourlyElectricity;
import com.greenenergy.model.Panel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

/**
 * HourlyElectricityService interface for all services related to HourlyElectricity.
 */
public interface HourlyElectricityService {

  HourlyElectricity save(HourlyElectricity hourlyElectricity, String panelSerial);

  Page<HourlyElectricity> getAllHourlyElectricityByPanelId(String panelSerial, Pageable pageable);

  List<HourlyElectricity> getAllHourlyElectricityByReadingAtBetween(LocalDateTime initialReadingAt, LocalDateTime finalReadingAt, Panel panel);

}
