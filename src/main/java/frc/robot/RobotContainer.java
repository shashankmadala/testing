package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.PneumaticsConstants;
import frc.robot.subsystems.Pneumatics;

public class RobotContainer {
    private final Pneumatics m_pneumatics = new Pneumatics();
    private final XboxController m_controller = new XboxController(PneumaticsConstants.CONTROLLER_PORT);
    
    public RobotContainer() {
        configureBindings();
    }
    
    private void configureBindings() {
        new JoystickButton(m_controller, PneumaticsConstants.PISTON_BUTTON)
            .onTrue(m_pneumatics.runOnce(() -> m_pneumatics.togglePiston()));
    }
}