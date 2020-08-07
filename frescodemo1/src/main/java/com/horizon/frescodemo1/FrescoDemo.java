package com.horizon.frescodemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.CloneableDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

import java.io.Closeable;
import java.util.BitSet;

/**
 * @author Horizon
 */
public class FrescoDemo extends AppCompatActivity {
    SimpleDraweeView simpleDraweeView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_demo);
        simpleDraweeView=findViewById(R.id.test);
        simpleDraweeView.setImageBitmap(getBitmapFromCache("https://gank.io/api/images/28ff615f01f5400f97a7ce6c085ddf11"));
    }


    private Bitmap getBitmapFromCache(String url){
        Uri uri = Uri.parse(url);
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequest imageRequest = ImageRequest.fromUri(uri);
        DataSource<CloseableReference<CloseableImage>> dataSource =
                imagePipeline.fetchImageFromBitmapCache(imageRequest, CallerThreadExecutor.getInstance());
        try {
            CloseableReference<CloseableImage> imageCloseableReference = dataSource.getResult();
            if (imageCloseableReference != null) {
                try {
                    CloseableBitmap image = (CloseableBitmap) imageCloseableReference.get();
                    Bitmap loadedImage = image.getUnderlyingBitmap();
                    if (loadedImage != null) {
                        return loadedImage;
                    } else {
                        return null;
                    }
                }finally {
                    CloseableReference.closeSafely(imageCloseableReference);
            }
        }
        }finally {
            dataSource.close();
        }
        return null;
    }
}
