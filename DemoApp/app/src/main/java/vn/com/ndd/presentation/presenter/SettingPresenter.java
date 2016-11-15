package vn.com.ndd.presentation.presenter;

import javax.inject.Inject;

import rx.Observer;
import vn.com.ndd.data.entity.Setting;
import vn.com.ndd.domain.interactor.SettingUseCase;
import vn.com.ndd.presentation.base.BasePresenter;
import vn.com.ndd.presentation.view.SettingView;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class SettingPresenter extends BasePresenter<SettingView>{
    /**
     * The use case.
     */
    @Inject
    SettingUseCase mUseCase;

    /**
     * The Setting observer.
     */
    Observer<Setting> settingObserver = new Observer<Setting>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Setting setting) {
            getView().onSettingDataReady(setting);
        }
    };

    /**
     * The Save setting observer.
     */
    Observer<Void> saveSettingObserver = new Observer<Void>() {

        /**
         * Notifies the Observer that the {@link rx.Observable} has finished sending push-based notifications.
         * <p>
         * The {@link rx.Observable} will not call this method if it calls {@link #onError}.
         */
        @Override
        public void onCompleted() {

        }

        /**
         * Notifies the Observer that the {@link rx.Observable} has experienced an error condition.
         * <p>
         * If the {@link rx.Observable} calls this method, it will not thereafter call {@link #onNext} or
         * {@link #onCompleted}.
         *
         * @param e the exception encountered by the Observable
         */
        @Override
        public void onError(Throwable e) {

        }

        /**
         * Provides the Observer with a new item to observe.
         * <p>
         * The {@link rx.Observable} may call this method 0 or more times.
         * <p>
         * The {@code Observable} will not call this method again after it calls either {@link #onCompleted} or
         * {@link #onError}.
         *
         * @param aVoid the item emitted by the Observable
         */
        @Override
        public void onNext(Void aVoid) {

        }
    };

    /**
     * Instantiates a new Setting presenter.
     */
    @Inject
    public SettingPresenter(){}

    /**
     * Load setting data.
     */
    public void loadSettingData(){
        mUseCase.setLoadSettingObserver();
        mUseCase.subscribe(settingObserver);
    }

    /**
     * Save setting.
     *
     * @param setting the setting
     */
    public void saveSetting(Setting setting){
        mUseCase.setSaveSettingObserver(setting);
        mUseCase.subscribe(saveSettingObserver);
    }
}
