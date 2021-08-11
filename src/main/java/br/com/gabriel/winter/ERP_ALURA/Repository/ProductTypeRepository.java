package br.com.gabriel.winter.ERP_ALURA.Repository;

import br.com.gabriel.winter.ERP_ALURA.ORM.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {


}
