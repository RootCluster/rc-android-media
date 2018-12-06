package org.incoder.media;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseFragmentPagerAdapter
 *
 * @author : Jerry xu
 * @date : 2018/10/30  10:37
 */
public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private String[] mTitles;

    BaseFragmentPagerAdapter(FragmentManager fm,
                             List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    BaseFragmentPagerAdapter(FragmentManager fm,
                             List<Fragment> fragments, String[] mTitles) {
        super(fm);
        this.fragments = fragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles == null ? "" : mTitles[position];
    }
}

