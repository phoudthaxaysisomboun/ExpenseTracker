package com.phoudthaxay.expensetracker.receivers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.phoudthaxay.expensetracker.R;
import com.phoudthaxay.expensetracker.entities.Reminder;
import com.phoudthaxay.expensetracker.ui.MainActivity;
import com.phoudthaxay.expensetracker.ui.reminders.NewReminderFragment;
import com.phoudthaxay.expensetracker.utils.RealmManager;


public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String reminderId = intent.getStringExtra(NewReminderFragment.REMINDER_ID_KEY);
        Reminder reminder = (Reminder) RealmManager.getInstance().findById(Reminder.class, reminderId);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_action)
                        .setContentTitle(context.getString(R.string.app_name))
                        .setContentText(reminder.getName());

        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);

        NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify((int) reminder.getCreatedAt().getTime(), mBuilder.build());
        Reminder.setReminder(reminder);

    }
}
