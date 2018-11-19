package userinterface.com.example.fxchemist.forexstrategy;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView wv;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction ("Action", null).show ();
            }
        });
        */

       getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
       getSupportActionBar ().setHomeButtonEnabled (true);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById (R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle (this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener (drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById (R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (this);

        wv = (WebView) findViewById (R.id.wv);
        WebSettings webSettings = wv.getSettings ();
        webSettings.setJavaScriptEnabled (true);
        wv.loadUrl ("https://findron.000webhostapp.com/index.php/component/sppagebuilder/1-news");
        wv.setWebViewClient (new WebViewClient ());






    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate (savedInstanceState);
        drawerToggle.syncState ();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged (newConfig);
        drawerToggle.syncState ();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        if (drawer.isDrawerOpen (GravityCompat.START)) {
            drawer.closeDrawer (GravityCompat.START);
        } else {
            super.onBackPressed ();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawerToggle.onOptionsItemSelected (item);

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected (item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId ();

        if (id == R.id.home) {
            wv.loadUrl ("https://findron.000webhostapp.com/index.php/component/sppagebuilder/1-news");

        } else if (id == R.id.Ilanmode) {
            wv.loadUrl ("https://financedron.blogspot.com");

        } else if (id == R.id.eurusdgbpusdtraiding) {

            wv.loadUrl ("https://3financedron.blogspot.com");

        } else if (id == R.id.PriceAction) {
            wv.loadUrl ("https://2financedron.blogspot.com");

        } else if (id == R.id.London) {
            wv.loadUrl ("https://4financedron.blogspot.com");

            // } else if (id == R.id.nav_share) {
            //  wv.loadUrl ("https://findron.000webhostapp.com/index.php/signal");

            // } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        drawer.closeDrawer (GravityCompat.START);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if((keyCode==KeyEvent.KEYCODE_BACK)&& wv.canGoBack ()){
            wv.canGoBack ();
            return true;

        }
        return super.onKeyLongPress (keyCode, event);
    }
}