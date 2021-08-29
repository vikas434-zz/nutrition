package co.rivatech.nutrition.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.rivatech.nutrition.model.Notice;

/**
 * @author vranjan
 * created 09/08/2021
 */
@Repository
public interface NoticeRepository extends PagingAndSortingRepository<Notice, Integer> {

}