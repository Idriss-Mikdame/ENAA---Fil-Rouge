package ma.enaa.enaafillrouge.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "panier")

    private List<Client> clients;

    private double total;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<ArticleDePanier> articlesDePanier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ArticleDePanier> getArticlesDePanier() {
        return articlesDePanier;
    }

    public void setArticlesDePanier(List<ArticleDePanier> articlesDePanier) {
        this.articlesDePanier = articlesDePanier;
    }
}
