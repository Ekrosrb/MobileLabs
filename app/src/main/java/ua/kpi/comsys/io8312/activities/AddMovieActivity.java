package ua.kpi.comsys.io8312.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ua.kpi.comsys.io8312.R;
@Deprecated
public class AddMovieActivity extends AppCompatActivity {
    EditText title;
    EditText year;
    EditText type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        title = findViewById(R.id.title_text);
        year = findViewById(R.id.year_text);
        type = findViewById(R.id.type_text);
    }

    public void addMovie(View view) {
//        MovieDto movieDto = new MovieDto(
//                title.getText().toString(),
//                year.getText().toString(), "",
//                type.getText().toString(),
//                R.drawable.third_icon);

//        Global.adapter.add(movieDto);
//        Global.adapter.notifyDataSetChanged();
//        Global.fileReader.write(movieDto);
        finish();
    }
}