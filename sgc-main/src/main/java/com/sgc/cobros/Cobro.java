package com.sgc.cobros;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

import java.io.Serializable;
import com.sgc.client.Client;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Data
@Table(name = "tb_cobro")
public class Cobro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double cobroAmount;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    
    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }
    
    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

}
