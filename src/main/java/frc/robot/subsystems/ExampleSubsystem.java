// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;

public class ExampleSubsystem extends SubsystemBase {
  private final TalonFX stage1Left = new TalonFX(1);
  private final TalonFX stage1Right = new TalonFX(2);
  private final TalonFX stage2Left = new TalonFX(3);
  private final TalonFX stage2Right = new TalonFX(4);
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */

  public Command runMotorsAtPercentCommand(double percent) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          stage1Left.set(percent);
          stage1Right.set(percent);
          stage2Left.set(percent);
          stage2Right.set(percent);
        });
  }

  public Command stopMotorCommand(){
    return runOnce(
      () -> {
        stage1Left.set(0);
        stage1Right.set(0);
        stage2Left.set(0);
        stage2Right.set(0);
      });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
