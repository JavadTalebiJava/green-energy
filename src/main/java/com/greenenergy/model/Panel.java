package com.greenenergy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Panel class hold information related to a Solar panel.
 *
 * @author javad talebi
 */
@Data
@Entity
@Table(name = "panel")
@AllArgsConstructor
@NoArgsConstructor
public class Panel implements Serializable {

  private static final long serialVersionUID = -8527695980909864257L;

  @JsonIgnore
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "serial", unique = true)
  private String serial;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "latitude")
  private Double latitude;

  @Nullable
  @Column(name = "brand")
  private String brand;


  public Panel(Long panelId) {
    this.id = panelId;
  }
}
