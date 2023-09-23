package com.shared.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Large_T1_32Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 38.sp
)

val Large_T2_32Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 40.sp
)

val Large_T2_28Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
    lineHeight = 32.sp,
)

val T2_24Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 32.sp
)

val T1_24Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 28.sp
)
val T1_24Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
    lineHeight = 28.sp
)

val H1_20Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.38.sp
)
val H1_20Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.01.sp
)

val H2_18Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    lineHeight = 24.sp,
)

val H2_18Regular = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp,
    lineHeight = 24.sp,
)

val H2_18Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    lineHeight = 24.sp,
)

val B1_16Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 24.sp
)
val B1_16Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp
)
val B1_16Regular = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val B2_14Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp
)
val B2_14Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.2.sp
)
val B2_14Regular = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = (-0.1).sp
)

val C1_12Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.25.sp
)
val C1_12Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.25.sp
)
val C1_12Regular = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.sp
)

val C2_11Regular = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 11.sp,
    lineHeight = 14.sp,
    letterSpacing = 0.4.sp
)
val C2_11Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp,
    lineHeight = 14.sp,
    letterSpacing = 0.3.sp
)
val C3_8Bold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 8.sp,
    lineHeight = 12.sp,
)
val C3_10Medium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp,
    lineHeight = 12.sp,
)
val C3_10Regular = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 12.sp,
)

val CodeLetter = 24.sp

val CustomTypography = Typography(
    h1 = Large_T1_32Bold,
    h2 = Large_T2_28Bold,
    h3 = T1_24Medium,
    h4 = H1_20Medium,
    h5 = B1_16Medium,
    h6 = B1_16Regular,
    subtitle1 = B2_14Medium,
    subtitle2 = B2_14Regular,
    body1 = B1_16Medium,
    body2 = B2_14Medium,
    button = B1_16Medium,
    caption = C2_11Regular,
    overline = C2_11Regular
)
