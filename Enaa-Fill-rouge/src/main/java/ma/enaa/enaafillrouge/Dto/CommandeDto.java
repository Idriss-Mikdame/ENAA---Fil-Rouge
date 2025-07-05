package ma.enaa.enaafillrouge.Dto;

import ma.enaa.enaafillrouge.Entity.Status;

import java.time.LocalDate;


public class CommandeDto{
    Long id;
    LocalDate date;
    double total;
    Status status;

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
}