package me.camdenorrb.core.gson

import com.google.gson.*
import me.camdenorrb.core.extensions.server
import org.bukkit.Location
import java.lang.reflect.Type
import java.util.*


const val WORLD_NOT_FOUND = "World not found while deserializing."

class LocationAdapter : JsonSerializer<Location>, JsonDeserializer<Location> {

	override fun deserialize(element: JsonElement, type: Type?, context: JsonDeserializationContext?): Location {
		element.asJsonObject.run {
			val world = server.getWorld(UUID.fromString(get("worldUUID").asString)) ?: error(WORLD_NOT_FOUND)
			return Location(world, get("x").asDouble, get("y").asDouble, get("z").asDouble, get("yaw").asFloat, get("pitch").asFloat)
		}
	}

	override fun serialize(loc: Location, type: Type?, context: JsonSerializationContext?): JsonElement {
		return JsonObject().apply {
			addProperty("x", loc.x)
			addProperty("y", loc.y)
			addProperty("z", loc.z)
			addProperty("yaw", loc.yaw)
			addProperty("pitch", loc.pitch)
			addProperty("worldUUID", loc.world.uid.toString())
		}
	}

}