package vn.com.ndd.common;

import rx.Subscriber;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 * This class is utilities for subscription observable of reactive programming
 */
public class SubscriptionUtils {

    /**
     * On complete.
     *
     * @param <T>        the type parameter
     * @param subscriber the subscriber
     */
    public static <T> void onComplete(Subscriber<T> subscriber) {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.onCompleted();
        }
    }

    /**
     * On error.
     *
     * @param <T>        the type parameter
     * @param subscriber the subscriber
     * @param throwable  the throwable
     */
    public static <T> void onError(Subscriber<T> subscriber, Throwable throwable) {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.onError(throwable);
        }
    }

    /**
     * On next.
     *
     * @param <T>        the type parameter
     * @param subscriber the subscriber
     * @param data       the data
     */
    public static <T> void onNext(Subscriber<T> subscriber, T data) {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.onNext(data);
        }
    }

    /**
     * On next.
     *
     * @param <T>        the type parameter
     * @param subscriber the subscriber
     */
    public static <T> void onNext(Subscriber<T> subscriber) {
        onNext(subscriber, null);
    }

    /**
     * On next and complete.
     *
     * @param <T>        the type parameter
     * @param subscriber the subscriber
     * @param data       the data
     */
    public static <T> void onNextAndComplete(Subscriber<T> subscriber, T data) {
        onNext(subscriber, data);
        onComplete(subscriber);
    }

    /**
     * On next and complete.
     *
     * @param <T>        the type parameter
     * @param subscriber the subscriber
     */
    public static <T> void onNextAndComplete(Subscriber<T> subscriber) {
        onNext(subscriber, null);
        onComplete(subscriber);
    }
}
