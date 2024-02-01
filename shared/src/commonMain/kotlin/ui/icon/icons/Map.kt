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

val Icons.Map: ImageVector
    get() {
        if (_map != null) {
            return _map!!
        }
        _map = Builder(
            name = "Map",
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
                moveToRelative(600.0f, 840.0f)
                lineToRelative(-240.0f, -84.0f)
                lineToRelative(-186.0f, 72.0f)
                quadToRelative(-20.0f, 8.0f, -37.0f, -4.5f)
                reflectiveQuadTo(120.0f, 790.0f)
                verticalLineToRelative(-560.0f)
                quadToRelative(0.0f, -13.0f, 7.5f, -23.0f)
                reflectiveQuadToRelative(20.5f, -15.0f)
                lineToRelative(212.0f, -72.0f)
                lineToRelative(240.0f, 84.0f)
                lineToRelative(186.0f, -72.0f)
                quadToRelative(20.0f, -8.0f, 37.0f, 4.5f)
                reflectiveQuadToRelative(17.0f, 33.5f)
                verticalLineToRelative(560.0f)
                quadToRelative(0.0f, 13.0f, -7.5f, 23.0f)
                reflectiveQuadTo(812.0f, 768.0f)
                lineToRelative(-212.0f, 72.0f)
                close()
                moveTo(560.0f, 742.0f)
                verticalLineToRelative(-468.0f)
                lineToRelative(-160.0f, -56.0f)
                verticalLineToRelative(468.0f)
                lineToRelative(160.0f, 56.0f)
                close()
                moveTo(640.0f, 742.0f)
                lineTo(760.0f, 702.0f)
                verticalLineToRelative(-474.0f)
                lineToRelative(-120.0f, 46.0f)
                verticalLineToRelative(468.0f)
                close()
                moveTo(200.0f, 732.0f)
                lineTo(320.0f, 686.0f)
                verticalLineToRelative(-468.0f)
                lineToRelative(-120.0f, 40.0f)
                verticalLineToRelative(474.0f)
                close()
                moveTo(640.0f, 274.0f)
                verticalLineToRelative(468.0f)
                verticalLineToRelative(-468.0f)
                close()
                moveTo(320.0f, 218.0f)
                verticalLineToRelative(468.0f)
                verticalLineToRelative(-468.0f)
                close()
            }
        }.build()
        return _map!!
    }

private var _map: ImageVector? = null
