package com.creatifcubed.minecraft.siliconangels.models;

import net.minecraft.client.entity.EntityClientPlayerMP;
import _root_.cpw.mods.fml.relauncher.{ Side, SideOnly };

@SideOnly(Side.CLIENT)
class DummySystem(val player: EntityClientPlayerMP) extends IPilot {

}