package net.tb11.LostHorizons.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.tb11.LostHorizons.LostHorizons;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(MinecraftClient.class)
public class LostHorizonsMixinClient {
	@Inject(at = @At("HEAD"), method = "run")
	private void init(CallbackInfo info) {
		LostHorizons.LOGGER.info("Mixin-Logger go brrrr");
	}
}
