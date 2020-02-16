package com.greenenergy.services;

import com.greenenergy.model.Panel;

import java.util.List;

/**
 * PanelService interface for Panels.
 */
public interface PanelService {

  /**
   * Register a panel for electricity monitoring.
   *
   * @param panel to register with system.
   */
  Panel register(Panel panel);

  /**
   * Find a {@link Panel} by its serial.
   *
   * @param serial The serial
   * @return The {@link Panel}
   */
  Panel getBySerial(String serial);

  /**
   * Returns all panels.
   *
   * @return List of {@link Panel}
   */
  // TODO: make it pageable to avoid performance issues
  List<Panel> getAll();
}
