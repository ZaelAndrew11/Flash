package cl.aguzman.flash.views.main.drawer;

import android.content.Context;

import cl.aguzman.flash.data.PhotoPreference;

public class PhotoValidate {
    private Context context;
    private  PhotoCallback callback;

    public PhotoValidate(Context context, PhotoCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void validate(){
        String url = new PhotoPreference(context).getPhoto();
        if (url != null){
            callback.photoAvailable(url);
        }else{
            callback.emptyPhoto();
        }
    }
}
