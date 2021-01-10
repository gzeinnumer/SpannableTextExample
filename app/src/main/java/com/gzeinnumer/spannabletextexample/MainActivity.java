package com.gzeinnumer.spannabletextexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tv);
        TextView textView2 = findViewById(R.id.tv2);

        style1(textView);

        setColor(textView2, "M Fadli Zein", "Zein", 0xFFCC5500);
    }

    private void style1(TextView textView) {
        SpannableStringBuilder longDescription = new SpannableStringBuilder();
        longDescription.append("First Part Not Bold ");
        int start = longDescription.length();
        longDescription.append("BOLD");
        longDescription.setSpan(new ForegroundColorSpan(0xFFCC5500), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        longDescription.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        longDescription.append(" rest not ");
        start = longDescription.length();
        longDescription.append("bold");
        longDescription.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.teal_200)), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        longDescription.setSpan(new StyleSpan(Typeface.ITALIC), start, longDescription.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(longDescription,  TextView.BufferType.SPANNABLE);
    }

    private void setColor(TextView view, String fulltext, String subtext, int color) {
        view.setText(fulltext, TextView.BufferType.SPANNABLE);
        Spannable str = (Spannable) view.getText();
        int i = fulltext.indexOf(subtext);
        str.setSpan(new ForegroundColorSpan(color), i, i + subtext.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}