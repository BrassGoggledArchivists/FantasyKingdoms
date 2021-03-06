package fantasykingdoms.common.blocks.dwarven;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fantasykingdoms.common.blocks.BaseBlock;
import fantasykingdoms.common.entity.EntityBarrelPrimed;

public class BlockExplosiveBarrel extends BaseBlock
{
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	public BlockExplosiveBarrel()
	{
		super(Material.wood);
		this.setBlockName("blockExplosiveBarrel");

	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
	{
		super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);

		if (p_149726_1_.isBlockIndirectlyGettingPowered(p_149726_2_, p_149726_3_, p_149726_4_))
		{
			this.onBlockDestroyedByPlayer(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, 1);
			p_149726_1_.setBlockToAir(p_149726_2_, p_149726_3_, p_149726_4_);
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	{
		if (p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_, p_149695_4_))
		{
			this.onBlockDestroyedByPlayer(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 1);
			p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
		}
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random p_149745_1_)
	{
		return 1;
	}

	/**
	 * Called upon the block being destroyed by an explosion
	 */
	@Override
	public void onBlockDestroyedByExplosion(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_)
	{
		if (!p_149723_1_.isRemote)
		{
			EntityBarrelPrimed entitytntprimed = new EntityBarrelPrimed(p_149723_1_, p_149723_2_ + 0.5F, p_149723_3_ + 0.5F, p_149723_4_ + 0.5F,
					p_149723_5_.getExplosivePlacedBy());
			entitytntprimed.fuse = p_149723_1_.rand.nextInt(entitytntprimed.fuse / 4) + (entitytntprimed.fuse / 8);
			p_149723_1_.spawnEntityInWorld(entitytntprimed);
		}
	}

	/**
	 * Called right before the block is destroyed by a player. Args: world, x,
	 * y, z, metaData
	 */
	@Override
	public void onBlockDestroyedByPlayer(World world, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_)
	{
		this.func_150114_a(world, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_, null);
	}

	public void func_150114_a(World world, int x, int y, int z, int p_150114_5_, EntityLivingBase p_150114_6_)
	{
		if (!world.isRemote)
		{
			if ((p_150114_5_ & 1) == 1)
			{
				EntityBarrelPrimed entitytntprimed = new EntityBarrelPrimed(world, x + 0.5F, y + 0.5F, z + 0.5F, p_150114_6_);
				world.spawnEntityInWorld(entitytntprimed);
				world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
			}
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_,
			float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if ((p_149727_5_.getCurrentEquippedItem() != null) && (p_149727_5_.getCurrentEquippedItem().getItem() == Items.flint_and_steel))
		{
			this.func_150114_a(world, p_149727_2_, p_149727_3_, p_149727_4_, 1, p_149727_5_);
			world.setBlockToAir(p_149727_2_, p_149727_3_, p_149727_4_);
			p_149727_5_.getCurrentEquippedItem().damageItem(1, p_149727_5_);
			return true;
		}
		else
		{
			return super.onBlockActivated(world, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_,
					p_149727_9_);
		}
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	@Override
	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
	{
		if ((p_149670_5_ instanceof EntityArrow) && !p_149670_1_.isRemote)
		{
			EntityArrow entityarrow = (EntityArrow) p_149670_5_;

			if (entityarrow.isBurning())
			{
				this.func_150114_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1,
						entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase) entityarrow.shootingEntity : null);
				p_149670_1_.setBlockToAir(p_149670_2_, p_149670_3_, p_149670_4_);
			}
		}
	}

	/**
	 * Return whether this block can drop from an explosion.
	 */
	@Override
	public boolean canDropFromExplosion(Explosion p_149659_1_)
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		switch (side)
		{
		case 0:
			return this.iconTop; // bottom

		case 1:
			return this.iconTop; // top

		default:
			return this.blockIcon; // sides
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon("fantasykingdoms:blockBarrelSideExplosive");
		this.iconTop = icon.registerIcon("fantasykingdoms:blockBarrelEndClosed");
	}

}
