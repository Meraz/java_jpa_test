package com.meraz.jpatest.DAO;

import com.meraz.jpatest.model.DBUser;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDAO extends CrudRepository<DBUser, Long> {
	DBUser findByUserId(Long userId);
}