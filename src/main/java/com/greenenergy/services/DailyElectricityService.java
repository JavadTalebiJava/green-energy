package com.greenenergy.services;

import com.greenenergy.dto.DailyElectricityDTO;
import com.greenenergy.model.DailyElectricity;

import java.util.List;

/**
 * Services for {@link DailyElectricity}.
 */
public interface DailyElectricityService {

    DailyElectricity save(DailyElectricity dailyElectricity);

    List<DailyElectricityDTO> getAllDailyElectricityByPanelId(String panelSerial);
}
