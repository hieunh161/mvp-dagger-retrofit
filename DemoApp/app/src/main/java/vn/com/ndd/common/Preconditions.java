package vn.com.ndd.common;

/**
 * Created by hieunh on 11/18/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class Preconditions {
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}
