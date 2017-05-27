package me.camdenorrb.core.extensions

import com.google.gson.Gson
import me.camdenorrb.core.Core
import me.camdenorrb.core.aliases.Accounts
import me.camdenorrb.core.aliases.Commands
import me.camdenorrb.minibus.MiniBus
import org.bukkit.Bukkit
import org.bukkit.Server


val server: Server by lazy { Bukkit.getServer() }

val defaultPlugin: Core by lazy { Core.instance }


val gson: Gson by lazy { Core.instance.gson }

val miniBus: MiniBus by lazy { Core.instance.miniBus }

val accounts: Accounts by lazy { Core.instance.accounts }

val commands: Commands by lazy { Core.instance.commands }