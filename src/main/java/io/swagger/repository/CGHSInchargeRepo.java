
package io.swagger.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.CGHSCity;
import io.swagger.model.CGHSIncharge;

@Repository
public interface CGHSInchargeRepo extends JpaRepository<CGHSIncharge, Integer>{

    CGHSIncharge findByCghsCity(CGHSCity city);
   
    @Query(value="select *from cghs_incharge where cghs_user_id=?1",nativeQuery = true)
    List<CGHSIncharge> findAllBycghsUser(Long id);

    @Modifying
    @Query(value="DELETE FROM cghs_incharge e WHERE e.cghs_user_id = :id",nativeQuery = true)
    void deleteBycghsUser(Integer id);

  
}

