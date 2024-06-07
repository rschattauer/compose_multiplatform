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

public val Icons.DateRange: ImageVector
    get() {
        if (_dateRange != null) {
            return _dateRange!!
        }
        _dateRange = Builder(
            name = "DateRange",
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
                moveTo(320.0f, 560.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(280.0f, 520.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(320.0f, 480.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(360.0f, 520.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(320.0f, 560.0f)
                close()
                moveTo(480.0f, 560.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(440.0f, 520.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(480.0f, 480.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(520.0f, 520.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(480.0f, 560.0f)
                close()
                moveTo(640.0f, 560.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(600.0f, 520.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(640.0f, 480.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(680.0f, 520.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(640.0f, 560.0f)
                close()
                moveTo(200.0f, 880.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                reflectiveQuadTo(120.0f, 800.0f)
                verticalLineToRelative(-560.0f)
                quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                reflectiveQuadTo(200.0f, 160.0f)
                horizontalLineToRelative(40.0f)
                verticalLineToRelative(-80.0f)
                horizontalLineToRelative(80.0f)
                verticalLineToRelative(80.0f)
                horizontalLineToRelative(320.0f)
                verticalLineToRelative(-80.0f)
                horizontalLineToRelative(80.0f)
                verticalLineToRelative(80.0f)
                horizontalLineToRelative(40.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                reflectiveQuadTo(840.0f, 240.0f)
                verticalLineToRelative(560.0f)
                quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                reflectiveQuadTo(760.0f, 880.0f)
                lineTo(200.0f, 880.0f)
                close()
                moveTo(200.0f, 800.0f)
                horizontalLineToRelative(560.0f)
                verticalLineToRelative(-400.0f)
                lineTo(200.0f, 400.0f)
                verticalLineToRelative(400.0f)
                close()
                moveTo(200.0f, 320.0f)
                horizontalLineToRelative(560.0f)
                verticalLineToRelative(-80.0f)
                lineTo(200.0f, 240.0f)
                verticalLineToRelative(80.0f)
                close()
                moveTo(200.0f, 320.0f)
                verticalLineToRelative(-80.0f)
                verticalLineToRelative(80.0f)
                close()
            }
        }.build()
        return _dateRange!!
    }

private var _dateRange: ImageVector? = null
