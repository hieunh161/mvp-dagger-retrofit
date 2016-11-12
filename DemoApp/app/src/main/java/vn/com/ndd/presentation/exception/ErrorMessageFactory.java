package vn.com.ndd.presentation.exception;

import java.net.ConnectException;

import vn.com.ndd.R;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 * <p>
 * Factory used to create error messages from an Exception as a condition.
 * </p>
 */

public class ErrorMessageFactory {
    private ErrorMessageFactory() {
        //empty
    }

    /**
     * Creates a String representing an error message.
     *
     * @param exception An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static int create(Exception exception) {
        if (exception instanceof ConnectException) {
            return R.string.exception_message_no_connection;
        }
        return 0;
    }
}
