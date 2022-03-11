package frc;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.math.controller.PIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;

public class Climber {

private Encoder m_leftEncoder = new Encoder(0,1);
private Encoder m_rightEncoder = new Encoder(2,3);

  private double m_driveEncoder = 1.0/4096.0*0.128*Math.PI;

  public  double m_driveEncoderMeter(){
    return (m_leftEncoder.get() + -m_rightEncoder.get())/2*m_driveEncoder;
  }


  private  CANSparkMax m_elevatorMotor = new CANSparkMax(0,MotorType.kBrushless);
  private  Encoder encoder = new Encoder(4,5);
  private  PIDController m_pidController = new PIDController(2, 0, 0.8);
  private  double m_elevatorEncoderTickMeter = 1.0/4096.0*0.1*Math.PI;

  public double m_elevatorEncoderMeters(){
    return encoder.get() * m_elevatorEncoderTickMeter;
  }

    public void drive(XboxController op_Stick){
        if (op_Stick.getRawButton(1)){
            m_pidController.setSetpoint(1.8);
            double sensor = m_elevatorEncoderMeters();
            double output = m_pidController.calculate(sensor);
            m_elevatorMotor.set(output);
          } else if(op_Stick.getRawButton(2)){
            m_pidController.setSetpoint(0);
            double sensor = m_driveEncoderMeter();
            double output = m_pidController.calculate(sensor);
            m_elevatorMotor.set(output);
          } else if (op_Stick.getRawButton(3)){
            m_elevatorMotor.set(0.5);
          } else if (op_Stick.getRawButton(4)){
            m_elevatorMotor.set(-0.5);
          } else{
            m_elevatorMotor.set(0);
          }
    }

    
    
}
