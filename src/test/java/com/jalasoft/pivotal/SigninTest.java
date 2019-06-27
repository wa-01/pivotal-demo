package com.jalasoft.pivotal;

import java.util.HashMap;
import java.util.Map;

import com.jalasoft.pivotal.pages.Dashboard;
import com.jalasoft.pivotal.pages.Header;
import com.jalasoft.pivotal.pages.ProfileDropdown;
import com.jalasoft.pivotal.pages.ProjectForm;
import com.jalasoft.pivotal.pages.Signin;
import org.junit.Assert;
import org.junit.Test;

public class SigninTest {

//    @Test
//    public void testSignin() {
//        // When
//        String expectedUserName = "Carledriss";
//        Signin signin = new Signin();
//        Header header = signin.loginAs(expectedUserName, "");
//
//        // Then
//        ProfileDropdown profileDropdown = header.clickProfileDropdown();
//        String actualResult = profileDropdown.getAvatarName();
//        Assert.assertEquals(expectedUserName, actualResult);
//    }

    @Test
    public void testCreateProject() {
        // Given
        String expectedUserName = "Carledriss";
        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, "");

        // When
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.clickCreateProjectButton();

        Map<String, String> data = new HashMap<>();
        data.put("project_name", "MyProject");
        data.put("account", "account1");

        projectForm.createProject(data);

        // Then
//        String actualProjectName = driver.findElement(By.cssSelector(".raw_context_name")).getText();
//        Assert.assertEquals(expectedProject, actualProjectName);
//
//        String actualPrivacy = driver.findElement(By.cssSelector(".public_project_label")).getText();
//        Assert.assertEquals("(Public)", actualPrivacy);
//
//        driver.findElement(By.cssSelector("a[href*=\"/settings\"] > span")).click();
//
//        actualProjectName = driver.findElement(By.cssSelector("#project_name")).getAttribute("value");
//        Assert.assertEquals(expectedProject, actualProjectName);
//
//        String actualAccount = driver.findElement(By.cssSelector("a[href*='/accounts']")).getText();
//        Assert.assertTrue(actualAccount.contains(expectedAccount));
//
//        Assert.assertTrue(driver.findElement(By.cssSelector("#project_public")).isSelected());


    }

    @Test
    public void testAddStoryForm() throws InterruptedException {
        // given
        String expectedUserName = "rubenmendoza";
        String expectedPassword = "p1v0t4Labc";
        String expectedStoryName = "My Project Story";
        String expectedStoryComment = "web automation test project";
        String expectedStoryLabel = "label of my project";

        Signin signin = new Signin();
        Header header = signin.loginAs(expectedUserName, expectedPassword);

        // when
        Dashboard dashboard = new Dashboard();
        ProjectForm projectForm = dashboard.selectProject();
        projectForm = dashboard.clickAddStory();

        Map<String, String> data = new HashMap<>();
        data.put("storyName", expectedStoryName);
        data.put("comment", expectedStoryComment);
        data.put("label", expectedStoryLabel);

        projectForm.addStoryForm(data);

        Thread.sleep(3000); // sleep added to show the user the Story was created

        header.clickProjectStoryDropdown();

        String actualStoryName = header.getStoryName();
        Assert.assertEquals(expectedStoryName, actualStoryName);

        String actualStoryLabel = header.getStoryLabel();
        Assert.assertEquals(expectedStoryLabel, actualStoryLabel);

        String actualStoryComment = header.getStoryComment();
        Assert.assertEquals(expectedStoryComment, actualStoryComment);
    }
}
