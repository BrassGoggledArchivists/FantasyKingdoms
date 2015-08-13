/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft Mod created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 *
 */
package fantasykingdoms.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

/**
 * @author Surseance
 *
 */
public class ItemModPickaxe extends ItemModTool
{
	public ItemModPickaxe(ToolMaterial mat)
	{
		super(mat.getDamageVsEntity() + 1.0F, mat);
		this.setHarvestLevel("pickaxe", mat.getHarvestLevel());
	}

	@Override
	public float getDigSpeed(ItemStack stack, Block block, int metadata)
	{

		if (block.getMaterial() == Material.rock)
		{
			return this.efficiencyOnProperMaterial;
		}

		return super.getDigSpeed(stack, block, metadata);
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return (block.getMaterial() == Material.rock) || super.canHarvestBlock(block, stack);
	}
}