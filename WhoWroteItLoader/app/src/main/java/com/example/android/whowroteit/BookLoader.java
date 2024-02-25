/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.whowroteit;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import android.widget.Toast;

import com.example.android.whowroteit.api.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

/**
 * AsyncTaskLoader implementation that opens a network connection and
 * query's the Book Service API.
 */
public class BookLoader extends AsyncTaskLoader<Book>{

    // Variable that stores the search string.
    private String mQueryString;
    private Context context1;

    Book result = new Book();

    // Constructor providing a reference to the search term.
    public BookLoader(Context context, String queryString) {
        super(context);
        context1 = context;
        mQueryString = queryString;

    }

    /**
     * This method is invoked by the LoaderManager whenever the loader is started
     */
    @Override
    protected void onStartLoading() {
        Log.e("Error","onStartLoading");
        forceLoad(); // Starts the loadInBackground method
    }

    /**
     * Connects to the network and makes the Books API request on a background thread.
     *
     * @return Returns the raw JSON response from the API call.
     */
    @Override
    public Book loadInBackground() {
        Call<Book> call =  ServiceApi.serviceApi.getDataBook(mQueryString,1,"books");
        // Gọi phương thức API thích hợp
        try {
            return call.execute().body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    /*public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }*/
}

