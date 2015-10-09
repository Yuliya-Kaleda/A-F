package nyc.c4q.yuliyakaleda.af;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CardActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PROMOTION = "promotion";
    private static final String DOLCE_PROMOTION = "Dolce";
    private static final String HOLLISTER = "https://m.hollisterco.com";
    private static final String ABERCROMBIE = "https://m.abercrombie.com";
    private Promotion receivedPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        receivedPromotion = (Promotion) getIntent().getSerializableExtra(PROMOTION);

        //This part of code initializes the views.
        ImageView image = (ImageView) findViewById(R.id.image);
        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);
        TextView footer = (TextView) findViewById(R.id.footer);
        FloatingActionButton fabOpenWebView = (FloatingActionButton) findViewById(R.id.fab);

        //It fills in the data.
        Picasso.with(this).load(receivedPromotion.getImage()).into(image);
        title.setText(receivedPromotion.getTitle());
        description.setText(receivedPromotion.getDescription());
        footer.setClickable(true);
        footer.setMovementMethod(LinkMovementMethod.getInstance());
        String text = receivedPromotion.getFooter();
        if (text != null) {
            footer.setText(Html.fromHtml(text));
        }
        fabOpenWebView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String link;
        if (receivedPromotion.getTitle().startsWith(DOLCE_PROMOTION)) {
            link = HOLLISTER;
        }
        else {
            link = ABERCROMBIE;
        }
        WebView webview = new WebView(this);
        webview.loadUrl(link);
    }
}
