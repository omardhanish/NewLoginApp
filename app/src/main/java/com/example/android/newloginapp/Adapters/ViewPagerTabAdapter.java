package com.example.android.newloginapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.newloginapp.Activities.MainActivity;
import com.example.android.newloginapp.Activities.RegisteringClassActivity;
import com.example.android.newloginapp.R;

/**
 * Created by omar on 10-03-2017.
 */

public class ViewPagerTabAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new  object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public ViewPagerTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MainActivity();
        } else {
            return new RegisteringClassActivity();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.login);
        } else {
            return mContext.getString(R.string.signup);
        }
    }


}
