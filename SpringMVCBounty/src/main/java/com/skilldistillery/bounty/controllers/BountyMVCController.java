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

	@RequestMapping(path = {"home.do"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		return "/WEB-INF/views/home.jsp";
	}

	
	@RequestMapping(path = {"navigationOptions.do"}, params = "home", method = RequestMethod.POST)
	public String backToHomePage(Model model) {
		return "/WEB-INF/views/home.jsp";
	}
	@RequestMapping(path = "navigationOptions.do", params = "detail", method = RequestMethod.POST)
	public String detailSearchPage(Model model) {
		model.addAttribute("notHome", new Boolean(true));
		model.addAttribute("detailSearch", new Boolean(true));
		return "/WEB-INF/views/form.jsp";
	}
	@RequestMapping(path = "navigationOptions.do", params = "add", method = RequestMethod.POST)
	public String addBountyPage(Model model) {
		model.addAttribute("notHome", new Boolean(true));
		model.addAttribute("addBounty", new Boolean(true));
		return "/WEB-INF/views/form.jsp";
	}
	@RequestMapping(path = "alterBounty.do", params = "update", method = RequestMethod.POST)
	public String editBountyPage(int id, Model model) {
		model.addAttribute("notHome", new Boolean(true));
		model.addAttribute("edit", new Boolean(true));
		model.addAttribute("editBounty", bountyDAO.findById(id));
		
		return "/WEB-INF/views/form.jsp";
	}
	@RequestMapping(path = "navigationOptions.do", params = "all", method = RequestMethod.POST)
	public String allResults(Model model) {
		List<Bounty> allBounties = bountyDAO.findAll();
		model.addAttribute("bounties", allBounties);
		return "/WEB-INF/views/results.jsp";
	}
	
	
	@RequestMapping(path = "nameSearch.do", params= {"name"}, method = RequestMethod.POST)
	public String searchByNameResults(String firstName, String lastName, String nickname, Model model) {
		List<Bounty> bountiesFound = bountyDAO.findAllByNames(firstName, lastName, nickname);
		model.addAttribute("bounties", bountiesFound);
		return "/WEB-INF/views/results.jsp";
	}
	
	@RequestMapping(path = "descriptionSearch.do", params= {"description"}, method = RequestMethod.POST)
	public String searchByDescriptionResults(String description,  Model model) {
		List<Bounty> bountiesFound = bountyDAO.findAllByDescription(description);
		model.addAttribute("bounties", bountiesFound);
		return "/WEB-INF/views/results.jsp";
	}
	@RequestMapping(path = "wantedSearch.do", params= {"wantedAlive"}, method = RequestMethod.POST)
	public String searchByWantedResults(String wantedAlive, Model model) {
		List<Bounty> bountiesFound = !wantedAlive.isEmpty() ? bountyDAO.findAllByWanted(wantedAlive.charAt(0)) : null;
		model.addAttribute("bounties", bountiesFound);
		return "/WEB-INF/views/results.jsp";
	}
	@RequestMapping(path = "crimeSearch.do", params= {"crime"}, method = RequestMethod.POST)
	public String searchByCrimeResults(String crimeCategory, Model model) {
		List<Bounty> bountiesFound = bountyDAO.findAllByCrime(crimeCategory);
		model.addAttribute("bounties", bountiesFound);
		return "/WEB-INF/views/results.jsp";
	}
	@RequestMapping(path = "priceSearch.do", params= {"price"}, method = RequestMethod.POST)
	public String searchByPriceRangeResults(int minPrice, int maxPrice, Model model) {
		int min = Math.min(maxPrice, minPrice);
		int max = Math.max(maxPrice, minPrice);
		List<Bounty> bountiesFound = bountyDAO.findAllByPriceRange(min, max);
		model.addAttribute("bounties", bountiesFound);
		return "/WEB-INF/views/results.jsp";
	}
	
	
	

	@RequestMapping(path = "search.do", params = "search", method = RequestMethod.POST)
	public String generalSearch(String searchText, Model model) {
		Set<Bounty> bountiesFound = bountyDAO.findAllByKeywords(searchText);
		model.addAttribute("bounties", bountiesFound);
		return "/WEB-INF/views/results.jsp";
	}

	@RequestMapping(path = "search.do", params = "lucky", method = RequestMethod.POST)
	public String luckySearch(String searchText, Model model) {
		Set<Bounty> bountiesFound = bountyDAO.findAllByKeywords(searchText);
		Bounty firstFound = emptyOrNull(bountiesFound) ? null : (Bounty) bountiesFound.toArray()[0];
		model.addAttribute("bounty", firstFound);
		return "/WEB-INF/views/results.jsp";
	}

	

	@RequestMapping(path = "getBounty.do", params = "bountyId", method = RequestMethod.GET)
	public String getBountyById(@RequestParam("bountyId") int bountyId, Model model) {
		Bounty bounty = bountyDAO.findById(bountyId);
		model.addAttribute("bounty", bounty);
		return "/WEB-INF/views/results.jsp";
	}
	@RequestMapping(path = "addBounty.do", params = "add", method = RequestMethod.POST)
	public String addNewBounty(Bounty bounty, Model model) {
		Bounty newBounty = bountyDAO.add(bounty);
		model.addAttribute("bounty", newBounty);
		return "/WEB-INF/views/results.jsp";
	}
	@RequestMapping(path = "alterBounty.do", params = "delete", method = RequestMethod.POST)
	public String deleteBounty(int id, Model model) {
		Boolean deletedBounty = bountyDAO.delete(id);
		model.addAttribute("deleteSuccess", deletedBounty);
		return "/WEB-INF/views/results.jsp";
	}

	@RequestMapping(path = "alterBounty.do", params = "updateBounty", method = RequestMethod.POST)
	public String updateBounty(int id, Bounty bounty, Model model) {
		Bounty updatedBounty = bountyDAO.update(id, bounty);
		model.addAttribute("bounty", updatedBounty);
		return "/WEB-INF/views/results.jsp";
	}

	private boolean emptyOrNull(Set<Bounty> s) {
		return s == null || s.isEmpty();
	}
}
