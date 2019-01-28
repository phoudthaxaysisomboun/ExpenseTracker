package com.phoudthaxay.expensetracker.ui.reminders;

import android.os.Bundle;

import com.phoudthaxay.expensetracker.R;
import com.phoudthaxay.expensetracker.interfaces.IUserActionsMode;
import com.phoudthaxay.expensetracker.ui.BaseActivity;


public class NewReminderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        @IUserActionsMode int mode = getIntent().getIntExtra(IUserActionsMode.MODE_TAG, IUserActionsMode.MODE_CREATE);
        String reminderId = getIntent().getStringExtra(NewReminderFragment.REMINDER_ID_KEY);
        replaceFragment(NewReminderFragment.newInstance(mode, reminderId), false);
    }

}
