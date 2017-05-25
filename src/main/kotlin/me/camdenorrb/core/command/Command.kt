package me.camdenorrb.core.command

import me.camdenorrb.core.account.Account
import me.camdenorrb.core.rank.FunRank
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

/**
 * Created by camdenorrb on 5/25/17.
 */

abstract class Command(val aliases: Array<String>, val ranks: Array<FunRank>, var minArgs: Int = 0, var usage: String = "") {

	abstract val name: String

	open val mainCmd = aliases.firstOrNull() ?: ""


	init {
		check(ranks.isNotEmpty(), { "The command $name has no ranks to figure out who can execute the command." })
		check(aliases.isNotEmpty()) { "The command $name has no aliases to signify when to execute." }
	}


	abstract fun execute(sender: CommandSender, account: Account?, args: MutableList<String>)

	open fun onTab(sender: CommandSender, args: MutableList<String>): List<String> {
		return Bukkit.getOnlinePlayers().map { it.name }
	}

}