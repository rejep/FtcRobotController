package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.testBench;

@TeleOp
@Disabled
public class DistancePractice extends OpMode {
    testBench bench = new testBench();
    double actualDistance;

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        actualDistance = bench.getDistanceFromSensor();
        telemetry.addData("Distance", actualDistance);
        if (actualDistance < 10.0){
            telemetry.addData("Message", "too close");
        }
    }
}
