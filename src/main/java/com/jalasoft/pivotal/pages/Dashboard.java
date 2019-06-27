package com.jalasoft.pivotal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPage {

	@FindBy(css = "#create-project-button")
	private WebElement createProjectButton;

	@FindBy(xpath = "//a[contains(text(),'MyProject')]")
	private WebElement selectProject;

	@FindBy(css = "a[title='Add Story']")
	private WebElement clickAddStory;

	public ProjectForm clickCreateProjectButton() {
		action.click(createProjectButton);
		return new ProjectForm();
	}

	public ProjectForm selectProject() {
		action.click(selectProject);
		return new ProjectForm();
	}

	public ProjectForm clickAddStory() {
		action.click(clickAddStory);
		return new ProjectForm();
	}



}
