package org.firstinspires.ftc.teamcode;

import static java.lang.Math.abs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class GamePadPractice extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {

        double speedForward = -gamepad1.left_stick_y / 2.0;


        telemetry.addData("Left X", gamepad1.left_stick_x);
        telemetry.addData("Left Y", speedForward);
        telemetry.addData("A button", gamepad1.a);

        telemetry.addData("Right X", gamepad1.right_stick_y);
        telemetry.addData("Right Y", gamepad1.right_stick_x);
        telemetry.addData("Button B", gamepad1.b);

        telemetry.addData("Difference of Right and Left", gamepad1.right_stick_x - gamepad1.left_stick_x);
        telemetry.addData("Sum of both triggers", gamepad1.left_trigger + gamepad1.right_trigger);

    }
}
