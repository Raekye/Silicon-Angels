package com.creatifcubed.minecraft.siliconangels;

import _root_.cpw.mods.fml.client.registry.KeyBindingRegistry.{ KeyHandler => AbstractKeyHandler };
import _root_.cpw.mods.fml.common.TickType;
import net.minecraft.client.settings.KeyBinding;
import java.util.EnumSet;
import org.lwjgl.input.Keyboard;
import com.creatifcubed.minecraft.siliconangels.models.{ IEntryPlug, EntryPlugZero, IPilot, DummySystem };
import net.minecraft.src.ModLoader;

class KeyHandler extends AbstractKeyHandler(KeyHandler.KEYBINDINGS, KeyHandler.KEYBINDINGS_REPEATINGS) {
  override def getLabel(): String = {
    return SiliconAngels.MOD_ID + "-keys";
  }
  override def keyDown(types: EnumSet[TickType], kb: KeyBinding, tickEnd: Boolean, isRepeat: Boolean): Unit = {
    return;
  }
  
  override def keyUp(types: EnumSet[TickType], kb: KeyBinding, tickEnd: Boolean): Unit = {
    SiliconAngels.log.info("PLAYER IS %s, tickend is %b".format(ModLoader.getMinecraftInstance().thePlayer.getClass().getName(), tickEnd));
    if (kb.equals(KeyHandler.KEYBINDINGS(0))) {
      val pilot: IPilot = new DummySystem(ModLoader.getMinecraftInstance().thePlayer);
      val entryPlug: IEntryPlug = new EntryPlugZero(pilot);
      SiliconAngels.setActiveMod(entryPlug);
    } else {
      SiliconAngels.setActiveMod(null);
      SiliconAngels.log.info("Player inventory is %s\n\t, %s".format(
          ModLoader.getMinecraftInstance().thePlayer.openContainer.getClass().getName()
          , ModLoader.getMinecraftInstance().thePlayer.inventoryContainer.getClass().getName()));
    }
  }
  
  override def ticks(): EnumSet[TickType] = {
    EnumSet.of(TickType.CLIENT);
  }
}

object KeyHandler {
  final val KEYBINDINGS: Array[KeyBinding] = Array(
    new KeyBinding(SiliconAngels.MOD_NAME + " - A", Keyboard.KEY_M)
    , new KeyBinding(SiliconAngels.MOD_NAME + " - B", Keyboard.KEY_N));
  final val KEYBINDINGS_REPEATINGS: Array[Boolean] = Array(false, false);
}