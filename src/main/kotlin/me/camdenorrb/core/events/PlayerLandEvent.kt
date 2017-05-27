package me.camdenorrb.core.events

import me.camdenorrb.minibus.event.CancellableMiniEvent
import org.bukkit.block.Block
import org.bukkit.entity.Player


class PlayerLandEvent(player: Player, fromBlock: Block, toBlock: Block, landedBlock: Block) : CancellableMiniEvent()