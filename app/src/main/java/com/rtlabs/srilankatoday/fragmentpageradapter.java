package com.rtlabs.srilankatoday;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by thari on 3/4/2018.
 */

public class fragmentpageradapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Breaking News", "Local", "International", "Sports","Finance" };
    public fragmentpageradapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BreakingNews();
        } else if (position == 1) {
            return new Local();
        } else if (position == 2) {
            return new International();
        } else if (position == 3) {
            return new Sports();
        } else {
            return new Finance();
        }
    }
    @Override
    public int getCount() {
        return 5;
    }

    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
