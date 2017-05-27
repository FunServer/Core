package me.camdenorrb.core.events

import me.camdenorrb.minibus.event.CancellableMiniEvent
import org.bukkit.Location
import org.bukkit.entity.Player


class PlayerJumpEvent(player: Player, toBlock: Location, fromBlock: Location) : CancellableMiniEvent()