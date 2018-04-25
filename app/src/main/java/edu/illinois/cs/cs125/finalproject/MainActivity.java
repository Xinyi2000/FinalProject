package edu.illinois.cs.cs125.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
//things add for button change import
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Main screen for our API testing app.
 */
public final class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Main Aactivity";

    /** Request queue for our network requests. */
    private static RequestQueue requestQueue;

    /**
     * Run when our activity comes into view.
     *
     * @param savedInstanceState state that was saved by the activity last time it was paused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up a queue for our Volley requests
        requestQueue = Volley.newRequestQueue(this);

        // Load the main layout for our activity
        setContentView(R.layout.activity_main);

        // Attach the handler to our UI button
        final Button refreshButton = findViewById(R.id.refresher);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "refresh the search result");
                startAPICall();
            }
        });
        //the things added for button change
        public void buttonOnclick(View v) {
            Button button = (Button) v;
            ((Button) v).setText("complete");
        }
        public void buttonOnclick1(View v) {
            Button button = (Button) v;
            ((Button) v).setText("Lucky");
        }

        final Button fortuneButton = findViewById(R.id.fortune);
        fortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "check your fortune for today");
                startAPICall();
            }
        });

        refreshButton.setVisibility(View.GONE);
        fortuneButton.setVisibility(View.VISIBLE);
    }

    /**
     * Make an API call.
     */
    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "http://api.jikan.me/",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d(TAG, response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w(TAG, error.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
//requestQueue.add(jsonObjectRequest);
//            final JSONObject jsonBody = new JSONObject("{\"type\":\"example\"}");
//            Request.Method.POST,
//                    "http://api.jikan.me/",
//                    null,