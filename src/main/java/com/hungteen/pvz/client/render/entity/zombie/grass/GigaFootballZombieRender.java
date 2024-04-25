package com.hungteen.pvz.client.render.entity.zombie.grass;

import com.hungteen.pvz.client.model.entity.zombie.grass.GigaFootballZombieModel;
import com.hungteen.pvz.client.render.entity.zombie.PVZZombieRender;
import com.hungteen.pvz.common.entity.zombie.grass.GigaFootballZombieEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GigaFootballZombieRender extends PVZZombieRender<GigaFootballZombieEntity>{

	public GigaFootballZombieRender(EntityRendererManager rendererManager) {
		super(rendererManager, new GigaFootballZombieModel(), 0.5f);
	}

}
