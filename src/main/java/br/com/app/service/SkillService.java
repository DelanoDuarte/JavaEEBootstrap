package br.com.app.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.app.domain.Skill;

@Stateless
public class SkillService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public Skill saveSkillOnDatabase(Skill skill) {
		return em.merge(skill);
	}

	public List<Skill> retrieveAllSkills() {
		return em.createQuery("SELECT s FROM Skill s", Skill.class).getResultList();
	}
}
