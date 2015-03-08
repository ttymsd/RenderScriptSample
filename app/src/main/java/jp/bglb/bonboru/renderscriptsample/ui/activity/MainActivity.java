package jp.bglb.bonboru.renderscriptsample.ui.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import jp.bglb.bonboru.renderscriptsample.R;
import jp.bglb.bonboru.renderscriptsample.helper.RenderScriptHelper;

public class MainActivity extends Activity {

    private RenderScriptHelper mRenderScriptHelper;

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRenderScriptHelper = new RenderScriptHelper(this);
        mImageView = (ImageView) findViewById(R.id.image);
        mImageView.setImageResource(R.drawable.ic_launcher);
        findViewById(R.id.convert).setOnClickListener(mConvertClick);
    }

    private View.OnClickListener mConvertClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
            Bitmap converted = mRenderScriptHelper.toMono(bmp);
            bmp.recycle();
            mImageView.setImageBitmap(converted);
        }
    };
}
