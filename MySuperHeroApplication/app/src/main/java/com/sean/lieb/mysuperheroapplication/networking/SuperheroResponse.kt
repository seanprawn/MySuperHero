package com.sean.lieb.mysuperheroapplication.networking

import com.google.gson.annotations.SerializedName

data class SuperheroResponse (
//    @SerializedName("response"), //Response ok?
    var response: String? = "",
    @SerializedName("results-for") // The search term used
    var resultsFor: String? = "",
//    @SerializedName("results") // List of superheroes that match
    var results: ArrayList<Superhero> = ArrayList<Superhero>()
)

data class Superhero (
//    @SerializedName("id")
    var id: Int = 0,
//    @SerializedName("name")
    var name: String = "",
//    @SerializedName("powerstats")
    var powerstats: PowerStats? = null,
//    @SerializedName("biography")
    var biography: Biography? = null,
//    @SerializedName("appearance")
    var appearance: Appearance? = null,
//    @SerializedName("work")
    var work: Work? = null,
//    @SerializedName("connections")
    var connections: Connections? = null,
//    @SerializedName("image")
    var image: Image? = null
)

data class PowerStats (
//    @SerializedName("intelligence")
    var intelligence: Int = 0,
//    @SerializedName("strength")
    var strength: Int = 0,
//    @SerializedName("speed")
    var speed: Int = 0,
//    @SerializedName("durability")
    var durability: Int = 0,
//    @SerializedName("power")
    var power: Int = 0,
//    @SerializedName("combat")
    var combat: Int = 0
)

data class Biography (
    @SerializedName("full-name")
    var fullName: String = "",
    @SerializedName("alter-egos")
    var alterEgos: String = "",
//    @SerializedName("aliases")
    var aliases: ArrayList<String> = ArrayList<String>(),
    @SerializedName("place-of-birth")
    var placeOfBirth: String = "",
    @SerializedName("first-appearance")
    var firstAppearance: String = "",
//    @SerializedName("publisher")
    var publisher: String = "",
//    @SerializedName("alignment")
    var alignment: String = ""
)

data class Appearance (
//    @SerializedName("gender")
    var gender: String = "",
//    @SerializedName("race")
    var race: String = "",
//    @SerializedName("height")
    var height: ArrayList<String> = ArrayList<String>(),
//    @SerializedName("weight")
    var weight: ArrayList<String> = ArrayList<String>(),
    @SerializedName("eye-color")
    var eyeColor: String = "",
    @SerializedName("hair-color")
    var hairColor: String = ""
)

data class Work (
//    @SerializedName("occupation")
    var occupation: String = "",
//    @SerializedName("base")
    var base: String = ""
)

data class Connections (
    @SerializedName("group-affiliation")
    var affiliation: String = "",
//    @SerializedName("relatives")
    var relatives: String = ""
)


data class Image (
//    @SerializedName("url")
    var url:String = ""
)

