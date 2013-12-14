package com.creatifcubed.minecraft.siliconangels.models;

trait IEntryPlug {
  def pilot: IPilot;
  def start(): Unit;
  def stop(): Unit;
  def onTick(): Unit;
}