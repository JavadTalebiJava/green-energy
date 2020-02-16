package com.greenenergy.repository;

import com.greenenergy.model.HourlyElectricity;
import com.greenenergy.model.Panel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * HourlyElectricity Repository is for all operations for HourlyElectricity.
 */
public interface HourlyElectricityRepository extends PagingAndSortingRepository<HourlyElectricity, Long> {
    Page<HourlyElectricity> findAllByPanelId(Long panelId, Pageable pageable);

    List<HourlyElectricity> findByReadingAtBetweenAndPanel(LocalDateTime initialReadingAt, LocalDateTime finalReadingAt, Panel panel);

}
