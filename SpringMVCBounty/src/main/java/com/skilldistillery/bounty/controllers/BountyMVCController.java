package com.skilldistillery.bounty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.bounty.data.BountyDAO;

@Controller
public class BountyMVCController {

	@Autowired
	BountyDAO bountyDAO;
	
	public void setBountyDAO(BountyDAO dao) {
		this.bountyDAO = dao;
	}
}
