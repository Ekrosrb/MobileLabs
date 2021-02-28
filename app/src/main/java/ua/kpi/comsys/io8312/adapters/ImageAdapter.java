package ua.kpi.comsys.io8312.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.models.ImageItem;
import ua.kpi.comsys.io8312.utils.ImageList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private Activity activity;
    private final ImageList images;
    private final Point w = new Point();
    private final TextView noConnectionMessage;
    public ImageAdapter(Context context, ImageList images, Activity activity,  TextView noConnectionMessage){
        inflater = LayoutInflater.from(context);
        this.images = images;
        this.activity = activity;
        this.noConnectionMessage = noConnectionMessage;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout[] linear;
        final ImageView[] imageViews;
        ViewHolder(View view){
            super(view);
            imageViews = new ImageView[6];
            linear = new LinearLayout[3];
            imageViews[0] = view.findViewById(R.id.layout_image_0);
            imageViews[1] = view.findViewById(R.id.layout_image_1);
            imageViews[2] = view.findViewById(R.id.layout_image_2);
            imageViews[3] = view.findViewById(R.id.layout_image_3);
            imageViews[4] = view.findViewById(R.id.layout_image_4);
            imageViews[5] = view.findViewById(R.id.layout_image_5);
            linear[0] = view.findViewById(R.id.linear_0);
            linear[1] = view.findViewById(R.id.linear_1);
            linear[2] = view.findViewById(R.id.linear_2);
        }
    }

    public void setActivity(Activity activity){
        this.activity = activity;
    }

    public void setNoConnectionMessageVisibility(int state){
        noConnectionMessage.setVisibility(state);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.image_manager_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageItem item = images.getImages().get(position);
        activity.getWindowManager().getDefaultDisplay().getSize(w);
        double a = w.x - w.x/2.8;
        double b = w.x - a;
        double c = a/3;
        double[] sizeW = {a, b, b, c, c, c};
        int[] sizeH;
        if(activity.getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT){
            sizeH = new int[]{500, 350, 350, 200, 200, 200};
        }else{
            sizeH = new int[]{700, 475, 475, 250, 250, 250};
        }
        for(int i = 0; i < holder.imageViews.length; i++){
            Uri uri;
            if((uri = item.get(i)) != null) {
                Picasso.with(inflater.getContext())
                        .load(uri).resize((int) sizeW[i], sizeH[i]).centerInside()
                        .placeholder(R.drawable.progress_animation)
                        .into(holder.imageViews[i]);
                holder.imageViews[i].setBackgroundColor(Color.GRAY);
                LayoutParams layoutParams = new LinearLayout.LayoutParams((int) sizeW[i], sizeH[i]);
                layoutParams.setMargins(1, 1, 1, 1);
                holder.imageViews[i].setLayoutParams(layoutParams);
            }
        }
    }

    @Override
    public int getItemCount() {
        return images.getImages().size();
    }
}