// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.*;

public class ExampleSubsystem extends SubsystemBase {
  private final TalonFX stage1Left = new TalonFX(1);
  private final TalonFX stage1Right = new TalonFX(2);
  private final TalonFX stage2Left = new TalonFX(3);
  private final TalonFX stage2Right = new TalonFX(4);
  private final DutyCycleOut dutyCycleOut = new DutyCycleOut(0);
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
          stage1Left.setControl(dutyCycleOut.withOutput(percent));
          stage1Right.setControl(dutyCycleOut.withOutput(percent));
          stage2Left.setControl(dutyCycleOut.withOutput(percent));
          stage2Right.setControl(dutyCycleOut.withOutput(percent));
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
    runMotorsAtPercentCommand(0.3);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
