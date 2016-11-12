package vn.com.ndd.data.repository;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public interface SharedPreferencesRepository {
    /**
     * Gets base url.
     *
     * @return the base url, if not exist return default url
     */
    String getBaseUrl();

    void setBaseUrl(String baseUrl);
}
