package ma.enaa.enaafillrouge.Dto;

public class CommentairDto  {
    Long id;
    String commentair;
    int note;

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
}