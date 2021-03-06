package freeskill.app.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import freeskill.app.R;
import freeskill.app.model.CurrentApp;
import freeskill.app.model.adapters.MarksAdapter;
import freeskill.app.model.query.GetMarks;

/**
 * Created by Florian on 11/02/2018.
 */

public class ListMarksScreen extends AppCompatActivity {

    private ListView listView;
    private RequestQueue queue;
    private CurrentApp currentApp;
    private GetMarks getMarks;
    private MarksAdapter adapter;
    private int idProfile;

    public int getIdProfile() {
        return idProfile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marks_by_tag);

        Intent intent = getIntent();
        if (intent.getIntExtra("idProfile", -1) == -1) {
            this.idProfile = 0;
        } else {
            this.idProfile = intent.getIntExtra("idProfile", -1);
        }

        queue = Volley.newRequestQueue(this);

        this.currentApp = CurrentApp.getInstance(null);
        this.getMarks = new GetMarks(this.currentApp.getAccessToken(), this.queue, this);
        this.getMarks.getMarks(this.currentApp.getAccessToken());

        this.adapter = this.getMarks.getAdapter();

        // Get ListView object from xml
        listView = findViewById(R.id.listViewMarks);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.idProfile == 0) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    Intent intent = new Intent(this, ProfileScreen.class);
                    startActivity(intent);
            }
            return true;
        } else {
            switch (item.getItemId()) {
                case android.R.id.home:
                    Intent intent = new Intent(this, SwipeScreen.class);
                    startActivity(intent);
            }
            return true;
        }
    }
}
