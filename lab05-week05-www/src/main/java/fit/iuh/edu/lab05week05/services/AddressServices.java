package fit.iuh.edu.lab05week05.services;

import fit.iuh.edu.lab05week05.entities.Address;
import fit.iuh.edu.lab05week05.responsitory.AddressResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AddressServices {

    @Autowired
    private AddressResponsitory addressResponsitory;

    public Page<Address> findAllPageAddress(int pageNo, int pageSize, String sortBy,
                                            String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return addressResponsitory.findAll(pageable);

    }
}
