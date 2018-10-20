package com.skilldistillery.bounty.controllers;

import java.util.List;
import java.util.Set;

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
	
	@RequestMapping(path="search.do", params="search", method = RequestMethod.GET)
	public String searchResults(String searchText, Model model) {
		Set<Bounty> bountiesFound = bountyDAO.findAllByKeywords(searchText);
		model.addAttribute("bounties", bountiesFound);
		return "/WEB-INF/views/searchResults.jsp";
	}
	@RequestMapping(path="search.do", params="lucky", method = RequestMethod.GET)
	public String luckyResults(String searchText, Model model) {
		Set<Bounty> bountiesFound = bountyDAO.findAllByKeywords(searchText);
		Bounty firstFound = emptyOrNull(bountiesFound) ? 
												  null : (Bounty) bountiesFound.toArray()[0];
		model.addAttribute("bounty", firstFound);
		return "/WEB-INF/views/searchResults.jsp";
	}
	
	@RequestMapping(path="allBounties.do", method = RequestMethod.GET)
	public String allBounties(Model model) {
		List<Bounty> allBounties = bountyDAO.findAll();
		model.addAttribute("bounties", allBounties);
		return "/WEB-INF/views/searchResults.jsp";
	}
	@RequestMapping(path="getBounty.do", params="bountyId", method = RequestMethod.GET)
	public String getBounty(@RequestParam("bountyId") int bountyId, Model model) {
		Bounty bounty= bountyDAO.findById(bountyId);
		model.addAttribute("bounty", bounty);
		return "/WEB-INF/views/searchResults.jsp";
	}
	
	private boolean emptyOrNull(Set<Bounty> s) {
		return s == null || s.isEmpty();
	}
}
