package com.elano.recipelist.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Jess on 12/5/2017.
 */
data class RecipeInfo(
        var name: String = "",
        var description: String = "",
        var image: Int = 0,
        var ingredients: String = "",
        var procedures: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(image)
        parcel.writeString(ingredients)
        parcel.writeString(procedures)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecipeInfo> {
        override fun createFromParcel(parcel: Parcel): RecipeInfo {
            return RecipeInfo(parcel)
        }

        override fun newArray(size: Int): Array<RecipeInfo?> {
            return arrayOfNulls(size)
        }
    }
}