package ua.kpi.comsys.io8312.models;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class ImageItem {
    public ImageItem(){
        images = new ArrayList<>(6);
    }
    private final List<Uri> images;

    public void add(Uri image){
        images.add(image);
    }

    public int size(){
        return images.size();
    }

    public Uri get(int index){
        if(index < images.size()) {
            return images.get(index);
        }
        return null;
    }
}
