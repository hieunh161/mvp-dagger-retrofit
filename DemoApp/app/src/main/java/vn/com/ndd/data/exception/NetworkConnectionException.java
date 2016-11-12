package vn.com.ndd.data.exception;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class NetworkConnectionException extends Exception {

    /**
     * Instantiates a new Network connection exception.
     */
    public NetworkConnectionException() {
        super();
    }

    /**
     * Instantiates a new Network connection exception.
     *
     * @param message the message
     */
    public NetworkConnectionException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Network connection exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NetworkConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Network connection exception.
     *
     * @param cause the cause
     */
    public NetworkConnectionException(final Throwable cause) {
        super(cause);
    }
}
