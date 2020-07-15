package com.roboticsworld.sharpminds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.text.util.Linkify;



public class ContactFragment extends Fragment{
    TextView tvMail;
    private static final String HTML ="<!DOCTYPE html><html><body><a href='tel:03158173978' style='color:white;font-size:160%;'>0315-8173978</a></body></html>";
    private static final String TEL_PREFIX = "tel:";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        WebView wv = view.findViewById(R.id.webview);
        wv.setWebViewClient(new CustomWebViewClient());
        wv.setBackgroundColor(getResources().getColor(R.color.blue));

        wv.loadData(HTML, "text/html", "utf-8");
        tvMail = view.findViewById(R.id.mail);
        tvMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","roboticsworld14@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
        return view;
    }
    private class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView wv, String url) {
            if (url.startsWith(TEL_PREFIX)) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            }
            return false;
        }
    }

}
