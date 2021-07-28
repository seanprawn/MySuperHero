package com.sean.lieb.mysuperheroapplication.database

import android.telephony.CellSignalStrength
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "superheroes")
data class Superhero(
    @PrimaryKey val id: Int,
    val name: String?,
    @Embedded val powerStats: PowerStats?,
    @Embedded val biography: Biography?,
    @Embedded val appearance: Appearance?,
    @Embedded val work: Work?,
    @Embedded val connections: Connections?,
    @Embedded val image: Image?
)

data class PowerStats(
    val intelligence: String?,
    val strength: String?,
    val speed: String?,
    val durability: String?,
    val power: String?
)

data class Biography(
    @ColumnInfo(name = "full_name") val fullName: String?,
    @ColumnInfo(name = "alter_egos") val alterEgos: String?,
    val aliases: String?, //???? string array?
    @ColumnInfo(name = "place_of_birth")val placeOfBirth: String?,
    @ColumnInfo(name = "first_appearance")val firstAppearance: String?,
    val publisher: String?,
    val alignment: String?
)

data class Appearance(
    val gender: String?,
    val race: String?,
    val height: String?, //???? string array?
    val weight: String?, //???? string array?
    @ColumnInfo(name = "eye_color") val eyeColor: String?,
    @ColumnInfo(name = "hair_color") val hairColor: String?
)
data class Work(
    val occupation: String?,
    val base: String?
)

data class Connections(
    @ColumnInfo(name = "group_affiliation") val groupAffiliation: String?,
    val relatives: String?
)

data class Image(
    val url: String?
)