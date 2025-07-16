package ma.enaa.enaafillrouge.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client extends User {
    public Client() {
        this.setRole(Role.CLIENT);
    }
    @OneToMany(mappedBy = "client")
    private List<Commentair> commentair;
    @OneToMany
    private List<Panier> panier;
    @OneToMany(mappedBy = "client")
    private List<Commande> commande;

    public List<Commentair> getCommentair() {
        return commentair;
    }

    public void setCommentair(List<Commentair> commentair) {
        this.commentair = commentair;
    }

    public List<Panier> getPanier() {
        return panier;
    }

    public void setPanier(List<Panier> panier) {
        this.panier = panier;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }
}
