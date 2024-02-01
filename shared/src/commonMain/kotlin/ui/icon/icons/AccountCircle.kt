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

val Icons.AccountCircle: ImageVector
    get() {
        if (_accountCircle != null) {
            return _accountCircle!!
        }
        _accountCircle = Builder(
            name = "AccountCircle",
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
                moveTo(234.0f, 684.0f)
                quadToRelative(51.0f, -39.0f, 114.0f, -61.5f)
                reflectiveQuadTo(480.0f, 600.0f)
                quadToRelative(69.0f, 0.0f, 132.0f, 22.5f)
                reflectiveQuadTo(726.0f, 684.0f)
                quadToRelative(35.0f, -41.0f, 54.5f, -93.0f)
                reflectiveQuadTo(800.0f, 480.0f)
                quadToRelative(0.0f, -133.0f, -93.5f, -226.5f)
                reflectiveQuadTo(480.0f, 160.0f)
                quadToRelative(-133.0f, 0.0f, -226.5f, 93.5f)
                reflectiveQuadTo(160.0f, 480.0f)
                quadToRelative(0.0f, 59.0f, 19.5f, 111.0f)
                reflectiveQuadToRelative(54.5f, 93.0f)
                close()
                moveTo(480.0f, 520.0f)
                quadToRelative(-59.0f, 0.0f, -99.5f, -40.5f)
                reflectiveQuadTo(340.0f, 380.0f)
                quadToRelative(0.0f, -59.0f, 40.5f, -99.5f)
                reflectiveQuadTo(480.0f, 240.0f)
                quadToRelative(59.0f, 0.0f, 99.5f, 40.5f)
                reflectiveQuadTo(620.0f, 380.0f)
                quadToRelative(0.0f, 59.0f, -40.5f, 99.5f)
                reflectiveQuadTo(480.0f, 520.0f)
                close()
                moveTo(480.0f, 880.0f)
                quadToRelative(-83.0f, 0.0f, -156.0f, -31.5f)
                reflectiveQuadTo(197.0f, 763.0f)
                quadToRelative(-54.0f, -54.0f, -85.5f, -127.0f)
                reflectiveQuadTo(80.0f, 480.0f)
                quadToRelative(0.0f, -83.0f, 31.5f, -156.0f)
                reflectiveQuadTo(197.0f, 197.0f)
                quadToRelative(54.0f, -54.0f, 127.0f, -85.5f)
                reflectiveQuadTo(480.0f, 80.0f)
                quadToRelative(83.0f, 0.0f, 156.0f, 31.5f)
                reflectiveQuadTo(763.0f, 197.0f)
                quadToRelative(54.0f, 54.0f, 85.5f, 127.0f)
                reflectiveQuadTo(880.0f, 480.0f)
                quadToRelative(0.0f, 83.0f, -31.5f, 156.0f)
                reflectiveQuadTo(763.0f, 763.0f)
                quadToRelative(-54.0f, 54.0f, -127.0f, 85.5f)
                reflectiveQuadTo(480.0f, 880.0f)
                close()
                moveTo(480.0f, 800.0f)
                quadToRelative(53.0f, 0.0f, 100.0f, -15.5f)
                reflectiveQuadToRelative(86.0f, -44.5f)
                quadToRelative(-39.0f, -29.0f, -86.0f, -44.5f)
                reflectiveQuadTo(480.0f, 680.0f)
                quadToRelative(-53.0f, 0.0f, -100.0f, 15.5f)
                reflectiveQuadTo(294.0f, 740.0f)
                quadToRelative(39.0f, 29.0f, 86.0f, 44.5f)
                reflectiveQuadTo(480.0f, 800.0f)
                close()
                moveTo(480.0f, 440.0f)
                quadToRelative(26.0f, 0.0f, 43.0f, -17.0f)
                reflectiveQuadToRelative(17.0f, -43.0f)
                quadToRelative(0.0f, -26.0f, -17.0f, -43.0f)
                reflectiveQuadToRelative(-43.0f, -17.0f)
                quadToRelative(-26.0f, 0.0f, -43.0f, 17.0f)
                reflectiveQuadToRelative(-17.0f, 43.0f)
                quadToRelative(0.0f, 26.0f, 17.0f, 43.0f)
                reflectiveQuadToRelative(43.0f, 17.0f)
                close()
                moveTo(480.0f, 380.0f)
                close()
                moveTo(480.0f, 740.0f)
                close()
            }
        }.build()
        return _accountCircle!!
    }

private var _accountCircle: ImageVector? = null
