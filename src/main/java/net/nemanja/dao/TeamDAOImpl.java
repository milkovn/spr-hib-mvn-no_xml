package net.nemanja.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.nemanja.model.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTeam(Team team) {
		getCurrentSession().save(team);
	}

	public void updateTeam(Team team) {
		Team teamToUpdate = (Team) getCurrentSession().get(Team.class,
				team.getId());
		teamToUpdate.setName(team.getName());
		teamToUpdate.setRating(team.getRating());
		getCurrentSession().update(teamToUpdate);
	}

	public Team getTeam(int id) {
		return (Team) getCurrentSession().get(Team.class, id);
	}

	public void deleteTeam(int id) {
		Team teamToDelete = (Team) getCurrentSession().get(Team.class, id);
		if (teamToDelete != null) {
			getCurrentSession().delete(teamToDelete);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Team> getTeams() {
		return getCurrentSession().createQuery("from Team").list();
	}

}
