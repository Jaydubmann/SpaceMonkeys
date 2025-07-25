package org.firstinspires.ftc.teamcode.SpaceMonkeys;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


//@TeleOp(name = "demoteleop")
public class DemoTeleOP extends LinearOpMode {
    hardwaredemo robot = hardwaredemo.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);

        robot.arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.flipper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("staus", "hello driver");
        telemetry.update();

        boolean pressinglb = false;
        int armposition = 0;
        boolean fliphight = false;
        int flipperposition = 0;
        boolean scoring = false;
        boolean pressingrb = false;



        waitForStart();
        while (opModeIsActive()) {

            robot.flipper.setPower(gamepad2.left_stick_y);
            robot.arm.setPower(gamepad2.right_stick_y);

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
            /*robot.arm.setTargetPosition(armposition);
            robot.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.arm.setPower(0.6);*/




            /*if (gamepad2.left_bumper && !pressinglb) {
                armposition = 1570 ;
                pressinglb = true;
            } else if (!gamepad2.left_bumper) {
                pressinglb = false;

            }
            if (gamepad2.right_bumper && !pressingrb) {
                armposition = 440 ;
                pressingrb = true;
            } else if (!gamepad2.right_bumper) {
                pressingrb = false;
            }*/


            telemetry.addData("arm postion", armposition);
        telemetry.addData("actual postion", robot.arm.getPower());
        telemetry.addData("flipper postion", flipperposition);
        telemetry.addData("actual postion", robot.flipper.getPower());
        telemetry.update();


        }
    }
}