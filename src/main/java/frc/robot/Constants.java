package frc.robot;

public final class Constants {
    public static final class PneumaticsConstants {
        public static final int PCM_CAN_ID = 3; 
        public static final int FORWARD_CHANNEL = 1; // solenoid forward
        public static final int REVERSE_CHANNEL = 1; // Change to match your solenoid reverse channel
        public static final int CONTROLLER_PORT = 2; // usb port
        public static final int PISTON_BUTTON = 1; // xbox
    }

    public static final class MotorConstants {
        public static final int KRAKEN_MOTOR = 15; // Update this to match your Kraken motor's CAN ID
        public static final double CURRENT_LIMIT = 40.0; // Amps
        public static final double DEADBAND = 0.1;
    }
}

