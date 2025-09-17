package se.lexicon.g56lecturespringbootjpa.repo;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.g56lecturespringbootjpa.entity.Address;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
