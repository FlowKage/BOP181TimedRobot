package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake {
    static CANSparkMax intakeRoll = new CANSparkMax(8, MotorType.kBrushless);
    static CANSparkMax intakePiviot = new CANSparkMax(7, MotorType.kBrushless);


//Switches from intake to outake depending which button is pressed
// 1 = Joystick Trigger (Intake)
// 6 = Xbox Right Bumper (Outake)
 public static void intakeDir(){
            if (Robot.driverStick.getRawButtonPressed(1)){
                intakeRoll.set(.5);
            }
            if (Robot.driverStick.getRawButtonReleased(1)){
                intakeRoll.set(0);
            }
            if (Robot.op_Stick.getRawButtonPressed(6)){
                intakeRoll.set(-.5);
            }
            if (Robot.op_Stick.getRawButtonReleased(6)){
                intakeRoll.set(0);
            }
}

//Moves the intake up or down depending which button is pressed
// 4 = Y (Up)
// 1 = A (Down)
    public static void moveIntake(){
        if (Robot.op_Stick.getRawButtonPressed(4)){
            intakePiviot.set(-.25);
        }
        if (Robot.op_Stick.getRawButtonReleased(4)){
            intakePiviot.set(0);
        }
        if (Robot.op_Stick.getRawButtonPressed(1)){
            intakePiviot.set(.25);
        }
        if (Robot.op_Stick.getRawButtonReleased(1)){
            intakePiviot.set(0);
        }    
    }
}