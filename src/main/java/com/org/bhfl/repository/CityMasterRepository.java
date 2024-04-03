/**
 * 
 */
package com.org.bhfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhfl.entity.CityMaster;

/**
 * 
 */
@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster, Long> {

}
