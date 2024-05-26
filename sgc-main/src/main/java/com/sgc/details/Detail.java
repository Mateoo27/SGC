package com.sgc.details;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.sgc.cobros.Cobro;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Data
@Table(name = "tb_detail")
public class Detail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cobro_id")
    private Cobro cobro;

    private int quantity;

    private BigDecimal subtotal;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @PreUpdate
    public void preUpdate(){
        updatedAt = Instant.now();
    }

    public Object getDetailType() {
        throw new UnsupportedOperationException("Unimplemented method 'getDetailType'");
    }

    public Object getDetailDescription() {
        throw new UnsupportedOperationException("Unimplemented method 'getDetailDescription'");
    }

    public void setDetailAmount(Object detailType) {
        throw new UnsupportedOperationException("Unimplemented method 'setDetailAmount'");
    }

    public void setDetailDescription(Object detailDescription) {
        throw new UnsupportedOperationException("Unimplemented method 'setDetailDescription'");
    }
}
