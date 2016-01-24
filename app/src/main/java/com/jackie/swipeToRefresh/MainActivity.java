/*
 * Copyright 2016 The Open Source Project of Jackie Zhu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jackie.swipeToRefresh;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        // Retrieve the SwipeRefreshLayout instances
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.my_swipe_refresh);

        /**
         * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
         * preforms a swipe-to-refresh gesture
         */
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // @TODO refresh data operation
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Listen for option item selections so that we receive a notification
     * when the user requests a refresh by selecting the refresh action bar item.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Check if user triggered a refresh:
            case R.id.action_refresh:
                Log.i(TAG, "onOptionsItemSelected: Refresh item selected");

                if (!mySwipeRefreshLayout.isRefreshing()) {
                    // Signal SwipeRefreshLayout to start the progress indicator
                    mySwipeRefreshLayout.setRefreshing(true);
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
