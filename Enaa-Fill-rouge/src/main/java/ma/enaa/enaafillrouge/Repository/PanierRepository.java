package ma.enaa.enaafillrouge.Repository;

import ma.enaa.enaafillrouge.Entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface PanierRepository extends JpaRepository<Panier,Long> {

}
