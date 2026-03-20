package com.kfc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kfc.dto.UserMembershipDTO;
import com.kfc.pojo.UserMembership;
@EnableJpaRepositories
public interface UserMembershipRepository extends JpaRepository<UserMembership, Integer> {
		
		List<UserMembership> findByUserUId(int uId);

	    @Query("SELECT COUNT(um) FROM UserMembership um WHERE um.startDate <= CURRENT_DATE AND um.endDate >= CURRENT_DATE")
	    long countActiveMemberships();
	    
	    @Query("SELECT um FROM UserMembership um WHERE um.startDate <= CURRENT_DATE AND um.endDate >= CURRENT_DATE")
	    List<UserMembership> findAllActiveMemberships();
	
}
