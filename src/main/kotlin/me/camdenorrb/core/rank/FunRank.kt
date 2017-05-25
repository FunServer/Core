package me.camdenorrb.core.rank

/**
 * Created by camdenorrb on 5/25/17.
 */

enum class FunRank {

	Admin,
	Default;

	val level: Int
		get() = ordinal

}