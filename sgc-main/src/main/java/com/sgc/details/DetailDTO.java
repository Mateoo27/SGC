package com.sgc.details;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

public class DetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long cobroId; // ID del cobro asociado al detalle
    private int quantity;
    private BigDecimal subtotal;
    private Instant updatedAt;    

    // Additional detail specific fields can be added here

    public DetailDTO(Long id, Long cobroId, int quantity, BigDecimal subtotal, Instant updatedAt) {
        this.id = id;
        this.cobroId = cobroId;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.updatedAt = updatedAt;
    }
    public DetailDTO(Detail entity) {
        this.id = entity.getId();
        this.cobroId = entity.getCobro().getId();
        this.quantity = entity.getQuantity();
        this.subtotal = entity.getSubtotal();
        this.updatedAt = entity.getUpdatedAt();
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Long getCobroId(){
        return cobroId;
    }
    public void setCobroId(Long cobroId){
        this.cobroId = cobroId;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public BigDecimal getSubtotal(){
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal){
        this.subtotal = subtotal;
    }
    public Instant getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(Instant updatedAt){
        this.updatedAt = updatedAt;
    }

}

