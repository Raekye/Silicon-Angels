package com.creatifcubed.minecraft.siliconangels.network;

case class ModCommand(modId: String, args: Array[String]) {
}

case class SetActiveItemOrBlock(itemOrBlockId: Int) {
}