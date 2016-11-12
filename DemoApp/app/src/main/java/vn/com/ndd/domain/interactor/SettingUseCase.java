package vn.com.ndd.domain.interactor;

import javax.inject.Inject;

import vn.com.ndd.data.entity.Setting;
import vn.com.ndd.data.repository.SharedPreferencesRepository;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class SettingUseCase extends UseCase {

    /**
     * The shared preferences repository.
     */
    @Inject
    SharedPreferencesRepository mSharedPreferencesRepository;

    /**
     * Instantiates a new Setting use case.
     */
    @Inject
    public SettingUseCase() {
    }

    public void setSaveSettingObserver(Setting setting){
        setObservable(mSharedPreferencesRepository.saveSetting(setting));
    }

    public void setLoadSettingObserver(){
        setObservable(mSharedPreferencesRepository.getSetting());
    }
}
