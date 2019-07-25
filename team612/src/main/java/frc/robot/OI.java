package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutoDrive;

public class OI 
{
    public static XboxController driver = new XboxController(RobotMap.DRIVER_PORT);
    public static XboxController gunner = new XboxController(RobotMap.GUNNER_PORT);

    public static JoystickButton driver_button_A    	= new JoystickButton(driver,1);
    public static JoystickButton driver_button_B 		= new JoystickButton(driver,2);
    public static JoystickButton driver_button_X    	= new JoystickButton(driver,3);
    public static JoystickButton driver_button_Y    	= new JoystickButton(driver,4);
    public static JoystickButton driver_button_LB   	= new JoystickButton(driver,5);
    public static JoystickButton driver_button_RB   	= new JoystickButton(driver,6);
    public static JoystickButton driver_button_BCK  	= new JoystickButton(driver,7);
    public static JoystickButton driver_button_STRT 	= new JoystickButton(driver,8);
    public static JoystickButton driver_button_LJ   	= new JoystickButton(driver,9);
    public static JoystickButton driver_button_RJ   	= new JoystickButton(driver,10);

    public static JoystickButton gunner_button_A    	= new JoystickButton(gunner, 1);
    public static JoystickButton gunner_button_B    	= new JoystickButton(gunner, 2);
    public static JoystickButton gunner_button_X    	= new JoystickButton(gunner,3);
    public static JoystickButton gunner_button_Y    	= new JoystickButton(gunner,4);
    public static JoystickButton gunner_button_LB   	= new JoystickButton(gunner,5);
    public static JoystickButton gunner_button_RB   	= new JoystickButton(gunner,6);
    public static JoystickButton gunner_button_BCK  	= new JoystickButton(gunner,7);
    public static JoystickButton gunner_button_STRT 	= new JoystickButton(gunner,8);
    public static JoystickButton gunner_button_LJ   	= new JoystickButton(gunner,9);
    public static JoystickButton gunner_button_RJ   	= new JoystickButton(gunner,10);

    public OI() {
        driver_button_A.whileHeld(new AutoDrive());
    }

}
