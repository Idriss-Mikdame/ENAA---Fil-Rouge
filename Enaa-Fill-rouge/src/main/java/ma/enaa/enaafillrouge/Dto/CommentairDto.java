package ma.enaa.enaafillrouge.Dto;

import ma.enaa.enaafillrouge.Entity.Client;

public class CommentairDto  {
    Long id;
    String commentair;
    int note;
    Long client_id;
    Long produitId;
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

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}