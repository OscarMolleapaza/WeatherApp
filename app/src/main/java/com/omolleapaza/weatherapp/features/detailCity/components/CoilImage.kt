package com.omolleapaza.weatherapp.features.detailCity.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.omolleapaza.weatherapp.R

@Composable
fun CoilImage(
    urlImg: String,
    @DrawableRes debugPreview: Int = R.drawable.ic_launcher_background,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(urlImg)
            .error(debugPreview)
            .crossfade(true)
            .build(),
        placeholder = debugPlaceholder(debugPreview = debugPreview),
        contentDescription = stringResource(R.string.img_desc_image_city),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(30.dp)
            .height(20.dp)
            .clip(RoundedCornerShape(5.dp)),
    )
}

@Composable
private fun debugPlaceholder(@DrawableRes debugPreview: Int): Painter? {
    return if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }
}
