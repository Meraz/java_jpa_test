package com.meraz.jpatest.controller;

import com.meraz.jpatest.DAO.UserDAO;
import com.meraz.jpatest.model.DBUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController{

	UserController() {
	}

	@Autowired
	protected UserDAO userDAO;
	
	@RequestMapping(value = "user/find/by/id/{userId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity findUserById(@PathVariable("userId") Long userId) {
		ResponseEntity responseMessage = null;
		try {
			DBUser user = userDAO.findByUserId(userId);
			responseMessage = new ResponseEntity<>(user, HttpStatus.OK);

		} catch(Exception e) {
			responseMessage = new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseMessage;
	}

	@RequestMapping(value = "user/create/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity createUser() {
		ResponseEntity responseMessage = null;
		try {
			DBUser user = new DBUser();
			user = userDAO.save(user);
			responseMessage = new ResponseEntity<>(user, HttpStatus.OK);

		} catch(Exception e) {
			responseMessage = new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseMessage;
	}
}