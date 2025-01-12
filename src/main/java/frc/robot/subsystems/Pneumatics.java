package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import frc.robot.Constants.PneumaticsConstants;

public class Pneumatics extends SubsystemBase {
    private final Compressor compressor = new Compressor(PneumaticsConstants.PCM_CAN_ID, PneumaticsModuleType.CTREPCM);
    private final PneumaticsControlModule pcm = new PneumaticsControlModule(PneumaticsConstants.PCM_CAN_ID);
    private final Solenoid piston = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    
    public Pneumatics() {
        compressor.enableDigital();
    }
    
    public void togglePiston() {
        piston.set(true);
    }
}