package com.rawks.jeremy.endangeredspecies;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // Names and images for items in GridView
    String[] animalNames= {"Eagle", "Elephant", "Gorilla", "Panda", "Panther", "Polar Bear"};
    Integer[] Animals = {R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla,
            R.drawable.panda, R.drawable.panther, R.drawable.polar};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create object representations of the activity widgets
        final GridView grid = findViewById((R.id.gridView));
        final ImageView imgLarge = findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Update the large image to the same as the selected GridView item
                imgLarge.setImageResource(Animals[position]);

                // Display toast message indicating animal selected
                Toast.makeText(getBaseContext(), animalNames[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter
    {
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
            // Populate each image in the GridView
            ImageView pic = new ImageView(context);
            pic.setImageResource(Animals[position]);
            pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            pic.setLayoutParams(new GridView.LayoutParams(330, 300));
            return pic;
        }
    }
}