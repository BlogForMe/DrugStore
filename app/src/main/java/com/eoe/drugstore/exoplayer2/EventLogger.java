package com.eoe.drugstore.exoplayer2;

import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;

import java.io.IOException;

/**
 * Created by jon on 17-7-2.
 * Logs player event using
 */

public class EventLogger implements ExtractorMediaSource.EventListener {
    private final MappingTrackSelector trackSelector;
    private static final String TAG = "EventLogger";

    public EventLogger(MappingTrackSelector trackSelector) {
        this.trackSelector = trackSelector;
    }

    @Override
    public void onLoadError(IOException error) {
        printInternalError("loadError", error);
    }

    private void printInternalError(String loadError, IOException error) {
//        Log.e(TAG,)
    }
}
