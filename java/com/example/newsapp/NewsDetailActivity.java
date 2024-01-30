package com.example.newsapp;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title, url, description, content, imageURL, publishedAt;
    private TextView titleTV, subDescTV, contentTV, DateTV;
    private ImageView newsIV;
    private Button readnewsbtn, shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        imageURL = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        publishedAt =  getIntent().getStringExtra("publishedAt");
        content = getIntent().getStringExtra("content");
        description = getIntent().getStringExtra("description");
        titleTV = findViewById(R.id.idTVTitle);
        subDescTV = findViewById(R.id.idTVSubDesc);
        contentTV = findViewById(R.id.idTVContent);
        DateTV = findViewById(R.id.idDate);
        shareButton = findViewById(R.id.shareButton);
        newsIV = findViewById(R.id.idIVNews);
        readnewsbtn = findViewById(R.id.btnreadnews);
        titleTV.setText(title);

        subDescTV.setText(description);
        contentTV.setText(content);
        DateTV.setText(publishedAt);
        Picasso.get().load(imageURL).into(newsIV);

//        setOnTouchListener();
        {


            Button shareButton = findViewById(R.id.shareButton);

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shareLink("https://www.example.com");
                }

                private void shareLink(String s) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, url);

                    startActivity(Intent.createChooser(shareIntent, "Share via"));

                }
            });



            readnewsbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                }
            });


        }
    }

//    private void setOnTouchListener() {
//    }
}