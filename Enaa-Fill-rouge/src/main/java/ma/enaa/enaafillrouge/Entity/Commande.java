package ma.enaa.enaafillrouge.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double total;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "commande")
    private List<Client> client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleDeCommande> articlesDeCommande;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public List<ArticleDeCommande> getArticlesDeCommande() {
        return articlesDeCommande;
    }

    public void setArticlesDeCommande(List<ArticleDeCommande> articlesDeCommande) {
        this.articlesDeCommande = articlesDeCommande;
    }
}
