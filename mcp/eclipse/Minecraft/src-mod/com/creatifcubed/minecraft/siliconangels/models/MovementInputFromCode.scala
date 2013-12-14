package com.creatifcubed.minecraft.siliconangels.models

import net.minecraft.util.MovementInput;

import scala.math;

import _root_.cpw.mods.fml.relauncher.{ Side, SideOnly };

@SideOnly(Side.CLIENT)
class MovementInputFromCode extends MovementInput {
  private var _shouldForward: Int = 0;
  private var _shouldStrafe: Int = 0;
  private var _shouldJump: Boolean = false;
  
  def shouldForward = this._shouldForward;
  def shouldfoward_=(_shouldForward: Int): Unit = {
    if (_shouldForward == 0) {
      this._shouldForward = 0;
    } else {
      this._shouldForward = _shouldForward / math.abs(_shouldForward);
    }
  }
  
  def shouldStrafe = this._shouldStrafe;
  def shouldStrafe_=(_shouldStrafe: Int): Unit = {
    if (_shouldStrafe == 0) {
      this._shouldStrafe = 0;
    } else {
      this._shouldStrafe = _shouldForward / math.abs(_shouldForward);
    }
  }
  
  def shouldJump = this._shouldJump;
  def shouldJump_=(_shouldJump: Boolean): Unit = {
    this._shouldJump = _shouldJump;
  }
  
  /**
   * @see net.minecraft.util.MovementInputFromOptions#updatePlayerMoveState()
   */
  override def updatePlayerMoveState(): Unit = {
    this.moveStrafe = this.shouldForward.toFloat;
    this.moveForward = this.shouldStrafe.toFloat;

    this.jump = this.shouldJump;
    if (this.sneak) {
      this.moveStrafe = (this.moveStrafe.toDouble * 0.3D).toFloat;
      this.moveForward = (this.moveForward.toDouble * 0.3D).toFloat;
    }
  }
}