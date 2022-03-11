package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Camera {
    static private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public static void cameraStream(){
        table.getEntry("stream").setNumber(1);
    }

}
