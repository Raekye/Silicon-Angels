package com.creatifcubed.minecraft.siliconangels;

import _root_.cpw.mods.fml.common.{ ITickHandler, TickType };
import java.util.EnumSet;
import com.creatifcubed.minecraft.siliconangels.models.IEntryPlug;

class TickHandler extends ITickHandler {
  override def getLabel(): String = {
    return SiliconAngels.MOD_ID + "-ticks";
  }
  override def tickStart(types: EnumSet[TickType], data: AnyRef*): Unit = {
    val mod: IEntryPlug = SiliconAngels.getActiveMod();
    if (mod == null) {
      return;
    }
    mod.onTick();
  }
  
  override def tickEnd(types: EnumSet[TickType], data: AnyRef*): Unit = {
    return;
  }
  
  override def ticks(): EnumSet[TickType] = {
    return EnumSet.of(TickType.CLIENT);
  }
}