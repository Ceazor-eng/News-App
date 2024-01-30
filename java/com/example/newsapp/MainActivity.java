package com.example.newsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity implements CategoryRVAdapter.CategoryClickInterface {
    private ProgressBar loading;
    private RecyclerView news, category;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<CategoryRVModel> categoryRVModelArrayList;
    private CategoryRVAdapter categoryRVAdapter;
    private NewsRVAdapter newsRVAdapter;
//    private ArrayList<NewsModel>newsModelArrayList;

//192.168.100.140




    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    ff6a872a6ad24cb180e1123a11005d56
         news = findViewById(R.id.news);
         category = findViewById(R.id.categories);
        loading = findViewById(R.id.loading);
        articlesArrayList = new ArrayList<>();
        categoryRVModelArrayList = new ArrayList<>();
        newsRVAdapter = new NewsRVAdapter(articlesArrayList,this);
        categoryRVAdapter = new CategoryRVAdapter(categoryRVModelArrayList,this, this);
        news.setLayoutManager(new LinearLayoutManager(this));
        news.setAdapter(newsRVAdapter);
        category.setAdapter(categoryRVAdapter);
        getCategories();
        getNews("All");
        newsRVAdapter.notifyDataSetChanged();



    }
    private void getCategories(){
        categoryRVModelArrayList.add(new CategoryRVModel("All","https://images.unsplash.com/photo-1583611352296-1e7f6d767659?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YWxsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=1000&q=60"));
        categoryRVModelArrayList.add(new CategoryRVModel("General","https://images.unsplash.com/photo-1493612276216-ee3925520721?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Z2VuZXJhbHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=1000&q=60"));
        categoryRVModelArrayList.add(new CategoryRVModel("Technology","https://images.unsplash.com/photo-1488590528505-98d2b5aba04b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dGVjaG5vbG9neXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=1000&q=60"));
        categoryRVModelArrayList.add(new CategoryRVModel("Science","https://plus.unsplash.com/premium_photo-1676325102583-0839e57d7a1f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c2NpZW5jZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=1000&q=60"));
        categoryRVModelArrayList.add(new CategoryRVModel("Sports","https://images.unsplash.com/photo-1461896836934-ffe607ba8211?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c3BvcnRzfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=1000&q=60"));
        categoryRVModelArrayList.add(new CategoryRVModel("Business","https://images.unsplash.com/photo-1665686310934-8fab52b3821b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YnVzaW5lc3N8ZW58MHx8MHx8&auto=format&fit=crop&w=1000&q=60"));
        categoryRVModelArrayList.add(new CategoryRVModel("Entertainment","https://images.unsplash.com/photo-1603190287605-e6ade32fa852?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8ZW50ZXJ0YWlubWVudHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=1000&q=60"));
        categoryRVModelArrayList.add(new CategoryRVModel("Health","https://images.unsplash.com/photo-1506126613408-eca07ce68773?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8aGVhbHRofGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=1000&q=60"));
        categoryRVAdapter.notifyDataSetChanged();
    }
    private void getNews(String category) {
        loading.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String url = "-headlines?excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apikey= https://0272-197-248-191-101.ngrok-free.app";
        String categoryURL = " https://0272-197-248-191-101.ngrok-free.app/ -headlines?country=category="+ category +"";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://0272-197-248-191-101.ngrok-free.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<ArrayList<Articles>> call;
        if (category.equals("All")) {
            call = retrofitAPI.getAllNews("https://0272-197-248-191-101.ngrok-free.app/");
        } else {
            call = retrofitAPI.getNewsByCategory(categoryURL);
        }
       call.enqueue(new Callback<ArrayList<Articles>>() {
           @Override
           public void onResponse(Call<ArrayList<Articles>> call, Response<ArrayList<Articles>> response) {

               Log.e("response",">>>>>>>>>>>>>>"+response);
               ArrayList<Articles> articles = response.body();
//               for (Articles article: articles) {
//                   Log.e("data",">>>>>>>>>>>>>>"+article);
//               }

               if(response.isSuccessful()){
                 ArrayList<Articles> article = response.body();
//                   Log.e("Articles",">>>>>>>>>>>>>>"+article.getArticles());
                                   loading.setVisibility(View.GONE);
                         if (articles !=null)
               for (int i = 0; i < articles.size(); i++) {
                   articlesArrayList.add(new Articles(articles.get(i).getTitle(), articles.get(i).getDescription(), articles.get(i).getUrl(), articles.get(i).getContent(), articles.get(i).getUrlToImage(), articles.get(i).getPublishedAt()));
               }
//                   Log.e("status",">>>>>>>>>>>>>>"+article.getStatus());
//                   Log.e("tota          articles = article.getArticles();
//   lResults",">>>>>>>>>>>>>>"+article.getTotalResults());
//                   Log.e("Articles",">>>>>>>>>>>>>>"+article.getArticles());

     newsRVAdapter.notifyDataSetChanged();


               }


//               Log.e("Response>>>",">>>>articles>>>>>>>>>>>>>>"+response.body().);
               Log.e("url",">>>>>>>>>>>>>>"+response);

//               Log.e("Articles",">>>>>>>>>>>>>>"+response.body().getArticles());
//               Log.e("status",">>>>>>>>>>>>>>"+response.body().getStatus());
//               Log.e("totalResults",">>>>>>>>>>>>>>"+response.body().getTotalResults());
//



           }

           @Override
           public void onFailure(Call<ArrayList<Articles>> call, Throwable i) {
               Log.e("response:error",">>>>>>>>>>>>>>"+i);
               Toast.makeText(MainActivity.this, "Fail to get news", Toast.LENGTH_SHORT).show();

           }

       });


        }

    @Override
    public void onCategoryClick ( int position){
        String category = categoryRVModelArrayList.get(position).getCategory();

        getNews(category);
    }
    }





