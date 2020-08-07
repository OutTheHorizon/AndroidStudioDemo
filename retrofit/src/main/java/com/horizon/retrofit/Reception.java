package com.horizon.retrofit;

import android.util.Log;

import java.util.List;

/**
 * @Author lhh
 * @ClasssName Reception
 * @Description
 * @UpdateDate 2020/8/7 4:20 PM
 */
public class Reception {
    List<ImageData> data;
    int status;

    public List<ImageData> getData() {
        return data;
    }

    public void setData(List<ImageData> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    public void show() {
//        Log.d("Horizon", "1");
//    }

    public class ImageData{
        String image;
        String title;
        String url;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
