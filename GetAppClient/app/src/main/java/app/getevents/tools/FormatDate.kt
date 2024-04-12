package app.getevents.tools

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun FormatDate(dateString : String) : String{
    return  ZonedDateTime.parse(dateString).format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", Locale.FRENCH))
}

@RequiresApi(Build.VERSION_CODES.O)
fun FormatDateHeure(dateString : String) : String{
    return  ZonedDateTime.parse(dateString).format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy à HH:mm", Locale.FRENCH))
}
