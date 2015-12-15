package handy.espressodemo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;


public class HelpButtonTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public HelpButtonTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        getActivity();
    }

    public void testDoesHelpDialogShowWhenHelpButtonPressed()
    {
        onView(withId(R.id.help_fab_button)).perform(click());
        onView(allOf(isAssignableFrom(TextView.class), withText(R.string.help_dialog_content))).check(matches(isDisplayed()));
    }

}
