package nextGenTweaks;

import java.util.List;

import buildcraft.api.recipes.BuildcraftRecipes;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "nextgentweaks", name = "NextGen Tweaks", version = "@VERSION@", dependencies = "required-after:BuildCraft|Energy@{6.0.16};required-after:ExtraUtilities@{1.1.0b}")
public class NextGenTweaks {

    public static Item enderGear;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        enderGear = new Item().setUnlocalizedName("itemEnderGear");
    }

	@EventHandler
	public void load(FMLInitializationEvent event) {
		removeRecipe(new ItemStack(GameRegistry.findBlock("ExtraUtilities", "enderQuarry")));
		
	}

	public void removeRecipe(ItemStack stack) {
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipeList.size(); i++) {
			IRecipe recipe = recipeList.get(i);
			ItemStack recipeResult = recipe.getRecipeOutput();
			if (ItemStack.areItemStacksEqual(stack, recipeResult)) {
				recipeList.remove(i);
				return;
			}
		}
	}

}
