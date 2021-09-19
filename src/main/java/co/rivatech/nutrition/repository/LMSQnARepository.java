package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import co.rivatech.nutrition.model.LMSQnA;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface LMSQnARepository extends CrudRepository<LMSQnA, Integer> {

    List<LMSQnA> findByLmsId(int lmsId);
}
