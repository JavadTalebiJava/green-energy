package com.greenenergy.controller;

import com.greenenergy.dto.DailyElectricityDTO;
import com.greenenergy.model.HourlyElectricity;
import com.greenenergy.model.Panel;
import com.greenenergy.services.DailyElectricityService;
import com.greenenergy.services.HourlyElectricityService;
import com.greenenergy.services.PanelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Panel Controller for all Rest APIs related to Panel.
 *
 * @author javad talebi
 */
@RestController
@RequestMapping("/panels")
public class PanelController {

    private final PanelService panelService;

    private final HourlyElectricityService hourlyElectricityService;

    private final DailyElectricityService dailyElectricityService;

    public PanelController(final PanelService panelService,
                           final HourlyElectricityService hourlyElectricityService,
                           final DailyElectricityService dailyElectricityService) {
        this.panelService = panelService;
        this.hourlyElectricityService = hourlyElectricityService;
        this.dailyElectricityService = dailyElectricityService;
    }

    /**
     * Register a Panel to System and start receiving the electricity statistics.
     *
     * @param panel to register.
     * @return
     */
    @PostMapping
    public ResponseEntity<Panel> registerPanel(@RequestBody Panel panel) {
        Panel saved = panelService.register(panel);
        return ResponseEntity.ok(saved);
    }

    /**
     * Controller Method to save hourly Electricity to Database.
     *
     * @param panelSerial       Serial number of Panel.
     * @param hourlyElectricity generated electricity for this panel.
     * @return
     */

    @PostMapping(path = "/{panel-serial}/hourly")
    public ResponseEntity<HourlyElectricity> saveHourlyElectricity(
            @PathVariable(value = "panel-serial") String panelSerial,
            @RequestBody HourlyElectricity hourlyElectricity) {
        return ResponseEntity.ok(hourlyElectricityService.save(hourlyElectricity, panelSerial));
    }

    /**
     * Get Hourly Electricity from Previous dates.
     */

    @GetMapping(path = "/{panel-serial}/hourly")
    public ResponseEntity<Page<HourlyElectricity>> hourlyElectricity(
            @PathVariable(value = "panel-serial") String panelSerial,
            @PageableDefault(size = 5, value = 0) Pageable pageable) {
        Page<HourlyElectricity> page = hourlyElectricityService.getAllHourlyElectricityByPanelId(panelSerial, pageable);
        return ResponseEntity.ok(page);
    }

    /**
     * This end point is used by Front end charts component to plot the daily statistics of
     * electricity generated by this Panel from the day it registered to end of previous day.
     *
     * @param panelSerial is unique serial for this Panel.
     * @return
     */

    @GetMapping(path = "/{panel-serial}/daily")
    public ResponseEntity<List<DailyElectricityDTO>> allDailyElectricityFromYesterday(
            @PathVariable(value = "panel-serial") String panelSerial) {
        List<DailyElectricityDTO> dailyElectricityForPanel = this.dailyElectricityService.getAllDailyElectricityByPanelId(panelSerial);
        return ResponseEntity.ok(dailyElectricityForPanel);
    }

}