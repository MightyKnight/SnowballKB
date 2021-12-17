package capitalistspz.test.mixin;

import capitalistspz.test.SnowballKB;
import capitalistspz.test.config.Config;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMxn {
    @Inject(method="save",at=@At("TAIL"))
    public void saveConfig(boolean suppressLogs, boolean flush, boolean force, CallbackInfoReturnable<Boolean> cir){
        if (!suppressLogs && Config.save(SnowballKB.config)){
            SnowballKB.logger.log(Level.INFO, "Config saved.");
        }
    }
}
