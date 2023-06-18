package io.swagger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.Application;
import io.swagger.model.Movement;

public interface MovementRepo extends JpaRepository<Movement,Long> {

    @Query(value = "select * from movement where from_office=?1", nativeQuery = true)
    List<Movement> findAllByFromUserId(Long fromUserId);

    @Query(value = "select * from movement as m left join application_type_level_role as atlr "+
    " on m.application_type = atlr.app_type where m.from_user_id = ?1 and atlr.role_id = ?2 and atlr.level_no = m.level_no", nativeQuery = true)
    List<Movement> activitylist(Long fromUserId, Long roleId);



    // @Query(value = "select * from movement where action_type = 1", nativeQuery = true)
    // List<Movement> findAllByToOffice(Long toUserId);

    @Query(value = "select * from movement as m left join application_type_level_role as atl on atl.app_type = m.application_type and atl.level_no = m.level_no inner join parichay_user as pu on pu.organization_office_id = m.to_office where  atl.role_id = ?2 and pu.id =?1 and m.action_type = 1", nativeQuery = true)
    List<Movement> findAllByToOffice(Long toUserId,long roleId);
    // @Query(value = "select * from movement where to_office=?1", nativeQuery = true)
    // List<Movement> findAllByToOffice(Long toUserId);

    Optional<Movement> findByApplication(Application application);
    
}
