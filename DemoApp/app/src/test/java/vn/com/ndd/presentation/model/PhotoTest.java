package vn.com.ndd.presentation.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by hieunh on 11/14/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class PhotoTest {
    @Test
    public void testPhoto(){
        Photo photo = new Photo();
        photo.setTitle("testTitle");
        photo.setUrl("http://test.com");
        assertThat("testTitle", is(photo.getTitle()));
        assertThat("http://test.com", is(photo.getUrl()));
    }
}
