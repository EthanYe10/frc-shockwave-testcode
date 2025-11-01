// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(Shooter subsystem) {
    return subsystem.runMotorsAtPercentCommand(0);
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
