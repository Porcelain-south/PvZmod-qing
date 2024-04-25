package com.hungteen.pvz.common.world.structure.shop;

import com.hungteen.pvz.common.world.structure.PVZStructureBase;
import com.mojang.serialization.Codec;

import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class SunTempleStructure extends PVZStructureBase<NoFeatureConfig> {

	public SunTempleStructure(Codec<NoFeatureConfig> p_i231997_1_) {
		super(p_i231997_1_);
	}
	
	@Override
	public String getPVZStructureName() {
		return "sun_temple";
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return Start::new;
	}
	
	public static class Start extends StructureStart<NoFeatureConfig> {

		public Start(Structure<NoFeatureConfig> structure, int chunkPosX, int chunkPosZ, MutableBoundingBox bounds, int references, long seed) {
            super(structure, chunkPosX, chunkPosZ, bounds, references, seed);
        }
		
		@Override
		public void generatePieces(DynamicRegistries p_230364_1_, ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ,
				Biome biomeIn, NoFeatureConfig p_230364_7_) {
			Rotation rotation = Rotation.values()[this.random.nextInt(Rotation.values().length)];
			BlockPos blockpos = new BlockPos(chunkX * 16, 180 + this.random.nextInt(10), chunkZ * 16);
			SunTempleComponents.generate(templateManagerIn, blockpos, rotation, this.pieces, this.random);
			this.calculateBoundingBox();
		}
	}

}
