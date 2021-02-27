package ua.kpi.comsys.io8312.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.adapters.ImageAdapter;
import ua.kpi.comsys.io8312.net.Async;
import ua.kpi.comsys.io8312.utils.Global;

public class Lab5Fragment extends Fragment {

    private ImageAdapter adapter;
//    private static final int PICK_IMAGE = 100;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lab5_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Activity a = getActivity();
        RecyclerView imageList = a.findViewById(R.id.imagesList_id);
        ImageButton button = a.findViewById(R.id.open_gallery_button_id);
        button.setVisibility(View.INVISIBLE);
//        button.setOnClickListener(v -> {
//            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//            startActivityForResult(gallery, PICK_IMAGE);
//        });
        if(adapter == null) {
            adapter = new ImageAdapter(getContext(), Global.images, a);
        }else{
            adapter.setActivity(a);
        }
        imageList.setAdapter(adapter);

        Async.getImages(adapter);

        imageList.invalidate();
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
//            Global.images.addImage(data.getData());
//            adapter.notifyDataSetChanged();
//        }
//    }
}