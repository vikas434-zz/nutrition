package co.rivatech.nutrition.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.rivatech.nutrition.model.LMS;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface LMSRepository extends PagingAndSortingRepository<LMS, Integer> {

}
