package com.skilldistillery.bounty.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.bounty.data.BountyDAO;
import com.skilldistillery.bounty.entities.Bounty;

@Controller
public class BountyMVCController {

	@Autowired
	BountyDAO bountyDAO;
	
	@RequestMapping(path="home.do", method = RequestMethod.GET)
	public String homePage(Model model) {
		return "/WEB-INF/views/home.jsp";
	}
	
	@RequestMapping(path="allBounties.do", method = RequestMethod.GET)
	public String allBounties(Model model) {
		List<Bounty> allBounties = bountyDAO.findAll();
		model.addAttribute("bounties", allBounties);
		return "/WEB-INF/views/result.jsp";
	}
	
	
}
