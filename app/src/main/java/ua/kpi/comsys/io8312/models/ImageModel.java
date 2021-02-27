package ua.kpi.comsys.io8312.models;

public class ImageModel {
    private final String webformatURL;

    public ImageModel(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public String getWebformatURL() {
        return webformatURL;
    }
}