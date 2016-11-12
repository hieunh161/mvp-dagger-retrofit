package vn.com.ndd.presentation.presenter;

import android.content.Context;

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
     * The Context.
     */
    @Inject
    Context context;

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
    Observer<Boolean> saveSettingObserver = new Observer<Boolean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Boolean result) {
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
