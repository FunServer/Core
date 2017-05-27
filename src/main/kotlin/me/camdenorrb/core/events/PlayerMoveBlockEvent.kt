package me.camdenorrb.core.events

import me.camdenorrb.minibus.event.CancellableMiniEvent
import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.entity.Player


class PlayerMoveBlockEvent(player: Player, to: Location, from: Location, toBlock: Block, fromBlock: Block) : CancellableMiniEvent()