package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DefaultDrive;


public class Drivetrain extends Subsystem {

    private WPI_TalonSRX talon_FL = new WPI_TalonSRX(RobotMap.TALON_PORT_FL);
    private WPI_TalonSRX talon_FR = new WPI_TalonSRX(RobotMap.TALON_PORT_FR);
    private WPI_TalonSRX talon_BL = new WPI_TalonSRX(RobotMap.TALON_PORT_BL);
    private WPI_TalonSRX talon_BR = new WPI_TalonSRX(RobotMap.TALON_PORT_BR);

    private MecanumDrive drivetrain;

    public Drivetrain() {

        drivetrain = new MecanumDrive(talon_FL, talon_BL, talon_FR, talon_BR);
    }

    public WPI_TalonSRX getTalon(int num){
        switch(num) {
            case 1:
                return talon_FL;
            case 2:
                return talon_FR;
            case 3:
                return talon_BL;
            case 4:
                return talon_BR;
            default:
                return null;
        }
    }
    public MecanumDrive getDriveTrain() {
        return drivetrain;
    }
    public void initDefaultCommand() {    
        
        talon_FR.setNeutralMode(NeutralMode.Brake);
        talon_FL.setNeutralMode(NeutralMode.Brake);
        talon_BR.setNeutralMode(NeutralMode.Brake);
        talon_BL.setNeutralMode(NeutralMode.Brake);
        
        setDefaultCommand(new DefaultDrive());
    }

}

