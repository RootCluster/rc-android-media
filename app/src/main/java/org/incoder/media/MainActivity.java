package org.incoder.media;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.incoder.media.audio.AudioFragment;
import org.incoder.media.camera.CameraFragment;
import org.incoder.media.notification.NotificationFragment;
import org.incoder.media.video.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity
 *
 * @author : Jerry xu
 * @date : 2018/10/30 09:18
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabs;
    private String[] mTitles = {"音频", "视频", "相机", "通知"};
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        mViewPager = findViewById(R.id.container);
        mTabs = findViewById(R.id.tabs);
        FloatingActionButton fab = findViewById(R.id.fab);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:incoder.xu@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "您的建议");
            intent.putExtra(Intent.EXTRA_TEXT, "我们很希望能得到您的建议！！！");
            startActivity(intent);
        });
        setTopTab();
    }

    private void setTopTab() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            mFragments.add(new AudioFragment());
            mFragments.add(new VideoFragment());
            mFragments.add(new CameraFragment());
            mFragments.add(new NotificationFragment());
            // 设置viewPager适配器
            mViewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
            mViewPager.setOffscreenPageLimit(mFragments.size());
            mTabs.setupWithViewPager(mViewPager);
            mTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }

}
