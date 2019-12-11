package com.example.welcome.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
public class DisplayImage extends AppCompatActivity {
    Button btnDelete;
    ImageView imageDetail;
    int imageId;
    Bitmap theImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

            btnDelete = (Button) findViewById(R.id.btnDelete);
            imageDetail = (ImageView) findViewById(R.id.imageView1);
            /**
             * getting intent data from search and previous screen
             */
            Intent intnt = getIntent();
            theImage = (Bitmap) intnt.getParcelableExtra("imagename");
            imageId = intnt.getIntExtra("imageid", 20);
            Log.d("Image ID:****", String.valueOf(imageId));
            imageDetail.setImageBitmap(theImage);
            btnDelete.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    /**
                     * create DatabaseHandler object
                     */
                    DataBaseHandler db = new DataBaseHandler(
                            DisplayImage.this);
                    /**
                     * Deleting records from database
                     */
                    Log.d("Delete Image: ", "Deleting.....");
                    db.deleteContact(new Contact(imageId));
                    // /after deleting data go to main page
                    Intent i = new Intent(DisplayImage.this,
                            UploadImg.class);
                    startActivity(i);
                    finish();
                }
            });

        }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    }



