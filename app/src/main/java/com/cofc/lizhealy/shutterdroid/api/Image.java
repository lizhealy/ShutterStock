package com.cofc.lizhealy.shutterdroid.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lizhealy on 1/4/17.
 */

public class Image {
    @SerializedName("id")
    private String mId;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("assets")
    private ImageAssets mAssets;

    public String getId() {
        return mId;
    }
    public String getDescription() {
        return mDescription;
    }
    public String getLargeThumbnail() {
        return mAssets.mLarge_thumb.mUrl;
    }

    private class ImageAssets {
        @SerializedName("preview")
        private Thumbnail mPreview;
        @SerializedName("small_thumb")
        private Thumbnail mSmall_thumb;
        @SerializedName("large_thumb")
        private Thumbnail mLarge_thumb;
    }

    private class Thumbnail {
        @SerializedName("url")
        private String mUrl;

    }
}
