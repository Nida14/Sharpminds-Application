package com.roboticsworld.sharpminds;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;



public class TutorialFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        VideoView videoView = view.findViewById(R.id.video_view);
       // String videoPath = "android.resource://" + view.getContext().getPackageName() + "/" + R.raw.abacus;
       // Uri uri = Uri.parse(videoPath);
       // videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        return view;

    }
}
