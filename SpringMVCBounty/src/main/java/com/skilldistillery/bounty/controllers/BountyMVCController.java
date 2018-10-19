package com.skilldistillery.bounty.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(path="getBounty.do", params="bountyId", method = RequestMethod.GET)
	public String getBounty(@RequestParam("bountyId") int bountyId, Model model) {
		Bounty bounty= bountyDAO.findById(bountyId);
		model.addAttribute("bounty", bounty);
		return "/WEB-INF/views/result.jsp";
	}
	@RequestMapping(path="bountiesByName.do", method = RequestMethod.GET)
	public String bountiesByName(Model model) {
		model.addAttribute("bountiesByName", new Boolean(true));
		return "/WEB-INF/views/search.jsp";
	}
	
	@RequestMapping(path="bountiesByCrime.do", method = RequestMethod.GET)
	public String bountiesByCrime(Model model) {
		model.addAttribute("bountiesByCrime", new Boolean(true));
		return "/WEB-INF/views/search.jsp";
	}
	
	
	
	
}
