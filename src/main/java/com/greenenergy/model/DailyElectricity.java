package com.greenenergy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DailyElectricity is responsible for electricity generated by a Panel in a day.
 */
@Data
@Entity
@Table(name = "daily_electricity")
public class DailyElectricity implements Serializable {
    private static final long serialVersionUID = -2291797968183794145L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "panel_id", referencedColumnName = "id")
    private Panel panel;

    @Column(name = "generated_electricity_sum")
    private Long generatedElectricitySum;

    @Column(name = "generated_electricity_min")
    private Long generatedElectricityMin;

    @Column(name = "generated_electricity_max")
    private Long generatedElectricityMax;

    @Column(name = "generated_electricity_average")
    private Double generatedElectricityAverage;

    @Column(name = "reading_at")
    private LocalDateTime readingAt;

  public DailyElectricity() {
  }

    public DailyElectricity(Panel panel, Long generatedElectricitySum, Long generatedElectricityMin,
                            Long generatedElectricityMax, Double generatedElectricityAverage, LocalDateTime readingAt) {
        this.panel = panel;
        this.generatedElectricitySum = generatedElectricitySum;
        this.generatedElectricityMin = generatedElectricityMin;
        this.generatedElectricityMax = generatedElectricityMax;
        this.generatedElectricityAverage = generatedElectricityAverage;
        this.readingAt = readingAt;
    }

}
