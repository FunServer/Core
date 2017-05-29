package me.camdenorrb.core

import com.google.gson.GsonBuilder
import me.camdenorrb.core.aliases.Accounts
import me.camdenorrb.core.aliases.Commands
import me.camdenorrb.core.cmd.cmds.TestCmd
import me.camdenorrb.core.gson.LocationAdapter
import me.camdenorrb.minibus.MiniBus
import org.bukkit.Location
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by camdenorrb on 5/25/17.
 */

class Core : JavaPlugin() {

	val miniBus = MiniBus()

	val commands: Commands = mutableSetOf()
	val accounts: Accounts = mutableMapOf()

	val gson = GsonBuilder().setPrettyPrinting().registerTypeAdapter(Location::class.java, LocationAdapter()).create()!!


	override fun onLoad() {
		instance = this
	}

	override fun onEnable() {
		commands.add(TestCmd())
	}


	override fun onDisable() {
		commands.clear()
		accounts.clear()
		miniBus.cleanUp()
	}


	companion object {

		lateinit var instance: Core
			private set

	}

}