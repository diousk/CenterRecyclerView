package com.diousk.centerrecyclerview.data

import com.diousk.centerrecyclerview.R
import java.util.ArrayList

object Data {
    var mDatabase: ArrayList<Album>? = null
    fun getAlbumDatabase(): List<Album> {
        if (mDatabase != null) {
            return mDatabase as ArrayList<Album>
        }

        val list = ArrayList<Album>()
        list.add(
            Album(
                R.drawable.lonerism,
                "Lonerism",
                "Tame Impala"
            )
        )
        list.add(
            Album(
                R.drawable.art_angels,
                "Art Angels",
                "Grimes"
            )
        )
        list.add(
            Album(
                R.drawable.atlas,
                "Atlas",
                "Real Estate"
            )
        )
        list.add(
            Album(
                R.drawable.born_to_die,
                "Born To Die",
                "Lana del Rey"
            )
        )
        list.add(
            Album(
                R.drawable.coeur_de_pirate, "Coeur de Pirate",
                "Coeur de Pirate"
            )
        )
        list.add(
            Album(
                R.drawable.days_of_abandon, "Days of Abandon",
                "The Pains of Being " + "Pure at Heart"
            )
        )
        list.add(
            Album(
                R.drawable.in_colour,
                "In Colour",
                "Jamie XX"
            )
        )
        list.add(
            Album(
                R.drawable.in_the_mountain,
                "In the Mountain in the Cloud",
                "Portugal. The Man"
            )
        )
        list.add(
            Album(
                R.drawable.melody, "Melody's Echo Chamber",
                "Melody's Echo Chamber"
            )
        )
        list.add(
            Album(
                R.drawable.royal_blood,
                "Royal Blood",
                "Royal Blood"
            )
        )
        list.add(
            Album(
                R.drawable.sun_shy,
                "Sun Shy",
                "Dresses"
            )
        )
        list.add(
            Album(
                R.drawable.the_flower_lane,
                "The Flower Lane",
                "Ducktails"
            )
        )
        list.add(
            Album(
                R.drawable.the_joshua_tree,
                "The Joshua Tree",
                "U2"
            )
        )
        list.add(
            Album(
                R.drawable.the_world_wont_listen,
                "The World Won't Listen",
                "The Smiths"
            )
        )
        list.add(
            Album(
                R.drawable.torches,
                "Torches",
                "Foster the People"
            )
        )
        list.add(
            Album(
                R.drawable.xy,
                "X&Y",
                "Coldplay"
            )
        )
        mDatabase = list
        return list
    }
}