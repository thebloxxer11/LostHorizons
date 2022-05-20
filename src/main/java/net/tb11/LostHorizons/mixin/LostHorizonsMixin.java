package net.tb11.LostHorizons.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.tb11.LostHorizons.LostHorizons;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class LostHorizonsMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		LostHorizons.LOGGER.info("Mixin-Logger go brrrr");
	}
}
