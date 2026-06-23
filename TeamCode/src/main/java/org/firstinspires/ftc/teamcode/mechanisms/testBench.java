package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class testBench {
    private DigitalChannel touchSensor;
    private DcMotor motor;
    public double ticksPerRev;

    private DistanceSensor distance;

    private Servo servoPos;
    private CRServo servoRot;

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


        //    -------- Distance Sensor
        distance = hwMap.get(DistanceSensor.class, "sensor_distance");

        // --------- Servos
        servoPos = hwMap.get(Servo.class, "servo_pos");
        servoRot = hwMap.get(CRServo.class, "servo_rot");
        servoPos.scaleRange(0.5, 1);
//        servoRot.setDirection(DcMotorSimple.Direction.REVERSE);
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

//    public void changeMotorMode(DcMotor.ZeroPowerBehavior behaviour) {
//        motor.setZeroPowerBehavior(behaviour);
//    }

//    My solution
    public void changeMotorModeBreak() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void changeMotorModeFloat() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    //    -------- Distance Sensor --------
    public double getDistanceFromSensor(){
        return distance.getDistance(DistanceUnit.CM);
    }


    // ---------- Servo Programs
    public void setServoPos(double angle) {
        servoPos.setPosition(angle);
    }

    public void setServoRotSpeed(double servoSpeed) {
        servoRot.setPower(servoSpeed);
    }
}
