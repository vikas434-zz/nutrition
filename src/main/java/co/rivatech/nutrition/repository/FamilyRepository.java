package co.rivatech.nutrition.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import co.rivatech.nutrition.model.Family;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Repository
public interface FamilyRepository extends PagingAndSortingRepository<Family, Integer> {
    Optional<Family> findTopByOrderByIdDesc();
}