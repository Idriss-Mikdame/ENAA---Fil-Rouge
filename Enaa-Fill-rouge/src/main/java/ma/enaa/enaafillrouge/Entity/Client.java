package ma.enaa.enaafillrouge.Entity;

import jakarta.persistence.*;

@Entity
public class Client extends User {
    public Client() {
        this.setRole(Role.CLIENT);
    }
    @ManyToOne
    private Commentair commentair;
    @ManyToOne
    private Panier panier;
    @ManyToOne
    private Commande commande;

    public Commentair getCommentair() {
        return commentair;
    }

    public void setCommentair(Commentair commentair) {
        this.commentair = commentair;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
