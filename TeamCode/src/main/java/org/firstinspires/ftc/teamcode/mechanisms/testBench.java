package org.firstinspires.ftc.teamcode.mechanisms;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class testBench {
    private DigitalChannel touchSensor;
    private DcMotor motor;
    public double ticksPerRev;

    private DistanceSensor distance;

    private Servo servoPos;
    private CRServo servoRot;

    private NormalizedColorSensor colorSensor;
    public enum DetectedColor {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        UNKNOWN
    }

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

        // ---------- Color Sensor
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensor_color_distance");
        colorSensor.setGain(10);
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

    // --------- Color Sensor
    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = colorSensor.getNormalizedColors();    // returns 4 values (RGBA = Red, Green, Blue, Alpha)

        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normBlue = colors.blue / colors.alpha;
        normGreen = colors.green / colors.alpha;

        telemetry.addData("Red", normRed);
        telemetry.addData("Green", normGreen);
        telemetry.addData("Blue", normBlue);

        // TODO add if statements for specific colors added
        /*
        RED = >.5, <.5, <.5
        GREEN = <.5, >.5, <.5
        BLUE = <.5, <.5, >.5
        YELLOW = >.5, >.5, <.5
        * */

        if (normRed > .5 && normGreen < .5 && normBlue < .5) {
//            telemetry.addData("Detected Color", "RED");
            return DetectedColor.RED;
        } else if (normRed < .5 && normGreen > .5 && normBlue < .5) {
//            telemetry.addData("Detected Color", "GREEN");
            return DetectedColor.GREEN;
        } else if (normRed < .5 && normGreen < .5 && normBlue > .5) {
//            telemetry.addData("Detected Color", "BLUE");
            return DetectedColor.BLUE;
        } else if (normRed > .5 && normGreen > .5 && normBlue < .5) {
//            telemetry.addData("Detected Color", "YELLOW");
            return DetectedColor.YELLOW;
        }

        return DetectedColor.UNKNOWN;
    }
}
