package com.example.composeproject.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import nl.dionsegijn.konfetti.KonfettiView

@Composable
fun ShowCelebration() {

    AndroidView(

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp),
        factory = { ctx ->

            KonfettiView(context = ctx).apply {

            }

        },

        update = {
            it.build()
                .addColors(
                    android.graphics.Color.YELLOW,
                    android.graphics.Color.GREEN,
                    android.graphics.Color.MAGENTA
                )
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(1000L)
                .setPosition(-50f, -50f, -50f)
                .streamFor(300, 5000L)

        }
    )

}