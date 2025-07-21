package org.dnyanyog.repo;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{ //Queries
	
	
	@Modifying
	@Transactional
	public int deleteByFirstName(String name);
	
	Users findByFirstName(String userName);
	
	Users findByLoginNameAndPasword(String loginName,String pasword);
	

}
