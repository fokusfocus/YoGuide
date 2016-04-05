package today.docoolthingsthatmatter.justforfun;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * Created by iyudhi on 4/4/16.
 */
public class FavoriteFood extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_second);
        order("YooFood.xls");
        //displayMessage("THIS IS JUST A TEST YO");

    }

    public void displayMessage(String message) {
        TextView cardMessage = (TextView) findViewById(R.id.main_page);
        cardMessage.setText(message);
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
