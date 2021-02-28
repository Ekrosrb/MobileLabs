package ua.kpi.comsys.io8312.models;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class ImageModel extends RealmObject {
    private String webformatURL;

    public ImageModel() {
    }

    public ImageModel(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public String getWebformatURL() {
        return webformatURL;
    }
}