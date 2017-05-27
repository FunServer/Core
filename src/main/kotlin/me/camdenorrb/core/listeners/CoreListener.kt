package me.camdenorrb.core.listeners

import me.camdenorrb.core.events.PlayerMoveBlockEvent
import me.camdenorrb.core.extensions.miniBus
import me.camdenorrb.minibus.listener.MiniListener
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority.HIGHEST
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent


class CoreListener : Listener, MiniListener {

	@EventHandler(ignoreCancelled = true, priority = HIGHEST)
	fun PlayerMoveEvent.onMove() {

		val toBlock = to.block
		val fromBlock = from.block

		if (toBlock == fromBlock) return

		isCancelled = miniBus.invoke(PlayerMoveBlockEvent(player, to, from, toBlock, fromBlock)).cancelled

	}

}