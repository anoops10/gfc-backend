package com.kfc.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.kfc.dto.UserMembershipDTO;
import com.kfc.pojo.UserMembership;

public interface UserMembershipServiceDao {
	UserMembership addUserMembership(int uId, int mId, LocalDate startDate, LocalDate endDate, String status);
	List<UserMembership> GetListByUID(int uId);
	UserMembership GetListByUMID(int umId);
	List<UserMembership> GetAllList();
//	UserMembership updateUserMembership(int umId,int tId, UserMembership mem);
	String deleteMembershipByUMID(int umId);
	
	long countActiveMembers();
	List<UserMembership> activeMembersList(); 
}
