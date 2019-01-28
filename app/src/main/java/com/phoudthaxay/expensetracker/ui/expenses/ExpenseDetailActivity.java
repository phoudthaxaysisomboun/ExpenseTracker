package com.phoudthaxay.expensetracker.ui.expenses;

import android.os.Bundle;

import com.phoudthaxay.expensetracker.R;
import com.phoudthaxay.expensetracker.ui.BaseActivity;

public class ExpenseDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        String expenseId = getIntent().getStringExtra(ExpenseDetailFragment.EXPENSE_ID_KEY);
        replaceFragment(ExpenseDetailFragment.newInstance(expenseId), false);
    }

}
