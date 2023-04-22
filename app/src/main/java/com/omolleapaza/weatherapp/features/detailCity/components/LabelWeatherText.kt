package com.omolleapaza.weatherapp.features.detailCity.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omolleapaza.weatherapp.R
import com.omolleapaza.weatherapp.features.detailCity.theme.fontFamily

@Composable
fun LabelWeatherText(
    label: String,
    type: String
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {

        Text(text = type, fontFamily = fontFamily, color = Color.White, fontWeight = FontWeight.Normal)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = fontFamily,
                            fontSize = 24.sp
                        ),
                    ) {
                        append("$label ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.grayAEAEAE),
                            fontFamily = fontFamily,
                            fontSize = 12.sp
                        ),
                    ) {
                        append("°C")
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }
    }

    
}

@Preview(showBackground = true)
@Composable
fun LabelWeatherTextPreview() {
    Box(modifier = Modifier.background(color = colorResource(id = R.color.gray))) {
        LabelWeatherText(label = "23", type = "Temp. Max")
    }
}
