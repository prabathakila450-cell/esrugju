package com.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/**
 * App Launch Screen (මුහුණත) displayed immediately upon opening the app.
 * Displays the high-resolution official O/L.LK poster clearly with all parts visible.
 * Allows instant tap-to-continue or automatically transitions into the main app.
 */
@Composable
fun AppLaunchSplashScreen(
  visible: Boolean,
  onDismiss: () -> Unit
) {
  LaunchedEffect(visible) {
    if (visible) {
      delay(2600)
      onDismiss()
    }
  }

  AnimatedVisibility(
    visible = visible,
    enter = fadeIn(),
    exit = fadeOut()
  ) {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF10151B))
        .testTag("app_launch_splash_screen")
        .clickable(
          interactionSource = remember { MutableInteractionSource() },
          indication = null,
          onClick = onDismiss
        ),
      contentAlignment = Alignment.Center
    ) {
      // High-resolution full welcome launch poster (100% visible, no parts cropped)
      Image(
        painter = painterResource(id = R.drawable.img_app_splash_screen_1791620889780),
        contentDescription = "සාමාන්‍ය පෙළ ඉලක්කය O/L.LK",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Fit
      )

      // Subtle modern cyan loading indicator at bottom
      CircularProgressIndicator(
        modifier = Modifier
          .align(Alignment.BottomCenter)
          .padding(bottom = 36.dp)
          .size(26.dp),
        color = Color(0xFF00E5FF),
        strokeWidth = 2.5.dp
      )
    }
  }
}
