package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class VariableExamples extends OpMode {
    @Override
    public void init() {
        int teamNumber = 23666;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "Shadow Hawks";
        int motorAngle = 124;

        telemetry.addData("Team number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Claw Closed", clawClosed);
        telemetry.addData("Team Name", teamName);
        telemetry.addData("Motor Angle", motorAngle);
    }

    @Override
    public void loop() {

    }
}
