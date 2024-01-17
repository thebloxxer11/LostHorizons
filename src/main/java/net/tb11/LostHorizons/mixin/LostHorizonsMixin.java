package net.tb11.LostHorizons.mixin;

import net.minecraft.server.MinecraftServer;
import net.tb11.LostHorizons.LostHorizons;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class LostHorizonsMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		LostHorizons.LOGGER.info("Server Mixin Loaded");
	}
}
