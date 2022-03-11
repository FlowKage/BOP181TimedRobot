package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class DriveTrain {

public static WPI_TalonSRX  m_leftFollower = new WPI_TalonSRX(1);
public static WPI_TalonSRX  m_rightFollower = new WPI_TalonSRX(3);
public static WPI_TalonSRX m_leftFront = new WPI_TalonSRX(2);
public static WPI_TalonSRX m_rightFront = new WPI_TalonSRX(4);


public static DifferentialDrive m_drive = new DifferentialDrive(m_leftFront, m_rightFront);

//Called in Robot to drive forward and turn
public static void drive(double forward, double turn){
    m_drive.arcadeDrive(forward, turn);
}

// Sets the motors to Factory Default
public static void configFactory(){
    m_leftFollower.configFactoryDefault();
    m_rightFollower.configFactoryDefault();
    m_leftFront.configFactoryDefault();
    m_rightFront.configFactoryDefault();
}

//Init. code for the motors to sync and invert
public static void Start(){
    m_leftFollower.follow(m_leftFront);
    m_rightFollower.follow(m_rightFront);
    m_leftFront.setInverted(true);
    m_rightFront.setInverted(false);
    m_leftFollower.setInverted(InvertType.FollowMaster);
    m_rightFollower.setInverted(InvertType.FollowMaster);
}

//Sets the control mode for motors 
public static void setControlMode(){
    m_leftFollower.set(ControlMode.PercentOutput, 0);
    m_rightFollower.set(ControlMode.PercentOutput, 0);
    m_leftFront.set(ControlMode.PercentOutput, 0);
    m_rightFront.set(ControlMode.PercentOutput, 0);
}

}
