package com.example.quadexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.upstream.DefaultAllocator
import androidx.media3.ui.PlayerView

class MainActivity : Activity() {
    private var allocator: DefaultAllocator? = null
    private val players = ArrayList<Player>()
    private val playerViews = ArrayList<PlayerView>()
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerViews.add(findViewById(R.id.playerView))
        playerViews.add(findViewById(R.id.playerView2))
        playerViews.add(findViewById(R.id.playerView3))
        playerViews.add(findViewById(R.id.playerView4))
        handler = Handler(mainLooper)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        releasePlayers()
        setIntent(intent)
    }

    override fun onStart() {
        super.onStart()
        initializePlayers()
        if (playerViews.isNotEmpty()) {
            playerViews.forEach { it.onResume() }
        }
    }

    override fun onResume() {
        super.onResume()
        if (players.isEmpty()) {
            initializePlayers()
            if (playerViews.isNotEmpty()) {
                playerViews.forEach { it.onResume() }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (playerViews.isNotEmpty()) {
            playerViews.forEach { it.onPause() }
        }
        releasePlayers()
    }


    /**
     * @return Whether initialization was successful.
     */
    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    private fun initializePlayers(): Boolean {
        if (players.isEmpty()) {
            if (allocator == null)
                allocator = DefaultAllocator(false, C.DEFAULT_BUFFER_SEGMENT_SIZE)
            playerViews.forEach {
                val player = ExoPlayer.Builder(this)
                    .setLoadControl(
                        DefaultLoadControl.Builder()
                            .setAllocator(allocator!!)
                            .build())
                    .build()
                player.playWhenReady = true
                player.repeatMode = Player.REPEAT_MODE_ONE
                it.player = player
                players.add(player)
            }
        }
        var delay = 0L
        players.forEach {
            handler.postDelayed({
                it.setMediaItem(
                    MediaItem.Builder()
                        .setUri("https://storage.googleapis.com/exoplayer-test-media-1/60fps/bbb-clear-1080/video.mp4")
                        .build()
                )
                it.prepare()
            }, delay)
            delay += 1000L
        }
        return true
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    private fun  releasePlayers() {
        players.forEach { it.release() }
        playerViews.forEach { it.player = null }
        players.clear()
        allocator?.reset()
        allocator = null
    }
}