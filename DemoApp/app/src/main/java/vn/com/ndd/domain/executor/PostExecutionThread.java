package vn.com.ndd.domain.executor;

import rx.Scheduler;

/**
 * Created by hieunh on 11/27/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}