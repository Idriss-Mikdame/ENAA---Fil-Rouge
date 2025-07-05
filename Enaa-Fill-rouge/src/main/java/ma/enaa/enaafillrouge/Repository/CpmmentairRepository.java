package ma.enaa.enaafillrouge.Repository;

import ma.enaa.enaafillrouge.Entity.Commentair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface CpmmentairRepository extends JpaRepository<Commentair,Long> {
    List<Commentair> findByProduitId(Long produitId);

}
