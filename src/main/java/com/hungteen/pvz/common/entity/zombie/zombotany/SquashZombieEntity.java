package com.hungteen.pvz.common.entity.zombie.zombotany;

import com.hungteen.pvz.common.entity.plant.enforce.SquashEntity;
import com.hungteen.pvz.common.impl.zombie.ZombieType;
import com.hungteen.pvz.common.impl.zombie.Zombotanies;
import com.hungteen.pvz.common.misc.PVZLoot;
import com.hungteen.pvz.common.entity.EntityRegister;
import com.hungteen.pvz.utils.EntityUtil;
import com.hungteen.pvz.utils.ZombieUtil;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SquashZombieEntity extends AbstractZombotanyEntity {

	public SquashZombieEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super(type, worldIn);
		this.canLostHead = false;
	}

	@Override
	public float getWalkSpeed() {
		return ZombieUtil.WALK_VERY_FAST;
	}
	
	@Override
	public void normalZombieTick() {
		super.normalZombieTick();
		if(! level.isClientSide) {
			LivingEntity target = this.getTarget();
			if(target != null && this.distanceToSqr(target) <= 10) {
				SquashEntity squash = EntityRegister.SQUASH.get().create(level);
				squash.setCharmed(! this.isCharmed());
				squash.setTarget(target);
				EntityUtil.onEntitySpawn(level, squash, blockPosition().above(2));
				this.remove();
			}
		}
	}
	
	@Override
	public float getLife() {
		return 25;
	}
	
	@Override
	public ZombieType getZombieType() {
		return Zombotanies.SQUASH_ZOMBIE;
	}

}
