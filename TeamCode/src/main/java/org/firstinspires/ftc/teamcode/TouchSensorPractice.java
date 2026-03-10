package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@Disabled
@TeleOp
public class TouchSensorPractice extends OpMode {
    TestBench bench = new TestBench();
    String isPressed = "";

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Touch Sensor State", bench.getTouchSensor());

        if (bench.isReleased()) {
            isPressed = "Not Pressed";
        }
        else {
            isPressed = "Pressed";
        }
        telemetry.addData("Is touch sensor released", isPressed);
    }
}
