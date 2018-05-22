package com.example.soundloneteamcomp.chitchat;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Anh on 5/16/2018.
 */

@RunWith(AndroidJUnit4.class)
public class MessageActivityTest {
    @Rule
    public ActivityTestRule<MessageActivity> activityTestRule = new ActivityTestRule<>(MessageActivity.class, true, true);

//    @Test
//    public void CreateGroupSuccessfully() throws Exception{
//        MessageActivity messageActivity = activityTestRule.getActivity();
////        String passCurrent = messageActivity.;
//        onView(withId(R.id.textview_add_group_message)).perform(click());
//        onView(withId(R.id.EditText_NameOfGroup)).perform(typeText("group demo unit test"));
//        onView(withId(R.id.TextView_Members)).perform(click());
//
//        onView(withId(R.id.addMemberButton)).perform(click());
//        onView(withId())
//
////        MessageActivity.
////        String passNew = "123456789";
////        onView(withId(R.id.EditText_NewPasswordProfile)).perform(typeText(passNew));
////        onView(withId(R.id.EditText_ConfirmPasswordProfile)).perform(typeText(passNew));
//
//        Assert.assertEquals(passNew, messageActivity.getPassCurrent());
//    }

    @Test
    public void SentRequestSuccessfully() throws Exception{
//        MessageActivity messageActivity = activityTestRule.getActivity();
//        messageActivity.createAddUserView("em","1234567890","aku cv");
////        String passCurrent = messageActivity.;
//        onView(withId(R.id.searchview_Message)).perform(click());
//        onView(withId(R.id.searchview_Message)).perform(typeText("e"));
//        onView(withId(R.id.addButton)).perform(click());
//        Button btnAdd = messageActivity.findViewById(R.id.addButton);
//        Assert.assertEquals("Sent", btnAdd.getText().toString());
    }
}
