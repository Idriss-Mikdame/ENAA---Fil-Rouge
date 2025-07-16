package ma.enaa.enaafillrouge.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commentair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentair;
    private int note;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentair() {
        return commentair;
    }

    public void setCommentair(String commentair) {
        this.commentair = commentair;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
