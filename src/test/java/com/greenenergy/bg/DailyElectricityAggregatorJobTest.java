package com.greenenergy.bg;

import com.greenenergy.model.DailyElectricity;
import com.greenenergy.model.HourlyElectricity;
import com.greenenergy.model.Panel;
import com.greenenergy.services.DailyElectricityService;
import com.greenenergy.services.HourlyElectricityService;
import com.greenenergy.services.PanelService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.greenenergy.utils.TestUtils.*;
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author javad talebi
 */
public class DailyElectricityAggregatorJobTest {

    private DailyElectricityAggregatorJob dailyElectricityAggregatorJob;
    private HourlyElectricityService hourlyElectricityService;
    private DailyElectricityService dailyElectricityService;
    private PanelService panelService;

    @Before
    public void setUp() {
        this.hourlyElectricityService = mock(HourlyElectricityService.class);
        this.dailyElectricityService = mock(DailyElectricityService.class);
        this.panelService = mock(PanelService.class);
        this.dailyElectricityAggregatorJob = new DailyElectricityAggregatorJob(hourlyElectricityService, dailyElectricityService, panelService);
    }

    @Test
    public void testConsolidateDailyElectricityGeneration() {
        List<Panel> expectedPanels = singletonList(panel());
        when(this.panelService.getAll()).thenReturn(expectedPanels);

        List<HourlyElectricity> expectedHourly = singletonList(hourlyElectricity());
        when(this.hourlyElectricityService.getAllHourlyElectricityByReadingAtBetween(any(), any(), any())).thenReturn(expectedHourly);

        DailyElectricity expectedDaily = dailyElectricity();
        when(this.dailyElectricityService.save(any())).thenReturn(expectedDaily);

        this.dailyElectricityAggregatorJob.consolidateDailyElectricityGeneration();
    }

}