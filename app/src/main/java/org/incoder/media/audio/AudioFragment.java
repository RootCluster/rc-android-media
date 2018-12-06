package org.incoder.media.audio;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.incoder.media.ConstantManager;
import org.incoder.media.R;
import org.incoder.media.audio.adapter.AudioAdapter;
import org.incoder.media.audio.adapter.AudioBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.app.Activity.RESULT_OK;

/**
 * AudioFragment
 *
 * @author : Jerry xu
 * @date : 2018/10/30 09:18
 */
public class AudioFragment extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private Chronometer mChronometer;
    private ImageView mSystemAudio;
    private ImageView mAudioSettings;
    private Button mStartAudio;
    private Button mPauseAudio;
    private Button mFinishAudio;
    private TextView mAudioTotal;
    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<AudioBean> data;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public AudioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);
        mChronometer = view.findViewById(R.id.chronometer);
        mSystemAudio = view.findViewById(R.id.iv_system_audio);
        mAudioSettings = view.findViewById(R.id.iv_audio_settings);
        mStartAudio = view.findViewById(R.id.btn_start_audio);
        mPauseAudio = view.findViewById(R.id.btn_pause_audio);
        mFinishAudio = view.findViewById(R.id.btn_finish_audio);
        mAudioTotal = view.findViewById(R.id.tv_audio_total);
        mRefreshLayout = view.findViewById(R.id.srl_refresh);
        mRecyclerView = view.findViewById(R.id.rv_media);
        mSystemAudio.setOnClickListener(this);
        mStartAudio.setOnClickListener(this);
        mPauseAudio.setOnClickListener(this);
        mFinishAudio.setOnClickListener(this);
        mAudioSettings.setOnClickListener(this);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorBlue, R.color.colorOrange, R.color.colorPrimary);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

//        DividerItemDecoration divider = new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
//        divider.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(getContext(), R.drawable.divider_line)));
//        mRecyclerView.addItemDecoration(divider);

        // 设置默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new AudioAdapter(data);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initData() {
        data = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(); i++) {
            AudioBean bean = new AudioBean();
            bean.setFileName(i + "");
            bean.setFileSize(i);
            bean.setType(1);
            data.add(bean);
        }
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 调用系统自带录音
            case R.id.iv_system_audio:
                Intent intent = new Intent();
                intent.setAction(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivityForResult(intent, ConstantManager.SYSTEM_VOICE_RESULT_CODE);
                break;
            // 开始录音
            case R.id.btn_start_audio:
                startAudio();
                break;
            // 暂停录音
            case R.id.btn_pause_audio:
                pauseAudio();
                break;
            // 结束录音
            case R.id.btn_finish_audio:
                finishAndSaveAudio();
                break;
            // 音频录制设置
            case R.id.iv_audio_settings:
                audioSettings();
                break;
            default:
                break;
        }
    }

    private void audioSettings() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint("InflateParams")
        View view = inflater.inflate(R.layout.alert_single, null);

        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.setContentView(view);
    }

    private void finishAndSaveAudio() {

    }

    private void pauseAudio() {

    }

    private void startAudio() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_audio, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_audio_record:
                Toast.makeText(getContext(), "audio", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_media_recorder:
                Toast.makeText(getContext(), "media", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        if (mRefreshLayout != null) {
            initData();
            mRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            // 系统录音
            if (requestCode == ConstantManager.SYSTEM_VOICE_RESULT_CODE) {
                Toast.makeText(getContext(), "系统录音", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
