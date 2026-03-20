package com.kfc.services;

import java.util.List;

import com.kfc.pojo.Membership;

public interface MembershipServicesDao {

	Membership addMembership(Membership mem);
	List<Membership> showAllMembership();
	Membership findMembershipById(int mId);
	Membership updateMembership(int mId, Membership mem);
	String deleteMembership(int mId);
}
