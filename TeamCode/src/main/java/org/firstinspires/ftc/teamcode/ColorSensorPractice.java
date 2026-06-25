package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.testBench;

@TeleOp
public class ColorSensorPractice extends OpMode {

    testBench bench = new testBench();
    testBench.DetectedColor detectedColor;

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        detectedColor =  bench.getDetectedColor(telemetry);
        telemetry.addData("Color detected", detectedColor);
    }
}
