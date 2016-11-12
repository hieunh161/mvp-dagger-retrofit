package vn.com.ndd.data.repository;

import rx.Observable;
import vn.com.ndd.data.entity.Setting;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public interface SharedPreferencesRepository {

    /**
     * Gets setting.
     *
     * @return the setting
     */
    Observable<Setting> getSetting();

    /**
     * Save setting.
     *
     * @param setting the setting
     */
    Observable<Boolean> saveSetting(Setting setting);
}
