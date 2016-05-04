package me.bayupaoh.bayumix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.imagefilter.Sif;
import com.samsung.android.sdk.imagefilter.SifImageFilter;

public class MainActivity extends AppCompatActivity {

    ImageView imgFotoBefore;
    ImageView imgFotoAfter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deklarasiWidget();
        try {
            deklarasiSif();
        } catch (SsdkUnsupportedException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void deklarasiSif() throws SsdkUnsupportedException {
        Sif sif = new Sif();

        sif.initialize(this);
        Bitmap fotoAsli = BitmapFactory.decodeResource(getResources(),R.drawable.unikom);

        Bitmap fotoEdit = SifImageFilter.filterImageCopy(fotoAsli,SifImageFilter.FILTER_COLOR_SKETCH,SifImageFilter.LEVEL_MEDIUM);

        imgFotoBefore.setImageBitmap(fotoAsli);
        imgFotoAfter.setImageBitmap(fotoEdit);

    }

    private void deklarasiWidget() {
        imgFotoBefore = (ImageView) findViewById(R.id.img_main_fotobefore);
        imgFotoAfter = (ImageView) findViewById(R.id.img_main_fotoafter);
    }
}
