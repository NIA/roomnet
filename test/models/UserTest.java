package models;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class UserTest {
    @Before
    public void startFakeApp() {
        start(fakeApplication(inMemoryDatabase()));
    }
    @After
    public void stopFakeApp() {
        stop(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new User("Bob", "secret").save();

        // Retrieve the user with e-mail address bob@gmail.com
        User bob = User.find.where().eq("login", "Bob").findUnique();

        // Test
        assertThat(bob).isNotNull();
        assertThat(bob.login).isEqualTo("Bob");
    }

    @Test
    public void tryConnectAsUser() {
        // Create a new user and save it
        new User("Ted", "foobar").save();

        // Test
        assertThat(User.connect("Ted", "foobar")).isNotNull();
        assertThat(User.connect("Ted", "badPassword")).isNull();
        assertThat(User.connect("Bob", "foobar")).isNull();
    }
}
