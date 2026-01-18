package frc.robot;

public final class Constants {  //final! Buton numaraları, portlar, deadband, motor ID'leri burada tutulur

    public static final class OperatorConstants {  //nested class (iç sınıf), nesneye bağlı değil
        public static final int DRIVER_CONTROLLER_PORT = 0;  //USB 0 numaralı joystick driverın
        public static final int OPERATOR_CONTROLLER_PORT = 1;

        public static final double DEADBAND = 0.08; 
    }

    public static final class ButtonConstants {
        // Operator mekanik tarafıdır. Intake, elevator, shooter, climber vb. ilgilenir.
        public static final int INTAKE_IN = 1;    // A
        public static final int INTAKE_OUT = 2;   // B
        public static final int INTAKE_STOP = 3;  // X

        public static final int ELEVATOR_L1 = 4;  // Y
        public static final int ELEVATOR_L2 = 5;  // LB
        public static final int ELEVATOR_L3 = 6;  // RB
        public static final int ELEVATOR_ZERO = 7;// BACK

        public static final int SHOOT = 8;         // START

        // Driver, robotu konumlandırır. Driver robotu hareket ettirir. Drive, dönüş, hizalama vb. işler.
        public static final int AUTO_ALIGN = 1;    // A
        public static final int ENDGAME_DEPLOY = 2;// B
        public static final int CLIMB_UP = 5;      // LB
        public static final int CLIMB_DOWN = 6;    // RB
    }
}
