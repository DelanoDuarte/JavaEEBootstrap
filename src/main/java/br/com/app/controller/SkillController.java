package br.com.app.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.app.domain.Skill;
import br.com.app.service.SkillService;

@Named
@RequestScoped
public class SkillController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private SkillService service;

	private Skill skill = new Skill();

	public String saveNewSkill() {
		try {
			service.saveSkillOnDatabase(skill);
			return "/pages/skill/skillList.xhtml";
		} catch (Exception e) {
			return "";
		}

	}

	public List<Skill> retrieveAllSkills() {
		try {
			return service.retrieveAllSkills();
		} catch (Exception e) {
			return null;
		}

	}

	/* getters and setters */
	public SkillService getService() {
		return service;
	}

	public void setService(SkillService service) {
		this.service = service;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
