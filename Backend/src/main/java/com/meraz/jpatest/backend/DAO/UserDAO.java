package com.meraz.jpatest.backend.DAO;

import com.meraz.jpatest.backend.model.DBUser;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDAO extends CrudRepository<DBUser, Long> {
	DBUser findByUserId(Long userId);
}