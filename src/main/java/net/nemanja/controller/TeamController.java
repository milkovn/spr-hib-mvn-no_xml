package net.nemanja.controller;

import java.util.List;

import net.nemanja.model.Team;
import net.nemanja.service.TeamService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Team team) {
		ModelAndView modelAndView = new ModelAndView("home");

		teamService.addTeam(team);

		String message = "Team was successfuly added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/list")
	public ModelAndView listTeams() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");

		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);

		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView teamEditPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");

		Team team = teamService.getTeam(id);
		modelAndView.addObject("team", team);

		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editingTeam(@ModelAttribute Team team,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		teamService.updateTeam(team);

		String message = "Team was successfuly updated";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");

		teamService.deleteTeam(id);

		String message = "Team was successfuly deleted.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listJson", method = RequestMethod.GET)
	public @ResponseBody JSONObject getJSON() {
		List<Team> teams = teamService.getTeams();
		
		JSONObject jo = new JSONObject();
		
		jo.put("aaData", teams);

		return jo;
	}
}
