package ma.enaa.enaafillrouge.Repository;

import ma.enaa.enaafillrouge.Entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface CommandeRepository extends JpaRepository<Commande,Long> {
//    List<Commande> findByUserId(Long userId);

}
