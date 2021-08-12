package com.ss.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.user_service.dao.BookingAgentDao;
import com.ss.user_service.entity.BookingAgent;

@Service
public class BookingAgentService {

	@Autowired
	private BookingAgentDao bookingAgentDao;
	
	public List<BookingAgent> getAllBookingUsers(){
		return bookingAgentDao.findAll();
	}
}
