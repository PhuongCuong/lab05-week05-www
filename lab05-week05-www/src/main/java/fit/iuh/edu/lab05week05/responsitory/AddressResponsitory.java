package fit.iuh.edu.lab05week05.responsitory;

import fit.iuh.edu.lab05week05.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressResponsitory extends JpaRepository<Address,Long> {
    Address findAllById(long id);

    Address deleteById(long id);

}
