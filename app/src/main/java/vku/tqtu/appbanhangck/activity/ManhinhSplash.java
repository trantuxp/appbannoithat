package vku.tqtu.appbanhangck.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import vku.tqtu.appbanhangck.R;

public class ManhinhSplash extends AppCompatActivity {
    static int tong=1;
    TextView textView;
    ProgressBar progressBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhsplash);

        new ManhinhSplash.congviec().execute();
    }
    public class congviec extends AsyncTask<Void,String,String> {
        protected void onPreExecute() {
            super.onPreExecute();
            textView = (TextView)findViewById(R.id.txt);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            textView.setText("0% ");
        }
        protected String doInBackground(Void... voids) {
            progressBar.setProgress(0);
            for (int i=0; i<102;i+=2) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tong+=2;
                int dem = progressBar.getProgress();
                progressBar.setProgress(dem + 2);
                String phantram =String.valueOf(progressBar.getProgress());
                publishProgress(phantram+"% ");
            }
            return null;
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            finish();
        }
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0]);
            if(progressBar.getProgress()== progressBar.getMax()){
                finish();
            }
        }
    }
}