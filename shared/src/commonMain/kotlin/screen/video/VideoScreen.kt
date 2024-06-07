package screen.video

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.component.VideoPlayer

@Composable
fun VideoScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    VideoPlayer(
        url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues = contentPadding)
            .aspectRatio(ratio = 1f)
            .fillMaxWidth(fraction = 0.7f),
    )
}
