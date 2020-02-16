package com.greenenergy.services;

import com.greenenergy.exceptions.ResourceNotFoundException;
import com.greenenergy.model.Panel;
import com.greenenergy.repository.PanelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;


/**
 * PanelServiceImpl for panel related handling.
 */
@Service
public class PanelServiceImpl implements PanelService {

  private final PanelRepository panelRepository;

  public PanelServiceImpl(final PanelRepository panelRepository) {
    this.panelRepository = panelRepository;
  }

  /* (non-Javadoc)
   * @see com.greenenergy.service.PanelService#register(com.greenenergy.model.Panel)
   */

  @Override
  public Panel register(Panel panel) {
    return panelRepository.save(panel);
  }

  @Override
  public Panel getBySerial(String serial) {
    Panel panel = panelRepository.findBySerial(serial);
    if (panel == null) {
      throw new ResourceNotFoundException(format("Panel '%s' was not found", serial));
    }

    return panel;
  }

  @Override
  public List<Panel> getAll() {
    return this.panelRepository.findAll();
  }
}
