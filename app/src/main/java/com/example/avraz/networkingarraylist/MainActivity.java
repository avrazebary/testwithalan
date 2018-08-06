package com.example.avraz.networkingarraylist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.avraz.networkingarraylist.JSONParsing.Article;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view_id);

        String avraz = "https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=c9a41e6e8603443c95c6c7d15aa589a0";
        try {
            URL url = new URL(avraz);
            new NewsAsyncTask().execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    class NewsAsyncTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            StringBuilder JsonData = new StringBuilder();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) urls[0].openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();

                // In order to get all lines you're gonna use while line is not equal to empty, get all the lines that are in the article
                while (null != line) {
                    JsonData.append(line);
                    line = reader.readLine();
                }
                // string can  NOT be changed and if you want to change it you have to create another object.
                // String Builder CAN BE  changed and you don't have to create another object.

            } catch (IOException e) {
                e.printStackTrace();
            }

            return JsonData.toString();
        }
        // GRANT PERMISSION FOR INTERNET ON MANIFEST
        // ADD PICASSO ON GRADLE>> BULD GRADLE (MODULE:APP)>> THEN PASTE IT IN THE FILE.
        // make an AsyncTask and give it a name
        // do the httpURLConnection
        // give it a setRequest Method and make it GET
        // give it a set connect Timeout
        // give it a setReadTimeout
        //then connect it by adding .connect(); to the httpURLConnection
        //Control O .........to add the methods
        // You're gonna add doInBackground method
        // Also onPost execute
        // after doing that you're g

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<Article> news = new ArrayList<>();

//                JSONObject root = new JSONObject(s);
//                JSONArray article = root.getJSONArray("articles"); // that is how you get the article
//                String title;
//                String author;
//                String description;
//                String imageSrc;
            // for parsing i have to get strings from the article by using JSON object or array depending on the article
//                for (int i = 0; i < article.length(); i++) {
//                    JSONObject newArticle = article.getJSONObject(i);
//                    title = newArticle.getString("title");
//                    author = newArticle.getString("author");
//                    description = newArticle.getString("description");
//                    imageSrc = newArticle.getString("urlToImage");
//                    news.add(new News(author, title, imageSrc, description));
//                }
            Gson gson = new Gson();
            Root root = gson.fromJson(s,Root.class);
            news = root.getArticles();

            NewsAdapter adapter = new NewsAdapter(getApplicationContext(), news);
            listView.setAdapter(adapter);


        }


    }
}
