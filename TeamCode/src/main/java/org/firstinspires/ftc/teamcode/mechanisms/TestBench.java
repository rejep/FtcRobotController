package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DigitalChannel touchSensor;
    private DcMotor motor;
    private double ticksPerRev;

//    -------- Initialization of Hardware components --------
    public void init(HardwareMap hwMap) {

        //    -------- Touch sensor --------
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);

        //    -------- Dc Motor --------
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    //    -------- Touch sensor --------
    public boolean getTouchSensor() {
        return !touchSensor.getState();
    }

    public boolean isReleased() {
        return touchSensor.getState();
    }

    //    -------- Dc Motor --------
    public void setMotor(double speed) {
        motor.setPower(speed);
    }

    public double getMotorRev() {
        return motor.getCurrentPosition() / ticksPerRev;  // normalizing ticks to revolutions
    }

    public void changeMotorModeBreak() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void changeMotorModeFloat() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }
}
