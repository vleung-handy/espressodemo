package handy.espressodemo;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class LoginTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static final String VALID_USERNAME = "username";
    private static final String VALID_PASSWORD = "password";
    private static final String INVALID_PASSWORD = "blahblah";

    public LoginTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void testLoginSuccessWithValidCredentials()
    {
        //can make shorthands for these if desired
        onView(withId(R.id.login_button)).perform(click());

        onView(withId(R.id.username_text)).perform(click(), typeText(VALID_USERNAME), closeSoftKeyboard());
        onView(withId(R.id.password_text)).perform(click(), typeText(VALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

        onView(withId(R.id.welcome_user_text)).check(matches(isDisplayed()));
    }

    public void testLoginFailsWithInvalidCredentials()
    {
        //can make shorthands for these if desired
        onView(withId(R.id.login_button)).perform(click());

        onView(withId(R.id.username_text)).perform(click(), typeText(VALID_USERNAME), closeSoftKeyboard());
        onView(withId(R.id.password_text)).perform(click(), typeText(INVALID_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

        onView(withId(R.id.welcome_user_text)).check(doesNotExist());
    }
}
