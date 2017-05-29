package me.camdenorrb.core.cmd.cmds

import me.camdenorrb.core.account.Account
import me.camdenorrb.core.cmd.Cmd
import me.camdenorrb.core.extensions.gson
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Created by camdenorrb on 5/25/17.
 */

class TestCmd : Cmd(arrayOf("test"), usage = "/Test", minArgs = 2) {

	override fun execute(sender: CommandSender, account: Account?, args: MutableList<String>): Boolean {
		sender.sendMessage("${args.joinToString(" ")} ${args.size}")
		if (sender is Player) sender.sendMessage(gson.toJson(sender.location))
		return true
	}

}