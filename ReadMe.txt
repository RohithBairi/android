MVP Design Pattern Example

In MVP the three classes are defined as follows:

The model is an interface defining the data to be displayed or otherwise acted upon in the user interface.
The view is a passive interface that displays data (from the model) and routes user commands (events) to the presenter to act upon that data.
The presenter acts upon the model and the view. It retrieves data from repositories (the model), and formats it for display in the view.

Creating the Model class and presenter  -> MainActivityPresenter.java

Presenter::
The methods of this class contain core business logic which will decide what to display and how to display. 
It triggers the View class to make the necessary changes to the UI.
Which returns view to the Main Activity (Attaching view and persenter)

View ::
The View class is responsible for updating the UI according to the changes triggered by the Presenter layer. 
The data provided by the Model will be used by View and the appropriate changes will be made in the activity. 

Advantages of MVP Architecture
No conceptual relationship in android components
Easy code maintenance and testing as the application’s model, view, and presenter layer are separated.

package com.mis.btmusic.media;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.PlaybackState;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;

/**
 * interface for media play controls
 */
public interface IMediaPlayControl {
    void init(Context context);
    void unInit();
    void registerMediaListener(IMediaListener listener);
    void unRegisterMediaListener(IMediaListener listener);
    boolean isConnected();
    boolean isLoading();
    void requestNowPlayingList();
    void requestLibsList();
    void requestFolderItemList(MediaBrowser.MediaItem mediaItem);
    void playMediaItem(MediaBrowser.MediaItem mediaItem);
    void playMediaForMediaId(String mediaId);
    boolean prepare();
    boolean play();
    boolean pause();
    boolean playPause();
    boolean skipToNext();
    boolean skipToPrevious();
    boolean stop();
    boolean rewind();
    boolean fastforward();
    void back();
    boolean isPlaying(PlaybackState state);
    PlaybackState getPlaybackState();
    MediaMetadata getMediaMetadata();
    //MediaManager.RequestType getCurrentFolderType();
    int getCurrentDepth();
    void notifyUpdateMediaMetadata();
    void setDeviceSupportMusicList(int deviceId, boolean support);
    boolean getDeviceSupportMusicList(int deviceId);
    void modeStart();
    void modeEnd();
    long getPosition();
    long getDuration();
}


package com.mis.btmusic.media;

import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.PlaybackState;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;

import java.util.List;

/**
 * Interface for listener in activity context.
 */
public interface IMediaListener {
    default void onMediaServiceConnected(){}
    default void onMediaServiceConnectionFailed(){}
    default void onMediaServiceDisconnected(){}
    default void onMediaNowPlayingLoaded(String parentId, List<MediaBrowser.MediaItem> mediaItemList){}
    default void onMediaLibsLoaded(String parentId, List<MediaBrowser.MediaItem> mediaItemList, String subFolderName){}
    default void onMediaItemLoadFailed(String parentId){}
    default void onMediaItemEmptyLoaded(String parentId, boolean isEmpty){}
    default void onMediaPlaybackStateChanged(PlaybackState state){}
    default void onMediaMetadataChanged(MediaMetadata metadata){}
    default void onMediaProgressUpdate(long position, long length){}
    default void onMeta(MediaMetadata metadata){}
    default void onMeta(String metadata){}
    default void onArtistReceived(String artist) { }
    default void onAlbumReceived(String album) {}

}
