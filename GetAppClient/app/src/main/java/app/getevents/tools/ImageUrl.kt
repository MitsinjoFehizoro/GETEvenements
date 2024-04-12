package app.getevents.tools

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import app.getevents.R
import coil.request.ImageRequest
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun imageUrl(url :String) : Painter{
    return rememberCoilPainter(
        request = ImageRequest.Builder(context = LocalContext.current)
            .data(url)
            .build()
    )

//    try{
//        rememberCoilPainter(
//            request = ImageRequest.Builder(context = LocalContext.current)
//                .data("https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg")
//                .build()
//        )
//    }catch (e: Exception) {
//        painterResource(R.drawable.arkeup)
//    }
}