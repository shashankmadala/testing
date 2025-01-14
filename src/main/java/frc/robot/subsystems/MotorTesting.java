package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MotorTesting extends SubsystemBase {
    // Motor and joystick
    private final TalonFX motor;
    private final Joystick joystick;
    
    public MotorTesting() {
        motor = new TalonFX(15);
        
        // Initialize joystick on USB port 0
        joystick = new Joystick(5);
        
        // Configure motor defaults
        motor.configFactoryDefault();
        motor.setNeutralMode(NeutralMode.Coast); // Start in coast mode
        
        // Current limiting
        motor.configSupplyCurrentLimit(
            new SupplyCurrentLimitConfiguration(
                true,   // Enable
                40,     // Current limit (amps)
                45,     // Trigger threshold (amps) 
                0.1     // Trigger threshold time (sec)
            )
        );
        
        // Log that we're initialized
        System.out.println("Motor Test Subsystem Initialized!");
    }
    
    @Override
    public void periodic() {
        // Get joystick input (-1 to 1)
        double speed = -joystick.getY(); // Negate so pushing up = positive
        
        // Add deadband
        if (Math.abs(speed) < 0.1) {
            speed = 0;
        }
        
        // Set motor speed
        motor.set(ControlMode.PercentOutput, speed);

        // Button controls
        if (joystick.getRawButtonPressed(1)) {
            // Button 1: Toggle direction
            motor.setInverted(!motor.getInverted());
        }
        
        if (joystick.getRawButtonPressed(2)) {
            // Button 2: Toggle brake/coast
            boolean isBrake = motor.getNeutralMode() == NeutralMode.Brake;
            motor.setNeutralMode(isBrake ? NeutralMode.Coast : NeutralMode.Brake);
        }
        
        // Log data to SmartDashboard
        SmartDashboard.putNumber("Motor Speed", speed);
        SmartDashboard.putNumber("Motor Current", motor.getStatorCurrent());
        SmartDashboard.putBoolean("Brake Mode", motor.getNeutralMode() == NeutralMode.Brake);
    }

    public void stop() {
        motor.set(ControlMode.PercentOutput, 0);
    }
}