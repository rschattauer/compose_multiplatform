package ui.icon.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ui.icon.Icons

val Icons.Mail: ImageVector
    get() {
        if (_mail != null) {
            return _mail!!
        }
        _mail = Builder(
            name = "Mail",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0f,
            viewportHeight = 960.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(160.0f, 800.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                reflectiveQuadTo(80.0f, 720.0f)
                verticalLineToRelative(-480.0f)
                quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                reflectiveQuadTo(160.0f, 160.0f)
                horizontalLineToRelative(640.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                reflectiveQuadTo(880.0f, 240.0f)
                verticalLineToRelative(480.0f)
                quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                reflectiveQuadTo(800.0f, 800.0f)
                lineTo(160.0f, 800.0f)
                close()
                moveTo(480.0f, 520.0f)
                lineTo(160.0f, 320.0f)
                verticalLineToRelative(400.0f)
                horizontalLineToRelative(640.0f)
                verticalLineToRelative(-400.0f)
                lineTo(480.0f, 520.0f)
                close()
                moveTo(480.0f, 440.0f)
                lineTo(800.0f, 240.0f)
                lineTo(160.0f, 240.0f)
                lineToRelative(320.0f, 200.0f)
                close()
                moveTo(160.0f, 320.0f)
                verticalLineToRelative(-80.0f)
                verticalLineToRelative(480.0f)
                verticalLineToRelative(-400.0f)
                close()
            }
        }.build()
        return _mail!!
    }

private var _mail: ImageVector? = null
