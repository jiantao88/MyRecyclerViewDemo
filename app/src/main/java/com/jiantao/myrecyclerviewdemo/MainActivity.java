package com.jiantao.myrecyclerviewdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements MainListFragment.OnFragmentInteractionListener {

    private android.widget.FrameLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.content = (FrameLayout) findViewById(R.id.content);
        MainListFragment mainListFragment = new MainListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content,mainListFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    @Override
    public void onFragmentInteraction(String id) {
        Fragment fragment = null;
        if (id.equals("1")){
            fragment = new RecyclerListFragment();

        }else if (id.equals("2")){
            fragment = new RecyclerGridFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).addToBackStack(null).commit();
    }

}
