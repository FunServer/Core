package me.camdenorrb.core.cmd.cmds

import me.camdenorrb.core.account.Account
import me.camdenorrb.core.cmd.Cmd
import org.bukkit.command.CommandSender

/**
 * Created by camdenorrb on 5/25/17.
 */

class TestCmd : Cmd(arrayOf("test"), usage = "/Test", minArgs = 2) {

	override val name = "Test"

	override fun execute(sender: CommandSender, account: Account?, args: MutableList<String>): Boolean {
		sender.sendMessage("${args.joinToString(" ")} ${args.size}")
		return true
	}

}