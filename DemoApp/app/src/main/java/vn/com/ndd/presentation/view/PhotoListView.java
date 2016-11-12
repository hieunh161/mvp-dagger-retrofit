package vn.com.ndd.presentation.view;

import java.util.List;

import vn.com.ndd.presentation.model.Photo;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public interface PhotoListView extends LoadDataView{

    void onPhotoListLoaded(List<Photo> photoList);
}
