package screen.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import composemultiplatform.shared.generated.resources.Res
import composemultiplatform.shared.generated.resources.compose_multiplatform
import composemultiplatform.shared.generated.resources.example_ai_image
import composemultiplatform.shared.generated.resources.hello_world
import composemultiplatform.shared.generated.resources.plural_example
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.pluralStringResource
import org.jetbrains.compose.resources.stringResource
import ui.theme.App
import ui.theme.AppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onClick: () -> Unit = {},
) {
    var image by remember { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxSize()
            .padding(contentPadding),
    ) {
        Text(
            text = "Headline headline hEaDlInE HeAdLiNe headline hEaDlInE HeAdLiNe headline hEaDlInE HeAdLiNe",
            style = App.typographies.headline,
            modifier = Modifier.testTag("tagHeadline"),
        )
        Text(
            text = "Subline subline sUbLiNe SuBlInE subline sUbLiNe SuBlInE subline sUbLiNe SuBlInE",
            style = App.typographies.subline,
            modifier = Modifier.testTag("tagSubline"),
        )
        Text(
            text = "Body body bOdY BoDy body bOdY BoDy body bOdY BoDy body bOdY BoDy body bOdY BoDy body bOdY BoDy",
            style = App.typographies.body,
        )
        Text(
            text = "Copy copy cOpY CoPy copy cOpY CoPy copy cOpY CoPy copy cOpY CoPy copy cOpY CoPy copy cOpY CoPy",
            style = App.typographies.copy,
        )
        Text(
            text = pluralStringResource(Res.plurals.plural_example, 0, "Example"),
            style = App.typographies.copy,
        )
        Text(
            text = pluralStringResource(Res.plurals.plural_example, 1, "Example"),
            style = App.typographies.copy,
        )
        Text(
            text = pluralStringResource(Res.plurals.plural_example, 2, "Example"),
            style = App.typographies.copy,
        )
        Text(
            text = pluralStringResource(Res.plurals.plural_example, 5, "Example"),
            style = App.typographies.copy,
            modifier = Modifier.clickable(role = Role.Image, onClick = {}),
        )
        Button(
            onClick = { image = (image + 1) % 3 },
            modifier = Modifier.testTag("tagButton"),
        ) {
            Text(text = stringResource(Res.string.hello_world))
        }
        AnimatedContent(
            targetState = image,
            transitionSpec = {
                (fadeIn() + slideInVertically { -it }) togetherWith (fadeOut() + slideOutVertically { -it })
            },
        ) { imageState ->
            when (imageState) {
                0 -> Image(
                    painterResource(Res.drawable.compose_multiplatform),
                    null,
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                )

                1 -> Image(
                    painterResource(Res.drawable.example_ai_image),
                    null,
                    modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                )

                else -> Text(text = "No image")
            }
        }
    }
}

@org.jetbrains.compose.ui.tooling.preview.Preview
@Composable
private fun PreviewWithinFleet() {
    AppTheme {
        HomeScreen()
    }
}

@androidx.compose.desktop.ui.tooling.preview.Preview
@Composable
private fun PreviewWithinIntelliJ() {
    AppTheme {
        HomeScreen()
    }
}
