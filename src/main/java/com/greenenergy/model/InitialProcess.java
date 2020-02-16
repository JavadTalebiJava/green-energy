package com.greenenergy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Initial process storage representation.
 */
@Data
@Entity
@Table(name = "initial_process")
@NoArgsConstructor
@AllArgsConstructor
public class InitialProcess implements Serializable {

    private static final long serialVersionUID = -1629623023107819784L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InitialProcessStatus status;

}
