package me.camdenorrb.core.cmd

import me.camdenorrb.core.account.Account
import me.camdenorrb.core.extensions.server
import me.camdenorrb.core.rank.FunRank
import org.bukkit.command.CommandSender

/**
 * Created by camdenorrb on 5/25/17.
 */

abstract class Cmd(val aliases: Array<String>, val ranks: Array<FunRank> = arrayOf(FunRank.Default), var usage: String = "", var minArgs: Int = 0) {

	open val mainCmd = aliases.firstOrNull() ?: ""


	init {
		check(ranks.isNotEmpty(), { "The cmd $mainCmd has no ranks to figure out who can execute the cmd." })
		check(aliases.isNotEmpty()) { "The cmd $mainCmd has no aliases to signify when to execute." }
	}


	open fun isThis(commandName: String) = aliases.any { it.equals(commandName, true) }


	open fun canExecute(account: Account) = canExecute(account.rank)

	open fun canExecute(rank: FunRank) = if (ranks.size == 1) rank >= ranks.first() else ranks.contains(rank)


	abstract fun execute(sender: CommandSender, account: Account?, args: MutableList<String>): Boolean

	open fun onTab(sender: CommandSender, args: MutableList<String>): List<String> {
		return server.onlinePlayers.map { it.name }
	}

}