package resource

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringArrayResource

private val simpleStringFormatRegex = Regex("""%(\d)\$[ds]""")

@Composable
fun pluralResource(resource: StringResource, count: Int, vararg formatArgs: Any): String {
    val stringArray = stringArrayResource(resource)
    val pluralString = when (count) {
        0 -> stringArray[0]
        1 -> stringArray[1]
        else -> stringArray[2]
    }
    val args = formatArgs.map { it.toString() }
    return simpleStringFormatRegex.replace(pluralString) { matchResult -> args[matchResult.groupValues[1].toInt() - 1] }
}
