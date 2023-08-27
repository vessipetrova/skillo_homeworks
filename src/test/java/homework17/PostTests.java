package homework17;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
public class PostTests extends TestObject {
    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\upload\\testUpload.jpg");
        String caption = "Testing create post caption";

        return new Object[][]{{"realtester", "123456", "realtester", postPicture, caption}};
    }
    @Test(dataProvider = "getUsers")
    public void testCreatePost(String user, String password, String username, File file, String caption) {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login(user, password);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        Header header = new Header(driver);
        header.clickNewPost();

        PostPage postPage = new PostPage(driver);
        Assert.assertTrue(postPage.isUrlLoaded(), "The POST URL is not correct!");
        postPage.uploadPicture(file);
        Assert.assertTrue(postPage.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(file.getName(), postPage.getImageName(), "The image name is incorrect!");
        postPage.populatePostCaption(caption);
        postPage.clickCreatePost();

        ProfilePage profilePage = new ProfilePage(driver);
        int oldpostcount = profilePage.getPostCount() - 1;
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        Assert.assertEquals(profilePage.getPostCount(), oldpostcount+1, "The number of Posts is incorrect!");
        profilePage.clickPost(0);

        PostModal postModal = new PostModal(driver);
        Assert.assertTrue(postModal.isImageVisible(), "The image is not visible!");
        Assert.assertEquals(postModal.getPostTitle(), file.getName(), "The post title is incorrect!");
        Assert.assertEquals(postModal.getPostUser(), postModal.getPostUser(), "The user is incorrect!");
    }
}
