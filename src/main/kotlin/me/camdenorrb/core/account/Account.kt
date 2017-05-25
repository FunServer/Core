package me.camdenorrb.core.account

import me.camdenorrb.core.rank.FunRank
import org.bukkit.entity.Player

/**
 * Created by camdenorrb on 5/25/17.
 */

data class Account(@Transient val player: Player, val rank: FunRank)