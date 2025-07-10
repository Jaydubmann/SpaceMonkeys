package org.firstinspires.ftc.teamcode.SpaceMonkeys;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "demoteleop")
public class DemoTeleOP extends LinearOpMode {
    hardwaredemo robot = hardwaredemo.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("staus", "hello driver");
        telemetry.update();

        boolean pressinglb = false;
        int armposition = 0;


        waitForStart();
        while (opModeIsActive()) {
            double movement = -gamepad1.left_stick_y;
            double turning = gamepad1.right_stick_x;

            double left = movement + turning;
            double right = movement - turning;

            double max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0) {
                left /= max;
                right /= max;
            }
            robot.left.setPower(left);
            robot.right.setPower(right);
            robot.arm.setTargetPosition(armposition);
            robot.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.arm.setPower(0.5);


            if (gamepad2.left_bumper && !pressinglb) {
                armposition = 1500 ;
                pressinglb = true;
            } else if (!gamepad2.left_bumper) {
                pressinglb = false;

            }
            if (gamepad2.right_stick_x > .1) {


            }


        }
    }
}