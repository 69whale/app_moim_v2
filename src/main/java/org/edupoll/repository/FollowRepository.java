package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.entity.Attendance;
import org.edupoll.model.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
	
	boolean existsByOwnerIdAndTargetId(String ownerId, String targetId); 
	
	// List<Follow> findByTargetId(String targetId); 
	
	Follow deleteByOwnerIdAndTargetId(String ownerId, String targetId);
	
	
    boolean findByOwnerIdAndTargetId(String ownerId, String targetId); 
	
	

}
