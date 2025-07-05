package ma.enaa.enaafillrouge.Entity;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User {
    public Admin() {
        this.setRole(Role.ADMIN);
    }
}
