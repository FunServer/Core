package me.camdenorrb.core

import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by camdenorrb on 5/25/17.
 */

class Core : JavaPlugin() {

	override fun onLoad() { instance = this }

	override fun onEnable() = Unit

	override fun onDisable() = Unit


	companion object {

		lateinit var instance: Core
			private set

	}

}