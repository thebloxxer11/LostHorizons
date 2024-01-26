//package net.tb11.LostHorizons.model.block;
//
//import net.fabricmc.fabric.api.renderer.v1.Renderer;
//import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
//import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
//import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
//import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
//import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
//import net.minecraft.block.BlockState;
//import net.minecraft.client.render.model.*;
//import net.minecraft.client.render.model.json.ModelOverrideList;
//import net.minecraft.client.render.model.json.ModelTransformation;
//import net.minecraft.client.texture.Sprite;
//import net.minecraft.client.texture.SpriteAtlasTexture;
//import net.minecraft.client.util.SpriteIdentifier;
//import net.minecraft.registry.Registries;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.math.random.Random;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.function.Function;
//
//public class TralyxConductorBlockModel implements UnbakedModel, BakedModel, FabricBakedModel {
//    private static final SpriteIdentifier[] SPRITE_IDS = new SpriteIdentifier[]{
//            new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("losthorizons:block/tralyx_conductor"))
//    };
//    private final Sprite[] sprites = new Sprite[SPRITE_IDS.length];
//    private static final int SPRITE_BASE = 0;
//    private Mesh mesh;
//
//    @Override
//    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
//        return null;
//    }
//
//    @Override
//    public boolean useAmbientOcclusion() {
//        return false;
//    }
//
//    @Override
//    public boolean hasDepth() {
//        return false;
//    }
//
//    @Override
//    public boolean isSideLit() {
//        return false;
//    }
//
//    @Override
//    public boolean isBuiltin() {
//        return false;
//    }
//
//    @Override
//    public Sprite getParticleSprite() {
//        return null;
//    }
//
//    @Override
//    public ModelTransformation getTransformation() {
//        return null;
//    }
//
//    @Override
//    public ModelOverrideList getOverrides() {
//        return null;
//    }
//
//    @Override
//    public Collection<Identifier> getModelDependencies() {
//        return List.of();
//    }
//
//    @Override
//    public void setParents(Function<Identifier, UnbakedModel> modelLoader) {
//
//    }
//
//    @Nullable
//    @Override
//    public BakedModel bake(Baker baker, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {
//        for(int i=0; i<SPRITE_IDS.length; ++i){
//            sprites[i] = textureGetter.apply(SPRITE_IDS[i]);
//        }
//        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
//        MeshBuilder builder = renderer.meshBuilder();
//        QuadEmitter emitter = builder.getEmitter();
//
//        for(Direction direction:Direction.values()){
//            int spriteIdx = direction == Direction.UP || direction == Direction.DOWN ? null : SPRITE_BASE;
//        }
//
//        return this;
//    }
//}
