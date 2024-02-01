package screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.koin.koinViewModel
import org.koin.core.parameter.parametersOf
import ui.icon.Icons
import ui.icon.icons.ArrowBack
import ui.theme.App

@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel = koinViewModel(DetailViewModel::class) { parametersOf(10) }
    val counter by viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        content = {
                            Icon(
                                imageVector = Icons.ArrowBack,
                                contentDescription = "Home As Up Description",
                                // Showcase a different color
                                tint = App.colors.materialColors.primary,
                            )
                        },
                    )
                },
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                Text(text = "ViewModel Value: $counter")
            }
        },
        modifier = modifier,
    )
}
