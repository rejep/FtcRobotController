package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class IfPractice extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double motorSpeed = gamepad1.left_stick_y;
        boolean leftBumper = gamepad1.left_bumper;

//        telemetry.addData("Motor Speed:", motorSpeed );

        if (leftBumper) {
            telemetry.addData("Motor Speed:", motorSpeed);
        }
        else{
            telemetry.addData("Motor Speed:", motorSpeed * 0.5);
        }

    }
}
