package today.docoolthingsthatmatter.justforfun;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by iyudhi on 4/4/16.
 */
public class FusionList extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        displayWeb();

    }

    public void displayWeb() {
        WebView myWebView = (WebView) findViewById(R.id.web_view);
        myWebView.loadUrl("http://yokaiwatch.wikia.com/wiki/Evolution");
    }

}
