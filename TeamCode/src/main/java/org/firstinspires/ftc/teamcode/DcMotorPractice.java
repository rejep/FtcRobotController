package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class DcMotorPractice extends OpMode {
    TestBench bench = new TestBench();
    double motorSpeed;
    String motorMode;


    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (bench.isReleased()){
            motorSpeed = 0;
        }
        else {
            motorSpeed = 0.5;
        }

        if (gamepad1.a) {
            bench.changeMotorModeBreak();
            motorMode = "BREAK";
        } else if (gamepad1.b) {
            bench.changeMotorModeFloat();
            motorMode = "FLOAT";
        }

//        bench.setMotor(motorSpeed);
        bench.setMotor(gamepad1.left_stick_y);
        telemetry.addData("Current Speed", gamepad1.left_stick_y);
        telemetry.addData("Motor Rev", bench.getMotorRev());
        telemetry.addData("Motor Mode", motorMode);
    }
}
