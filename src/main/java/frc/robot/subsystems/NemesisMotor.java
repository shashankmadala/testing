package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

public class NemesisMotor {
    private TalonFX motor;
    private double currentLimit = 40.0;
    
    public NemesisMotor(int canID) {
        motor = new TalonFX(canID);
        
        // Default configuration
        motor.configFactoryDefault();
        motor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, currentLimit, currentLimit, 0));
        motor.setNeutralMode(NeutralMode.Brake);
    }

    /**
     * Sets the motor's speed
     * @param speed Value between -1.0 and 1.0
     */
    public void set(double speed) {
        motor.set(ControlMode.PercentOutput, speed);
    }

    /**
     * Inverts the motor direction
     * @param inverted True to invert, false for normal
     */
    public void setInverted(boolean inverted) {
        motor.setInverted(inverted);
    }

    /**
     * Sets another motor to follow this one
     * @param followerMotor The NemesisMotor that should follow this one
     * @param inverted Whether the follower should be inverted relative to the leader
     */
    public void setFollower(NemesisMotor followerMotor, boolean inverted) {
        followerMotor.motor.follow(motor);
        followerMotor.motor.setInverted(inverted);
    }

    /**
     * Sets the current limit for the motor
     * @param amps Current limit in amps
     */
    public void setCurrentLimit(double amps) {
        currentLimit = amps;
        motor.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, currentLimit, currentLimit, 0));
    }

    /**
     * Sets whether the motor is in brake mode
     * @param brake True for brake mode, false for coast
     */
    public void setBrakeMode(boolean brake) {
        motor.setNeutralMode(brake ? NeutralMode.Brake : NeutralMode.Coast);
    }

    /**
     * Stops the motor
     */
    public void stop() {
        motor.set(ControlMode.PercentOutput, 0);
    }

    /**
     * Gets the raw TalonFX motor controller
     * @return The TalonFX object
     */
    public TalonFX getRawMotor() {
        return motor;
    }
}