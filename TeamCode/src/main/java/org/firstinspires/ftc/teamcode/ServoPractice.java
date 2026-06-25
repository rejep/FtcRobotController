package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.testBench;

@TeleOp
@Disabled
public class ServoPractice extends OpMode {
    testBench bench = new testBench();
    boolean mode;

    @Override
    public void init() {
        bench.init(hardwareMap);
        mode = false;
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            mode = !mode;
        }
        if (mode){
            telemetry.addData("Active servo", "left");
            if (gamepad1.a) {
                bench.setServoPos(1.0);
            } else if (gamepad1.b) {
                bench.setServoPos(-1.0);
            }
        }
        else {
            telemetry.addData("Active servo", "right");
            if (gamepad1.a) {
                bench.setServoRotSpeed(1.0);
            } else if (gamepad1.b) {
                bench.setServoRotSpeed(-1.0);
            }
        }
    }
}
