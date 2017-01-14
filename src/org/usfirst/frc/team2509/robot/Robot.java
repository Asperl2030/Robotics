package org.usfirst.frc.team2509.robot;

import com.ctre.CANTalon;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends IterativeRobot {
	Joystick stick;
	CANTalon m1, m2, m3, m4;
	RobotDrive drive;
	UsbCamera camera;
	public void robotInit() {
		stick= new Joystick(0);
		m1= new CANTalon(0);
		m2= new CANTalon(1);
		m2.setInverted(true);
		m3= new CANTalon(2);
		m4= new CANTalon(3);
		m4.setInverted(true);
		drive= new RobotDrive(m1,m3,m2,m4);
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(480, 360);
	}

	public void autonomousInit() {
		drive.drive(0.5, 0);
		Timer.delay(2.0);
		drive.drive(0, 0);
	}

	public void autonomousPeriodic() {
		
	}

	public void teleopPeriodic(){
		drive.setSafetyEnabled(true);
		while(isEnabled()&& isOperatorControl()){
			drive.mecanumDrive_Cartesian(stick.getX(), stick.getY(), stick.getZ(), 0);
		}
	}

	public void testPeriodic() {
	}
}

