package com.example.task1.Address.repo;

import com.example.task1.Address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {

}
