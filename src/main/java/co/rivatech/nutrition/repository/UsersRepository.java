package co.rivatech.nutrition.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.rivatech.nutrition.model.User;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

    Optional<User> findByMobile(BigInteger mobile);

    //TODO change string to enum
    List<User> findByRoleEqualsAndAndBlockId(final String role, final int blockId);
}
