package ua.kpi.comsys.io8312.utils;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import ua.kpi.comsys.io8312.models.ImageItem;

public class ImageList {

    private final List<ImageItem> images;

    public ImageList(){
        images = new ArrayList<>();
        images.add(new ImageItem());
    }

    public void addImage(Uri image){
        if(images.get(images.size()-1).size() == 6){
            images.add(new ImageItem());
        }
        images.get(images.size()-1).add(image);
    }

    public List<ImageItem> getImages() {
        return images;
    }
}