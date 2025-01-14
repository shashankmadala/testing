package frc.robot;

import frc.robot.subsystems.MotorTesting;

public class RobotContainer {
    private final MotorTesting m_motorTesting = new MotorTesting();
    
    public RobotContainer() {
        configureBindings();
    }
    
    private void configureBindings() {
        // Add any additional button bindings here if needed
    }
}