package ma.enaa.enaafillrouge.Dto;


import ma.enaa.enaafillrouge.Entity.Client;

import java.util.List;

public class PanierDto{
    private Long id;
    private double total;
    private Long clientId;
    Long produitId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }




    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}