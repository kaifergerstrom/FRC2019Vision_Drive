/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoDrive extends Command {

  // Split elements off array into individual variables
  private double positionOffset = Robot.visionListener.responseTable[0];
  private double leftTapeLength = Robot.visionListener.responseTable[1];
  private double rightTapeLength = Robot.visionListener.responseTable[2];

  private double POSITION_DEADBAND = 10;
  private double KP_POSITION = 0.02;
  private double KP_TAPE = 0.02;

  public AutoDrive() {

    requires(Robot.drivetrain);

  }

  // Determine if the offset is not within a deadband apply magnitude based on value calculated with KP
  private double calculateMagnitude() {
    double magnitude = 0;

    if (Math.abs(positionOffset) > POSITION_DEADBAND) {  // Check if position offset not within deadband
      magnitude = KP_POSITION * Math.abs(positionOffset);
    }

    return magnitude;
  }


  // Calculate the angle value by determining whether the offset is negative or positive and strafing in the opposite distance
  private double calculateAngle() {
    double angle = (positionOffset < 0) ? 90 : -90;
    return angle;
  }


  // Calculate the offset of the tape lengths and determine a value with KP to strafe
  private double calculateRotation() {
    double tapeLengthOffset = Math.abs(leftTapeLength) - Math.abs(rightTapeLength);
    return KP_TAPE * tapeLengthOffset;
  }

  @Override
  protected void initialize() {
  }


  @Override
  protected void execute() {

    double magnitude = calculateMagnitude();
    double angle = calculateAngle();
    double rotation = calculateRotation();

    Robot.drivetrain.getDriveTrain().drivePolar(magnitude, angle, rotation);

  }


  @Override
  protected boolean isFinished() {
    return true;
  }


  @Override
  protected void end() {
  }


  @Override
  protected void interrupted() {
  }


}
