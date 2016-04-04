package today.docoolthingsthatmatter.justforfun;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set a Toolbar to replace the ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_yokai) {

            /*TextView view = (TextView) findViewById(R.id.main_page);
            view.setVisibility(View.GONE);

            WebView webView = (WebView)findViewById(R.id.web_view);
            webView.setVisibility(View.VISIBLE);*/
            //closeCurrentLayout();



            /*LayoutInflater inflater = getLayoutInflater();
            LinearLayout container = (LinearLayout) findViewById(R.id.content_main);
            inflater.inflate(R.layout.activity_main, container);*/

            displayWeb();


        } else if (id == R.id.nav_food) {

            /*WebView webView = (WebView)findViewById(R.id.web_view);
            webView.setVisibility(View.GONE);

            TextView view = (TextView) findViewById(R.id.main_page);
            view.setVisibility(View.VISIBLE);*/

            //closeCurrentLayout();



            /*LayoutInflater inflater = getLayoutInflater();
            LinearLayout container = (LinearLayout) findViewById(R.id.content_second);
            inflater.inflate(R.layout.activity_main, container);*/

            order("YooFood.xls");

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void closeCurrentLayout(int n){
        if(n==1) {
            TextView view = (TextView) findViewById(R.id.main_page);
            view.setVisibility(View.GONE);

            WebView webView = (WebView)findViewById(R.id.web_view);
            webView.setVisibility(View.VISIBLE);
        }
    }

    //display message in main window
    public void displayMessage(String message) {
        TextView cardMessage = (TextView) findViewById(R.id.main_page);
        cardMessage.setText(message);
    }

    public void displayWeb() {
        WebView myWebView = (WebView) findViewById(R.id.web_view);
        myWebView.loadUrl("http://www.thonky.com/yo-kai-watch/list-of-yo-kai");
    }

    public void order(String fileName) {
        try {
            AssetManager am = getAssets();
            InputStream is = am.open(fileName);
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();

            String xx = "";
            for (int i = 0; i<row; i++) {
                for (int c=0; c<col; c++){
                    Cell z = s.getCell(c,i);
                    xx = xx + z.getContents();
                }
                xx = xx + "\n";
            }
            displayMessage(xx);

        } catch (Exception e) {

        }
    }


}
