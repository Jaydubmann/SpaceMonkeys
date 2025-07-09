package org.firstinspires.ftc.teamcode.SpaceMonkeys;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "demoteleop")
public class DemoTeleOP extends LinearOpMode {
    hardwaredemo robot = hardwaredemo.getInstance();
    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("staus", "hello driver");
        telemetry.update();

        boolean pressingx = false;

        waitForStart();
        while (opModeIsActive()) ;
        double movement = gamepad1.left_stick_x;
        double turning = gamepad1.right_stick_y;

        double left = movement + turning;
        double right = movement - turning;

        double max = Math.max(Math.abs(left), Math.abs(right));
        if (max > 1.0) {
            left /= max;
            right /= max;
        }
        robot.left.setPower(left);
        robot.right.setPower(right);

        if (gamepad2.x && !pressingx)

        if (gamepad2.right_stick_x > .1){


    }


    }
}
