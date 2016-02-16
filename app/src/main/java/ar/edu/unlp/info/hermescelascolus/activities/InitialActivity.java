package ar.edu.unlp.info.hermescelascolus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import ar.edu.unlp.info.hermescelascolus.models.Kid;
import ar.edu.unlp.info.hermescelascolus.R;
import ar.edu.unlp.info.hermescelascolus.models.dao.Daos;

public class InitialActivity extends AppCompatActivity {

    public final static String KID_ID = "ar.edu.unlp.info.hermescelascolus.KID_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        //testing
        getApplicationContext().deleteDatabase("celascolus.db");

        ArrayAdapter<Kid> adapter = new ArrayAdapter<>(
                this,
                R.layout.kid_list_item,
                android.R.id.text1,
                Daos.KID.all()
        );
        ListView listView = (ListView) findViewById(R.id.kids_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Kid kid = (Kid) parent.getItemAtPosition(position);
                startKidActivity(kid);
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

    private void startKidActivity(Kid kid){
        Intent intent = new Intent(this, KidActivity.class);
        intent.putExtra(KID_ID, kid.getId());
        startActivity(intent);
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
