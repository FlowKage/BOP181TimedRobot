package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Intake {
    static CANSparkMax intakeB = new CANSparkMax(8, MotorType.kBrushless);
    static CANSparkMax intakeM = new CANSparkMax(7, MotorType.kBrushless);

    public static void intakeChange(double num){
        intakeB.set(num);
    }
    public static void intakeShift(double num){
        intakeB.set(num);
    }

    public static void intakeDir(XboxController opStick){
        if (opStick.getRawButton(0)){
            intakeChange(1);
        }
        else if (opStick.getRawButton(0)){
            intakeChange(-1);
        }
}
    public static void moveIntake(XboxController opStick){
        if(opStick.getRawButton(0)){
            intakeShift(.25);
        }
        else if(opStick.getRawButton(0)){
            intakeShift(-.25);
        }
    }

    

}

