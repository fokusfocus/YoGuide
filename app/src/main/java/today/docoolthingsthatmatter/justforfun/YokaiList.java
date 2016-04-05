package today.docoolthingsthatmatter.justforfun;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by iyudhi on 4/4/16.
 */
public class YokaiList extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        displayWeb();

    }

    public void displayWeb() {
        WebView myWebView = (WebView) findViewById(R.id.web_view);
        myWebView.loadUrl("http://www.thonky.com/yo-kai-watch/list-of-yo-kai");
    }



}

