package co.rivatech.nutrition.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.rivatech.nutrition.model.Family;

/**
 * @author vranjan
 * created 09/08/2021
 */
public interface FamilyRepository extends PagingAndSortingRepository<Family, Integer> {
}
