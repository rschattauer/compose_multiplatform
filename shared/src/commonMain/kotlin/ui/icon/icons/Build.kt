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

val Icons.Build: ImageVector
    get() {
        if (_build != null) {
            return _build!!
        }
        _build = Builder(
            name = "Build",
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
                moveTo(686.0f, 828.0f)
                lineTo(444.0f, 584.0f)
                quadToRelative(-20.0f, 8.0f, -40.5f, 12.0f)
                reflectiveQuadToRelative(-43.5f, 4.0f)
                quadToRelative(-100.0f, 0.0f, -170.0f, -70.0f)
                reflectiveQuadToRelative(-70.0f, -170.0f)
                quadToRelative(0.0f, -36.0f, 10.0f, -68.5f)
                reflectiveQuadToRelative(28.0f, -61.5f)
                lineToRelative(146.0f, 146.0f)
                lineToRelative(72.0f, -72.0f)
                lineToRelative(-146.0f, -146.0f)
                quadToRelative(29.0f, -18.0f, 61.5f, -28.0f)
                reflectiveQuadToRelative(68.5f, -10.0f)
                quadToRelative(100.0f, 0.0f, 170.0f, 70.0f)
                reflectiveQuadToRelative(70.0f, 170.0f)
                quadToRelative(0.0f, 23.0f, -4.0f, 43.5f)
                reflectiveQuadTo(584.0f, 444.0f)
                lineToRelative(244.0f, 242.0f)
                quadToRelative(12.0f, 12.0f, 12.0f, 29.0f)
                reflectiveQuadToRelative(-12.0f, 29.0f)
                lineToRelative(-84.0f, 84.0f)
                quadToRelative(-12.0f, 12.0f, -29.0f, 12.0f)
                reflectiveQuadToRelative(-29.0f, -12.0f)
                close()
                moveTo(715.0f, 743.0f)
                lineTo(742.0f, 716.0f)
                lineTo(486.0f, 460.0f)
                quadToRelative(18.0f, -20.0f, 26.0f, -46.5f)
                reflectiveQuadToRelative(8.0f, -53.5f)
                quadToRelative(0.0f, -60.0f, -38.5f, -104.5f)
                reflectiveQuadTo(386.0f, 202.0f)
                lineToRelative(74.0f, 74.0f)
                quadToRelative(12.0f, 12.0f, 12.0f, 28.0f)
                reflectiveQuadToRelative(-12.0f, 28.0f)
                lineTo(332.0f, 460.0f)
                quadToRelative(-12.0f, 12.0f, -28.0f, 12.0f)
                reflectiveQuadToRelative(-28.0f, -12.0f)
                lineToRelative(-74.0f, -74.0f)
                quadToRelative(9.0f, 57.0f, 53.5f, 95.5f)
                reflectiveQuadTo(360.0f, 520.0f)
                quadToRelative(26.0f, 0.0f, 52.0f, -8.0f)
                reflectiveQuadToRelative(47.0f, -25.0f)
                lineToRelative(256.0f, 256.0f)
                close()
                moveTo(472.0f, 472.0f)
                close()
            }
        }.build()
        return _build!!
    }

private var _build: ImageVector? = null
