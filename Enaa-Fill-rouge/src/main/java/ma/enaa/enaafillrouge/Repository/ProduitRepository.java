package ma.enaa.enaafillrouge.Repository;

import ma.enaa.enaafillrouge.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
