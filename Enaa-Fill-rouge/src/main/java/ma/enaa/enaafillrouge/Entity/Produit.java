package ma.enaa.enaafillrouge.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private double prix;
    private String image;
    private int stock;
    private String couleur;
    private String taille;
    private String optionsSpeciales;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commentair > commentaires;
    @OneToMany(mappedBy = "produit")
    private List<ArticleDeCommande> articleDeCommandes;
    @OneToMany(mappedBy = "produit")
    private List<ArticleDePanier> articleDePaniers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getOptionsSpeciales() {
        return optionsSpeciales;
    }

    public void setOptionsSpeciales(String optionsSpeciales) {
        this.optionsSpeciales = optionsSpeciales;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Commentair> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentair> commentaires) {
        this.commentaires = commentaires;
    }

    public List<ArticleDeCommande> getArticleDeCommandes() {
        return articleDeCommandes;
    }

    public void setArticleDeCommandes(List<ArticleDeCommande> articleDeCommandes) {
        this.articleDeCommandes = articleDeCommandes;
    }

    public List<ArticleDePanier> getArticleDePaniers() {
        return articleDePaniers;
    }

    public void setArticleDePaniers(List<ArticleDePanier> articleDePaniers) {
        this.articleDePaniers = articleDePaniers;
    }
}
