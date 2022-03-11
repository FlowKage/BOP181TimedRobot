package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Conveyer {
public static CANSparkMax m_conveyVert = new CANSparkMax(5,MotorType.kBrushless);
public static CANSparkMax m_conveyHori = new CANSparkMax(6,MotorType.kBrushless);

//Used to set the speed for the vertival conveyer
public static void m_vert(){
    double vertSpeed = Robot.op_Stick.getLeftY() * -1;
    if(Math.abs(vertSpeed) > .2  ){
        m_conveyVert.set(vertSpeed);
    }
    else{
        m_conveyVert.set(0);
    }
}
// Used to set the speed for horizontal conveyer 
public static void m_hort(){
    double horiSpeed = Robot.op_Stick.getRightY() * -1;
    if(Math.abs(horiSpeed) > .2){
        m_conveyHori.set(horiSpeed);
    }
    else{
        m_conveyHori.set(0);
    }
}
}