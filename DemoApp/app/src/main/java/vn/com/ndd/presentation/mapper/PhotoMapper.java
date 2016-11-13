package vn.com.ndd.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vn.com.ndd.data.entity.PhotoResponse;
import vn.com.ndd.presentation.model.Photo;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class PhotoMapper {
    @Inject
    public PhotoMapper() {
    }

    public List<Photo> mapPhotoResponse(List<PhotoResponse> responseList) {
        List<Photo> photos = new ArrayList<>();
        for (PhotoResponse response : responseList
                ) {
            Photo photo = new Photo();
            photo.setTitle(response.getTitle());
            photo.setUrl(response.getUrl());
            photos.add(photo);
        }
        return photos;
    }
}
