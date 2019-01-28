package com.phoudthaxay.expensetracker;

import android.app.Application;
import android.content.Context;

/**
 * Created by Phoudthaxay Sisomboun on 10/01/2018.
 */
public class ExpenseTrackerApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }

}
