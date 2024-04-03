/**
 * 
 */
package com.org.bhfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhfl.entity.Address;

/**
 * 
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
