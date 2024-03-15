package com.example.test.ui.videoscreen

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : Fragment() {

    private lateinit var videoPlayer: YouTubePlayerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoPlayer = view.findViewById(R.id.video_player)
        videoPlayer.apply {
            setBackgroundColor(Color.TRANSPARENT)
            enableAutomaticInitialization = false

            initialize(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = "QKWAvLeayec"
                    youTubePlayer.loadVideo(videoId, 0f)
                    setCustomPlayerUi(
                        DefaultPlayerUiController(
                            this@apply,
                            youTubePlayer
                        ).rootView
                    )
                }
            }, IFramePlayerOptions.Builder().controls(0).build())

            lifecycle.addObserver(this)
        }
    }
}