package me.camdenorrb.core.extensions


fun <T> MutableCollection<T>.add(vararg values: T) = this.addAll(values)