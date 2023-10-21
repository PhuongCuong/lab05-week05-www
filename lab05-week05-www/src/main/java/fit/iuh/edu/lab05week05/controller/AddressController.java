package fit.iuh.edu.lab05week05.controller;

import fit.iuh.edu.lab05week05.customerRespon.PageResponse;
import fit.iuh.edu.lab05week05.entities.Address;
import fit.iuh.edu.lab05week05.responsitory.AddressResponsitory;
import fit.iuh.edu.lab05week05.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressResponsitory addressResponsitory;
    @Autowired
    private AddressServices addressServices;

    @GetMapping("/get-all")
    public List<Address> getAlladdress(){
        return addressResponsitory.findAll();
    }

    @GetMapping("/get-by-id")
    public Address getaddressbyId(@RequestParam long id){
        return addressResponsitory.findAllById(id);
    }

    @PostMapping(value = "/create-address",consumes = "application/json")
    public ResponseEntity<String> createaddress(@RequestBody Address address){
        if(addressResponsitory.save(address) != null){
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"create\": \"not found\"}");

    }


    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteaddress(@RequestParam long id) {
        if (addressResponsitory.existsById(id)) {
            addressResponsitory.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"delete\": \"ok\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"delete\": \"not found\"}");
        }
    }

    @GetMapping("/get-all-address-page")
    public Page<Address> getAllAddressPage(@RequestParam("pageNo") int pageNo , @RequestParam("pageSize") int pageSize,
                                                          @RequestParam("sortdes") String sortdes, @RequestParam("sortby") String sortby){
        return addressServices.findAllPageAddress(pageNo, pageSize, sortby, sortdes);
    }


    @PutMapping("/update-by-id")
    public ResponseEntity<String> updateaddress(@RequestBody Address address){
        if(addressResponsitory.existsById(address.getId())){
            addressResponsitory.save(address);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"update\": \"ok\"}");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"update\": \"not found\"}");
    }


}
