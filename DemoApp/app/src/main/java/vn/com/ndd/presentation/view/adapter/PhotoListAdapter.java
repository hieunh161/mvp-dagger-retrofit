package vn.com.ndd.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.com.ndd.R;
import vn.com.ndd.presentation.model.Photo;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Photo> mPhotoList = new ArrayList<>();

    public PhotoListAdapter(LayoutInflater layoutInflater) {
        this.mLayoutInflater = layoutInflater;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_photo_item, parent, false);
        return new ViewHolder(view);
    }

    public void addPhotos(List<Photo> photos){
        this.mPhotoList.addAll(photos);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mPhotoList.get(position));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    /**
     * The type View holder.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo_title)
        TextView mPhotoTitle;

        @BindView(R.id.photo_url)
        TextView mPhotoUrl;

        public View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, mView);
        }

        public void bind(Photo photo) {
            mPhotoTitle.setText(photo.getTitle());
            mPhotoUrl.setText(photo.getUrl());
        }
    }
}
