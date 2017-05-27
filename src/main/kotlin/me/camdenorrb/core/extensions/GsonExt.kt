package me.camdenorrb.core.extensions

import java.io.File


fun Any.toJson(): String = gson.toJson(this)

fun Any.writeJsonTo(file: File) = file.write { this.write(toJson()) }


inline fun <reified T> String.readJson(): T = gson.fromJson(this, T::class.java)