package ar.edu.unlp.info.hermescelascolus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class InitialActivity extends AppCompatActivity {

    public final static String KID_NAME = "ar.edu.unlp.info.hermescelascolus.KID_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.kid_list_item,
                android.R.id.text1,
                Arrays.asList(
                        "Jimi Hendrix",
                        "Jimmy Page",
                        "Jenny Gump",
                        "Jimmy Carter",
                        "Jimmy Olsen",
                        "Jimmy James",
                        "Jimmy Carrey (?)",
                        "Jimmy Churry"
                )
        );
        ListView listView = (ListView) findViewById(R.id.kids_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                startKidActivity(String.valueOf(textView.getText()));
            }
        });



        FloatingActionButton addKidButton = (FloatingActionButton) findViewById(R.id.fab);
        addKidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregar nuevo alumn@. Proximamente...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    private void startKidActivity(String kidName){
        Intent intent = new Intent(this, KidActivity.class);
        intent.putExtra(KID_NAME, kidName);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_initial, menu);
        return true;
    }

    //@Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
