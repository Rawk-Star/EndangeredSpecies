package com.rawks.jeremy.endangeredspecies;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    String[] animalNames= {"Eagle", "Elephant", "Gorilla", "Panda", "Panther", "Polar Bear"};
    Integer[] Animals = {R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla,
            R.drawable.panda, R.drawable.panther, R.drawable.polar};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView grid = findViewById((R.id.gridView));
        final ImageView pic = findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getBaseContext(), animalNames[position], Toast.LENGTH_SHORT).show();
                pic.setImageResource(Animals[position]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter{

        private Context context;

        public ImageAdapter(Context c)
        {
            context = c;
        }

        @Override
        public int getCount()
        {
            return Animals.length;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            pic = new ImageView(context);
            pic.setImageResource(Animals[position]);
            pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            pic.setLayoutParams(new GridView.LayoutParams(330, 300));
            return pic;
        }
    }
}
