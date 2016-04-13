package com.lucamannella.englishidioms;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * This class contains some utility methods.
 * Created by Luca on 13/04/2016.
 * @author Luca
 */
public class Utility {

    /**
     * This method use an {@link Intent} to send an e-mail.
     * P.S.: Everything can be modified by the user.
     * @param emailAddress - The e-mail address of the receiver.
     * @param subject - The e-mail subject
     * @param text - The text of the mail (can be modified by the user).
     * @param activity - The activity that will start the intent.
     * @return True if the intent is started, false otherwise.
     */
    public static boolean sendEmail(String emailAddress, String subject, String text, Activity activity) {
        if(activity == null)
            return false;

        Intent intent = new Intent(Intent.ACTION_SENDTO);

        if(emailAddress != null)
            intent.setData(Uri.parse("mailto: " + emailAddress));
        else
            intent.setData(Uri.parse("mailto: "));

        if(subject != null)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if(text != null)
            intent.putExtra(Intent.EXTRA_TEXT, text);

        if (intent.resolveActivity(activity.getPackageManager()) == null)
            return false;

        activity.startActivity(intent);
        return true;
    }

}
