package se.lexicon.g56lecturespringbootjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g56lecturespringbootjpa.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
