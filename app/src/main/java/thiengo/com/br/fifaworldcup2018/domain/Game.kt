package thiengo.com.br.fifaworldcup2018.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Game(
        val group: String,
        val countryA: Country,
        val countryB: Country,
        val dateTime: Date,
        val stadium: String) : Parcelable {
    fun generateGroupLabel() = "Grupo $group"

    fun generateDateTimeLabel(): String {
        var gameTime = "${dateTime.getDayOfMonthLabel()}/"
        gameTime += dateTime.getMonthLabel()
        gameTime += " às ${dateTime.getHourOfDayLabel()}:"
        gameTime += dateTime.getMinuteLabel()

        return gameTime
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readParcelable<Country>(Country::class.java.classLoader),
            source.readParcelable<Country>(Country::class.java.classLoader),
            source.readSerializable() as Date,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(group)
        writeParcelable(countryA, 0)
        writeParcelable(countryB, 0)
        writeSerializable(dateTime)
        writeString(stadium)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Game> = object : Parcelable.Creator<Game> {
            override fun createFromParcel(source: Parcel): Game = Game(source)
            override fun newArray(size: Int): Array<Game?> = arrayOfNulls(size)
        }
    }
}