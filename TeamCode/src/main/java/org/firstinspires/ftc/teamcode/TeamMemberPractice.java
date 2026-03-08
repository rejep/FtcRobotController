package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class TeamMemberPractice extends OpMode {

    boolean initDone;

    @Override
    public void init() {
        telemetry.addData("Init:", initDone);
        initDone = true;
    }

    double SquareWithSign(double value) {
        if (value < 0) {
            return -1 * value * value;
        }
        return value * value;
    }

    @Override
    public void loop() {
        telemetry.addData("Init:", initDone);

        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("Left Stick Normal Value:", yAxis);
        telemetry.addData("Left Stick Modified Value:", SquareWithSign(yAxis));
    }
}
