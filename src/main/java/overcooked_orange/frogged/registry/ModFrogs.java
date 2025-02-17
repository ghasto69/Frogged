package overcooked_orange.frogged.registry;

import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import overcooked_orange.frogged.Frogged;

public class ModFrogs {
    public static final FrogVariant BLUE_POISON_DART_FROG = frog("blue_poison_dart_frog");
    public static final FrogVariant GOLDEN_POISON_DART_FROG = frog("golden_poison_dart_frog");
    public static final FrogVariant VARIEGATED_POISON_DART_FROG = frog("variegated_poison_dart_frog");
    public static final FrogVariant SANDY_FROG = frog("sandy_frog");

    private static FrogVariant frog(String name) {
        return Registry.register(Registries.FROG_VARIANT, Frogged.id(name), new FrogVariant(Frogged.id("textures/entity/frog/" + name + ".png")));
    }

    public static void registerFrogs() {}
}
