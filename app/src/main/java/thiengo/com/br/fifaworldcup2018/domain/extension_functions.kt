package thiengo.com.br.fifaworldcup2018.domain

import java.util.*


fun Date.getMonthLabel() : String{
    return getHumanLabel( Calendar.MONTH )
}

fun Date.getDayOfMonthLabel() : String{
    return getHumanLabel( Calendar.DAY_OF_MONTH )
}

fun Date.getHourOfDayLabel() : String{
    return getHumanLabel( Calendar.HOUR_OF_DAY )
}

fun Date.getMinuteLabel() : String{
    return getHumanLabel( Calendar.MINUTE )
}

private fun Date.getHumanLabel( type: Int ) : String{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.time

    val number = calendar.get(type)
    return if( number < 10 )
        "0$number"
    else
        number.toString()
}
