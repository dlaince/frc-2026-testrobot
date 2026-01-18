package frc.robot;  //klasör

import edu.wpi.first.wpilibj.TimedRobot;  //Her 20 ms'de belirli fonksiyonlar çağıran ana sınıflardan
import edu.wpi.first.wpilibj2.command.Command;  /*Interface/ abstract class. Commandler initialize -başladığı an-, execute -çalıştığı sürece-, 
end -bitti /iptal edildi- ve isFinished -ne zaman bitsin- fonksiyonlarından oluşur (Bilgilendirme hehehe) */
import edu.wpi.first.wpilibj2.command.CommandScheduler;  //Commandlerin kullanımı, subsystemlerin çakışmaması ve buton kullanımı gbi kısımları denetler


public class Robot extends TimedRobot {  //TimedRobot'tan türeme Robot ana sınıfı, Initli fonksiyonlar otomatik çağrılır (Driver Station'da mod değişince otomatik çağrılır)

    private RobotContainer robotContainer; //robotun beyni denilebilir,boş referans tanımlanmış
    private Command autonomousCommand;

    @Override
    public void robotInit() {  //robot ilk açıldığında tek seferliğine çalışır.
        robotContainer = new RobotContainer();  //Container oluşturuldu
    }

    @Override
    public void robotPeriodic() {  //Her 20ms'de bir çalışır
        CommandScheduler.getInstance().run(); //Her 20 ms'de bir çalışır.
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = robotContainer.getAutonomousCommand(); //RobotContainer'dan command alınır
        if (autonomousCommand != null) {  //null değilse başlar
            autonomousCommand.schedule();
        }
    }

    @Override
    public void teleopInit() {
        if (autonomousCommand != null) {  //otonomda çalışan command varsa durdurur
            autonomousCommand.cancel();
        }
    }

    @Override
    public void disabledInit() {}
    //encoder reset, led kapatma vs. eklenilenilir
  
    @Override
    public void disabledPeriodic() {}

    @Override
    public void teleopPeriodic() {}

    @Override
    public void autonomousPeriodic() {}
}
