package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.rivatech.nutrition.model.Village;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface VillageRepository extends CrudRepository<Village, Integer> {

}
