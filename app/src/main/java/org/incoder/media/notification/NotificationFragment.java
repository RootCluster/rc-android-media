package org.incoder.media.notification;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.incoder.media.R;

/**
 * NotificationFragment
 *
 * @author : Jerry xu
 * @date : 2018/10/30 09:18
 */
public class NotificationFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    private Button mNormal;
    private Button mFold;
    private Button mRich;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        mNormal = view.findViewById(R.id.btn_normal);
        mFold = view.findViewById(R.id.btn_fold);
        mRich = view.findViewById(R.id.btn_rich_media);
        mNormal.setOnClickListener(this);
        mNormal.setOnLongClickListener(this);
        mFold.setOnClickListener(this);
        mRich.setOnClickListener(this);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal:
                break;
            case R.id.btn_fold:
                break;
            case R.id.btn_rich_media:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_notification, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_public:
                Toast.makeText(getContext(), "public", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_private:
                Toast.makeText(getContext(), "private", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_secret:
                Toast.makeText(getContext(), "secret", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
