package es.avifer.abp.common.extensions

import java.math.RoundingMode
import java.text.DecimalFormat

private const val PATTERN_TWO_DECIMALS = "#,###.00"

fun Double.toFormatTwoDecimal(): String {
    val df = DecimalFormat(PATTERN_TWO_DECIMALS)
    df.roundingMode = RoundingMode.DOWN
    return df.format(this)
}