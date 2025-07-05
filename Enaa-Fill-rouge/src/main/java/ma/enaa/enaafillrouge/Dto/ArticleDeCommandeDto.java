package ma.enaa.enaafillrouge.Dto;

import lombok.Value;
import ma.enaa.enaafillrouge.Entity.ArticleDeCommande;

import java.io.Serializable;


public class ArticleDeCommandeDto {
    Long id;
    int quantite;
    double sousTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getSousTotal() {
        return sousTotal;
    }

    public void setSousTotal(double sousTotal) {
        this.sousTotal = sousTotal;
    }
}