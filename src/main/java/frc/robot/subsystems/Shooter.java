// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;

public class Shooter extends SubsystemBase {
  private final TalonFX bottomLeftShooter = new TalonFX(1, "canivore"); // bottom left
  private final TalonFX bottomRightShooter = new TalonFX(21, "canivore");// bottom right
  private final TalonFX topRightShooter = new TalonFX(15, "canivore"); // top right
  private final TalonFX topLeftShooter = new TalonFX(3, "canivore"); // top left
  
  /** Creates a new ExampleSubsystem. */
  public Shooter() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    bottomLeftShooter.getConfigurator().apply(config);
    bottomRightShooter.getConfigurator().apply(config);
    topLeftShooter.getConfigurator().apply(config);
    topRightShooter.getConfigurator().apply(config);
  }

  public void runMotorsAtPercent(double percent) {
    bottomLeftShooter.set(percent);
    bottomRightShooter.set(percent);
    topLeftShooter.set(-percent);
    topRightShooter.set(-percent);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */

  public Command runMotorsAtPercentCommand(double percent) {
    return run(() -> runMotorsAtPercent(percent));
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
