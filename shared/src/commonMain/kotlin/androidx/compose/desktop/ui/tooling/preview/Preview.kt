package androidx.compose.desktop.ui.tooling.preview

/**
 * This exists to show a preview of a composable function in the IntelliJ IDE until
 * https://github.com/JetBrains/compose-multiplatform/issues/2045
 * is resolved.
 * Although this is not a live preview like we are used to from Android it is still useful to see a static preview.
 */
@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
expect annotation class Preview()
