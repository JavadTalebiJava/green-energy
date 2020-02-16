package com.greenenergy.repository;

import com.greenenergy.model.Panel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PanelRepository allows all operations to Panel Entity.
 */
public interface PanelRepository extends JpaRepository<Panel, Long> {

  /**
   * Finds a {@link Panel} by the given serial.
   *
   * @param serial The serial
   * @return {@link Panel}
   */
  Panel findBySerial(String serial);
}
