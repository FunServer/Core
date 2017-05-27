package me.camdenorrb.core.extensions

import java.io.File
import java.io.FileReader
import java.io.FileWriter


fun File.create() {
	check(this.exists().not(), { "The file you tried to create already exists" })
	this.parentFile?.mkdirs().also { createNewFile() }
}

inline fun File.write(write: FileWriter.() -> Unit) {
	this.parentFile?.mkdirs()
	FileWriter(this).use(write)
}


inline fun <R> File.read(reader: FileReader.() -> R): R = FileReader(this).use(reader)

inline fun File.readOrCreate(reader: FileReader.() -> Unit) {
	if (this.parentFile == null || this.parentFile.mkdirs()) return
	return FileReader(this).use(reader)
}

inline fun <reified T> File.readJson(): T? {
	if (this.exists().not()) return null
	return this.read { gson.fromJson(this, T::class.java) }
}

inline fun <reified T> File.readJson(onDoesNotExist: () -> T): T {
	if (this.exists().not()) return onDoesNotExist()
	return this.read { gson.fromJson(this, T::class.java) }
}

inline fun <reified T> File.readJson(defaultValue: T): T {
	if (this.exists().not()) return defaultValue.apply { writeJsonTo(this@readJson) }
	return this.read { gson.fromJson(this, T::class.java) }
}