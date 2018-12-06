package org.incoder.media.audio.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.incoder.media.R;

import java.util.List;

/**
 * AudioAdapter
 *
 * @author : Jerry xu
 * @date : 2018/10/30  15:44
 */
public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.AudioViewHolder> {

    private List<AudioBean> data;

    public AudioAdapter(List<AudioBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_audio_card, viewGroup, false);
        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder audioViewHolder, int i) {
        audioViewHolder.mFileName.setText(data.get(i).getFileName());
        switch (data.get(i).getType()) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class AudioViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        ImageView mAudioConvert;
        TextView mFileName;
        TextView mFileType;
        TextView mFileSize;

        AudioViewHolder(@NonNull View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.cv_content);
            mAudioConvert = itemView.findViewById(R.id.iv_item_audio_convert);
            mFileName = itemView.findViewById(R.id.tv_file_name);
            mFileType = itemView.findViewById(R.id.tv_audio_type);
            mFileSize = itemView.findViewById(R.id.tv_file_size);
        }
    }
}
